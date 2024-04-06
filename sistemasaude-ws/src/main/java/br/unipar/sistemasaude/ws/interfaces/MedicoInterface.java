package br.unipar.sistemasaude.ws.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.models.Medico;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ValidationException;


@WebService
public interface MedicoInterface {
    
    @WebMethod
    ArrayList<Medico> listAllMedico() throws SQLException;
    
    @WebMethod
    Medico findByIdMedico(@WebParam int id) throws SQLException;
    
    @WebMethod
    Medico inserirMedico(Medico medicoDto) throws SQLException,ValidationException, EspecialidadeException;
    
    @WebMethod
    void atualizarMedico(Medico medico) throws SQLException, Exception;
    
    @WebMethod
    void deletarMedico(int id)throws SQLException;

}
