package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.errors.MedicoInativoError;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendamentoAntecedenciatrintaminutoserror;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendamentosNoMesmoDiaError;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendarConsultaMedicoNaMesmaHoraError;
import br.unipar.sistemasaude.ws.errors.PacienteInativoError;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.repository.ConsultaRepository;
import br.unipar.sistemasaude.ws.repository.MedicoRepository;
import br.unipar.sistemasaude.ws.repository.PacienteRepository;

public class ConsultaService {
    public ConsultaService() {

    }

    public Consulta insert(InsertConsultaRequestDTO consultaRequest) throws Exception {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        PacienteRepository pacienteRepository = new PacienteRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
        LocalDateTime localAgora = LocalDateTime.now();
        LocalDateTime dataHoraMinima = localAgora.plusMinutes(30);
        Paciente pacineteIsActive = pacienteRepository.findById(consultaRequest.getPacienteid());
        Medico medicoIsActive = medicoRepository.findById(consultaRequest.getMedicoid());
        ConsultaFiltrada consultaFiltrada = new ConsultaFiltrada();
        ArrayList<Consulta> consultasDoPaciente = consultaRepository.findConsultaByPacienteId(consultaRequest.getPacienteid());
        List<Consulta> consultasProximasDoPaciente = consultaFiltrada.filtrarConsultasProximas(consultasDoPaciente);
        ArrayList<Consulta> consultasDoMedico = consultaRepository.findConsultaByMedicoId(consultaRequest.getMedicoid());
    for (Consulta consulta : consultasDoMedico) {
        LocalDateTime dataHoraConsulta = consulta.getDatahora();
        LocalDateTime dataHoraTerminoConsulta = dataHoraConsulta.plusHours(1); // Considerando que a consulta tem duração de 1 hora
        if (consultaRequest.getDatahora().isAfter(dataHoraConsulta) && consultaRequest.getDatahora().isBefore(dataHoraTerminoConsulta)) {
            throw new NaoPermitirAgendarConsultaMedicoNaMesmaHoraError();
        }    
    }
        if(consultasProximasDoPaciente.size() > 0){
            throw new NaoPermitirAgendamentosNoMesmoDiaError();
        }

        if (medicoIsActive.getIsActive() != 1) {
            throw new MedicoInativoError();
        }
        if (pacineteIsActive.getIsActive() != 1) {
            throw new PacienteInativoError();
        }

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

    public ArrayList<Consulta> findConsultaByMedicoId(int medicoId) {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findConsultaByMedicoId(medicoId);
    }

    public ArrayList<Consulta> findCOnsultaByPacienteId(int pacienteId) {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findConsultaByPacienteId(pacienteId);
    }

    public ArrayList<Consulta> findConsultaByPacienteId(int pacienteId) {
        throw new UnsupportedOperationException("Unimplemented method 'findConsultaByPacienteId'");

    }

    public class ConsultaFiltrada {
        public List<Consulta> filtrarConsultasProximas(ArrayList<Consulta> consultas) {
            List<Consulta> consultasProximas = new ArrayList<>();
            LocalDateTime agora = LocalDateTime.now();
            LocalDateTime limiteSuperior = agora.plusHours(24);

            for (Consulta consulta : consultas) {
                if (consulta.getDatahora().isAfter(agora) && consulta.getDatahora().isBefore(limiteSuperior)) {
                    consultasProximas.add(consulta);
                }
            }

            return consultasProximas;
        }
    }
}
