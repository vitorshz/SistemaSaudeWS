package br.unipar.sistemasaude.ws.errors;

public class ConsultaDeverSeragendadaAntesError extends Exception{
    public ConsultaDeverSeragendadaAntesError() {
        super("A consulta deve ser agendada com antecendência de 30 minutos");
    }
}
