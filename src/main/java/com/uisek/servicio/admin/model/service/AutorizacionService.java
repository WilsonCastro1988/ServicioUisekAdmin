package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Autorizacion;
import com.uisek.servicio.admin.model.entity.Menu;
import com.uisek.servicio.admin.model.entity.Perfil;

public interface AutorizacionService {

	public List<Autorizacion> findAll();

	public Autorizacion findById(Long id);

	public Autorizacion findByUrlMenu(String urlMenu);

	public Autorizacion save(Autorizacion entidad);

	public void deleteById(Long id);

	public List<Autorizacion> findByMenu(Menu entidad);

	List<Autorizacion> findByPerfil(Perfil perfil);

}
