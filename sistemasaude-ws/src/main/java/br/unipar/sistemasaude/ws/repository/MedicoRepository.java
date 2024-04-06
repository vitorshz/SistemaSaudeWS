package br.unipar.sistemasaude.ws.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Endereco;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Pessoa;

public class MedicoRepository {
    
    @SuppressWarnings("unused")
    private EnderecoRepository enderecoRepository;
    @SuppressWarnings("unused")
    private PessoaRepository pessoaRepository;
    
    public MedicoRepository() {
        this.enderecoRepository = new EnderecoRepository();
        this.pessoaRepository = new PessoaRepository();  
    }
    
    public ArrayList<Medico> listAll() throws SQLException {
        ArrayList<Medico> medicos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT m.*, pe.nome, pe.email, pe.telefone, pe.isActive, pe.enderecoid " +
                           "FROM medico m " +
                           "INNER JOIN pessoa pe ON m.pessoaid = pe.id " +
                           "ORDER BY pe.nome ASC";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setMedicoid(rs.getInt("id"));
                medico.setCrm(rs.getInt("crm"));
                medico.setEspecializacao(rs.getString("especializacao"));
                medico.setPessoaid(rs.getInt("pessoaid"));
                medico.setNome(rs.getString("nome"));
                medico.setEmail(rs.getString("email"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setIsActive(rs.getInt("isActive"));

                // Define o ID do endereço no médico
                Endereco endereco = new Endereco();
                endereco.setEnderecoid(rs.getInt("enderecoid"));
                medico.setEndereco(endereco);
                
                medicos.add(medico);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return medicos;
    }
    
    public Medico findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Medico medico = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT m.*, pe.nome, pe.email, pe.telefone, pe.isActive, pe.enderecoid " +
                           "FROM medico m " +
                           "INNER JOIN pessoa pe ON m.pessoaid = pe.id " +
                           "WHERE m.id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                medico = new Medico();
                medico.setMedicoid(rs.getInt("id"));
                medico.setCrm(rs.getInt("crm"));
                medico.setEspecializacao(rs.getString("especializacao"));
                medico.setPessoaid(rs.getInt("pessoaid"));
                medico.setNome(rs.getString("nome"));
                medico.setEmail(rs.getString("email"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setIsActive(rs.getInt("isActive"));
                
                // Define o ID do endereço no médico
                Endereco endereco = new Endereco();
                endereco.setEnderecoid(rs.getInt("enderecoid"));
                medico.setEndereco(endereco);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return medico;
    }

    public Medico insert(Medico medico) throws SQLException, EspecialidadeException {
        
        String query = 
                "INSERT INTO MEDICO (CRM, ESPECIALIZACAO,pessoaid)"
                + "VALUES(?, ?, ?);";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if(!medico.getEspecializacao().equals("Ortopedia") && !medico.getEspecializacao().equals("Cardiologia") && 
                !medico.getEspecializacao().equals("Ginecologia") && !medico.getEspecializacao().equals("Dermatologia")) {
            
            throw new EspecialidadeException();
            
            }
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            Endereco enderecoInserido = enderecoRepository.insert(medico.getEndereco());
            
            PessoaRepository pessoaRepository = new PessoaRepository();
            medico.setEndereco(enderecoInserido); 
            Pessoa p = pessoaRepository.insertPessoa(medico);

            if(p!=null){
            
             // Define o ID da pessoa inserida no paciente
            medico.setPessoaid(p.getPessoaid());    
            
            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, medico.getCrm()); 
            ps.setString(2, medico.getEspecializacao());
            ps.setInt(3, medico.getPessoaid());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                medico.setMedicoid(rs.getInt(1)); 
            } else {
                throw new SQLException("Falha ao inserir o paciente na tabela medico.");
                }
            }
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return medico;
        
    }
    
    public void update(Medico medico) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "UPDATE medico SET crm = ?, especializacao = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, medico.getCrm());
            ps.setString(2, medico.getEspecializacao());
            ps.setInt(3, medico.getMedicoid());
            
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }
    
    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "UPDATE pessoa SET isActive = 0 WHERE id = (SELECT pessoaid FROM medico WHERE id = ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
