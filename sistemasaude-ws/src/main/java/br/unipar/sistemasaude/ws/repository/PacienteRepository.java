/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.repository;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class PacienteRepository {

    public PacienteRepository() {
    }

    public ArrayList<Paciente> findPaciente(String nome) {
        return null;
        }

    public ArrayList<Paciente> listAll() {
        return null;
    }

    public Paciente insert(Paciente paciente) throws SQLException {
        Connection conn = null;
    PreparedStatement psPessoa = null;
    PreparedStatement psPaciente = null;
    ResultSet rsPessoa = null;
    ResultSet rsPaciente = null;

    try {
        conn = new ConnectionFactory().getConnection();

        
        String queryPessoa = "INSERT INTO pessoa (nome, email, telefone, cpf, isActive) VALUES (?, ?, ?, ?, ?)";
        psPessoa = conn.prepareStatement(queryPessoa, Statement.RETURN_GENERATED_KEYS);
        psPessoa.setString(1, paciente.getNome()); 
        psPessoa.setString(2, paciente.getEmail());
        psPessoa.setString(3, paciente.getTelefone());
        psPessoa.setString(4, paciente.getCpf());
        psPessoa.setInt(5, 1); //setando o isactive para 1 = ativo 
        psPessoa.executeUpdate();

        // Obtendo o ID (chave primária) da pessoa inserida
        rsPessoa = psPessoa.getGeneratedKeys();
        if (rsPessoa.next()) {
            int pessoaid = rsPessoa.getInt(1);

            
            String queryPaciente = "INSERT INTO paciente (pessoaid) VALUES (?)";
            psPaciente = conn.prepareStatement(queryPaciente, Statement.RETURN_GENERATED_KEYS);
            psPaciente.setInt(1, pessoaid); 
            psPaciente.executeUpdate();

            
            rsPaciente = psPaciente.getGeneratedKeys();
            if (rsPaciente.next()) {
                paciente.setPacienteId(rsPaciente.getInt(1)); 
            }
        } else {
            throw new SQLException("Falha ao inserir a pessoa na tabela pessoa.");
        }
         } finally {
        // Fechando recursos em um bloco finally para garantir que sejam sempre fechados,
        // mesmo se uma exceção for lançada
        if (rsPessoa != null) rsPessoa.close();
        if (psPessoa != null) psPessoa.close();
        if (rsPaciente != null) rsPaciente.close();
        if (psPaciente != null) psPaciente.close();
        if (conn != null) conn.close();
    }

    return paciente;
    }

    public Paciente update(Paciente paciente) throws Exception {
        String queryValidateIsActive = "SELECT * FROM PACIENTE WHERE NOME = ? ISACTIVE = 1";
        String query = "UPDATE PACIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, cpf = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(queryValidateIsActive);
            ps.setString(1, paciente.getNome());
            ResultSet ifIsActive = ps.executeQuery();
            if (ifIsActive == null){
                throw new Exception("dado não encontrado");
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEmail());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getCpf());

            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return paciente;    }

    
    public PacienteRepository delete(int id) {
        return null;
    }
    
    
    
}
