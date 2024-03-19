package br.unipar.sistemasaude.ws.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.unipar.sistemasaude.ws.dto.MedicoRequest;
import br.unipar.sistemasaude.ws.infraestructure.ConnectionFactory;
import br.unipar.sistemasaude.ws.models.Medico;

public class MedicoRepository {
     public MedicoRepository() {
    }
    public ArrayList<Medico> listAll(){
        return null;
    }
    
    public Medico findById(int id){
        return null;
    }

    public MedicoRequest insert(MedicoRequest medicoDto) throws SQLException {
        
        String query = 
                "INSERT INTO MEDICO (NOME, EMAIL, TELEFONE, CRM, ESPECIALIZACAO,ENDERECOCOMPLETO)"
                + "VALUES(?, ?, ?, ?, ?,?);";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String enderecocompleto = medicoDto.getLogradouro() + medicoDto.getNumero() + medicoDto.getComplemento() + medicoDto.getBairro();
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(query, 
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medicoDto.getNome());
            ps.setString(2, medicoDto.getEmail());
            ps.setInt(3, medicoDto.getTelefone());
            ps.setInt(4, medicoDto.getCrm());
            ps.setString(5, medicoDto.getEspecializacao());
            ps.setString(6, enderecocompleto);
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            medicoDto.setId(rs.getInt(1));
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return medicoDto;
    }
}
