package it.newunimol.corsi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.io.Serializable;

@Schema(description = "DTO per la creazione di un nuovo corso")
public class CorsoRequestDTO implements Serializable {
    
    @Schema(description = "Nome del corso", example = "Programmazione Java")
    private String nome;
    
    @Schema(description = "Codice univoco del corso", example = "INF001")
    private String codice;
    
    @Schema(description = "Descrizione del corso", example = "Corso introduttivo di programmazione Java")
    private String descrizione;
    
    @Schema(description = "Crediti formativi universitari", example = "9")
    private int cfu;
    
    @Schema(description = "Lista degli UUID dei docenti associati", example = "[\"00000000-0000-0000-0000-000000000001\"]")
    private List<String> docentiIds;
    
    @Schema(description = "Orari del corso (l'ID viene generato automaticamente)")
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