package br.com.eguadorodrigo.adopet.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "TUTOR")
public class Tutor extends Usuario{
}
