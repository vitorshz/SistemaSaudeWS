package br.unipar.sistemasaude.ws;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequest;
import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.interfaces.ConsultaInterface;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.service.ConsultaService;
import br.unipar.sistemasaude.ws.utils.ConverterStringParaLocalDateTime;
import jakarta.jws.WebService;

@WebService(endpointInterface="br.unipar.sistemasaude.ws.interfaces.ConsultaInterface")
public class ConsultaWebServiceImp implements ConsultaInterface{

    @Override
    public Consulta inserirConsulta(InsertConsultaRequest consultaRequest) throws Exception {
        LocalDateTime datahora = ConverterStringParaLocalDateTime.converterStringParaLocalDateTim(consultaRequest.getDatahora());
        InsertConsultaRequestDTO dto = new InsertConsultaRequestDTO();
        dto.setId(consultaRequest.getId());
        dto.setMedicoid(consultaRequest.getMedicoid());
        dto.setPacienteid(consultaRequest.getPacienteid());
        dto.setDatahora(datahora);
       ConsultaService consultaService = new ConsultaService();
       return consultaService.insert(dto);
    }

    @Override
    public void deletarConsulta(Consulta consulta) throws Exception{
        ConsultaService consultaService = new ConsultaService();
         consultaService.delete(consulta);
    }
    @Override
    public ArrayList<Consulta> findConsultaByMedicoId(int medicoId) throws SQLException{
    ConsultaService consultaService = new ConsultaService();
    return consultaService.findConsultaByMedicoId(medicoId);
    }

    @Override
    public ArrayList<Consulta> findConsultaByPacienteId(int pacienteId){
        ConsultaService consultaService = new ConsultaService();
        return consultaService.findConsultaByPacienteId(pacienteId);
    }
    
}
