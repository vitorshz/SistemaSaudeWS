package br.unipar.sistemasaude.ws.service;


import br.unipar.sistemasaude.ws.errors.validacaoError;
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

    public Paciente insert(Paciente paciente) throws SQLException, validacaoError {
        validarPaciente(paciente);
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.insert(paciente);
    }

    public void atualizar(Paciente paciente)  throws Exception {
        validarPaciente(paciente);
        
        // Remova a atualização dos campos que não devem ser modificados
        Paciente pacienteExistente = findById(paciente.getPacienteid());
        paciente.setEmail(pacienteExistente.getEmail());
        paciente.setCpf(pacienteExistente.getCpf());

        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.update(paciente);
    }

    public void delete(int id) throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.delete(id);
    }
    
    // Método de validação de paciente
    public static void validarPaciente(Paciente paciente) throws validacaoError {
        if (paciente.getNome() == null || paciente.getNome().isEmpty()) {
            throw new validacaoError("Nome inválido! Por favor, informe um nome válido!");
        }
        if (paciente.getEmail() == null || paciente.getEmail().isEmpty()) {
            throw new validacaoError("E-mail inválido! Por favor, informe um email válido!");
        }
        if (paciente.getTelefone() == null) {
            throw new validacaoError("Telefone inválido! Por favor, informe um telefone válido!");
        }
        if (paciente.getCpf()== null) {
            throw new validacaoError("CPF inválido! Por favor, um CPF válido!");
        }
    }
    
}
