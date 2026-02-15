package it.newunimol.corsi.dto;

import java.util.List;

public class CorsoRequestDTO {
    private String nome;
    private String codice;
    private String descrizione;
    private int cfu;
    private List<String> docentiIds;
    private List<OrarioDTO> orari;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodice() { return codice; }
    public void setCodice(String codice) { this.codice = codice; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public int getCfu() { return cfu; }
    public void setCfu(int cfu) { this.cfu = cfu; }

    public List<String> getDocentiIds() { return docentiIds; }
    public void setDocentiIds(List<String> docentiIds) { this.docentiIds = docentiIds; }

    public List<OrarioDTO> getOrari() { return orari; }
    public void setOrari(List<OrarioDTO> orari) { this.orari = orari; }
}

