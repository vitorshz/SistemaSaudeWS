package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendamentoAntecedenciatrintaminutoserror;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.repository.ConsultaRepository;

public class ConsultaService {
    public ConsultaService() {

    }

    public Consulta insert(InsertConsultaRequestDTO consultaRequest) throws Exception {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        LocalDateTime localAgora = LocalDateTime.now();
        LocalDateTime dataHoraMinima = localAgora.plusMinutes(30);
    
        if (consultaRequest.getDatahora().isBefore(dataHoraMinima)) {
            throw new NaoPermitirAgendamentoAntecedenciatrintaminutoserror();
        }
    
        try {
            return consultaRepository.inserirConsulta(consultaRequest);
        } catch (SQLException ex) {
            System.err.println("Erro SQL ao inserir consulta: " + ex.getMessage());
            throw ex;
        }
    }

    public void delete(Consulta consulta) throws Exception {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        consultaRepository.deletarConsulta(consulta);
    }

    public Consulta findConsultaByMedicoId(Medico medico, LocalDateTime datahora) {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findConsultaByMedicoId(medico, datahora);
    }

    public Consulta findCOnsultaByPacienteId(Paciente paciente, LocalDateTime datahora) {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findCOnsultaByPacienteId(paciente, datahora);
    }
}
