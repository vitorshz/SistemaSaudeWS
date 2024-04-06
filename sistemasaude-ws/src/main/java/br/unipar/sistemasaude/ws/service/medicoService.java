package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.models.Paciente;
import br.unipar.sistemasaude.ws.repository.MedicoRepository;

public class medicoService {
     public ArrayList<Medico> listAll() throws SQLException {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.listAll();
    }
   
    public Medico findById(int id) throws SQLException{
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.findById(id);
    }
    
    public Medico insert(Medico medicoDto) throws SQLException, EspecialidadeException, validacaoError {
        validarMedico(medicoDto);
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.insert(medicoDto);
    }
    public void atualizar(Medico updateDTO) throws Exception {
        validarMedico(updateDTO);
        
        // Remova a atualização dos campos que não devem ser modificados
        Medico medicoExistente = findById(updateDTO.getMedicoid());
        updateDTO.setEmail(medicoExistente.getEmail());
        updateDTO.setCrm(medicoExistente.getCrm());
        
        MedicoRepository medicoRepository = new MedicoRepository();
        medicoRepository.update(updateDTO);
    }

    public void delete(int id) throws SQLException { 
        MedicoRepository medicoRepository = new MedicoRepository();
        medicoRepository.delete(id);
    }
    
    // Método de validação de medico
    public static void validarMedico(Medico m) throws validacaoError {
        if (m.getNome() == null || m.getNome().isEmpty()) {
            throw new validacaoError("Nome inválido! Por favor, informe um nome válido!");
        }
        if (m.getEmail() == null || m.getEmail().isEmpty()) {
            throw new validacaoError("E-mail inválido! Por favor, informe um email válido!");
        }
        if (m.getTelefone() == null || m.getTelefone().isEmpty()) {
            throw new validacaoError("Telefone inválido! Por favor, informe um telefone válido!");
        }
        if (m.getCrm() <= 0) {
            throw new validacaoError("CRM inválido! Por favor, informe um CRM válido!");
        }
    }
}
