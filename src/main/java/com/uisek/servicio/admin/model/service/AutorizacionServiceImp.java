package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.AutorizacionDao;
import com.uisek.servicio.admin.model.entity.Autorizacion;
import com.uisek.servicio.admin.model.entity.Menu;
import com.uisek.servicio.admin.model.entity.Perfil;

@Service
public class AutorizacionServiceImp implements AutorizacionService {

	@Autowired
	private AutorizacionDao repo;

	@Override
	public List<Autorizacion> findAll() {
		return (List<Autorizacion>) repo.findAll();
	}

	@Override
	public Autorizacion findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Autorizacion save(Autorizacion entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Autorizacion> findByMenu(Menu entidad) {
		// TODO Auto-generated method stub
		return repo.findByMenu(entidad);
	}

	@Override
	public List<Autorizacion> findByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return repo.findByPerfil(perfil);
	}

	@Override
	public Autorizacion findByUrlMenu(String urlMenu) {
		// TODO Auto-generated method stub
		return repo.findByUrlMenu(urlMenu);
	}

}
