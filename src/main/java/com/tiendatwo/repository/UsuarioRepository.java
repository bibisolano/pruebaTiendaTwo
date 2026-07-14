package com.tiendatwo.repository;

import com.tiendatwo.domain.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // se trabaja por consultas derivadas para buscar el usuario activo y no pueden ver dos usuarios iguales 
    // documuentacion de gobierno covid19?? info 
    // uno de los grandes problemas en los sistemas  es la infomacion duplicada 
    
    public Optional<Usuario> findByUsernameAndActivoTrue(String username);
    
}

