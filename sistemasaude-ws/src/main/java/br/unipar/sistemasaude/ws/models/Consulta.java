package br.unipar.sistemasaude.ws.models;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.enuns.MotivoCancelamentosEnum;

public class Consulta {
    private int id;
    private int pacienteid;
    private int medicoid;
    private LocalDateTime datahora;
    private MotivoCancelamentosEnum motivoCancelamento;
    private int isActive;

}
