package com.admin.billar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.billar.entities.models.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
