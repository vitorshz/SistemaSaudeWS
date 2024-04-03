package br.unipar.sistemasaude.ws.repository;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Endereco;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.models.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PacienteRepository {
    
    private EnderecoRepository enderecoRepository;
    private PessoaRepository pessoaRepository;
    public PacienteRepository() {
        this.enderecoRepository = new EnderecoRepository();
        this.pessoaRepository = new PessoaRepository();   
     }
 

    public ArrayList<Paciente> listAll() throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT p.cpf, p.pessoaid, p.id, pe.nome, pe.isActive " +
                       "FROM paciente p " +
                       "INNER JOIN pessoa pe ON p.pessoaid = pe.id " +
                       "ORDER BY pe.nome";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf"));
                paciente.setPessoaid(rs.getInt("pessoaid"));
                paciente.setPacienteid(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setIsActive(rs.getInt("isactive"));

                pacientes.add(paciente);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return pacientes;
    }
    
    public Paciente findById(int pacienteId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Paciente paciente = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT p.cpf, p.pessoaid, pe.nome, pe.isActive " +
                           "FROM paciente p " +
                           "INNER JOIN pessoa pe ON p.pessoaid = pe.id " +
                           "WHERE p.id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, pacienteId);
            rs = ps.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setPacienteid(pacienteId);
                paciente.setCpf(rs.getString("cpf"));
                paciente.setPessoaid(rs.getInt("pessoaid"));
                paciente.setNome(rs.getString("nome"));
                paciente.setIsActive(rs.getInt("isActive"));
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return paciente;
    }

    public Paciente insert(Paciente paciente) throws SQLException {
        Connection conn = null;
        PreparedStatement psPaciente = null;
        ResultSet rsPaciente = null;

        try {
            conn = new ConnectionFactory().getConnection();
            
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            Endereco enderecoInserido = enderecoRepository.insert(paciente.getEndereco());
            
            PessoaRepository pessoaRepository = new PessoaRepository();
            paciente.setEndereco(enderecoInserido); 
            Pessoa p = pessoaRepository.insertPessoa(paciente);
            
            
            if(p!=null){
             
             // Define o ID da pessoa inserida no paciente
            paciente.setPessoaid(p.getPessoaid());    
            
            String queryPaciente = "INSERT INTO paciente (pessoaid, cpf) VALUES (?, ?)";
            psPaciente = conn.prepareStatement(queryPaciente, PreparedStatement.RETURN_GENERATED_KEYS);
            psPaciente.setInt(1, paciente.getPessoaid()); 
            psPaciente.setString(2, paciente.getCpf());
            psPaciente.executeUpdate();

            rsPaciente = psPaciente.getGeneratedKeys();
            if (rsPaciente.next()) {
                paciente.setPacienteid(rsPaciente.getInt(1)); 
            } else {
                throw new SQLException("Falha ao inserir o paciente na tabela paciente.");
            }
            }
            
        } finally {
            
            if (rsPaciente != null) rsPaciente.close();
            if (psPaciente != null) psPaciente.close();
            if (conn != null) conn.close();
        }

        return paciente;
    }

    public void update(Paciente paciente) throws SQLException {
        Connection conn = null;
        PreparedStatement psPaciente = null;

        try {
            conn = new ConnectionFactory().getConnection();

            EnderecoRepository enderecoRepository = new EnderecoRepository();
            enderecoRepository.update(paciente.getEndereco());
            
            PessoaRepository pessoaRepository = new PessoaRepository();
            pessoaRepository.update(paciente);

            
            String queryPaciente = "UPDATE paciente SET cpf = ? WHERE pessoaid = ?";
            psPaciente = conn.prepareStatement(queryPaciente);
            psPaciente.setString(1, paciente.getCpf());
            psPaciente.setInt(2, paciente.getPacienteid());
            psPaciente.executeUpdate();
            
        } finally {
            
            if (psPaciente != null) psPaciente.close();
            if (conn != null) conn.close();
        }
    }

    
    public void delete(int pacienteId) throws SQLException {
        Connection conn = null;
        PreparedStatement psPaciente = null;

        try {
            conn = new ConnectionFactory().getConnection();
            
            String query = "UPDATE pessoa SET isActive = 0 WHERE id = (SELECT pessoaid FROM paciente WHERE id = ?)";
            psPaciente = conn.prepareStatement(query);
            psPaciente.setInt(1, pacienteId);
            psPaciente.executeUpdate();
            
        } finally {
            
            if (psPaciente != null) psPaciente.close();
            if (conn != null) conn.close();
        }
    }
    
    
}
