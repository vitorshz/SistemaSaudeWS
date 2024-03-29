package br.unipar.sistemasaude.ws.models;


public class Paciente extends Pessoa{
    private int pacienteId;
    private String cpf;

    public Paciente(int pacienteId, String cpf, int pessoaid, String nome, String email, String telefone, int isActive) {
        super(pessoaid, nome, email, telefone, isActive);
        this.pacienteId = pacienteId;
        this.cpf = cpf;
    }

   
    public Paciente() {
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }
}
