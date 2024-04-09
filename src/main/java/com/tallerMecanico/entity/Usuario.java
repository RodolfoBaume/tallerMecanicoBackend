package com.tallerMecanico.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long idUsuario;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
	, inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id_rol"))
	private List<Rol> rol = new ArrayList<>();
	@OneToOne(mappedBy = "usuario")
    @JsonIgnore
	private Cliente cliente;
	@OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Empleado empleado;
	
	public Usuario() {
		super();
	}

	public Usuario(long idUsuario, String email, String password, List<Rol> rol, Cliente cliente, Empleado empleado) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRol() {
		return rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}
