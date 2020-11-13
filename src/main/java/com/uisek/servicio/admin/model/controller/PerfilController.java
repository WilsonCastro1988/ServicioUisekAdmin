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

import com.uisek.servicio.admin.model.entity.Perfil;
import com.uisek.servicio.admin.model.service.PerfilServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "perfil")
public class PerfilController {

	@Autowired
	private PerfilServiceImp service;

	@GetMapping("/listar")
	public List<Perfil> listarPerfil() {
		return service.findAll();
	}
	
	@GetMapping("/obtenerPerfilesUsuario/{nombreUsuario}")
	public List<Perfil> obtenerPerfilesUsuario(@PathVariable String nombreUsuario) {
		return service.obtenerPerfilesUsuario(nombreUsuario);
	}

	@GetMapping("/ver/{id}")
	public Perfil verItem(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/findPerfilByNombre/{nombre}")
	public Perfil findPerfilByNombre(@PathVariable String nombre) {
		return service.findByNombre(nombre);
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil crear(@RequestBody Perfil entidad) {
		return service.save(entidad);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Perfil editar(@RequestBody Perfil entidad, @PathVariable Long id) {
		Perfil entidadDb = service.findById(id);

		entidad.setIdPerfil(entidadDb.getIdPerfil());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}
}
