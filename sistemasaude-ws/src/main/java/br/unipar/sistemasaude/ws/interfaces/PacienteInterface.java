package br.unipar.sistemasaude.ws.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import br.unipar.sistemasaude.ws.models.Paciente;

@WebService
public interface PacienteInterface {
    
    @WebMethod
    ArrayList<Paciente> findPaciente(String nome);
    
    @WebMethod
    ArrayList<Paciente> listAll() throws SQLException;
    
    @WebMethod
    Paciente findById(int id) throws SQLException;
    
    @WebMethod
    Paciente inserirPaciente(Paciente paciente) throws SQLException;
    
    @WebMethod
    void atualizar(Paciente paciente) throws SQLException, Exception;
    
    @WebMethod 
    void deletar(int id)throws SQLException;
}
