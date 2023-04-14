package br.com.eguadorodrigo.adopet.model.request;

import br.com.eguadorodrigo.adopet.model.entities.Pet;
import br.com.eguadorodrigo.adopet.model.entities.Tutor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.UUID;

public class AdocaoRequest {

    private UUID id;

    @NotNull(message = "Animal precisa ser informado.")
    private Pet animal;

    @NotNull(message = "Tutor precisa ser informado")
    private Tutor tutor;

    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "A data deve estar no formato dd/mm/yyyy")
    private LocalDateTime data;

    public AdocaoRequest(UUID id, Pet animal, Tutor tutor, LocalDateTime data) {
        this.id = id;
        this.animal = animal;
        this.tutor = tutor;
        this.data = data;
    }

    public AdocaoRequest() {
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
