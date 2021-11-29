package com.nttdata.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="productos")
public class Producto {
	@Id // primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	//observaciones, el generated value debe seguir inmediato de la primary key o se pone a llorar
	@NotNull
	@NotBlank
	private String nombre;
	@NotNull
	@NotBlank
	private Double precio;
	@NotNull
	@NotBlank
	private String categoria;
	@NotNull
	@NotBlank
	private String caracteristica; 
	
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="productos_ventas",
			joinColumns = @JoinColumn(name="producto_id"),
			inverseJoinColumns = @JoinColumn(name="venta_id")
			)
	private List<Venta> ventas;
	/*
	@OneToOne(mappedBy="producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="venta_id")
	
	private Venta venta;
	*/
	public Producto() {
		super();
	}
	public Producto(String nombre, Double precio, Long id, String categoria, String caracteristica) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.caracteristica = caracteristica;
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + ", caracteristica="
				+ caracteristica + "]";
	}
	
	public List<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	}