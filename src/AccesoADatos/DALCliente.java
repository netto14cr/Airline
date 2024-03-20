/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatosBD.servicioCliente;
import Modelo.Cliente;
import Modelo.LineaDetalleCliente;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class DALCliente {

    private static DALCliente mInstance;
    private final servicioCliente sClient;

    public static DALCliente getInstance() {
        if (mInstance == null) {
            mInstance = new DALCliente();
        }
        return mInstance;
    }

    private DALCliente() {
        sClient = new servicioCliente();
    }

    //   Metodo de DAL Insertar Cliente
    public void insertarCliente(Cliente cliente) {
        sClient.insertarCliente(cliente);
    }

    //   Metodo de DAL Actualizar Cliente
    public void modificarCliente(Cliente cliente) {
        sClient.modificarCliente(cliente);
    }

    //   Metodo de DAL Eliminar Cliente
    public void eliminarCliente(String id) {
        sClient.eliminarCliente(id);
    }

    //   Metodo de DAL Listar Cliente
    public ArrayList<LineaDetalleCliente> listarCliente() {
        return sClient.listarClientes();
    }

    //   Metodo de DAL Consultar Cliente
    public Cliente consultarCliente(String id) {
        return sClient.consultarCliente(id);
    }

    //   Metodo de DAL Consultar Uusuario Cliente
    public Cliente consultarUsuarioCliente(String user) {
        return sClient.consultarCliente(user);
    }

    //   Metodo de DAL Consultar Passw Cliente
    public Cliente consultarPasswCliente(String passw) {
        return sClient.consultarCliente(passw);
    }

    
    

    public LineaDetalleCliente consultarClienteID(String pos) {

        ArrayList<LineaDetalleCliente> al = new ArrayList<>(this.listarCliente());
        LineaDetalleCliente aux = null;
        for (int i = 0; i < al.size(); i++) {
            if (pos.equals(al.get(i).getId())  ) {
                aux = new LineaDetalleCliente(al.get(i).getId(),al.get(i).getNombre()
                        ,al.get(i).getApell1(),
                        al.get(i).getApell2(),
                        al.get(i).getCel(),
                        al.get(i).getContrasenia());
                
                break;
            }
        }
        return aux;
    }

}
