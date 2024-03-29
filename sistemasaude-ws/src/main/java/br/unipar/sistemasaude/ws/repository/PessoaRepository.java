/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.repository;

import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
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
public class PessoaRepository {

    public PessoaRepository() {
    }
    
    public ArrayList<Pessoa> findPessoa(String nome) {
        return null;
        }

    public ArrayList<Pessoa> listAllPessoas() {
        return null;
    }

    public Pessoa insertPessoa(Pessoa pessoa) throws SQLException {

        String query
                = "INSERT INTO Pessoa (NOME, EMAIL, TELEFONE, CPF, ISACTIVE) VALUES (?, ?, ?, ?,?)";;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
       
        try {
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getTelefone());
            ps.setBoolean(5, true);
            
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            rs.next();
            pessoa.setId(rs.getInt(1));

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return pessoa;
    }

    public Pessoa updatePessoa(Pessoa pessoa) throws Exception {
        String queryValidateIsActive = "SELECT * FROM PACIENTE WHERE NOME = ? ISACTIVE = 1";
        String query = "UPDATE PACIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, cpf = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(queryValidateIsActive);
            ps.setString(1, pessoa.getNome());
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
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getTelefone());

            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return pessoa;    }

    
    public PacienteRepository deletePessoa(int id) {
        return null;
    }

    
}
