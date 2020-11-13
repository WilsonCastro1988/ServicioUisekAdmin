package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.CuentaDao;
import com.uisek.servicio.admin.model.entity.Cuenta;

@Service
public class CuentaServiceImp implements CuentaService{

	@Autowired
	private CuentaDao repo;
	
	@Override
	public List<Cuenta> findAll() {
		return (List<Cuenta>) repo.findAll();
	}

	@Override
	public Cuenta findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Cuenta save(Cuenta entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
