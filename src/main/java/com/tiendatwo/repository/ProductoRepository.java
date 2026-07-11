
package com.tiendatwo.repository;

import com.tiendatwo.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository; --- borrar 
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

//@Repository -- borrar 
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public List<Producto> findByActivoTrue();
    
    
    //semana #8 precio asc - desc  ordena los precios de mayor a menor y de menor a mayor 
    public List<Producto> findByPrecioBetweenOrderByPrecioAsc(double precioInf, double precioSup);
    
    // linea 2 semana #8 se usa para la practica #2 se envia por el mismo de un parametro -- terminar de copiar 
   @Query(value = "SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Producto> consultaJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    // linea 3 -- 
    @Query(nativeQuery = true,
     value = "SELECT * FROM producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    public List<Producto> consultaSQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //practica #2 6-7-2026
   
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto p WHERE p.existencias = :existencias")
    public List<Producto> buscarPorExistencias(@Param("existencias") Integer existencias);
}

