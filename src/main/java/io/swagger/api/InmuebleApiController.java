package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Inmueble;
import io.swagger.model.Negocio;
import io.swagger.repository.InmuebleRepository;
import io.swagger.repository.NegocioRepository;

@Controller
public class InmuebleApiController implements InmuebleApi {

	private static final Logger log = LoggerFactory.getLogger(InmuebleApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private InmuebleRepository inmuebleRepository;
	
	private NegocioRepository negocioRepository;

	@Autowired
	public InmuebleApiController(ObjectMapper objectMapper, HttpServletRequest request,
			InmuebleRepository inmuebleRepository, NegocioRepository negocioRepository) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.inmuebleRepository = inmuebleRepository;
		this.negocioRepository = negocioRepository;
	}

	@Override
	public ResponseEntity<Void> agregarInmueble(
			@ApiParam(value = "ID del inmueble a buscar", required = true) @PathVariable("idInmueble") String idInmueble,
			@ApiParam(value = "inmueble a agregar") @Valid @RequestBody Inmueble inmueble) {
		inmuebleRepository.save(inmueble);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Inmueble> buscarInmueble(
			@ApiParam(value = "ID del inmueble a buscar", required = true) @PathVariable("idInmueble") String idInmueble) {
		Inmueble inmueble = inmuebleRepository.findOne(idInmueble);
		if (inmueble == null) {
			return new ResponseEntity<Inmueble>(HttpStatus.NOT_FOUND);
		}
		// agregar hypermedia
		inmueble.add(linkTo(InmuebleApi.class).slash(inmueble.getIdInmueble()).withSelfRel());

		// asignar referencia a negocio
		List<Negocio> linkBuilder = methodOn(InmuebleApiController.class).listarNegocios(inmueble.getIdInmueble());
		Link negocioLink = linkTo(linkBuilder).withRel("listarNegocios");
		inmueble.add(negocioLink);

		HttpHeaders headers = new HttpHeaders();
		headers.setExpires(1000);
		headers.set("Mi-header", "valor 5");

		return new ResponseEntity<Inmueble>(inmueble, headers, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> removerInmueble(
			@ApiParam(value = "ID del inmueble a buscar", required = true) @PathVariable("idInmueble") String idInmueble,
			@ApiParam(value = "inmueble a remover") @Valid @RequestBody Inmueble inmueble) {
		inmuebleRepository.delete(inmueble);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public List<Negocio> listarNegocios(
			@ApiParam(value = "ID del inmueble a buscar", required = true) @PathVariable("idInmueble") String idInmueble) {
		List<Negocio> negocios = negocioRepository.findAll();
		return negocios.stream().filter(negocio -> idInmueble.equals(negocio.getIdInmueble())).map(neg -> {
			neg.add(linkTo(NegocioApi.class).slash(neg.getIdNegocio()).withSelfRel());
			return neg;
		}).collect(Collectors.toList());
	}

}
