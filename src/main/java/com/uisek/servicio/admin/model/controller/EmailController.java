package com.uisek.servicio.admin.model.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisek.servicio.admin.email.Email;
import com.uisek.servicio.admin.email.SendMailGmail;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
@RequestMapping(value = "servicio-email")
public class EmailController {

	

	@PostMapping("/notificarRegistro")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean notificarRegistro(@RequestBody Email entidad) {
		SendMailGmail servicioEmail = new SendMailGmail();
		servicioEmail.setEmailTo(entidad.getEmailTo());
		servicioEmail.setMensajeTo(entidad.getMensajeTo());
		servicioEmail.setTelefonoTo(entidad.getTelefonoTo());
		servicioEmail.setUsernameTo(entidad.getUsernameTo());
		return servicioEmail.enviarMailRegistro();
	}
	
	
	@PostMapping("/notificarContacto")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean notificarContacto(@RequestBody Email entidad) {
		SendMailGmail servicioEmail = new SendMailGmail();
		servicioEmail.setEmailTo(entidad.getEmailTo());
		servicioEmail.setMensajeTo(entidad.getMensajeTo());
		servicioEmail.setTelefonoTo(entidad.getTelefonoTo());
		servicioEmail.setUsernameTo(entidad.getUsernameTo());
		return servicioEmail.enviarMailContacto();
	}

}
