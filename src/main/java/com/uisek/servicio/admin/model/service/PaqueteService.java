package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Paquetes;


public interface PaqueteService {

	public List<Paquetes> findAll();
	public Paquetes findById(Long id);
	public Paquetes save(Paquetes entidad);
	public void deleteById(Long id);
}
