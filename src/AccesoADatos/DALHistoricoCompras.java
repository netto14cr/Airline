/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatosBD.ServicioHistoricoCompras;
import Excepciones.NoDataException;
import Modelo.LineaDetalleHistoricoCompras;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class DALHistoricoCompras {
    
    private static DALHistoricoCompras mInstance;
    private final ServicioHistoricoCompras sAdmin;

    public static DALHistoricoCompras getInstance() {
        if (mInstance == null) {
            mInstance = new DALHistoricoCompras();
        }
        return mInstance;
    }

    private DALHistoricoCompras() {
          sAdmin=new ServicioHistoricoCompras();
    }

    
    //   Metodo de DAL Insertar Administrador
    public void insertarLineaDetalleHistoricoCompras(LineaDetalleHistoricoCompras adminnistrador) {
            sAdmin.insertarHistoricoCompras(adminnistrador);
    }

    
    //   Metodo de DAL Listar Historico de Compras
     public ArrayList listarLineaDetalleHistoricoCompras(String id) {
            return sAdmin.listarHistoricoCompras(id);
    }
     
     
     
     //   Metodo de DAL Listar Historico de Compras
       //   Metodo de DAL Listar Vuelo
     
     
     
     
         //   Metodo de DAL Listar Vuelo
     public ArrayList listarTodo() throws NoDataException {
            return sAdmin.listarComprar();
    }
    

}
