package com.goncode.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goncode.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
 
    
}
