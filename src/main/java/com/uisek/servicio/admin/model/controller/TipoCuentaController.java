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

import com.uisek.servicio.admin.model.entity.TipoCuenta;
import com.uisek.servicio.admin.model.service.TipoCuentaServiceImp;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.OPTIONS })
@RequestMapping(value = "tipo-cuenta")
public class TipoCuentaController {

	@Autowired
	private TipoCuentaServiceImp service;

	@GetMapping("/listar")
	public List<TipoCuenta> listarTipoCuenta() {
		return service.findAll();
	}

	@GetMapping("/ver/{id}")
	public TipoCuenta verItem(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(path = "/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoCuenta crear(@RequestBody TipoCuenta entidad) {
		return service.save(entidad);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoCuenta editar(@RequestBody TipoCuenta entidad, @PathVariable Long id) {
		TipoCuenta entidadDb = service.findById(id);

		entidad.setIdTipo(entidadDb.getIdTipo());

		return service.save(entidad);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		service.deleteById(id);
	}
}
