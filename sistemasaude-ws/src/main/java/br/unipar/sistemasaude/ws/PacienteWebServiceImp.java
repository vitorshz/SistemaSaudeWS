package br.unipar.sistemasaude.ws;

import br.unipar.sistemasaude.ws.interfaces.PacienteInterface;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.service.PacienteService;
import jakarta.jws.WebService;

import java.sql.SQLException;
import java.util.ArrayList;


@WebService(endpointInterface = "br.unipar.sistemasaude.ws.interfaces.PacienteInterface")
public class PacienteWebServiceImp implements PacienteInterface{
    
    @Override
    public ArrayList<Paciente> listAll() throws SQLException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.listAll();
    }

    @Override
    public Paciente findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente inserirPaciente(Paciente paciente) throws SQLException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.insert(paciente);
    }

    @Override
    public void atualizar(Paciente paciente) throws Exception {
        PacienteService pacienteService = new PacienteService();
        pacienteService.atualizar(paciente);
    }

    @Override
    public void deletar(int id) throws SQLException {
        PacienteService pacienteService = new PacienteService();
        pacienteService.delete(id);
    }

    @Override
    public ArrayList<Paciente> findPaciente(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
