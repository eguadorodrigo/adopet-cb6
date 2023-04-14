package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
