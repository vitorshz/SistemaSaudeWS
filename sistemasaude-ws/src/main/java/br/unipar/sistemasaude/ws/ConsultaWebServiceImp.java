package br.unipar.sistemasaude.ws;

import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.interfaces.ConsultaInterface;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.service.ConsultaService;
import jakarta.jws.WebService;

@WebService(endpointInterface="br.unipar.sistemasaude.ws.interfaces.ConsultaInterface")
public class ConsultaWebServiceImp implements ConsultaInterface{

    @Override
    public Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest) throws Exception {
       ConsultaService consultaService = new ConsultaService();
       return consultaService.insert(consultaRequest);
    }

    @Override
    public void deletarConsulta(Consulta consulta) throws Exception{
        ConsultaService consultaService = new ConsultaService();
         consultaService.delete(consulta);
    }
    @Override
    public Consulta findConsultaByMedicoId(Medico medico, LocalDateTime datahora){
    ConsultaService consultaService = new ConsultaService();
    return consultaService.findConsultaByMedicoId(medico,datahora);
    }

    @Override
    public Consulta findCOnsultaByPacienteId(Paciente paciente, LocalDateTime datahora){
        ConsultaService consultaService = new ConsultaService();
        return consultaService.findCOnsultaByPacienteId(paciente, datahora);
    }
    
}
