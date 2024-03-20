/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatosBD.servicioAdministrador;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Administrador;
import Modelo.LineaDetalleAdministrador;
import java.util.ArrayList;

/**
 *
 * @author Netto
 */
public class DALAdministrador {

    private static DALAdministrador mInstance;
    private final servicioAdministrador sAdmin;

    public static DALAdministrador getInstance() {
        if (mInstance == null) {
            mInstance = new DALAdministrador();
        }
        return mInstance;
    }

    private DALAdministrador() {
        sAdmin = new servicioAdministrador();
    }

    //   Metodo de DAL Insertar Administrador
    public void insertarAdministrador(Administrador adminnistrador) {
        sAdmin.insertarAdministrador(adminnistrador);
    }

    //   Metodo de DAL Actualizar Administrador
    public void modificarAdministrador(Administrador adminnistrador) {
        sAdmin.modificarAdministrador(adminnistrador);
    }

    //   Metodo de DAL Eliminar Administrador
    public void eliminarAdministrador(String id) {
        sAdmin.eliminarAdministrador(id);
    }

    //   Metodo de DAL Listar Administrador
    public ArrayList<LineaDetalleAdministrador> listarAdministrador() {
        return sAdmin.listarAdministradores();
    }

    
    
    
    
    
    
    //   Metodo de DAL Consultar Administrador
    public Administrador consultarAdministrador(String id) {
        return sAdmin.consultarAdministrador(id);
    }

// Metodo que consulta en la Base de datos si existe un administrador indicado
    public boolean verificarAdministradorBase(String user, String passw) throws GlobalException {
        boolean verificarAux;
        verificarAux = false;
        Administrador aux = null;
        aux = this.consultarAdministrador(user);
        if (user.equals(aux.getIdentificacion()) && passw.equals(aux.getContrasenia())) {
            verificarAux = true;
            System.out.println("<<<<<<<<    EXISTE UN  ADMINISTRADOR      >>>>>>");
        }else{
            try {
            throw new GlobalException("NO exite un Administrador");
            } catch (GlobalException e) {
            }
        }

        return verificarAux;
    }
    
    
    
    
    public LineaDetalleAdministrador consultarAdmininistradorID(String pos) {

        ArrayList<LineaDetalleAdministrador> al = new ArrayList<>(this.listarAdministrador());
        LineaDetalleAdministrador aux = null;
        for (int i = 0; i < al.size(); i++) {
            if (pos.equals(al.get(i).getId())  ) {
                aux = new LineaDetalleAdministrador(al.get(i).getId(),al.get(i).getNombre()
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
