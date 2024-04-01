package br.unipar.sistemasaude.ws.repository;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Endereco;
import br.unipar.sistemasaude.ws.models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PacienteRepository {
    
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
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
            String query = "SELECT * FROM paciente";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf"));
                paciente.setPessoaid(rs.getInt("pessoaid"));
                

                pacientes.add(paciente);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return pacientes;
    }
    
    public Paciente findById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement psPaciente = null;
        ResultSet rsPaciente = null;

        try {
            conn = new ConnectionFactory().getConnection();
            String query = "SELECT p.pacienteid, p.cpf, pe.nome, pe.email, pe.telefone, pe.enderecoid, pe.isActive " +
                           "FROM paciente p " +
                           "INNER JOIN pessoa pe ON p.pessoaid = pe.pessoaid " +
                           "WHERE p.pacienteid = ?";
            psPaciente = conn.prepareStatement(query);
            psPaciente.setInt(1, id);
            rsPaciente = psPaciente.executeQuery();

            if (rsPaciente.next()) {
                // Recupera os dados do paciente e cria uma instância de Paciente
                Paciente paciente = new Paciente();
                paciente.setPacienteid(rsPaciente.getInt("pacienteid"));
                paciente.setCpf(rsPaciente.getString("cpf"));
                paciente.setNome(rsPaciente.getString("nome"));
                paciente.setEmail(rsPaciente.getString("email"));
                paciente.setTelefone(rsPaciente.getString("telefone"));

                // Recupera o endereço do paciente e define no objeto Paciente
                Endereco endereco = new Endereco();
                endereco.setEnderecoid(rsPaciente.getInt("enderecoid"));
                paciente.setEndereco(endereco);

                // Retorna o objeto Paciente
                return paciente;
            } else {
                return null; // Retorna null se o paciente não for encontrado
            }
        } finally {
            // Fecha os recursos
            if (rsPaciente != null) rsPaciente.close();
            if (psPaciente != null) psPaciente.close();
            if (conn != null) conn.close();
        }
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
            pessoaRepository.insertPessoa(paciente);
            
            String queryPaciente = "INSERT INTO paciente (pessoaid, cpf) VALUES (?, ?)";
            psPaciente = conn.prepareStatement(queryPaciente, PreparedStatement.RETURN_GENERATED_KEYS);
            psPaciente.setInt(1, paciente.getPacienteid()); 
            psPaciente.setString(2, paciente.getCpf());
            psPaciente.executeUpdate();

            rsPaciente = psPaciente.getGeneratedKeys();
            if (rsPaciente.next()) {
                paciente.setPacienteid(rsPaciente.getInt(1)); 
            } else {
                throw new SQLException("Falha ao inserir o paciente na tabela paciente.");
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
            
            String query = "UPDATE paciente SET isActive = 0 WHERE pacienteid = ?";
            psPaciente = conn.prepareStatement(query);
            psPaciente.setInt(1, pacienteId);
            psPaciente.executeUpdate();
            
        } finally {
            
            if (psPaciente != null) psPaciente.close();
            if (conn != null) conn.close();
        }
    }
    
    
}
