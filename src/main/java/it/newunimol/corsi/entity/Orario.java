package it.newunimol.corsi.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "orario")
public class Orario {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    private String giorno;
    private String oraInizio;
    private String oraFine;
    private String aula;

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Corso getCorso() { return corso; }
    public void setCorso(Corso corso) { this.corso = corso; }

    public String getGiorno() { return giorno; }
    public void setGiorno(String giorno) { this.giorno = giorno; }

    public String getOraInizio() { return oraInizio; }
    public void setOraInizio(String oraInizio) { this.oraInizio = oraInizio; }

    public String getOraFine() { return oraFine; }
    public void setOraFine(String oraFine) { this.oraFine = oraFine; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }
}

