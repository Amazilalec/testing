package com.nttdata.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id // primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	//observaciones, el generated value debe seguir inmediato de la primary key o se pone a llorar
	private String nombre;
	private String precio;
	
	public Producto() {
		super();
	}
	public Producto(String nombre, String precio, Long id) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	}