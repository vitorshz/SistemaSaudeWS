package br.unipar.sistemasaude.ws;

import java.sql.SQLException;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.MedicoRequest;
import br.unipar.sistemasaude.ws.dto.MedicoUpdateRequestDTO;
import br.unipar.sistemasaude.ws.errors.EspecialidadeException;
import br.unipar.sistemasaude.ws.interfaces.MedicoInterface;
import br.unipar.sistemasaude.ws.models.Medico;
import br.unipar.sistemasaude.ws.service.medicoService;
import jakarta.jws.WebService;
import jakarta.validation.ValidationException;



@WebService(endpointInterface="br.unipar.sistemasaude.ws.interfaces.MedicoInterface")
public class MedicoWebServiceImp implements MedicoInterface{
    

    @Override
    public Medico inserirMedico(Medico medicoDto) throws SQLException, ValidationException, EspecialidadeException {
        medicoService medicoService = new medicoService();
        return medicoService.insert(medicoDto);
    }
    
    @Override
    public void atualizarMedico(Medico medico) throws SQLException, Exception {
        medicoService medicoService = new medicoService();
      medicoService.atualizar(medico);
    }

    @Override
    public void deletarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Medico> listAllMedico() throws SQLException {
        medicoService medicoService = new medicoService();
        return medicoService.listAll();
    }

    @Override
    public Medico findByIdMedico(int id) throws SQLException {
        medicoService medicoService = new medicoService();
        Medico medico = medicoService.findById(id);
        return medico;
    }

    
    
}
