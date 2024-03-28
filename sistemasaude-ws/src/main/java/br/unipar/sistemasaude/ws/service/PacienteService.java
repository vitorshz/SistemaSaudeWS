package br.unipar.sistemasaude.ws.service;

import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.repository.PacienteRepository;

import java.sql.SQLException;
import java.util.ArrayList;


public class PacienteService {


    public ArrayList<Paciente> listAll() throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.listAll();
    }

    public Paciente insert(Paciente paciente) throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.insert(paciente);
    }

    public Paciente atualizar(Paciente paciente)  throws Exception {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.update(paciente);
    }

    public PacienteRepository delete(int id) {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.delete(id);
    }
    
}
