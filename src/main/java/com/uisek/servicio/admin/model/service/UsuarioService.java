package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Usuario;


public interface UsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(Usuario entidad);
	public void deleteById(Long id);
	
	public Usuario findByNombreUsuario(String nombreUsuario);
	public Usuario findByNombreUsuarioAndClave(String nombreUsuario, String clave);
	
}
