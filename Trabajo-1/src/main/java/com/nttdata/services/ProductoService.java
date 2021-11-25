package com.nttdata.services;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.models.Usuario;
import com.nttdata.repository.ProductoRepository;
@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> obtenerListaProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	public void insertarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
		
	}

	public Producto buscarProductoId(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	public void eliminarProductoObjeto(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.delete(producto);
	}

	public void updateProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		if(productoRepository.existsById(producto.getId())) {
			productoRepository.save(producto);
		}
	}

}
