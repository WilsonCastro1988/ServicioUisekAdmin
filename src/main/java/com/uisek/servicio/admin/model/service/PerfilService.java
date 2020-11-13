package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Perfil;

public interface PerfilService {

	public List<Perfil> findAll();

	public Perfil findById(Long id);

	public Perfil save(Perfil entidad);

	public void deleteById(Long id);

	public List<Perfil> obtenerPerfilesUsuario(String nombreUsuario);
	
	public Perfil findByNombre(String nombre);

}
