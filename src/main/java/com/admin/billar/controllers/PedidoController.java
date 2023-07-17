package com.admin.billar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.billar.entities.models.Pedido;
import com.admin.billar.repositories.IPedidoRepository;
import com.admin.billar.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	private final IPedidoRepository pedidoRepository;
	
	public PedidoController(IPedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pedido pedido){
		return ResponseEntity.status(HttpStatus.OK).body(pedidoRepository.save(pedido));
	}
	
}
