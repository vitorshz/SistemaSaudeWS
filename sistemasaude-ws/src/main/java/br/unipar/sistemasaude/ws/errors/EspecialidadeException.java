package br.unipar.sistemasaude.ws.errors;

public class EspecialidadeException extends Exception{

    public EspecialidadeException() {
        super("A especialização so pode ser Ortoledia,Cardiologia,Ginecologia Dermatologia");
    }
    
}
