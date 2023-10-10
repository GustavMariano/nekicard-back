package br.com.neki.nekicard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.neki.nekicard.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDetails findByEmail(String email);
    
}
