package br.unipar.sistemasaude.ws.interfaces;

import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.models.Endereco;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;


@WebService
public interface EnderecoInterface {

    
    @WebMethod()
    Endereco insertEndereco(Endereco enndereco) throws SQLException, validacaoError;
    
    @WebMethod()
    Endereco getEnderecoById(int id) throws SQLException;
    
    @WebMethod()
    void updateEndereco(Endereco endereco) throws SQLException;
    
    @WebMethod()
    void deleteEnderecoById(int id) throws SQLException;
}
