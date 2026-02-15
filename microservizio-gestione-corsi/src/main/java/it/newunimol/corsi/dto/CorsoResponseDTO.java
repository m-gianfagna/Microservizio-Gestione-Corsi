package it.newunimol.corsi.dto;

import java.io.Serializable;
import java.util.List;

public class CorsoResponseDTO implements Serializable {
    private String id;
    private String nome;
    private String codice;
    private String descrizione;
    private int cfu;
    private List<DocenteDTO> docenti;
    private List<OrarioDTO> orari;

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodice() { return codice; }
    public void setCodice(String codice) { this.codice = codice; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public int getCfu() { return cfu; }
    public void setCfu(int cfu) { this.cfu = cfu; }

    public List<DocenteDTO> getDocenti() { return docenti; }
    public void setDocenti(List<DocenteDTO> docenti) { this.docenti = docenti; }

    public List<OrarioDTO> getOrari() { return orari; }
    public void setOrari(List<OrarioDTO> orari) { this.orari = orari; }
}

