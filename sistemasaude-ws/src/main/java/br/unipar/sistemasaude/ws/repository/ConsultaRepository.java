package br.unipar.sistemasaude.ws.repository;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;

public class ConsultaRepository{
    
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;
    
    public ConsultaRepository() {
        this.pacienteRepository = new PacienteRepository();
        this.medicoRepository = new MedicoRepository();
        
        
    }


    public Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest ){
      return null;
    }
    
    public void deletarConsulta(Consulta consulta) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime dataHoraTabela = LocalDateTime.of(2024, 4, 2, 12, 0); 

            // Calcula a diferença em minutos entre a hora atual e a hora da tabela
            long diffMinutes = ChronoUnit.MINUTES.between(dataHoraTabela, now);
            
            
            if (Math.abs(diffMinutes) > 30) {
                throw new RuntimeException("Erro: A diferença entre a hora atual e a hora da tabela é maior que 30 minutos.");
            } else {
                System.out.println("A diferença é menor ou igual a 30 minutos.");
                
                String query = "UPDATE consulta SET isActive = 0 WHERE consultaid = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, consulta.getId());
                
                ps.executeUpdate();
            }
          
        } finally {
            
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }
    public Consulta findConsultaByMedicoId(Medico medico, LocalDateTime datahora){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findConsultaByMedicoId'");
    }
    public Consulta findCOnsultaByPacienteId(Paciente paciente, LocalDateTime datahora){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCOnsultaByPacienteId'");
    }
    
}
