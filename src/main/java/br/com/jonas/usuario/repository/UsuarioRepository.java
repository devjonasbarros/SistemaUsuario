package br.com.jonas.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jonas.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
