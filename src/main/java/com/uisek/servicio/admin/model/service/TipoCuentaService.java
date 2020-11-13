package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.TipoCuenta;


public interface TipoCuentaService {

	public List<TipoCuenta> findAll();
	public TipoCuenta findById(Long id);
	public TipoCuenta save(TipoCuenta entidad);
	public void deleteById(Long id);
}
