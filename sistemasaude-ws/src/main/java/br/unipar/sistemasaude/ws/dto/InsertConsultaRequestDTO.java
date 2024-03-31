package br.unipar.sistemasaude.ws.dto;

import java.time.LocalDateTime;

public class InsertConsultaRequestDTO {
    private int id;
    private int pacienteid;
    private int medicoid;
    private LocalDateTime datahora;
    private int isActive;

    public InsertConsultaRequestDTO(int id, int pacienteid, int medicoid, LocalDateTime datahora, int isActive) {
        this.id = id;
        this.pacienteid = pacienteid;
        this.medicoid = medicoid;
        this.datahora = datahora;
        this.isActive = isActive;
    }

    public InsertConsultaRequestDTO() {
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

    public LocalDateTime getDatahora() {
        return datahora;
    }

    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    
    
    }
