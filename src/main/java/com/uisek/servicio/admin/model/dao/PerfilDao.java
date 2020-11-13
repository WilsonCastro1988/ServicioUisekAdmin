package com.uisek.servicio.admin.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisek.servicio.admin.model.entity.Perfil;

public interface PerfilDao extends JpaRepository<Perfil, Long> {

	// @Query("select p from Perfil as p, IN (p.usuarios) u where p.activo='SI' and
	// u.nombreUsuario=?1")
	@Query("select p.perfil from PerfilHasUsuario  p where p.perfil.activo=true and p.usuario.nombreUsuario=?1")
	public List<Perfil> obtenerPerfilesUsuario(@Param("nombreUsuario") String nombreUsuario);

	public Perfil findByNombre(String nombre);

}
