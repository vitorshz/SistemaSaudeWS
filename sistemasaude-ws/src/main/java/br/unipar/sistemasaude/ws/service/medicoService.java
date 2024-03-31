package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.MedicoRequest;
import br.unipar.sistemasaude.ws.dto.MedicoUpdateRequestDTO;
import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.repository.MedicoRepository;
import br.unipar.sistemasaude.ws.repository.PacienteRepository;

public class medicoService {
     public ArrayList<Medico> listAll() {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.listAll();
    }
   
    public Medico findById(int id){
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.findById(id);
    }
    
    public MedicoRequest insert(MedicoRequest medicoDto) throws SQLException, EspecialidadeException {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.insert(medicoDto);
    }
    public MedicoUpdateRequestDTO atualizar(MedicoUpdateRequestDTO updateDTO) throws Exception {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.update(updateDTO);
    }

    public void delete(int id) throws SQLException {
        PacienteRepository medicoRepository = new PacienteRepository();
        medicoRepository.delete(id);
    }
}
