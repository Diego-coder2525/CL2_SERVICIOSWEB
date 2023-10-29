package com.example.cl2_serviciosweb.controller;

import com.example.cl2_serviciosweb.model.ProductoModel;
import com.example.cl2_serviciosweb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto/")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping
    public List<ProductoModel> getAllProductos() {
        return productoService.getProductos();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ProductoModel getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    // Crear un nuevo producto
    @PostMapping
    public void createProducto(@RequestBody ProductoModel productoModel) {
        productoService.saveProducto(productoModel);
    }

    // Actualizar un producto existente por su ID
    @PutMapping("/{id}")
    public void updateProducto(@PathVariable Integer id, @RequestBody ProductoModel productoModel) {
        productoModel.setId(id);
        productoService.saveProducto(productoModel);
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        ProductoModel producto = productoService.getProductoById(id);
        productoService.deleteProducto(producto);
    }
    // Obtener producto por nombre
    @GetMapping("/nombre/{nombre}")
    public ProductoModel getProductoByNombre(@PathVariable String nombre){
        ProductoModel producto = productoService.getProductoByNombre(nombre);
        return producto;
    }
    // Obtener productos 2024 vec
    @GetMapping("/vec")
    public List<ProductoModel> getProductos2024(){
        return productoService.getProductosVec2024();
    }
    // Obtener productos 10 100
    @GetMapping("/bet")
    public List<ProductoModel> getProductos10between100(){
        return productoService.getProductosMayor10Menor100();
    }
}
