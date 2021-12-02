package com.nttdata.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	//despues del log tirarlo al home
	@RequestMapping("/home")
		public String home(HttpSession session, Model model) {
		//get attribute retorna un objeto, y se necesita castearlo en otro tipo de dato para usarlo
		String nombre = (String) session.getAttribute("nombre_usuario");
		model.addAttribute("nombre_usuario", nombre);
		
		return "home/home.jsp";
	}
}