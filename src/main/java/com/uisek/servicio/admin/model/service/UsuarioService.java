package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Usuario;


public interface UsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Integer id);
	public Usuario save(Usuario entidad);
	public void deleteById(Integer id);
	
	public Usuario findByNombreUsuario(String nombreUsuario);
	public Usuario findByNombreUsuarioAndClave(String nombreUsuario, String clave);
	
}
