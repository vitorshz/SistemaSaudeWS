package br.unipar.sistemasaude.ws.models;

public class Paciente extends Pessoa{
    private int pacienteid;
    private String cpf;

    public Paciente(int pacienteid, String cpf, int pessoaid, String nome, String email, String telefone, int isActive, Endereco endereco) {
        super(pessoaid, nome, email, telefone, isActive, endereco);
        this.pacienteid = pacienteid;
        this.cpf = cpf;
    }
    

    public Paciente() {
    }
    

    public int getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(int pacienteid) {
        this.pacienteid = pacienteid;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
}
