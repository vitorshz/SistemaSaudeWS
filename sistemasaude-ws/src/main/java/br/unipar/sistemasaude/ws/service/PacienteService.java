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
    
    public Paciente findById(int id) throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.findById(id);
    }

    public Paciente insert(Paciente paciente) throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.insert(paciente);
    }

    public void atualizar(Paciente paciente)  throws Exception {
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.update(paciente);
    }

    public void delete(int id) throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.delete(id);
    }
    
    
    
}
