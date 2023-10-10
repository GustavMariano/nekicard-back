package br.com.neki.nekicard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.nekicard.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    
}
