/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.models;

/**
 *
 * @author lucia
 */

public class Medico extends Pessoa{
    
    private int id;
    private int crm;
    private String especializacao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Medico(int id, int crm, String especializacao, int pessoaid, String nome, String email, String telefone, int isActive) {
        super(pessoaid, nome, email, telefone, isActive);
        this.id = id;
        this.crm = crm;
        this.especializacao = especializacao;
    }

    
    public Medico() {
    
    }

 
}
