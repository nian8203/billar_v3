package com.admin.billar.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.admin.billar.entities.models.Producto;
import com.admin.billar.entities.request.ProductoRequest;
import com.admin.billar.entities.response.ProductoResponse;
import com.admin.billar.repositories.IProductoRepository;
import com.admin.billar.service.IProductoService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	private final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	private final IProductoRepository productoRepository;
	
	public ProductoServiceImpl(IProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Producto create(ProductoRequest request) {
		// TODO Auto-generated method stub
		return productoRepository.save(request(request));
	}
	

	@Override
	public ProductoResponse getById(Long id) {
		// TODO Auto-generated method stub
		return requestById(id);
	}

	@Override
	public Map<String, Object> list() {
		// TODO Auto-generated method stub
		Map<String, Object> res = new HashMap<>();
		List<Producto> productos = productoRepository.findAll();
		listResponse(productos);
		res.put("mensaje", "productos disponibles");
		res.put("productos", productos);		
		return res;
	}

	@Override
	public void Producto(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}
	
	@Override
	public Map<String, Object> getTest(Long id){
	    Producto p = productoRepository.findById(id).orElse(null);	    
	    return requestByIdMap(p);
	    
	}
	
	@Override
	public Map<String, Object> update(ProductoRequest request, Long id) {
		// TODO Auto-generated method stub
		Producto p = (Producto)responseUpdate(request, id).get("producto");
		productoRepository.save(p);
		return responseUpdate(request, id);
	}
	

	private Producto request(ProductoRequest request) {
		Producto p = new Producto();
		p.setActivo('S');
		p.setCreateAt(LocalDate.now());
		p.setUpdateAt(LocalDateTime.now());
		BeanUtils.copyProperties(request, p);
		return p;		
	}
	
	private ProductoResponse requestById(Long id) {
		ProductoResponse resp = new ProductoResponse();
		log.info(id.toString());
		Producto p = productoRepository.findById(id).get();
		if (p == null) {
			log.info("no hay informacion");
		}
		BeanUtils.copyProperties(p, resp);
		return resp;
	}
	
	// retorna producto por id, correspondiente al service public Map<String, Object> getTest(Long id)
	private Map<String, Object> requestByIdMap(Producto p) {
		Map<String, Object> result = new HashMap<>();
		ProductoResponse pr = new ProductoResponse();		
	    if (p == null) {
	        result.put("mensaje", "el producto no se encuentra registrado");
	    } else {
	    	BeanUtils.copyProperties(p, pr);
	        result.put("mensaje", "producto disponible");
	        result.put("producto", pr);
	    }
	    return result;
	}
	
	// actualizar productos
	private Map<String, Object> responseUpdate(ProductoRequest request, Long id) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		Producto p = productoRepository.findById(id).orElse(null);
		if (p == null) {
			result.put("mensaje", "el producto no se encientra registrado");
			return result;
		}
		p.setUpdateAt(LocalDateTime.now());
		BeanUtils.copyProperties(request, p);
		result.put("mensaje", "producto actualizado con éxito");
		result.put("producto", p);
		return result;
	}
	
	private List<ProductoResponse> listResponse(List<Producto> productos){
		List<ProductoResponse> response = new ArrayList<>();
		BeanUtils.copyProperties(productos, response);
		return response;
	}

	
	
	


}
