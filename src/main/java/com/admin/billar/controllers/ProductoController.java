package com.admin.billar.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.admin.billar.entities.models.Producto;
import com.admin.billar.entities.request.ProductoRequest;
import com.admin.billar.entities.response.ProductoResponse;
import com.admin.billar.repositories.IProductoRepository;
import com.admin.billar.service.IProductoService;
import com.admin.billar.service.impl.ProductoServiceImpl;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	Map<String, Object> response = new HashMap<>();
	
	private final IProductoService productoService;
	private IProductoRepository productoRepository;
	
	public ProductoController(IProductoService productoService, IProductoRepository productoRepository) {
		this.productoService = productoService;
		this.productoRepository = productoRepository;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductoRequest productoRequest){
		Producto p = productoService.create(productoRequest);
		response.put("mensaje", "producto creado con éxito");
		response.put("producto", p);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(productoService.list());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		ProductoResponse pr = productoService.getById(id);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (pr == null) {
			response.put("resultado","producto no encontrado");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("resultado","producto encontrado");
		response.put("producto",pr);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/test/{id}")
	public ResponseEntity<?> getTest(@PathVariable Long id){
		return ResponseEntity.ok().body(productoService.getTest(id));
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductoRequest request){		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.update(request, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Producto eliminado con éxito");
	}
	
}
