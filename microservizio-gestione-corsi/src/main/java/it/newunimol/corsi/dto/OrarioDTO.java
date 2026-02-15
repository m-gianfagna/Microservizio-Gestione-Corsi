package it.newunimol.corsi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "ID univoco dell'orario (generato automaticamente, non specificare in POST)", accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    
    @Schema(description = "Giorno della settimana", example = "Lunedì", required = true)
    private String giorno;
    
    @Schema(description = "Ora di inizio", example = "09:00", required = true)
    private String oraInizio;
    
    @Schema(description = "Ora di fine", example = "11:00", required = true)
    private String oraFine;
    
    @Schema(description = "Aula dove si svolge la lezione", example = "Aula A1", required = true)
    private String aula;

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGiorno() { return giorno; }
    public void setGiorno(String giorno) { this.giorno = giorno; }

    public String getOraInizio() { return oraInizio; }
    public void setOraInizio(String oraInizio) { this.oraInizio = oraInizio; }

    public String getOraFine() { return oraFine; }
    public void setOraFine(String oraFine) { this.oraFine = oraFine; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }
}