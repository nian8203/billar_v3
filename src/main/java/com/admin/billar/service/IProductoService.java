package com.admin.billar.service;

import java.util.List;
import java.util.Map;

import com.admin.billar.entities.models.Producto;
import com.admin.billar.entities.request.ProductoRequest;
import com.admin.billar.entities.response.ProductoResponse;

public interface IProductoService {
	
	Producto create(ProductoRequest request);
	ProductoResponse getById(Long id);
	Map<String, Object> list();
	void Producto(Long id);
	public Map<String, Object> getTest(Long id);
	public Map<String, Object> update(ProductoRequest request, Long id);

}
