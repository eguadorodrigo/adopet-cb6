package br.com.eguadordorigo.adopet.repository;

import br.com.eguadordorigo.adopet.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("select count(u) = 1 from Usuario u where u.email = ?1")
    public Optional<Usuario> buscarPorEmail(String email);


}
