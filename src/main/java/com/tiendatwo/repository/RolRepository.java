package com.tiendatwo.repository;

import com.tiendatwo.domain.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    
    
    public Optional<Rol> findByRol(String rol);

}

