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

import com.nttdata.models.Venta;
import com.nttdata.services.ProductoService;
import com.nttdata.services.VentaService;
@Controller
@RequestMapping("/ventas")
public class VentaController {
@Autowired
VentaService ventaService;
@Autowired
ProductoService productoService;
@RequestMapping("")
public String Venta(@ModelAttribute("venta") Venta venta, Model model){
	model.addAttribute("listaventas", ventaService.obtenerListaVentas());
	return "venta/ventas.jsp";
	}
@RequestMapping("/login")
public String login(@Valid @ModelAttribute("venta") Venta venta) {
	ventaService.insertarVenta(venta);
	return "redirect:/ventas";
	}
@RequestMapping("/eliminar")
public String eliminarVenta(@RequestParam("id") Long id) {
	Venta venta = ventaService.buscarVentaId(id);
	if(venta!=null)ventaService.eliminarVentaObjeto(venta);
	return "redirect:/ventas";
	}
@RequestMapping("/{id}/editar")
public String edit(@PathVariable("id") Long id, Model model) {
	Venta venta = ventaService.buscarVentaId(id);
	if(venta!=null) {
		model.addAttribute("venta", venta);
		return "/venta/editar.jsp";
		}
	else {
		ventaService.updateVenta(venta);
		return "redirect:/ventas";
		}
	}
@RequestMapping(value="/update/{id}")
public String update(@Valid @ModelAttribute("venta") Venta venta, BindingResult result) {
	if(result.hasErrors()) return "/venta/editar.jsp";
	else ventaService.updateVenta(venta);
	return "redirect:/ventas";
	}

}
