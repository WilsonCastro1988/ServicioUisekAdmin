package com.uisek.servicio.admin.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisek.servicio.admin.model.entity.TipoCuenta;

public interface TipoCuentaDao extends JpaRepository<TipoCuenta, Long> {

}
