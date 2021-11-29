package com.nttdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
	List<Carrito> findAll();
}
