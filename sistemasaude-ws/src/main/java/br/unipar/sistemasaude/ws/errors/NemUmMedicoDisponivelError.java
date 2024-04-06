package br.unipar.sistemasaude.ws.errors;

public class NemUmMedicoDisponivelError extends Exception{
    public NemUmMedicoDisponivelError() {
        super("Não Existe medico disponivel neste horario, tente outro horario");
    }
}
