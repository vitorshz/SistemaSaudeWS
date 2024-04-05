package br.unipar.sistemasaude.ws.models;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.enuns.MotivoCancelamentosEnum;

public class Consulta {
    private int id;
    private int pacienteid;
    private int medicoid;
    private int duracaoemminutos = 60;
    private LocalDateTime datahora;
    private MotivoCancelamentosEnum motivoCancelamento;
    private int isActive;

    public Consulta(int id, int pacienteid, int medicoid, LocalDateTime datahora, MotivoCancelamentosEnum motivoCancelamento, int isActive,int duracaoemminutos) {
        this.id = id;
        this.pacienteid = pacienteid;
        this.medicoid = medicoid;
        this.datahora = datahora;
        this.duracaoemminutos = duracaoemminutos;
        this.motivoCancelamento = motivoCancelamento;
        this.isActive = isActive;
    }
    

    public Consulta() {
     
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

    public MotivoCancelamentosEnum getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(MotivoCancelamentosEnum motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }


    public void setMotivoCancelamento(String string) {

        throw new UnsupportedOperationException("Unimplemented method 'setMotivoCancelamento'");
    }
    
    
    }
