package com.uisek.servicio.admin.model.service;

import java.util.List;

import com.uisek.servicio.admin.model.entity.Aplicacion;
import com.uisek.servicio.admin.model.entity.Menu;

public interface MenuService {

	public List<Menu> findAll();

	public Menu findById(Long id);

	public Menu save(Menu entidad);

	public void deleteById(Long id);

	public List<Menu> findByAplicacion(Aplicacion entidad);

	public List<Menu> findMenuPadreByAplicacion(Long id);

	public List<Menu> findByMenuPadre(Long id);

	public List<Menu> findOpcionesByAplicacionAndMenuPadre(Long idAplicacion, Long idMenuPadre);

	public List<Menu> obtenerMenusPorRolAplicativo(String rol, long idAplicativo);

	public List<Menu> obtenerMenusHijo(String rol, long idMenuPadre, String opcion, String opcion2);

}
