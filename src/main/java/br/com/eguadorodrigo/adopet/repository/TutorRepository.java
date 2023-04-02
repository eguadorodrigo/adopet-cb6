package br.com.eguadorodrigo.adopet.repository;

import br.com.eguadorodrigo.adopet.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
