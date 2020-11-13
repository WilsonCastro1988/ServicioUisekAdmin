package com.uisek.servicio.admin.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisek.servicio.admin.model.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	
	public Usuario findByNombreUsuario(String nombreUsuario);
	
	public Usuario findByNombreUsuarioAndClave(String nombreUsuario, String clave);
}
