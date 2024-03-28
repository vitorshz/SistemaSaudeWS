package br.unipar.sistemasaude.ws.errors;

public class DontExistsMedicoError extends Exception{
    public DontExistsMedicoError() {
        super("o medico não foi encontrada, verifique as informações enviadas e tente novamente");
    }
}
