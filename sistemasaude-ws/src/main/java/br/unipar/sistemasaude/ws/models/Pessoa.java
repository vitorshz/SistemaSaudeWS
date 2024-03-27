/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.models;

/**
 *
 * @author lucia
 */
public abstract class Pessoa {
    private int pessoaid;
    private String nome;
    private String email;
    private String telefone;
    private String Cpf;
    private int isActive;

    public Pessoa(int pessoaid, String nome, String email, String telefone, String Cpf, int isActive) {
        this.pessoaid = pessoaid;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.Cpf = Cpf;
        this.isActive = isActive;
    }
    
    public Pessoa() {
    }

    public int getPessoaid() {
        return pessoaid;
    }

    public void setPessoaid(int pessoaid) {
        this.pessoaid = pessoaid;
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

    

    
    
        
}
