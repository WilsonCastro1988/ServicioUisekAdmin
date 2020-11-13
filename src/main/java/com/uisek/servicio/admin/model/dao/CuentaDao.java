package com.uisek.servicio.admin.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisek.servicio.admin.model.entity.Cuenta;

public interface CuentaDao extends JpaRepository<Cuenta, Long> {

}
