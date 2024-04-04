package br.unipar.sistemasaude.ws;


import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.interfaces.EnderecoInterface;
import br.unipar.sistemasaude.ws.models.Endereco;
import br.unipar.sistemasaude.ws.service.EnderecoService;
import jakarta.jws.WebService;
import java.sql.SQLException;


@WebService(endpointInterface="br.unipar.sistemasaude.ws.interfaces.EnderecoInterface")
public class EnderecoWebServiceImp implements EnderecoInterface{

    @Override
    public Endereco insertEndereco(Endereco endereco) throws SQLException, validacaoError {
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.insert(endereco);
    
    }

    @Override
    public Endereco getEnderecoById(int id) throws SQLException {
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.findById(id);
    }


    @Override
    public void updateEndereco(Endereco endereco) throws SQLException {
        EnderecoService enderecoService = new EnderecoService();
        enderecoService.atualizar(endereco);
    }

    @Override
    public void deleteEnderecoById(int id) throws SQLException {
        EnderecoService enderecoService = new EnderecoService();
        enderecoService.delete(id);
    }

    

    
    
}
