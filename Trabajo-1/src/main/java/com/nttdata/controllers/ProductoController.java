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

import com.nttdata.models.Producto;
import com.nttdata.models.Usuario;
import com.nttdata.models.Venta;
import com.nttdata.services.CarritoService;
import com.nttdata.services.ProductoService;
import com.nttdata.services.UsuarioService;
import com.nttdata.services.VentaService;


@Controller
@RequestMapping("/productos")
public class ProductoController {
@Autowired
ProductoService productoService;
@Autowired
VentaService ventaService;
@Autowired
UsuarioService usuarioService;
@Autowired
CarritoService carritoService;
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

@RequestMapping("/listaproductos")
public String listaProducto(@ModelAttribute("producto") Producto producto, Model model) {
	model.addAttribute("listaProductos", productoService.obtenerListaProductos());
	
	return "producto/listaProductos.jsp";
	}
//ESTA LINKEANDO AL CARRITO DEL USUARIO, SOLO FALTA PRESENTARLO POR PANTALLA
@RequestMapping("/listaproductos/comprar")
	public String comprar(@RequestParam("id") Long id) {
	Venta venta = new Venta();
	Producto producto = productoService.buscarProductoId(id);
	Usuario usuario = usuarioService.buscarUsuarioId(14L);
	venta.setDetalle(producto.getCaracteristica());
	venta.setTotal(producto.getPrecio());
	venta.setCarrito(usuario.getCarrito());
	ventaService.agregarProducto(producto,venta);
	//venta.getProductos().add(producto);
	ventaService.insertarVenta(venta);
	
	if(usuario.getCarrito() != null) {
		usuario.getCarrito().getLista_ventas().add(venta);
		carritoService.insertarCarrito(usuario.getCarrito());
	}
	return "redirect:/productos/listaproductos";
}
/*
@RequestMapping("/listaproductos/comprar/finalizar")
	public String crearVenta(@Valid @ModelAttribute("venta") Venta venta) {
	ventaService.insertarVenta(venta);
	
	return "redirect:/productos/listaproductos";
}
*/
@RequestMapping("/busquedacategorias")
public String busquedacategorias(Model model) {
	model.addAttribute("producto", new Producto());
	return "producto/busquedacategoria.jsp";
}

@RequestMapping("producto/busquedacategorias/categoria")
public String buscarPorCategoria(@RequestParam String categoria, Model model, @ModelAttribute("producto") Producto producto) {
	if(categoria.isEmpty()) return "redirect:/productos";
	else {
	model.addAttribute("productoPorCategoria", productoService.buscarPorCategoria(categoria));
	return "producto/busquedaexitosa.jsp";
	}
}

@RequestMapping("producto/busquedacategorias/nombre")
public String buscarPorNombre(@RequestParam String nombre, Model model, @ModelAttribute("producto") Producto producto) {
	model.addAttribute("productoPorNombre", productoService.buscarPorNombre(nombre));
	return "producto/busquedaexitosa.jsp";
}



}