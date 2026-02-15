package it.newunimol.corsi.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "corso")
public class Corso {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String codice;
    private String descrizione;
    private int cfu;

    @ManyToMany
    @JoinTable(name = "corso_docente",
            joinColumns = @JoinColumn(name = "corso_id"),
            inverseJoinColumns = @JoinColumn(name = "docente_id"))
    private Set<Docente> docenti = new HashSet<>();

    @OneToMany(mappedBy = "corso", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orario> orari = new HashSet<>();

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodice() { return codice; }
    public void setCodice(String codice) { this.codice = codice; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public int getCfu() { return cfu; }
    public void setCfu(int cfu) { this.cfu = cfu; }

    public Set<Docente> getDocenti() { return docenti; }
    public void setDocenti(Set<Docente> docenti) { this.docenti = docenti; }

    public Set<Orario> getOrari() { return orari; }
    public void setOrari(Set<Orario> orari) { this.orari = orari; }
}

