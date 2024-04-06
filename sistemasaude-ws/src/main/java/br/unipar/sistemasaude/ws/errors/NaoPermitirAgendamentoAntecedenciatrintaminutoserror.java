package br.unipar.sistemasaude.ws.errors;

public class NaoPermitirAgendamentoAntecedenciatrintaminutoserror extends Exception{
    public NaoPermitirAgendamentoAntecedenciatrintaminutoserror() {
        super("As consultas devem ser agendadas com antecedência mínima de 30 minutos");
    }
}
