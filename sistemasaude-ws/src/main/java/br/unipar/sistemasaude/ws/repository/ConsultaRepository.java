package br.unipar.sistemasaude.ws.repository;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;

public class ConsultaRepository{
    
    public ConsultaRepository() {
    }


    public Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest ){
      throw new UnsupportedOperationException("Unimplemented method 'inserirConsulta'");
    }
    public void deletarConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Unimplemented method 'deletarConsulta'");
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
