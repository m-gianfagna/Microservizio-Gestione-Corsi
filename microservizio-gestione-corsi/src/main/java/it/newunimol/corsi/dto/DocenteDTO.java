package it.newunimol.corsi.dto;

import java.io.Serializable;

public class DocenteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nome;
    private String cognome;
    private String email;

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}