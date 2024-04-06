package br.unipar.sistemasaude.ws.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.InsertConsultaRequestDTO;
import br.unipar.sistemasaude.ws.errors.ConsultaNaoPodeSerCanceladaError;
import br.unipar.sistemasaude.ws.errors.DontExistsConsultaError;
import br.unipar.sistemasaude.ws.errors.DontExistsMedicoError;
import br.unipar.sistemasaude.ws.errors.DontExistsPacienteError;
import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.models.Consulta;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.validation.ValidationException;

@WebService
public interface ConsultaInterface {
    @WebMethod
    Consulta inserirConsulta(InsertConsultaRequestDTO consultaRequest) throws SQLException,validacaoError, Exception;
    @WebMethod
    void deletarConsulta(Consulta consulta) throws SQLException,DontExistsConsultaError,ConsultaNaoPodeSerCanceladaError, Exception;
    @WebMethod
    ArrayList<Consulta> findConsultaByMedicoId(int medicoId) throws SQLException,ValidationException,DontExistsMedicoError;
    @WebMethod
    ArrayList<Consulta> findConsultaByPacienteId(int pacienteId) throws SQLException,ValidationException,DontExistsPacienteError;
    
}
