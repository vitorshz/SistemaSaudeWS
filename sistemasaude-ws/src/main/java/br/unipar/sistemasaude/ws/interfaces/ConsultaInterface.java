package br.unipar.sistemasaude.ws.interfaces;

import java.sql.SQLException;
import java.time.LocalDateTime;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.errors.ConsultaNaoPodeSerCanceladaError;
import br.unipar.sistemasaude.ws.errors.DontExistsConsultaError;
import br.unipar.sistemasaude.ws.errors.DontExistsMedicoError;
import br.unipar.sistemasaude.ws.errors.DontExistsPacienteError;
import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.validation.ValidationException;

@WebService
public interface ConsultaInterface {
    @WebMethod
    Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest) throws SQLException,validacaoError;
    @WebMethod
    void deletarConsulta(Consulta consulta) throws SQLException,DontExistsConsultaError,ConsultaNaoPodeSerCanceladaError, Exception;
    @WebMethod
    Consulta findConsultaByMedicoId(Medico medico,LocalDateTime datahora) throws SQLException,ValidationException,DontExistsMedicoError;
    @WebMethod
    Consulta findCOnsultaByPacienteId(Paciente paciente,LocalDateTime datahora) throws SQLException,ValidationException,DontExistsPacienteError;
    
}
