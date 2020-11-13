package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.TipoCuentaDao;
import com.uisek.servicio.admin.model.entity.TipoCuenta;

@Service
public class TipoCuentaServiceImp implements TipoCuentaService{

	@Autowired
	private TipoCuentaDao repo;
	
	@Override
	public List<TipoCuenta> findAll() {
		return (List<TipoCuenta>) repo.findAll();
	}

	@Override
	public TipoCuenta findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public TipoCuenta save(TipoCuenta entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
