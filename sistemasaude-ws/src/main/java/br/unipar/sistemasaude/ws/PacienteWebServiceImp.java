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
    public ArrayList<Paciente> listAllPacientes() throws SQLException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.listAll();
    }

    @Override
    public Paciente findByIdPaciente(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Paciente inserirPaciente(Paciente paciente) throws SQLException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.insert(paciente);
    }

    @Override
    public void atualizarPaciente(Paciente paciente) throws Exception {
        PacienteService pacienteService = new PacienteService();
        pacienteService.atualizar(paciente);
    }

    @Override
    public void deletarPaciente(int id) throws SQLException {
        PacienteService pacienteService = new PacienteService();
        pacienteService.delete(id);
    }



}
