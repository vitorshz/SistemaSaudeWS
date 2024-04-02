package br.unipar.sistemasaude.ws.service;

import br.unipar.sistemasaude.ws.models.Consulta;
import br.unipar.sistemasaude.ws.repository.ConsultaRepository;

public class ConsultaService {
    public Consulta insert(){
      ConsultaRepository consultaRepository = new ConsultaRepository();
      return consultaRepository.inserirConsulta();
    }
    public void delete(){
        throw new UnsupportedOperationException("Unimplemented method 'deletarConsulta'");
    }
    public Consulta findConsultaByMedicoId(){
        throw new UnsupportedOperationException("Unimplemented method 'findConsultaByMedicoId'");
    }
    public Consulta findCOnsultaByPacienteId(){
        throw new UnsupportedOperationException("Unimplemented method 'findCOnsultaByPacienteId'");
    }
}
