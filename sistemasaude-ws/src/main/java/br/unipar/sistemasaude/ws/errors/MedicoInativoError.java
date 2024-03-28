package br.unipar.sistemasaude.ws.errors;

public class MedicoInativoError extends Exception{
    public MedicoInativoError() {
        super("Medico não encontrado ou inativo");
    }
}
