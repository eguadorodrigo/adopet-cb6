package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
