package com.admin.billar.entities.models;

import java.util.List;
import java.util.UUID;

import com.admin.billar.enums.EstadoPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "CODIGO")
	private UUID codigo;
	@NotBlank
	@Column(name = "MESA")
	private String mesa;
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO")
	private EstadoPedido estado = EstadoPedido.ESTADO;

	@Column(name = "PEDIDOS")
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "pedidos_productos", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "producto_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "pedido_id", "producto_id" }) })
	private List<Producto> productos;

	public Pedido() {
		super();
	}

	public Pedido(Long id, UUID codigo, String mesa, EstadoPedido estado, List<Producto> productos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.mesa = mesa;
		this.estado = estado;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getCodigo() {
		return UUID.randomUUID();
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
