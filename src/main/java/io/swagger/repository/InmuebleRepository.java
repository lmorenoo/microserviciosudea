package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, String>  {

}
