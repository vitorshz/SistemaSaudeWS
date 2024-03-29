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
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int isActive;
    private int medicoId;
    private int pacienteId;

    public Pessoa(int id, String nome, String email, String telefone, int isActive,int medicoId,int pacienteId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.isActive = isActive;
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
    }
    
    public Pessoa() {
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
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



    

    
    
        
}
