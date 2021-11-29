package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="carritos")
public class Carrito {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	
	private Date createdAt;
	private Date updatedAt;
	private Double total_pagar;
	//CARRO SE RELACIONA CON LAS VENTAS 
	//CON LOGIN SE IMPLEMENTA EL MAPPING 1 A 1 CON USUARIO
	@OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Venta> lista_ventas;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	
	
	public Carrito() {
		super();
	}

	public Carrito(Long id, Double total_pagar) {
		super();
		this.id = id;
		this.total_pagar = total_pagar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal_pagar() {
		return total_pagar;
	}

	public void setTotal_pagar(Double total_pagar) {
		this.total_pagar = total_pagar;
	}

	public List<Venta> getLista_ventas() {
		return lista_ventas;
	}

	public void setLista_ventas(List<Venta> lista_ventas) {
		this.lista_ventas = lista_ventas;
	}
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", total_pagar=" + total_pagar + "]";
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
