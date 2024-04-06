package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.models.Medico;
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
    
    public Medico insert(Medico medicoDto) throws SQLException, EspecialidadeException {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.insert(medicoDto);
    }
    public void atualizar(Medico updateDTO) throws Exception {
        MedicoRepository medicoRepository = new MedicoRepository();
        medicoRepository.update(updateDTO);
    }

    public void delete(int id) throws SQLException { 
        MedicoRepository medicoRepository = new MedicoRepository();
        medicoRepository.delete(id);
    }
}
