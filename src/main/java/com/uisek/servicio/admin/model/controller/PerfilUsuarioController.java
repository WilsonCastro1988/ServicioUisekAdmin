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
import com.uisek.servicio.admin.model.entity.PerfilHasUsuario;
import com.uisek.servicio.admin.model.entity.PerfilHasUsuarioPK;
import com.uisek.servicio.admin.model.service.PerfilUsuarioServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "perfil-usuario")
public class PerfilUsuarioController {

	@Autowired
	private PerfilUsuarioServiceImp service;

	@GetMapping("/listar")
	public List<PerfilHasUsuario> listarPerfilUsuario() {
		return service.findAll();
	}

	@GetMapping("/ver/{idTabla1}/{idTabla2}O")
	public PerfilHasUsuario verItem(@PathVariable Long idTabla1, @PathVariable Long idTabla2) {
		return service.findById(new PerfilHasUsuarioPK(idTabla1, idTabla2));
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public PerfilHasUsuario crear(@RequestBody PerfilHasUsuario entidad) {
		return service.save(entidad);
	}
	
	@PostMapping(path = "/findPerfilUsuarioByPerfil")
	public List<PerfilHasUsuario> findPerfilUsuarioByPerfil(@RequestBody Perfil entidad) {
		return service.findByPerfil(entidad);
	}

	@PutMapping("/editar/{idTabla1}/{idTabla2}")
	@ResponseStatus(HttpStatus.CREATED)
	public PerfilHasUsuario editar(@RequestBody PerfilHasUsuario entidad, @PathVariable Long idTabla1,
			@PathVariable Long idTabla2) {
		PerfilHasUsuario entidadDb = service.findById(new PerfilHasUsuarioPK(idTabla1, idTabla2));

		entidad.setPerfilHasUsuarioPK(entidadDb.getPerfilHasUsuarioPK());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{idTabla1}/{idTabla2}")
	public void eliminar(@PathVariable Long idTabla1, @PathVariable Long idTabla2) {
		service.deleteById(new PerfilHasUsuarioPK(idTabla1, idTabla2));
	}
}
