package com.admin.billar.entities.request;

import java.math.BigDecimal;

public class ProductoRequest {

	private String nombre;
	private String marca;
	private String tipo;
	private Integer cantidad;
	private BigDecimal precio;

	public ProductoRequest() {
		super();
	}

	public ProductoRequest(String nombre, String marca, String tipo, Integer cantidad, BigDecimal precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

}
