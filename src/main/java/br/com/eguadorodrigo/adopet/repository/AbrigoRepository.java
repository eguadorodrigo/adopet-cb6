package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.entities.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {

}
