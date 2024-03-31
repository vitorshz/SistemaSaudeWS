package br.unipar.sistemasaude.ws.models;


public abstract class Pessoa {
    private int pessoaid;
    private String nome;
    private String email;
    private String telefone;
    private int isActive;
    private Endereco endereco;

    public Pessoa(int pessoaid, String nome, String email, String telefone, int isActive, Endereco endereco) {
        this.pessoaid = pessoaid;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.isActive = isActive;
        this.endereco = endereco;
    }



    public Pessoa() {
    }

    public int getPessoaid() {
        return pessoaid;
    }

    public void setPessoaid(int pessoaid) {
        this.pessoaid = pessoaid;
    }
    
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    


}


    
    

    
    
        

