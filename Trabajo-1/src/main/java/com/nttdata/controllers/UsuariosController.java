package com.nttdata.controllers;

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
	@RequestMapping("/login")
		String login(@Valid @ModelAttribute("usuario") Usuario usuario, Model model)
	{
		System.out.println(usuario.getNombre()+" "+usuario.getApellido()+" "+usuario.getLimite()+" "+usuario.getCodigoPostal()); 
		usuarioService.insertarUsuario(usuario);
		if(usuario.getCarrito() == null) {
			Carrito carrito = new Carrito();
			carrito.setUsuario(usuario);
			usuario.setCarrito(carrito);
			carritoService.insertarCarrito(carrito);
			usuarioService.insertarUsuario(usuario);
		}
		
		return "redirect:/usuarios";
		
		
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
	public String edit(@PathVariable("id") Long id, Model model) {
		System.out.println("editar");
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario !=null) {
			model.addAttribute("usuario",usuario);
			return "editar.jsp";	
		}
		return "redirect:/usuarios";
	}

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