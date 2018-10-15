package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.TipoInmueble;
import io.swagger.repository.TipoInmuebleRepository;

@Controller
public class TipoInmuebleApiController implements TipoInmuebleApi {

	private static final Logger log = LoggerFactory.getLogger(TipoInmuebleApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private TipoInmuebleRepository tipoInmuebleRepository;

	@Autowired
	public TipoInmuebleApiController(ObjectMapper objectMapper, HttpServletRequest request,
			TipoInmuebleRepository tipoInmuebleRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.tipoInmuebleRepository = tipoInmuebleRepository;
	}

	public ResponseEntity<Void> agregarTipoInmueble(
			@ApiParam(value = "ID del tipo de inmueble a buscar", required = true) @PathVariable("idTipoInmueble") String idTipoInmueble,
			@ApiParam(value = "tipo inmueble a agregar") @Valid @RequestBody TipoInmueble tipoInmueble) {
		tipoInmuebleRepository.save(tipoInmueble);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<TipoInmueble> buscarTipoInmueble(
			@ApiParam(value = "ID del tipo de inmueble a buscar", required = true) @PathVariable("idTipoInmueble") String idTipoInmueble) {
		TipoInmueble tipoInmueble = tipoInmuebleRepository.findOne(idTipoInmueble);
		if (tipoInmueble == null) {
			return new ResponseEntity<TipoInmueble>(HttpStatus.NOT_FOUND);
		}

		// agregar hypermedia
		tipoInmueble.add(linkTo(TipoInmuebleApi.class).slash(tipoInmueble.getIdTipoInmueble()).withSelfRel());

		return ResponseEntity.ok(tipoInmueble);
	}

}
