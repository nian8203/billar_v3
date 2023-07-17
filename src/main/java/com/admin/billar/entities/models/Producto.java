package com.admin.billar.entities.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOMBRE",length = 20, nullable = false)
	private String nombre;
	@Column(name = "MARCA",length = 20, nullable = false)
	private String marca;
	@Column(name = "TIPO",length = 20)
	private String tipo;
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	@Column(name = "PRECIO")
	private BigDecimal precio;
	@Column(name = "ACTIVO")
	private char activo;
	@Column(name = "CREADO")
	private LocalDate createAt;
	@Column(name = "ACTUALIZADO")
	private LocalDateTime updateAt;

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, String marca, String tipo, Integer cantidad, BigDecimal precio, char activo,
			LocalDate createAt, LocalDateTime updateAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.activo = activo;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public char getActivo() {
		return activo;
	}

	public void setActivo(char activo) {
		this.activo = activo;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

}
