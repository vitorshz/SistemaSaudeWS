package br.unipar.sistemasaude.ws.service;


import br.unipar.sistemasaude.ws.errors.validacaoError;
import br.unipar.sistemasaude.ws.models.Endereco;
import br.unipar.sistemasaude.ws.repository.EnderecoRepository;
import java.sql.SQLException;


public class EnderecoService { 
     

    public Endereco insert(Endereco endereco) throws SQLException, validacaoError {
        validarEndereco(endereco);
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        return enderecoRepository.insert(endereco);
    }

    public void atualizar(Endereco endereco)  throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.update(endereco);
    }

    public void delete(int id) throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.delete(id);
    }


    public Endereco findById(int id) throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        return enderecoRepository.findById(id);
    }
    
    public static void validarEndereco(Endereco e) throws validacaoError {
        if(e.getBairro() == null){
            throw new validacaoError("Bairro inválido! Porfavor informe um bairro válido!");
        }
        if(e.getLogradouro() == null){
            throw new validacaoError("Logradouro inválido! Porfavor informe um logradouro válido!");
        }
        if(e.getUF() == null){
            throw new validacaoError("UF inválida! Porfavor informe um UF válido!");
        }
        if(e.getCidade() == null){
            throw new validacaoError("Cidade inválida! Porfavor informe uma cidade váliao!");
        }
        if(e.getCEP() == null){
            throw new validacaoError("CEP inválido! Porfavor informe um CEP válido!");
        }
    }
}
