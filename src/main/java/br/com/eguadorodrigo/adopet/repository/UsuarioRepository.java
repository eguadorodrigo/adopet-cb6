package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("SELECT u from Usuario u where u.email = ?1")
    Optional<Usuario> buscarPorEmail(String email);


}
