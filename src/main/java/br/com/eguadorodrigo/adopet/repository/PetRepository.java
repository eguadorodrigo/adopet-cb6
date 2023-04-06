package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pets, Long> {

}
