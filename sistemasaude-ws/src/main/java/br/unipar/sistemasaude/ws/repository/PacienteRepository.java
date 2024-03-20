/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.repository;

import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Paciente;
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

    public ArrayList<Paciente> findPaciente(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Paciente> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Paciente insert(Paciente paciente) throws SQLException {

        String query
                = "INSERT INTO PACIENTE (NOME, EMAIL, TELEFONE, "
                + "CPF) "
                + "VALUES(?, ?, ?, ?);";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEmail());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getCpf());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            rs.next();
            paciente.setId(rs.getInt(1));

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

        return paciente;
    }

    public Paciente update(Paciente paciente) throws SQLException {
        String query = "UPDATE PACIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, cpf = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        

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

    public Paciente atualizar(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PacienteRepository delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
