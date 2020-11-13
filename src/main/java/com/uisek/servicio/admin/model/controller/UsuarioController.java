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

import com.uisek.servicio.admin.model.entity.Usuario;
import com.uisek.servicio.admin.model.service.UsuarioServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImp service;

	@GetMapping("/listar")
	public List<Usuario> listarUsuario() {
		return service.findAll();
	}

	@GetMapping("/ver/{id}")
	public Usuario verItem(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario entidad) {
		return service.save(entidad);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario entidad, @PathVariable Long id) {
		Usuario entidadDb = service.findById(id);

		entidad.setIdUsuario(entidadDb.getIdUsuario());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PostMapping("/findByNombreUsuario")
	public Usuario findByNombreUsuario(@RequestBody Usuario entidad) {
		return service.findByNombreUsuario(entidad.getNombreUsuario());
	}

	@PostMapping("/findByNombreUsuarioAndClave")
	public Usuario findByNombreUsuarioAndClave(@RequestBody Usuario entidad) {
		return service.findByNombreUsuarioAndClave(entidad.getNombreUsuario(), entidad.getClave());
	}

}
