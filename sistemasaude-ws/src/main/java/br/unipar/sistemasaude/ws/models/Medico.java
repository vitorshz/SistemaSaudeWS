/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.models;

/**
 *
 * @author lucia
 */

public class Medico {
    private int id;
    private String nome;
    private String email;
    private int telefone;
    private int crm;
    private String especializacao;
    private String enderecocompleto;
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getEnderecocompleto() {
        return enderecocompleto;
    }

    public void setEnderecocompleto(String enderecocompleto) {
        this.enderecocompleto = enderecocompleto;
    }

    public Medico(int id, String nome, String email, int telefone, int crm, String especializacao, String enderecocompleto, boolean isActive) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.crm = crm;
        this.especializacao = especializacao;
        this.enderecocompleto = enderecocompleto;
        this.isActive = isActive;
    }

    
    public Medico() {}

 
}
