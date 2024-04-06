package br.unipar.sistemasaude.ws.errors;

public class ClinicaForaDoHorarioException extends Exception{
    public ClinicaForaDoHorarioException() {
        super("Clinica funciona so durante as 7 as 19 horas");
    }
}
