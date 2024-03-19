<<<<<<< HEAD
package br.unipar.sistemasaude.ws.infraestructure;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
     //Constantes
    private static final String RESOURCE_NAME = "postgresResource";
    
    private DataSource getDatasource() throws NamingException {
        
        Context c = new InitialContext();
        
        return (DataSource) c.lookup(RESOURCE_NAME);
        
    }
    
    public Connection getConnection() {
        
        try {
            
            return getDatasource().getConnection();
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        
        } 
        
        return null;
        
    }
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.sistemasaude.ws.infraestructure;

/**
 *
 * @author lucia
 */
public class ConnectionFactory {
    
>>>>>>> 19c9438b0758353d6dba0b989aa2a5570dee98da
}
