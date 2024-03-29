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
    
    private int medicoid;
    private int crm;
    private String especializacao;

    public Medico(int medicoid, int crm, String especializacao, int id, String nome, String email, String telefone, int isActive) {
        super(id, nome, email, telefone, isActive);
        this.medicoid = medicoid;
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public Medico() {
    }

    public int getMedicoid() {
        return medicoid;
    }

    public void setMedicoid(int medicoid) {
        this.medicoid = medicoid;
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

    

   


   

 
}
