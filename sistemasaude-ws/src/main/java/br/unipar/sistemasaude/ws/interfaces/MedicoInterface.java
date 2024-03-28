/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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

/**
 *
 * @author lucia
 */
@WebService
public interface MedicoInterface {
    
    @WebMethod
    ArrayList<Medico> listAll();
    
    @WebMethod
    Medico findById(@WebParam int id);
    
    @WebMethod
    MedicoRequest inserir(MedicoRequest medicoDto) throws SQLException,ValidationException, EspecialidadeException;
    
    @WebMethod
    void atualizar(MedicoUpdateRequestDTO medico) throws SQLException, Exception;
    
    @WebMethod
    void deletar(int id);

}
