package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Producto;
import com.nttdata.models.Usuario;
import com.nttdata.services.ProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {
@Autowired
ProductoService productoService;
@RequestMapping("")
public String producto(@ModelAttribute("producto") Producto producto, Model model) {
	model.addAttribute("listaProductos", productoService.obtenerListaProductos());
	return "producto/productos.jsp";
	}

@RequestMapping("/login")
public String login(@Valid @ModelAttribute("producto") Producto producto){
	productoService.insertarProducto(producto);
	return "redirect:/productos";
	}

@RequestMapping("/eliminar")
public String eliminar(@RequestParam("id") Long id) {
	Producto producto = productoService.buscarProductoId(id);
	if(producto == null) {
		return "redirect:/productos";
	}
	else {
	productoService.eliminarProductoObjeto(producto);
	return "redirect:/productos";
	}
}
@RequestMapping("/{id}/editar")
public String edit(@PathVariable("id") Long id, Model model) {
	System.out.println("editar");
	Producto producto = productoService.buscarProductoId(id);
	if(producto !=null) {
		model.addAttribute("producto",producto);
		return "/producto/editar.jsp";	
	}
	return "redirect:/productos";
}

@RequestMapping("/update/{id}")
public String update(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
	System.out.println("Update");
    if (result.hasErrors()) {
        return "/producto/editar.jsp";
    } else {
    	productoService.updateProducto(producto);
        return "redirect:/productos";
    }
}
}