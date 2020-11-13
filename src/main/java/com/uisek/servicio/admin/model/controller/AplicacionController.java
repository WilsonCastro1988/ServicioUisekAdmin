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
import com.uisek.servicio.admin.model.service.AplicacionServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "aplicacion")
public class AplicacionController {

	@Autowired
	private AplicacionServiceImp service;

	@GetMapping("/listar")
	public List<Aplicacion> listarAplicacion() {
		return service.findAll();
	}
	
	@GetMapping("/findBy/{url}")
	public Aplicacion findByUrl(@PathVariable String url) {
		return service.findByUrl(url);
	}

	@GetMapping("/ver/{id}")
	public Aplicacion verItem(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacion crear(@RequestBody Aplicacion entidad) {
		return service.save(entidad);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacion editar(@RequestBody Aplicacion entidad, @PathVariable Long id) {
		Aplicacion entidadDb = service.findById(id);

		entidad.setIdAplicacion(entidadDb.getIdAplicacion());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}
}
