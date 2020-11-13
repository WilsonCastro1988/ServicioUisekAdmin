package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Aplicacion;


public interface AplicacionService {

	public List<Aplicacion> findAll();
	public Aplicacion findById(Long id);
	public Aplicacion save(Aplicacion entidad);
	public void deleteById(Long id);
	
	public Aplicacion findByUrl(String url);
	
	
}
