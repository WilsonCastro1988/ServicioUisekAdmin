package com.uisek.servicio.admin.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisek.servicio.admin.model.entity.Aplicacion;
import com.uisek.servicio.admin.model.entity.Menu;

public interface MenuDao extends JpaRepository<Menu, Long> {

	public List<Menu> findByAplicacion(Aplicacion entidad);

	@Query("select p from Menu as p where p.menuPadre.id = ?1")
	public List<Menu> findByMenuPadre(@Param("idMenuPadre") Long idMenuPadre);

	@Query("select p from Menu as p where p.aplicacion.id=?1 and p.tipo='menu'")
	public List<Menu> findMenuPadreByAplicacion(@Param("idAplicacion") Long id);

	@Query("select m from Menu as m where m.aplicacion.idAplicacion=?1 and m.menuPadre.idMenu=?2 and m.tipo='opcion'")
	public List<Menu> findOpcionesByAplicacionAndMenuPadre(@Param("idAplicacion") Long idAplicacion,
			@Param("idMenu") Long idMenu);

}
