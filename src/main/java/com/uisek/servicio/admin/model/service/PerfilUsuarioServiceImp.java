package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.PerfilUsuarioDao;
import com.uisek.servicio.admin.model.entity.Perfil;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuario;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuarioPK;

@Service
public class PerfilUsuarioServiceImp implements PerfilUsuarioService {

	@Autowired
	private PerfilUsuarioDao repo;

	@Override
	public List<PerfilHasUsuario> findAll() {
		return (List<PerfilHasUsuario>) repo.findAll();
	}

	@Override
	public PerfilHasUsuario findById(PerfilHasUsuarioPK id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public PerfilHasUsuario save(PerfilHasUsuario entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(PerfilHasUsuarioPK id) {
		repo.deleteById(id);
	}

	@Override
	public List<PerfilHasUsuario> findByPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return repo.findByPerfil(perfil);
	}

}
