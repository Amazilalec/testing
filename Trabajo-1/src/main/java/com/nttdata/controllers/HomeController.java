package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	//http://localhost:8080/
	// metodo inicial
	public String index() {

		return "/home/index.jsp";
	}
	
	@RequestMapping("/login")
		String login(@ModelAttribute("usuario") Usuario usuario, Model model) {
			model.addAttribute("listaUsuarios",usuarioService.obtenerListaUsuarios());
			return "/home/login.jsp";
	}
	

}