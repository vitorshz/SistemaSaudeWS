package br.unipar.sistemasaude.ws;

import java.sql.SQLException;
import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.errors.ConsultaNaoPodeSerCanceladaError;
import br.unipar.sistemasaude.ws.errors.DontExistsConsultaError;
import br.unipar.sistemasaude.ws.errors.DontExistsMedicoError;
import br.unipar.sistemasaude.ws.errors.DontExistsPacienteError;
import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.interfaces.ConsultaInterface;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import jakarta.jws.WebService;
import jakarta.validation.ValidationException;

@WebService(endpointInterface="br.unipar.sistemasaude.ws.interfaces.ConsultaInterface")
public class ConsultaWebServiceImp implements ConsultaInterface{

    @Override
    public Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest) throws SQLException, validacaoError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirConsulta'");
    }

    @Override
    public void deletarConsulta(Consulta consulta)
            throws SQLException, DontExistsConsultaError, ConsultaNaoPodeSerCanceladaError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarConsulta'");
    }

    @Override
    public Consulta findConsultaByMedicoId(Medico medico, LocalDateTime datahora)
            throws SQLException, ValidationException, DontExistsMedicoError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findConsultaByMedicoId'");
    }

    @Override
    public Consulta findCOnsultaByPacienteId(Paciente paciente, LocalDateTime datahora)
            throws SQLException, ValidationException, DontExistsPacienteError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCOnsultaByPacienteId'");
    }
    
}
