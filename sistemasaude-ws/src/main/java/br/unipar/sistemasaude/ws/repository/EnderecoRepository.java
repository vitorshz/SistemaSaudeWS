package br.unipar.sistemasaude.ws.repository;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EnderecoRepository {

    public EnderecoRepository() {
    }
    
    public Endereco insert(Endereco endereco) throws SQLException {
        
        String query = 
                "INSERT INTO ENDERECO (LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO)"
                + "VALUES(?, ?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(query, 
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, endereco.getLogradouro());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4,endereco.getBairro());

            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            endereco.setEnderecoid(rs.getInt(1));
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return endereco;
    }
    public Endereco findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement psEndereco = null;
        ResultSet rsEndereco = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT rua, cidade, estado, cep FROM endereco WHERE id = ?";
            psEndereco = conn.prepareStatement(query);
            psEndereco.setInt(1, id);
            rsEndereco = psEndereco.executeQuery();

            if (rsEndereco.next()) {
                
                Endereco endereco = new Endereco();
                endereco.setEnderecoid(id);
                endereco.setLogradouro(rsEndereco.getString("rua"));
                endereco.setBairro(rsEndereco.getString("bairro"));
                endereco.setComplemento(rsEndereco.getString("complemento"));
                endereco.setNumero(rsEndereco.getInt("numero"));
                return endereco;
            } else {
                return null; 
            }
        } finally {
            if (rsEndereco != null) rsEndereco.close();
            if (psEndereco != null) psEndereco.close();
            if (conn != null) conn.close();
        }
    }

    public void update(Endereco endereco) throws SQLException {
        Connection conn = null;
        PreparedStatement psEndereco = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "UPDATE endereco SET logradouro = ?, numero = ?, complemento = ?, bairro = ? WHERE id = ?";
            psEndereco = conn.prepareStatement(query);
            psEndereco.setString(1, endereco.getLogradouro());
            psEndereco.setInt(2, endereco.getNumero());
            psEndereco.setString(3, endereco.getComplemento());
            psEndereco.setString(4, endereco.getBairro());
            psEndereco.setInt(5, endereco.getEnderecoid());
            psEndereco.executeUpdate();
        } finally {
            if (psEndereco != null) psEndereco.close();
            if (conn != null) conn.close();
        }
    }

    public EnderecoRepository delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement psEndereco = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "DELETE FROM endereco WHERE id = ?";
            psEndereco = conn.prepareStatement(query);
            psEndereco.setInt(1, id);
            psEndereco.executeUpdate();
        } finally {
            if (psEndereco != null) psEndereco.close();
            if (conn != null) conn.close();
        }
        return null;
    }

   
    
    
}
