package com.uisek.servicio.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.UsuarioDao;
import com.uisek.servicio.admin.model.entity.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDao repo;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) repo.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		return repo.findByNombreUsuario(nombreUsuario);
	}

	@Override
	public Usuario findByNombreUsuarioAndClave(String nombreUsuario, String clave) {
		return repo.findByNombreUsuarioAndClave(nombreUsuario, clave);
	}

}
