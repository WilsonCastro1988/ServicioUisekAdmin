package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.PerfilDao;
import com.uisek.servicio.admin.model.entity.Perfil;

@Service
public class PerfilServiceImp implements PerfilService{

	@Autowired
	private PerfilDao repo;
	
	@Override
	public List<Perfil> findAll() {
		return (List<Perfil>) repo.findAll();
	}

	@Override
	public Perfil findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Perfil save(Perfil entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Perfil> obtenerPerfilesUsuario(String nombreUsuario) {
		return repo.obtenerPerfilesUsuario(nombreUsuario);
	}

	@Override
	public Perfil findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByNombre(nombre);
	}
	
	
	

}
