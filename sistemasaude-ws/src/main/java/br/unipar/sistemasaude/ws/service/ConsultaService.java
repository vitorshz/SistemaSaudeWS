package br.unipar.sistemasaude.ws.service;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.repository.ConsultaRepository;

public class ConsultaService {
    public ConsultaService() {

    }
    public Consulta insert(InsertConsultaRequestDTO consultaRequest){
      ConsultaRepository consultaRepository = new ConsultaRepository();
      return consultaRepository.inserirConsulta(consultaRequest);
    }
    public void delete(Consulta consulta) throws Exception{
        ConsultaRepository consultaRepository = new ConsultaRepository();
     consultaRepository.deletarConsulta(consulta);
    }
    public Consulta findConsultaByMedicoId(Medico medico, LocalDateTime datahora){
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findConsultaByMedicoId(medico, datahora);
    }
    public Consulta findCOnsultaByPacienteId(Paciente paciente, LocalDateTime datahora){
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findCOnsultaByPacienteId(paciente, datahora);
    }
}
