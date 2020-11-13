package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.PaqueteDao;
import com.uisek.servicio.admin.model.entity.Paquetes;

@Service
public class PaqueteServiceImp implements PaqueteService{

	@Autowired
	private PaqueteDao repo;
	
	@Override
	public List<Paquetes> findAll() {
		return (List<Paquetes>) repo.findAll();
	}

	@Override
	public Paquetes findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Paquetes save(Paquetes entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
