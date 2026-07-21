package com.tiendatwo.repository;

import java.util.List;
import com.tiendatwo.domain.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // se trabaja por consultas derivadas para buscar el usuario activo y no pueden ver dos usuarios iguales 
    // documuentacion de gobierno covid19?? info 
    // uno de los grandes problemas en los sistemas  es la infomacion duplicada 
    
    
    // segunda parte del usuario repository semmana #11
    public Optional<Usuario> findByUsernameAndActivoTrue(String username);

    public List<Usuario> findByActivoTrue();

    public Optional<Usuario> findByUsername(String username);

    public Optional<Usuario> findByUsernameAndPassword(String username, String Password);

    public Optional<Usuario> findByUsernameOrCorreo(String username, String correo);

    public boolean existsByUsernameOrCorreo(String username, String correo);

   // terminar de explicar el codigo :)

}


