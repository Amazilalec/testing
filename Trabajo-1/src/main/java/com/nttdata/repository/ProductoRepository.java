package com.nttdata.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	List<Producto> findAll();
	List<Producto> findByCategoria(String categoria);
	List<Producto> findByNombre(String nombre);
}
