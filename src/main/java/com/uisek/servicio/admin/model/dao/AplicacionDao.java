package com.uisek.servicio.admin.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisek.servicio.admin.model.entity.Aplicacion;

public interface AplicacionDao extends JpaRepository<Aplicacion, Long> {
	
	Aplicacion findByUrl(String url);
	

}
