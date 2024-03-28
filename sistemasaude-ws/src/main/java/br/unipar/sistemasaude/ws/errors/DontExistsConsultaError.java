package br.unipar.sistemasaude.ws.errors;

public class DontExistsConsultaError extends Exception{
    public DontExistsConsultaError() {
        super("a consulta não foi encontrada, verifique as informações enviadas e tente novamente");
    }
}
