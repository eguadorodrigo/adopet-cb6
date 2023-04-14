package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.entities.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, UUID> {

}
