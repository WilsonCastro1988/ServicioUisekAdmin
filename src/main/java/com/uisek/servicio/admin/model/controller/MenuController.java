package com.uisek.servicio.admin.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisek.servicio.admin.model.entity.Aplicacion;
import com.uisek.servicio.admin.model.entity.Menu;
import com.uisek.servicio.admin.model.service.MenuServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "menu")
public class MenuController {

	@Autowired
	private MenuServiceImp service;

	@GetMapping("/listar")
	public List<Menu> listarMenu() {
		return service.findAll();
	}

	@GetMapping("/ver/{id}")
	public Menu verItem(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Menu crear(@RequestBody Menu entidad) {
		return service.save(entidad);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Menu editar(@RequestBody Menu entidad, @PathVariable Long id) {
		Menu entidadDb = service.findById(id);

		entidad.setIdMenu(entidadDb.getIdMenu());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PostMapping("/findByAplicacion")
	public List<Menu> findByAplicacion(@RequestBody Aplicacion entidad) {
		return service.findByAplicacion(entidad);
	}

	@GetMapping("/findMenuPadreByAplicacion/{id}")
	public List<Menu> findMenuPadreByAplicacion(@PathVariable Long id) {
		return service.findMenuPadreByAplicacion(id);
	}

	@GetMapping("/findByMenuPadre/{id}")
	public List<Menu> findByMenuPadre(@PathVariable Long id) {
		return service.findByMenuPadre(id);
	}

	@GetMapping("/findOpcionesByAplicacionAndMenuPadre/{idAplicacion}/{idMenuPadre}")
	public List<Menu> findOpcionesByAplicacionAndMenuPadre(@PathVariable Long idAplicacion,
			@PathVariable Long idMenuPadre) {
		return service.findOpcionesByAplicacionAndMenuPadre(idAplicacion, idMenuPadre);
	}

	@GetMapping("/obtenerMenusPorRolAplicativo/{rol}/{idAplicacion}")
	public List<Menu> obtenerMenusPorRolAplicativo(@PathVariable String rol, @PathVariable Long idAplicacion) {
		return service.obtenerMenusPorRolAplicativo(rol, idAplicacion);
	}
	

	@GetMapping("/obtenerMenusHijo/{rol}/{idMenuPadre}/{opcion}/{opcion2}")
	public List<Menu> obtenerMenusHijo(@PathVariable String rol, @PathVariable Long idMenuPadre,
			@PathVariable String opcion, @PathVariable String opcion2) {
		return service.obtenerMenusHijo(rol, idMenuPadre, opcion, opcion2);
	}

}
