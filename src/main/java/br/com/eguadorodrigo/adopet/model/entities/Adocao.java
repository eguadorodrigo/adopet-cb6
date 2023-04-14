package br.com.eguadorodrigo.adopet.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "ADOCAO")
@Table(name ="tb_adocao", schema = "CB6")
public class Adocao {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "animal_id", foreignKey = @ForeignKey(name = "Fk_adocao_pet"))
    private Pet animal;

    @ManyToOne
    @JoinColumn(name = "tutor_id", foreignKey = @ForeignKey(name = "Fk_adocao_tutor"))
    private Tutor tutor;

    @Column(name = "data")
    private LocalDateTime data;

    public Adocao(UUID id, Pet animal, Tutor tutor, LocalDateTime data) {
        this.id = id;
        this.animal = animal;
        this.tutor = tutor;
        this.data = data;
    }

    public Adocao() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pet getAnimal() {
        return animal;
    }

    public void setAnimal(Pet animal) {
        this.animal = animal;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
