package br.unipar.sistemasaude.ws.errors;

public class NaoPermitirAgendamentosNoMesmoDiaError extends Exception{
    public NaoPermitirAgendamentosNoMesmoDiaError() {
        super("Não é permitido agendar 2 consulta para o mesmo paciente no mesmo dia");
    }
}
