package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.errors.ClinicaForaDoHorarioException;
import br.unipar.sistemasaude.ws.errors.ConsultaNaoPodeSerCanceladaError;
import br.unipar.sistemasaude.ws.errors.MedicoInativoError;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendamentoAntecedenciatrintaminutoserror;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendamentosNoMesmoDiaError;
import br.unipar.sistemasaude.ws.errors.NaoPermitirAgendarConsultaMedicoNaMesmaHoraError;
import br.unipar.sistemasaude.ws.errors.NemUmMedicoDisponivelError;
import br.unipar.sistemasaude.ws.errors.PacienteInativoError;
import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.repository.ConsultaRepository;
import br.unipar.sistemasaude.ws.repository.MedicoRepository;
import br.unipar.sistemasaude.ws.repository.PacienteRepository;
import java.util.Random;

public class ConsultaService {
    public ConsultaService() {

    }

    public Consulta insert(InsertConsultaRequestDTO consultaRequest) throws Exception {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        PacienteRepository pacienteRepository = new PacienteRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
        LocalDateTime localAgora = LocalDateTime.now();
        LocalDateTime dataHoraMinima = localAgora.plusMinutes(30);
        Paciente pacienteIsActive = pacienteRepository.findById(consultaRequest.getPacienteid());
        Medico medicoIsActive = null; // iniciar como nulo

        ConsultaFiltrada consultaFiltrada = new ConsultaFiltrada();

        ArrayList<Consulta> consultasDoPaciente = consultaRepository.findConsultaByPacienteId(consultaRequest.getPacienteid());
        List<Consulta> consultasProximasDoPaciente = consultaFiltrada.filtrarConsultasProximas(consultasDoPaciente);

        //só fazer a consulta do medico se forr informado o id do medico
        ArrayList<Consulta> consultasDoMedico = new ArrayList<>();
        Integer medicoid = consultaRequest.getMedicoid(); // converter para int
        if (medicoid != null && medicoid != 0) {
            consultasDoMedico = consultaRepository.findConsultaByMedicoId(medicoid);
        }

        //verificar se o id do medico nao foi informado ou se há consultas com o medico
        if (medicoid == null || medicoid == 0 || consultasDoMedico.isEmpty()) {
            List<Medico> medicosDisponiveis = getMedicosDisponiveis(consultaRequest.getDatahora());
            if (medicosDisponiveis.isEmpty()) {
                throw new NemUmMedicoDisponivelError();
            }
            // randomizar o medico
            medicoIsActive = medicosDisponiveis.get(new Random().nextInt(medicosDisponiveis.size()));
        } else {
            //selecionar medico se nao ha consultas com ele
            medicoIsActive = medicoRepository.findById(medicoid);
        }

        for (Consulta consulta : consultasDoMedico) {
            LocalDateTime dataHoraConsulta = consulta.getDatahora();
            LocalDateTime dataHoraTerminoConsulta = dataHoraConsulta.plusHours(1); // Considerando que a consulta tem duração de 1 hora
            if (consultaRequest.getDatahora().isAfter(dataHoraConsulta)
                    && consultaRequest.getDatahora().isBefore(dataHoraTerminoConsulta)) {
                throw new NaoPermitirAgendarConsultaMedicoNaMesmaHoraError();
            }
        }

        if (consultaRequest.getDatahora().getHour() < 7 || consultaRequest.getDatahora().getHour() > 19) {
            throw new ClinicaForaDoHorarioException();
        }

        if (!consultasProximasDoPaciente.isEmpty()) {
            throw new NaoPermitirAgendamentosNoMesmoDiaError();
        }

        if (consultaRequest.getDatahora().isBefore(dataHoraMinima)) {
            throw new NaoPermitirAgendamentoAntecedenciatrintaminutoserror();
        }

        if (medicoIsActive == null || medicoIsActive.getIsActive() != 1) {
            throw new MedicoInativoError();
        }

        if (pacienteIsActive == null || pacienteIsActive.getIsActive() != 1) {
            throw new PacienteInativoError();
        }

        // setar o medico
        consultaRequest.setMedicoid(medicoIsActive.getMedicoid());

        try {
            return consultaRepository.inserirConsulta(consultaRequest);
        } catch (SQLException ex) {
            System.err.println("Erro SQL ao inserir consulta: " + ex.getMessage());
            throw ex;
        }
    }


    public void delete(Consulta consulta) throws Exception {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        LocalDateTime localAgora = LocalDateTime.now();
    LocalDateTime dataLimiteCancelamento = localAgora.plusHours(24);
        if(consulta.getMotivoCancelamento() == null){
            throw new validacaoError("Informe o motivo do cancelamento é obrigatorio");
        }
        if (consulta.getDatahora().isBefore(dataLimiteCancelamento)) {
            throw new ConsultaNaoPodeSerCanceladaError();
        }
        try{
        consultaRepository.deletarConsulta(consulta);
        }
        catch(SQLException ex){
            System.err.println("Erro SQL ao inserir consulta: " + ex.getMessage());
            throw ex;
        }
    }

    public ArrayList<Consulta> findConsultaByMedicoId(int medicoId) throws SQLException {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findConsultaByMedicoId(medicoId);
    }

    public ArrayList<Consulta> findCOnsultaByPacienteId(int pacienteId) throws SQLException {
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
    public List<Medico> getMedicosDisponiveis(LocalDateTime dataHoraConsulta) throws SQLException {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
    
        // Consultas marcadas para a data e hora especificadas
        ArrayList<Consulta> consultas = consultaRepository.findConsultaByDataHora(dataHoraConsulta);
    
        // Todos os médicos
        ArrayList<Medico> medicos = medicoRepository.listAll();
    
        // Lista para armazenar médicos disponíveis
        List<Medico> medicosDisponiveis = new ArrayList<>(medicos);
    
        // Filtrar médicos que têm consultas na mesma data e hora
        for (Consulta consulta : consultas) {
            for (Medico medico : medicos) {
                if (consulta.getMedicoid() == medico.getMedicoid()) {
                    medicosDisponiveis.remove(medico); // Remove o médico da lista de disponíveis
                }
            }
        }
    
        return medicosDisponiveis;
    }
}
