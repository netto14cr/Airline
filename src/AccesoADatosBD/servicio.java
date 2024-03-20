/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatosBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Netto
 */
public class servicio {

    protected Connection conexion= null;
    
    public servicio() {
        
    }
    
    protected void conectar() throws SQLException,ClassNotFoundException 
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
//        conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
         conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","SYSTEM");
    }
    
    protected void desconectar() throws SQLException{
        if(!conexion.isClosed())
        {
            conexion.close();
        }
    }
}
