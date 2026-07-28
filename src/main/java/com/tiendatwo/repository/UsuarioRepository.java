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
    
    // busca que el usuario este activo
    public Optional<Usuario> findByUsernameAndActivoTrue(String username);
    
    //busca todos los activos 
    public List<Usuario> findByActivoTrue();
    
    //busca por nombre de usernamr
    public Optional<Usuario> findByUsername(String username);
    
    //busca por usuario password
    public Optional<Usuario> findByUsernameAndPassword(String username, String Password);
    
    //busca por usuuario correo 
    public Optional<Usuario> findByUsernameOrCorreo(String username, String correo);
    
    // verifica que exista el usuario con los parametros que tenga 
    public boolean existsByUsernameOrCorreo(String username, String correo);

   // terminar de explicar el codigo :)

}


