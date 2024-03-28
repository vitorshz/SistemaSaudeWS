package br.unipar.sistemasaude.ws.errors;

public class ConsultaNaoPodeSerCanceladaError extends Exception{
    public ConsultaNaoPodeSerCanceladaError(){
        super("A consulta somente poderá ser cancelada com antecedência mínima de 24 horas");
    }
}
