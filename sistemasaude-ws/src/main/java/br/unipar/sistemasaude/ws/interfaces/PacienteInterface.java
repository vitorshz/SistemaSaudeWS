package br.unipar.sistemasaude.ws.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import br.unipar.sistemasaude.ws.models.Paciente;
import jakarta.jws.WebParam;

@WebService
public interface PacienteInterface {
    
    @WebMethod
    ArrayList<Paciente> findPaciente(String nome);
    
    @WebMethod
    ArrayList<Paciente> listAll() throws SQLException;
    
    @WebMethod
    Paciente findById(int id) throws SQLException;
    
    @WebMethod
    Paciente inserir(Paciente paciente);
    
    @WebMethod
    Paciente atualizar(Paciente paciente) throws SQLException;
    
    @WebMethod 
    void deletar(int id)throws SQLException;
    
}
