package br.unipar.sistemasaude.ws.dto;

public class InsertConsultaRequest {
    private int id;
    private int pacienteid;
    private int medicoid;
    private String datahora;
    private int isActive;
    public InsertConsultaRequest(int id, int pacienteid, int medicoid, String datahora, int isActive) {
        this.id = id;
        this.pacienteid = pacienteid;
        this.medicoid = medicoid;
        this.datahora = datahora;
        this.isActive = isActive;
    }

    public InsertConsultaRequest() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(int pacienteid) {
        this.pacienteid = pacienteid;
    }

    public int getMedicoid() {
        return medicoid;
    }

    public void setMedicoid(int medicoid) {
        this.medicoid = medicoid;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    
    
}
