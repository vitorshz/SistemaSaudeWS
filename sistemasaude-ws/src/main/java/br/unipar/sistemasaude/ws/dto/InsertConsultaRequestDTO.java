package br.unipar.sistemasaude.ws.dto;

import java.time.LocalDateTime;

public class InsertConsultaRequestDTO {
    private int id;
    private int pacienteid;
    private int medicoid;
    private LocalDateTime datahora;
    private int isActive;
}
