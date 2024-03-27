/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.service;

import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Pessoa;
import br.unipar.sistemasaude.ws.repository.PacienteRepository;
import br.unipar.sistemasaude.ws.repository.PessoaRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class PessoaService {
    
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    private Connection connection = null;
    private PessoaRepository pessoaRepository = null;

    public ArrayList<Pessoa> findPessoa(String nome) {
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.findPessoa(nome);  
    }

    public ArrayList<Pessoa> listAllPessoas() {
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.listAllPessoas();
    }

    public Pessoa insertPessoa(Pessoa pessoa) throws SQLException {
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.insertPessoa(pessoa);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa)  throws Exception {
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.updatePessoa(pessoa);
    }

    public PessoaRepository deletePessoa(int id) {
        PessoaRepository pessoaRepository = new PessoaRepository();
        pessoaRepository.deletePessoa(id);
        return null;
    }
    
    
}
