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

import com.uisek.servicio.admin.model.entity.Autorizacion;
import com.uisek.servicio.admin.model.entity.Menu;
import com.uisek.servicio.admin.model.entity.Perfil;
import com.uisek.servicio.admin.model.service.AutorizacionServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "autorizacion")
public class AutorizacionController {

	@Autowired
	private AutorizacionServiceImp service;

	@GetMapping("/listar")
	public List<Autorizacion> listarAutorizacion() {
		return service.findAll();
	}

	@GetMapping("/ver/{id}")
	public Autorizacion verItem(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Autorizacion crear(@RequestBody Autorizacion entidad) {
		return service.save(entidad);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Autorizacion editar(@RequestBody Autorizacion entidad, @PathVariable Long id) {
		Autorizacion entidadDb = service.findById(id);

		entidad.setIdAutorizacion(entidadDb.getIdAutorizacion());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PostMapping(path = "/findByMenu")
	public List<Autorizacion> findByMenu(@RequestBody Menu entidad) {
		return service.findByMenu(entidad);
	}

	@PostMapping(path = "/findByPerfil")
	public List<Autorizacion> findByPerfil(@RequestBody Perfil entidad) {
		return service.findByPerfil(entidad);
	}

	@PostMapping("/findByUrlMenu")
	public Autorizacion findByUrlMenu(@RequestBody String urlMenu) {
		return service.findByUrlMenu(urlMenu);
	}

}
