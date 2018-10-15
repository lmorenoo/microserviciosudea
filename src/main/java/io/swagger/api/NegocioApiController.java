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
import io.swagger.model.Negocio;
import io.swagger.repository.NegocioRepository;

@Controller
public class NegocioApiController implements NegocioApi {

	private static final Logger log = LoggerFactory.getLogger(NegocioApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private NegocioRepository negocioRepository;

	@Autowired
	public NegocioApiController(ObjectMapper objectMapper, HttpServletRequest request,
			NegocioRepository negocioRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.negocioRepository = negocioRepository;
	}

	public ResponseEntity<Void> agregarNegocio(
			@ApiParam(value = "ID de negocio a buscar", required = true) @PathVariable("idNegocio") String idNegocio,
			@ApiParam(value = "negocio a agregar") @Valid @RequestBody Negocio negocio) {
		negocioRepository.save(negocio);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<Negocio> buscarNegocio(
			@ApiParam(value = "ID del negocio a buscar", required = true) @PathVariable("idNegocio") String idNegocio) {
		Negocio negocio = negocioRepository.findOne(idNegocio);
		if (negocio == null) {
			return new ResponseEntity<Negocio>(HttpStatus.NOT_FOUND);
		}

		// agregar hypermedia
		negocio.add(linkTo(NegocioApi.class).slash(negocio.getIdNegocio()).withSelfRel());

		return ResponseEntity.ok(negocio);
	}

}
