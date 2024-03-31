package br.unipar.sistemasaude.ws.repository;

import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PessoaRepository {
    private EnderecoRepository enderecorepository;
    
    public PessoaRepository() {
        enderecorepository = new EnderecoRepository();
    }
    
    public ArrayList<Pessoa> findPessoa(String nome) {
        return null;
        }

    public ArrayList<Pessoa> listAllPessoas() {
        return null;
    }

    public Pessoa insertPessoa(Pessoa pessoa) throws SQLException {

        String query
                = "INSERT INTO Pessoa (NOME, EMAIL, TELEFONE,enderecoid, ISACTIVE) VALUES (?, ?, ?, ?,?)";;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
       
        try {
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getTelefone());
            ps.setInt(4, pessoa.getEndereco().getEnderecoid());
            ps.setInt(5, 1);
            
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            rs.next();
            pessoa.setPessoaid(rs.getInt(1));

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

    public void update(Pessoa pessoa) throws SQLException {
        Connection conn = null;
        PreparedStatement psPessoa = null;

        try {
            conn = new ConnectionFactory().getConnection();

            
            String queryPessoa = "UPDATE pessoa SET nome = ?, email = ?, telefone = ?, enderecoid = ? WHERE id = ?";
            psPessoa = conn.prepareStatement(queryPessoa);
            psPessoa.setString(1, pessoa.getNome());
            psPessoa.setString(2, pessoa.getEmail());
            psPessoa.setString(3, pessoa.getTelefone());
            psPessoa.setInt(4, pessoa.getEndereco().getEnderecoid());
            psPessoa.setInt(5, pessoa.getPessoaid());
            psPessoa.executeUpdate();

        } finally {
            
            if (psPessoa != null) psPessoa.close();
            if (conn != null) conn.close();
        }
    }

    
    public void deletePessoa(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "DELETE FROM pessoa WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    
}
