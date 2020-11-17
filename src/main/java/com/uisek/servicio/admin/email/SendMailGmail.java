package com.uisek.servicio.admin.email;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailGmail {

	private String usernameTo = "";
	private String emailTo = "";
	private String telefonoTo = "";
	private String mensajeTo = "";
	
	
	//private String correoEnvia = "yagamichester@gmail.com";
	//private String claveCorreo = "Chester_yagami5";
	private String correoEnvia = "informes.tecnicos@karpatty.com";
	private String claveCorreo = "AdminUIOFirm14";
	private Properties properties = new Properties();

	public SendMailGmail() {
		properties.put("mail.smtp.host", "smtp.office365.com");// mail.office365.com
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");// 25
		properties.put("mail.smtp.auth", "true");// false
		properties.put("mail.user", correoEnvia);
		properties.put("mail.password", claveCorreo);
	}

	public void send(String host, String port, final String userName, final String password, String toAddress,
			String subject, String htmlBody, Map<String, String> mapInlineImages)
			throws AddressException, MessagingException {
		// sets SMTP server properties

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(htmlBody, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds inline image attachments
		if (mapInlineImages != null && mapInlineImages.size() > 0) {
			Set<String> setImageID = mapInlineImages.keySet();

			for (String contentId : setImageID) {
				MimeBodyPart imagePart = new MimeBodyPart();
				imagePart.setHeader("Content-ID", "<" + contentId + ">");
				imagePart.setDisposition(MimeBodyPart.INLINE);

				String imageFilePath = mapInlineImages.get(contentId);
				try {
					imagePart.attachFile(imageFilePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(imagePart);
			}
		}

		msg.setContent(multipart);

		Transport.send(msg);
	}

	public boolean enviarMailRegistro() {
		// SMTP info
		String host = properties.getProperty("mail.smtp.host");
		String port = properties.getProperty("mail.smtp.port");

		// message info
		String mailTo = emailTo;
		String subject = "REGISTRO EN NINESSELAS";
		StringBuffer body = new StringBuffer("<html><br>");
		// body.append("<img src=\"cid:image1\" style=\"width:100%;height:100px\"/>");
		body.append(
				"<form style=\"padding: 0px 14px 0px 14px;border-bottom:none !important;border-top:none !important;border: solid 1px red;\"> Estimado Usuario.<br><br>");
		body.append("<br>"+usernameTo);
		body.append("<br>Gracias por registrarse en UISEK<br>Sus Datos de Registro:<br>");
		body.append("Fecha: " + new Date() + "<br>");
		body.append("Su Email: " + emailTo + " <br><br>");
		body.append("# Teléfono: " + telefonoTo + "<br><br>");
		body.append("<br>" + mensajeTo + "<br><br><br>");
		body.append("Atentamente,<br>");
		body.append("Office TEST XD.</form>");
		// body.append("<img src=\"cid:image2\" style=\"width:100%;height:130px\"
		// /><br>");
		body.append("</html>");

		// inline images
		Map<String, String> inlineImages = new HashMap<String, String>();
		// inlineImages.put("image1", "C:/Users/Public/Pictures/imagenCabecera.png");
		// inlineImages.put("image2", "C:/Users/Public/Pictures/imagenPie.png");

		// inlineImages.put("image1", "/home/digetbi/imagenCabecera.png");
		// inlineImages.put("image2", "/home/digetbi/imagenPie.png");

		try {
			send(host, port, correoEnvia, claveCorreo, mailTo, subject, body.toString(), inlineImages);
			System.out.println("Email sent.");
			return true;
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean enviarMailContacto() {
		// SMTP info
		String host = properties.getProperty("mail.smtp.host");
		String port = properties.getProperty("mail.smtp.port");

		// message info
		String mailTo = correoEnvia;
		String subject = "USUARIO NUEVO CONTACTADO";
		StringBuffer body = new StringBuffer("<html><br>");
		// body.append("<img src=\"cid:image1\" style=\"width:100%;height:100px\"/>");
		body.append(
				"<form style=\"padding: 0px 14px 0px 14px;border-bottom:none !important;border-top:none !important;border: solid 1px red;\"> Estimado Usuario.<br><br>");
		body.append("Notificación de Contacto<br>");
		body.append("EL USUARIO CONTACTADO ES: "+usernameTo+"<br><br>");
		body.append("Fecha: " + new Date() + "<br>");
		body.append("EL CORREO DEL USUARIO ES: " + emailTo + " <br><br>");
		body.append("EL TELEFONO DEL USUARIO ES: " + telefonoTo + "<br><br>");
		body.append("EL COMENTARIO DEL USUARIO ES: " + mensajeTo + "<br><br><br>");
		body.append("Atentamente,<br>");
		body.append("TEST XD.</form>");
		// body.append("<img src=\"cid:image2\" style=\"width:100%;height:130px\"
		// /><br>");
		body.append("</html>");

		// inline images
		Map<String, String> inlineImages = new HashMap<String, String>();
		// inlineImages.put("image1", "C:/Users/Public/Pictures/imagenCabecera.png");
		// inlineImages.put("image2", "C:/Users/Public/Pictures/imagenPie.png");

		// inlineImages.put("image1", "/home/digetbi/imagenCabecera.png");
		// inlineImages.put("image2", "/home/digetbi/imagenPie.png");

		try {
			send(host, port, correoEnvia, claveCorreo, mailTo, subject, body.toString(), inlineImages);
			System.out.println("Email sent.");
			return true;
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		SendMailGmail email = new SendMailGmail();
		email.setEmailTo("wilson.castro@epn.edu.ec");
		email.setMensajeTo("Orueba de envio");
		email.setTelefonoTo("0998571410");
		email.setUsernameTo("TEST");
		email.enviarMailRegistro();
		
	
		

		
	}

	/** SETTERS Y GETTERS **/

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
