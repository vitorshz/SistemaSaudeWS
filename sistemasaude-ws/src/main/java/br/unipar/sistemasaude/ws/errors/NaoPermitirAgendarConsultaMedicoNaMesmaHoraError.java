package br.unipar.sistemasaude.ws.errors;

public class NaoPermitirAgendarConsultaMedicoNaMesmaHoraError extends Exception{
    public NaoPermitirAgendarConsultaMedicoNaMesmaHoraError(){
        super("Medico já tem um agendamento neste horario");
    }
}
