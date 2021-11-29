package com.nttdata.services;
import java.util.List;
import java.util.Vector;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

import com.nttdata.models.Producto;
import com.nttdata.models.Venta;
import com.nttdata.repository.VentaRepository;
@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;
	public List<Venta> obtenerListaVentas() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}

	public void insertarVenta(@Valid Venta venta) {
		// TODO Auto-generated method stub
		ventaRepository.save(venta);
	}

	public Venta buscarVentaId(Long id) {
		// TODO Auto-generated method stub
		return ventaRepository.findById(id).get();
	}

	public void eliminarVentaObjeto(Venta venta) {
		// TODO Auto-generated method stub
		ventaRepository.delete(venta);
	}

	public void updateVenta(@Valid Venta venta) {
		// TODO Auto-generated method stub
		if(ventaRepository.existsById(venta.getId()))ventaRepository.save(venta);
	}
	public void agregarProducto(Producto producto, Venta venta) {
		List temp = new Vector<Object>();
		temp.add(producto);
		venta.setProductos(temp);
	}
}
