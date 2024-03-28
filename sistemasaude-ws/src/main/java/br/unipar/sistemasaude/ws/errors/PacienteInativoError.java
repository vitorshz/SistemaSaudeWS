package br.unipar.sistemasaude.ws.errors;

public class PacienteInativoError extends Exception{
    public PacienteInativoError(){
        super("paciente não exites ou esta inativado");
    }
}
