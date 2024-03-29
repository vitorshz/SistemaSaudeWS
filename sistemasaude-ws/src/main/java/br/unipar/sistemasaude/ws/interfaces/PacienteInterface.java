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
    ArrayList<Paciente> listAllPacientes() throws SQLException;
    
    @WebMethod
    Paciente findByIdPaciente(int id) throws SQLException;
    
    @WebMethod
    Paciente inserirPaciente(Paciente paciente) throws SQLException;
    
    @WebMethod
    void atualizarPaciente(Paciente paciente) throws SQLException, Exception;
    
    @WebMethod 
    void deletarPaciente(int id)throws SQLException;
}
