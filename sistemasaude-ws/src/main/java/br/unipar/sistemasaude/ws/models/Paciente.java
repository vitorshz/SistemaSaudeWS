package br.unipar.sistemasaude.ws.models;


public class Paciente {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String Cpf;
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public Paciente(int id, String nome, String email, String telefone, String Cpf, boolean isActive) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.Cpf = Cpf;
        this.isActive = isActive;
    }

    public Paciente() {
    }
    
}
