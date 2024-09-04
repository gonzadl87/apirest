package com.goncode.apirest.apirest.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goncode.apirest.apirest.Entities.Producto;
import com.goncode.apirest.apirest.Repositories.ProductoRepository;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping()
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id){
        return productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: "+id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detalleProducto){
        Producto producto = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontro el producto con el ID: "+id));

        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return productoRepository.save(producto);
    
    }

}


