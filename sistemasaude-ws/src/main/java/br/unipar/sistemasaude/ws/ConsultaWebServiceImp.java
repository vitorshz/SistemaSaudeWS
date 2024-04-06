package br.unipar.sistemasaude.ws;


import java.sql.SQLException;
import java.util.ArrayList;
import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.interfaces.ConsultaInterface;
import br.unipar.sistemasaude.ws.models.Consulta;
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
