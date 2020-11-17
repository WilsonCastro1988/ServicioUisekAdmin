package com.uisek.servicio.admin.email;

public class Email {

	private String usernameTo = "";
	private String emailTo = "";
	private String telefonoTo = "";
	private String mensajeTo = "";

	public String getUsernameTo() {
		return usernameTo;
	}

	public void setUsernameTo(String usernameTo) {
		this.usernameTo = usernameTo;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getTelefonoTo() {
		return telefonoTo;
	}

	public void setTelefonoTo(String telefonoTo) {
		this.telefonoTo = telefonoTo;
	}

	public String getMensajeTo() {
		return mensajeTo;
	}

	public void setMensajeTo(String mensajeTo) {
		this.mensajeTo = mensajeTo;
	}

}
