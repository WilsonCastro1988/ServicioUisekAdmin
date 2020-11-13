package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.AplicacionDao;
import com.uisek.servicio.admin.model.entity.Aplicacion;

@Service
public class AplicacionServiceImp implements AplicacionService{

	@Autowired
	private AplicacionDao repo;
	
	@Override
	public List<Aplicacion> findAll() {
		return (List<Aplicacion>) repo.findAll();
	}

	@Override
	public Aplicacion findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Aplicacion save(Aplicacion entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Aplicacion findByUrl(String url) {
		return repo.findByUrl(url);
	}

}
