package com.admin.billar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.billar.entities.models.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Long> {

}
