package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Negocio;

public interface NegocioRepository extends JpaRepository<Negocio, String>  {

}
