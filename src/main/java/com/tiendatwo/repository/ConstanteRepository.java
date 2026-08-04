package com.tiendatwo.repository;

import com.tiendatwo.domain.Constante;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstanteRepository extends JpaRepository<Constante,Integer> {
    
    //findbyAtributo 
    // es una consulta derivada que permite trater los datos de la base de datos pertinentes 
    
    public Optional<Constante> findByAtributo(String atributo);
    
}