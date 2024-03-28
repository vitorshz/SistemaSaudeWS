package br.unipar.sistemasaude.ws.errors;

public class DontExistsPacienteError extends Exception {
    public DontExistsPacienteError() {
        super("o paciente não foi encontrada, verifique as informações enviadas e tente novamente");
    }
}
