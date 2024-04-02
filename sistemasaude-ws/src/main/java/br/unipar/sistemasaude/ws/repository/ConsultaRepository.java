package br.unipar.sistemasaude.ws.repository;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import jakarta.resource.cci.ResultSet;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.temporal.ChronoUnit;

public class ConsultaRepository {

    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaRepository() {
        this.pacienteRepository = new PacienteRepository();
        this.medicoRepository = new MedicoRepository();

    }

    public Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest) {
        return null;
    }

    public void deletarConsulta(Consulta consulta) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        String queryByDateTimeConsulta = "SELECT datahora FROM consulta WHERE datahora > ?;";
        try {
            conn = new ConnectionFactory().getConnection();

            LocalDateTime now = LocalDateTime.now();
            ps = conn.prepareStatement(queryByDateTimeConsulta);
            ps.setString(1, null);
            ResultSet rs = (ResultSet) ps.executeQuery();
            Consulta consultaQuery = new Consulta();
            while (rs.next()) {
                consultaQuery.setId(rs.getInt("id"));
                consultaQuery.setMedicoid(rs.getInt("medicoid"));
                consultaQuery.setPacienteid(rs.getInt("pacienteid"));
                Timestamp timestamp = rs.getTimestamp("datahora");
                if (timestamp != null) {
                    LocalDateTime localDateTime = timestamp.toLocalDateTime();
                    consultaQuery.setDatahora(localDateTime);
                } else {
                    throw new Exception("Internal server error");
                }
                consultaQuery.setIsActive(rs.getInt("isactive"));
                consultaQuery.setMotivoCancelamento(rs.getString("motivocancelamento"));
            }

            // Calcula a diferença em minutos entre a hora atual e a hora da tabela
            long diffMinutes = ChronoUnit.HOURS.between(consulta.getDatahora(), now);
            if(consultaQuery.getIsActive() == 0){
                throw new Exception("Consulta já cancelada");
            }
            if (Math.abs(diffMinutes) > 24) {
                throw new RuntimeException(
                        "Erro: A diferença entre a hora atual e a hora da tabela é maior que 24 horas");
            } else {

                String query = "UPDATE consulta SET isActive = 0 motivocancelamento = ? WHERE consultaid = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, consulta.getMotivoCancelamento().toString());
                ps.setInt(2, consulta.getId());

                ps.executeUpdate();
            }

        } finally {

            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
    }

    public Consulta findConsultaByMedicoId(Medico medico, LocalDateTime datahora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findConsultaByMedicoId'");
    }

    public Consulta findCOnsultaByPacienteId(Paciente paciente, LocalDateTime datahora) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCOnsultaByPacienteId'");
    }

}
