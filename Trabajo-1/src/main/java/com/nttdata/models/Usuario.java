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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity //representacion de la entidad modelo
@Table(name="usuarios") // nombre de la tabla en la db

public class Usuario {
	@Id // primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // auto incrementable
	private Long id;
	@NotBlank
	@NotNull
	private String nombre;
	@NotBlank
	@NotNull
	private String apellido;
	@NotBlank
	@NotNull
	private String limite;
	@NotBlank
	@NotNull
	private String codigoPostal;
	@NotBlank
	@NotNull
	private String nombreUsuario;
	@NotBlank
	@NotNull
	private String password;
	@NotBlank
	@NotNull
	private String email;
	//con trasient es que no entra a la base de datos
	@Transient
	private String passwordConfirmation;
	private Date createdAt;
	private Date updatedAt;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	
	private Carrito carrito;
	//trae todo de una el eager, el lazy solo trae cuando le piden
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="usuarios_roles",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private List<Role> roles;
	
	
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String apellido, String limite, String codigoPostal,
			String nombreUsuario, String password,String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.limite = limite;
		this.codigoPostal = codigoPostal;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getLimite() {
		return limite;
	}
	public void setLimite(String limite) {
		this.limite = limite;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
