package br.unipar.sistemasaude.ws.service;


import br.unipar.sistemasaude.ws.models.Endereco;
import br.unipar.sistemasaude.ws.repository.EnderecoRepository;
import java.sql.SQLException;


public class EnderecoService { 
     

    public Endereco insert(Endereco endereco) throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        return enderecoRepository.insert(endereco);
    }

    public void atualizar(Endereco endereco)  throws Exception {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.update(endereco);
    }

    public void delete(int id) throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.delete(id);
    }
    
}
