package com.uisek.servicio.admin.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisek.servicio.admin.model.entity.Perfil;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuario;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuarioPK;

public interface PerfilUsuarioDao extends JpaRepository<PerfilHasUsuario, PerfilHasUsuarioPK>{

	List<PerfilHasUsuario> findByPerfil(Perfil perfil);
	
	
}


