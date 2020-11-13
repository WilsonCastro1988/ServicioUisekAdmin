package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Cuenta;


public interface CuentaService {

	public List<Cuenta> findAll();
	public Cuenta findById(Long id);
	public Cuenta save(Cuenta entidad);
	public void deleteById(Long id);
}
