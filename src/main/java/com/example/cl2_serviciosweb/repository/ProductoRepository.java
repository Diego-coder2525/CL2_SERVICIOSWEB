package com.example.cl2_serviciosweb.repository;

import com.example.cl2_serviciosweb.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Integer > {
    ProductoModel findByNombre(String nombre);
    @Query("SELECT p FROM ProductoModel p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<ProductoModel> findProductosBetween10And100();
    @Query(value = "SELECT * FROM producto p WHERE YEAR(p.fecha_venc) = 2024", nativeQuery = true)
    List<ProductoModel> findProductosWithYear2024();
}
