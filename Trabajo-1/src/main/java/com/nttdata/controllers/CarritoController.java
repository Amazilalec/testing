package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Carrito;
import com.nttdata.services.CarritoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	CarritoService carritoService;
	@Autowired
	UsuarioService usuarioService;
	@RequestMapping("")
	public String carrito(@ModelAttribute("carrito") Carrito carrito, Model model) {
		model.addAttribute("carrito", new Carrito());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "Carrito/carrito.jsp";
		}
	
	@RequestMapping("/crear")
	public String crearCarrito(@Valid @ModelAttribute("carrito") Carrito carrito) {
		carritoService.insertarCarrito(carrito);
		return "redirect:/carrito";
	}
}
