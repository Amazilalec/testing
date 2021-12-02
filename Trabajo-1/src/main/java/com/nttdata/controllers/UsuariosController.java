package com.nttdata.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Carrito;
import com.nttdata.models.Usuario;
import com.nttdata.services.CarritoService;
import com.nttdata.services.UsuarioService;

import ch.qos.logback.core.net.SyslogOutputStream;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	CarritoService carritoService;

	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
		model.addAttribute("listaUsuarios",usuarioService.obtenerListaUsuarios());
		return "usuarios.jsp";
	}
	/*
	@RequestMapping("/login")
	public String login(Principal principal, Model model, HttpSession session) {
		String nombre = principal.getName();
		Usuario usuario = usuarioService.findByNombre(nombre);
		model.addAttribute("nombre_usuario", usuario.getNombre());
		return "home.jsp";
	}
	*/
		
		@RequestMapping("/login")
		String login(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session) {

		
		System.out.println(username+" "+password);
		boolean resultado = usuarioService.loginUsuario(username, password);
		if(resultado) { 
			Usuario usuario = usuarioService.findByNombre(username);
			//variable de sesion, almacenando las variables de session
			session.setAttribute("usuario_id", usuario.getId());
			session.setAttribute("nombre_usuario", usuario.getNombre());
			// return "redirect:/home";}
			return "home.jsp";}
		else return "redirect:/login";
			
	}
	
	@RequestMapping("/registrar")
	//revisar esta wea
	String registrar(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
		if(usuario2 == null) {
		//usuarioService.registroUsuario(usuario);
			usuarioService.persistirUsuarioRol(usuario);
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/registrarjsp")
	public String registrarjsp(@ModelAttribute("usuario") Usuario usuario) {

	return "registro.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id") Long id) {
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario == null) {
			return "redirect:/usuarios";
		}
		else {
		usuarioService.eliminarUsuarioObjeto(usuario);
		return "redirect:/usuarios";
		}
	}
	@RequestMapping("/{id}/editar")
	//el pathvariable recibe parametros desde la URL
	public String edit(@PathVariable("id") Long id, Model model) {
		System.out.println("editar");
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario !=null) {
			model.addAttribute("usuario",usuario);
			return "editar.jsp";	
		}
		return "redirect:/usuarios";
	}
	//${sessionScope.usuarioLogin.getName()}
	// session.setAttribute("usuarioLogin", usuarioLogin);
    @RequestMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
    	System.out.println("Update");
        if (result.hasErrors()) {
            return "editar.jsp";
        } else {
        	usuarioService.updateUsuario(usuario);
            return "redirect:/usuarios";
        }
    }
}