package com.uisek.servicio.admin.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisek.servicio.admin.model.entity.Autorizacion;
import com.uisek.servicio.admin.model.entity.Menu;
import com.uisek.servicio.admin.model.entity.Perfil;

public interface AutorizacionDao extends JpaRepository<Autorizacion, Long> {
	
	List<Autorizacion> findByMenu(Menu menu);
	
	List<Autorizacion> findByPerfil(Perfil perfil);
	
	@Query("select pa from Autorizacion pa where pa.menu.url = ?1")
	Autorizacion findByUrlMenu(@Param("urlMenu") String urlMenu);
	
	
	
	

}
