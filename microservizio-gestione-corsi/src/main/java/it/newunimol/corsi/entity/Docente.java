package it.newunimol.corsi.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String cognome;

    @Column(unique = true)
    private String email;

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

