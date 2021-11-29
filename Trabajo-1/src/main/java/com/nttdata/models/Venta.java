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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Double total;
	@NotNull
	@NotBlank
	private String detalle;
	private String fecha;
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="productos_ventas",
			joinColumns = @JoinColumn(name="venta_id"),
			inverseJoinColumns = @JoinColumn(name="producto_id")
			)
	private List<Producto> productos;
	/*
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="producto_id")
	private Producto producto;
	*/
	public Venta() {
		super();
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="carrito_id")
	private Carrito carrito;
	
	public Venta(Long id, Double total, String detalle, String fecha) {
		super();
		this.id = id; // se genera solo
		this.total = total; // lo determinan los productos
		this.detalle = detalle; // lo determinan los productos
		this.fecha = fecha; // lo determina la fecha
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	/*
	public Producto getProducto() {
		return producto;
	}
	@Override
	public String toString() {
		return "Venta [total=" + total + ", detalle=" + detalle + ", fecha=" + fecha + "]";
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	*/
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
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
