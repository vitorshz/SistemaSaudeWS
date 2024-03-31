package br.unipar.sistemasaude.ws.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.MedicoRequest;
import br.unipar.sistemasaude.ws.dto.MedicoUpdateRequestDTO;
import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.models.Medico;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.validation.ValidationException;


@WebService
public interface MedicoInterface {
    
    @WebMethod
    ArrayList<Medico> listAllMedico();
    
    @WebMethod
    Medico findByIdMedico(@WebParam int id);
    
    @WebMethod
    MedicoRequest inserirMedico(MedicoRequest medicoDto) throws SQLException,ValidationException, EspecialidadeException;
    
    @WebMethod
    void atualizarMedico(MedicoUpdateRequestDTO medico) throws SQLException, Exception;
    
    @WebMethod
    void deletarMedico(int id);

}
