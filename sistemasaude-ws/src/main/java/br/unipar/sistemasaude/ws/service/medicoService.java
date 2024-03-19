package br.unipar.sistemasaude.ws.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.MedicoRequest;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.repository.MedicoRepository;

public class medicoService {
     public ArrayList<Medico> listAll() {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.listAll();
    }
   
    public Medico findById(int id){
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.findById(id);
    }
    
    public MedicoRequest insert(MedicoRequest medicoDto) throws SQLException {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.insert(medicoDto);
    }
    
}
