package com.uisek.servicio.admin.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisek.servicio.admin.model.dao.MenuDao;
import com.uisek.servicio.admin.model.entity.Aplicacion;
import com.uisek.servicio.admin.model.entity.Autorizacion;
import com.uisek.servicio.admin.model.entity.Menu;

@Service
public class MenuServiceImp implements MenuService {

	@Autowired
	private MenuDao repo;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Menu> obtenerMenusPorRolAplicativo(String rol, long idAplicativo) {
		Query q = entityManager.createQuery(
				"select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion "
						+ " where p.nombre=?1 and p.activo=true and m.activo=true AND m.aplicacion.idAplicacion=?2 "
						+ " order by COALESCE(m.menuPadre.idMenu,0), m.orden");
		q.setParameter(1, rol);
		q.setParameter(2, idAplicativo);
		List<Autorizacion> resultado = q.getResultList();

		List<Menu> menus = new ArrayList<Menu>();
		for (Autorizacion a : resultado) {
			menus.add(a.getMenu());
			Menu m = a.getMenu();
			m.setPermisos(a.getPermisos());
			if (m.getUrl() != null) {
				if (m.getAplicacion() == null) {
					m.setUrlCompleto(m.getUrl());
				} else {
					m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
				}
			}
		}
		return menus;
	}
	
	@Override
	public List<Menu> obtenerMenusHijo(String rol, long idMenuPadre, String opcion, String opcion2) {
		Query q = entityManager.createQuery(
				"select a from Autorizacion as a join fetch a.perfil p join fetch a.menu m join fetch m.aplicacion "
						+ "where p.nombre=?1 and p.activo=true and m.activo=true and (m.tipo=?2 or m.tipo=?3)  "
						+ "and m.menuPadre.idMenu=?4 order by COALESCE(m.menuPadre.idMenu,0), m.orden");
		q.setParameter(1, rol);
		q.setParameter(2, opcion);
		q.setParameter(3, opcion2);
		q.setParameter(4, idMenuPadre);
		List<Autorizacion> resultado = q.getResultList();

		List<Menu> menus = new ArrayList<Menu>();
		for (Autorizacion a : resultado) {
			menus.add(a.getMenu());
			Menu m = a.getMenu();
			m.setPermisos(a.getPermisos());
			if (m.getUrl() != null) {
				if (m.getAplicacion() == null) {
					m.setUrlCompleto(m.getUrl());
				} else {
					m.setUrlCompleto(m.getAplicacion().getUrl() + m.getUrl());
				}
			}
		}
		return menus;
	}

	@Override
	public List<Menu> findAll() {
		return (List<Menu>) repo.findAll();
	}

	@Override
	public Menu findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Menu save(Menu entidad) {
		return repo.save(entidad);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Menu> findByAplicacion(Aplicacion entidad) {
		return repo.findByAplicacion(entidad);
	}

	@Override
	public List<Menu> findMenuPadreByAplicacion(Long id) {
		return repo.findMenuPadreByAplicacion(id);
	}

	@Override
	public List<Menu> findByMenuPadre(Long id) {
		return repo.findByMenuPadre(id);
	}

	@Override
	public List<Menu> findOpcionesByAplicacionAndMenuPadre(Long idAplicacion, Long idMenuPadre) {
		// TODO Auto-generated method stub
		return repo.findOpcionesByAplicacionAndMenuPadre(idAplicacion, idMenuPadre);
	}

}
