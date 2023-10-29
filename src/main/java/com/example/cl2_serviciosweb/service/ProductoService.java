package com.example.cl2_serviciosweb.service;

import com.example.cl2_serviciosweb.model.ProductoModel;
import com.example.cl2_serviciosweb.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    // agregar - actualizar
    public void saveProducto(ProductoModel productoModel){
        productoRepository.save(productoModel);
    }
    // eliminar
    public void deleteProducto(ProductoModel productoModel){
        productoRepository.delete(productoModel);
    }
    // listar
    public List<ProductoModel> getProductos(){
        return productoRepository.findAll();
    }
    // find by id
    public ProductoModel getProductoById(Integer id){
        return productoRepository.findById(id).get();
    }
    // obtener por nombre
    public ProductoModel getProductoByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }
    // obtener mayor cantidad a 10 y menor 100
    public List<ProductoModel> getProductosMayor10Menor100(){
        return productoRepository.findProductosBetween10And100();
    }
    // obtener fecha vencimiento 2024
    public List<ProductoModel> getProductosVec2024(){
        return productoRepository.findProductosWithYear2024();
    }
}
