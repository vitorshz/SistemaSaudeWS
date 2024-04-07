package br.unipar.sistemasaude.ws.repository;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.enuns.MotivoCancelamentosEnum;
import br.unipar.sistemasaude.ws.errors.DontExistsConsultaError;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Consulta;
import java.sql.ResultSet;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;

public class ConsultaRepository {

    @SuppressWarnings("unused")
    private final PacienteRepository pacienteRepository;
    @SuppressWarnings("unused")
    private final MedicoRepository medicoRepository;

    public ConsultaRepository() {
        this.pacienteRepository = new PacienteRepository();
        this.medicoRepository = new MedicoRepository();

    }

    public Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String queryInsert = "INSERT INTO CONSULTA(medicoid,pacienteid,datahora,isactive) values (?,?,?,?)";
        Consulta consultacreated = new Consulta();
        
        try {
            conn = new ConnectionFactory().getConnection();
     
            ps = conn.prepareStatement(queryInsert);
            ps.setInt(1, consultaRequest.getMedicoid());
            ps.setInt(2, consultaRequest.getPacienteid());
            ps.setTimestamp(3, Timestamp.valueOf(consultaRequest.getDatahora()));
            ps.setInt(4,1);
            ResultSet rs = (ResultSet) ps.executeQuery();
            
            while (rs.next()) {
                consultacreated.setId(rs.getInt("id"));
                consultacreated.setMedicoid(rs.getInt("medicoid"));
                consultacreated.setPacienteid(rs.getInt("pacienteid"));
                Timestamp timestamp = rs.getTimestamp("datahora");
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                consultacreated.setDatahora(localDateTime);
                consultacreated.setIsActive(rs.getInt("isactive"));
                consultacreated.setMotivoCancelamento(rs.getString("motivocancelamento"));
            }

        }finally{
            if (ps != null)
            ps.close();
        if (conn != null)
            conn.close();
        }
        return consultacreated;
    }

    public void deletarConsulta(int consultaId, MotivoCancelamentosEnum motivo) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String updateQuery = "UPDATE consulta SET isActive = 0, motivocancelamento = ? WHERE consultaid = ?";
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(updateQuery);
            ps.setString(1, motivo.getCodigo());
            ps.setInt(2, consultaId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new DontExistsConsultaError();
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public ArrayList<Consulta> findConsultaByMedicoId(int medicoId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Consulta> consultasQuery = new ArrayList<Consulta>();
        String querySQL = "SELECT * FROM consulta WHERE medicoid = ?;";
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(querySQL);
            ps.setInt(1, medicoId);
            ResultSet rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int pacienteId = rs.getInt("pacienteid");
                LocalDateTime dataHora = rs.getTimestamp("datahora").toLocalDateTime();
                MotivoCancelamentosEnum motivoCancelamento = MotivoCancelamentosEnum.valueOf(rs.getString("motivoCancelamento"));
                int isActive = rs.getInt("isActive");
                int duracaoEmMinutos = rs.getInt("duracaoemminutos");

                Consulta consulta = new Consulta(id, pacienteId, medicoId, dataHora, motivoCancelamento, isActive, duracaoEmMinutos);
                consultasQuery.add(consulta);
            }
            return consultasQuery;
        }finally{
            if (ps != null)
            ps.close();
        if (conn != null)
            conn.close();
        }
    }

    public ArrayList<Consulta> findConsultaByPacienteId(int pacienteId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Consulta> consultasQuery = new ArrayList<Consulta>();
        String querySQL = "SELECT * FROM consulta WHERE pacienteid = ?;";
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(querySQL);
            ps.setInt(1, pacienteId);
            ResultSet rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDateTime dataHora = rs.getTimestamp("datahora").toLocalDateTime();
                String motivocancelamentors = rs.getString("motivoCancelamento");
                MotivoCancelamentosEnum motivoCancelamento = MotivoCancelamentosEnum.ESTAATIVO;
                if(motivocancelamentors != null){
                      motivoCancelamento = MotivoCancelamentosEnum.valueOf(motivocancelamentors);
                }
               
                int isActive = rs.getInt("isActive");
                int duracaoEmMinutos = rs.getInt("duracaoemminutos");

                Consulta consulta = new Consulta(id, pacienteId, rs.getInt("medicoid"), dataHora, motivoCancelamento, isActive, duracaoEmMinutos);
                consultasQuery.add(consulta);
            }
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return consultasQuery;
    }
    public ArrayList<Consulta> findConsultaByDataHora(LocalDateTime datahora) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ArrayList<Consulta> consultasQuery = new ArrayList<Consulta>();
        String querySQL = "SELECT * FROM consulta WHERE datahora = ?;";
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(querySQL);
            ps.setTimestamp(1, java.sql.Timestamp.valueOf(datahora));
            ResultSet rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int pacienteId = rs.getInt("pacienteid");
                int medicoId = rs.getInt("medicoid");
                MotivoCancelamentosEnum motivoCancelamento = MotivoCancelamentosEnum.ESTAATIVO;
                int isActive = rs.getInt("isActive");
                int duracaoEmMinutos = rs.getInt("duracaoemminutos");

                Consulta consulta = new Consulta(id, pacienteId, medicoId, datahora, motivoCancelamento, isActive, duracaoEmMinutos);
                consultasQuery.add(consulta);
            }
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return consultasQuery;
    }
    public Consulta findConsultaById(int consultaId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Consulta consulta = null;
        String querySQL = "SELECT * FROM consulta WHERE id = ? AND isactive = 1;";
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(querySQL);
            ps.setInt(1, consultaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int pacienteId = rs.getInt("pacienteid");
                int medicoId = rs.getInt("medicoid");
                LocalDateTime dataHora = rs.getTimestamp("datahora").toLocalDateTime();
                String motivoCancelamentoStr = rs.getString("motivoCancelamento");
                MotivoCancelamentosEnum motivoCancelamento = null;
                if (motivoCancelamentoStr != null) {
                    motivoCancelamento = MotivoCancelamentosEnum.valueOf(motivoCancelamentoStr);
                }
                int isActive = rs.getInt("isActive");
                int duracaoEmMinutos = rs.getInt("duracaoemminutos");
    
                consulta = new Consulta(consultaId, pacienteId, medicoId, dataHora, motivoCancelamento, isActive, duracaoEmMinutos);
            }
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return consulta;
    }

}
