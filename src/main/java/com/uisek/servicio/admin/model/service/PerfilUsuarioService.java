package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Perfil;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuario;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuarioPK;

public interface PerfilUsuarioService {

	public List<PerfilHasUsuario> findAll();

	public PerfilHasUsuario findById(PerfilHasUsuarioPK id);

	public PerfilHasUsuario save(PerfilHasUsuario entidad);

	public void deleteById(PerfilHasUsuarioPK id);
	
	List<PerfilHasUsuario> findByPerfil(Perfil perfil);

}
