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

    public PacienteRepository() {
    }

    public ArrayList<Paciente> listAll() throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT * FROM paciente";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setPacienteid(rs.getInt("pacienteid"));
                paciente.setId(rs.getInt("pessoaid"));
                

                pacientes.add(paciente);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return pacientes;
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
                paciente.setPacienteid(rsPaciente.getInt(1)); 
            }
        } else {
            throw new SQLException("Falha ao inserir a pessoa na tabela pessoa.");
        }
         } finally {
        if (rsPessoa != null) rsPessoa.close();
        if (psPessoa != null) psPessoa.close();
        if (rsPaciente != null) rsPaciente.close();
        if (psPaciente != null) psPaciente.close();
        if (conn != null) conn.close();
    }

    return paciente;
    }

    public Paciente update(Paciente paciente) throws Exception {
     Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = new ConnectionFactory().getConnection();
        
        String updatePessoaQuery = "UPDATE pessoa SET nome = ?, email = ?, telefone = ?, "
                + "cpf = ?, isActive = ? WHERE pessoaid = ?";
        ps = conn.prepareStatement(updatePessoaQuery);
        ps.setString(1, paciente.getNome());
        ps.setString(2, paciente.getEmail());
        ps.setString(3, paciente.getTelefone());
        ps.setString(4, paciente.getCpf());
        ps.setInt(5, paciente.getIsActive());
        ps.setInt(6, paciente.getId());
        ps.executeUpdate();

        
        String updatePacienteQuery = "UPDATE paciente SET WHERE pessoaid = ?";
        ps = conn.prepareStatement(updatePacienteQuery);
        ps.setInt(2, paciente.getId());
        ps.executeUpdate();

    } finally {
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }

    return paciente;
    }

    
    public PacienteRepository delete(int id) {
        return null;
    }
    
    
    
}
