package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Carrito;
import com.nttdata.models.Usuario;
import com.nttdata.repository.CarritoRepository;

@Service
public class CarritoService {
	@Autowired
	CarritoRepository carritoRepository;
	@Autowired
	UsuarioService usuarioService;
	public void insertarCarrito(@Valid Carrito carrito) {
		carritoRepository.save(carrito);
		
	}



}
