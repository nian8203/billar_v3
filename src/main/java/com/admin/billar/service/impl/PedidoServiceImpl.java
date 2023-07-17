package com.admin.billar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.billar.entities.models.Pedido;
import com.admin.billar.entities.models.Producto;
import com.admin.billar.repositories.IPedidoRepository;
import com.admin.billar.repositories.IProductoRepository;
import com.admin.billar.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private IProductoRepository productoRepository;
	
	@Override
	 public Pedido crearPedido(Pedido pedido) {
        List<Producto> productos = pedido.getProductos();
        for (Producto producto : productos) {
            Producto productoBD = productoRepository.findById(producto.getId()).orElse(producto);
            if (productoBD != null) {
                pedido.getProductos().add(productoBD);
            }
        }
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        return pedidoGuardado;
	}

}
