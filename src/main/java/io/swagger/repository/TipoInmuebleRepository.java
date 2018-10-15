package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.TipoInmueble;

public interface TipoInmuebleRepository extends JpaRepository<TipoInmueble, String>  {

}
