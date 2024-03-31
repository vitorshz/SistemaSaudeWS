package br.unipar.sistemasaude.ws.models;


public class Endereco {
    private int enderecoid;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private int idPessoa;
    
    public Endereco() {
    }
    
    public Endereco(int enderecoid, String logradouro, int numero, String complemento, String bairro, int idPessoa) {
        this.enderecoid = enderecoid;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.idPessoa = idPessoa;
    }

    public int getEnderecoid() {
        return enderecoid;
    }

    public void setEnderecoid(int enderecoid) {
        this.enderecoid = enderecoid;
    }

    

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    

    
    }
