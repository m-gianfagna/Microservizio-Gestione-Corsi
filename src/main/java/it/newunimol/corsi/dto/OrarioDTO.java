package it.newunimol.corsi.dto;

public class OrarioDTO {
    private String id;
    private String giorno;
    private String oraInizio;
    private String oraFine;
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

