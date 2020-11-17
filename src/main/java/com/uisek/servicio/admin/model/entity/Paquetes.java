/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisek.servicio.admin.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name="paquetes")
@XmlRootElement
public class Paquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paquete", nullable = false)
    private Long idPaquete;
    @Column(name = "numero_aplicacion")
    private Integer numeroAplicacion;
    @Column(name = "numero_matriculas")
    private Integer numeroMatriculas;
    @Column(name = "numero_menus")
    private Integer numeroMenus;
    @Column(name = "numero_cursos")
    private Integer numeroCursos;
    @Column(name = "numero_perfil_usuario")
    private Integer numeroPerfilUsuario;
    @Column(name = "numero_perfiles")
    private Integer numeroPerfiles;
    @Column(name = "numero_permisos")
    private Integer numeroPermisos;
    @Column(name = "numero_usuarios")
    private Integer numeroUsuarios;
    @Column(name = "numero_Carreras")
    private Integer numeroCarreras;
    @OneToMany(mappedBy = "paquete")
    @JsonBackReference
    private List<TipoCuenta> tipoCuentaList;

    public Paquetes() {
    }

	public Long getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Long idPaquete) {
		this.idPaquete = idPaquete;
	}

	public Integer getNumeroAplicacion() {
		return numeroAplicacion;
	}

	public void setNumeroAplicacion(Integer numeroAplicacion) {
		this.numeroAplicacion = numeroAplicacion;
	}

	public Integer getNumeroMatriculas() {
		return numeroMatriculas;
	}

	public void setNumeroMatriculas(Integer numeroMatriculas) {
		this.numeroMatriculas = numeroMatriculas;
	}

	public Integer getNumeroMenus() {
		return numeroMenus;
	}

	public void setNumeroMenus(Integer numeroMenus) {
		this.numeroMenus = numeroMenus;
	}

	public Integer getNumeroCursos() {
		return numeroCursos;
	}

	public void setNumeroCursos(Integer numeroCursos) {
		this.numeroCursos = numeroCursos;
	}

	public Integer getNumeroPerfilUsuario() {
		return numeroPerfilUsuario;
	}

	public void setNumeroPerfilUsuario(Integer numeroPerfilUsuario) {
		this.numeroPerfilUsuario = numeroPerfilUsuario;
	}

	public Integer getNumeroPerfiles() {
		return numeroPerfiles;
	}

	public void setNumeroPerfiles(Integer numeroPerfiles) {
		this.numeroPerfiles = numeroPerfiles;
	}

	public Integer getNumeroPermisos() {
		return numeroPermisos;
	}

	public void setNumeroPermisos(Integer numeroPermisos) {
		this.numeroPermisos = numeroPermisos;
	}

	public Integer getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public void setNumeroUsuarios(Integer numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}

	public Integer getNumeroCarreras() {
		return numeroCarreras;
	}

	public void setNumeroCarreras(Integer numeroCarreras) {
		this.numeroCarreras = numeroCarreras;
	}

	public List<TipoCuenta> getTipoCuentaList() {
		return tipoCuentaList;
	}

	public void setTipoCuentaList(List<TipoCuenta> tipoCuentaList) {
		this.tipoCuentaList = tipoCuentaList;
	}

    
    
}
