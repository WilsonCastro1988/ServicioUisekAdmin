package com.uisek.servicio.admin.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisek.servicio.admin.model.entity.Paquetes;

public interface PaqueteDao extends JpaRepository<Paquetes, Long> {

}
