package br.unipar.sistemasaude.ws.models;


public class Paciente extends Pessoa{
    private int pacienteId;

    public Paciente(int pacienteId, int pessoaid, String nome, String email, String telefone, String Cpf, int isActive) {
        super(pessoaid, nome, email, telefone, Cpf, isActive);
        this.pacienteId = pacienteId;
    }
    
    public Paciente() {
        
    }
    
    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
}
