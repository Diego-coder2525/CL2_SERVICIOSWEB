package com.example.cl2_serviciosweb.controller;

import com.example.cl2_serviciosweb.model.ProductoModel;
import com.example.cl2_serviciosweb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/producto/")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoModel>> getAllProductos() {
        List<ProductoModel> productoList = new ArrayList<>();
        productoService.getProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList,HttpStatus.OK);
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoModel> getProductoById(@PathVariable Integer id) {
        ProductoModel producto = productoService.getProductoById(id);
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<ProductoModel> createProducto(@RequestBody ProductoModel productoModel) {
        return new ResponseEntity<>(productoService.saveProducto(productoModel),HttpStatus.OK);
    }

    // Actualizar un producto existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductoModel> updateProducto(@PathVariable Integer id, @RequestBody ProductoModel productoModel) {
        ProductoModel oldProducto = productoService.getProductoById(id);
        oldProducto.setCantidad(productoModel.getCantidad());
        oldProducto.setNombre(productoModel.getNombre());
        oldProducto.setFecha_venc(productoModel.getFecha_venc());
        oldProducto.setDescripcion(productoModel.getDescripcion());
        return new ResponseEntity<>(productoService.saveProducto(oldProducto),HttpStatus.OK);
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable Integer id) {
        ProductoModel producto = productoService.getProductoById(id);
        productoService.deleteProducto(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Obtener producto por nombre
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ProductoModel> getProductoByNombre(@PathVariable String nombre){
        ProductoModel producto = productoService.getProductoByNombre(nombre);
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }
    // Obtener productos 2024 vec
    @GetMapping("/vec")
    public ResponseEntity<List<ProductoModel>> getProductos2024(){
        return new ResponseEntity<>(productoService.getProductosVec2024(),HttpStatus.OK);
    }
    // Obtener productos 10 - 100
    @GetMapping("/bet")
    public ResponseEntity<List<ProductoModel>> getProductos10between100(){
        return new ResponseEntity<>(productoService.getProductosMayor10Menor100(),HttpStatus.OK);
    }
}
