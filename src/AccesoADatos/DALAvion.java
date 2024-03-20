/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Excepciones.GlobalException;
import AccesoADatosBD.servicioAviones;
import Excepciones.GlobalException;
import Modelo.Avion;
import java.util.ArrayList;
import java.lang.Exception;

/**
 *
 * @author gabri
 */
public class DALAvion {
    
    private static DALAvion mInstance;
    private final servicioAviones sAdmin;

    public static DALAvion getInstance() {
        if (mInstance == null) {
            mInstance = new DALAvion();
        }
        return mInstance;
    }

    private DALAvion() {
          sAdmin=new servicioAviones();
    }

    
    //   Metodo de DAL Insertar Administrador
    public void insertarAvion(Avion adminnistrador) {
            sAdmin.insertarAvion(adminnistrador);
    }

    //   Metodo de DAL Actualizar Administrador
    public void modificarAvion(Avion adminnistrador){
            sAdmin.modificarAvion(adminnistrador);
    }
    
    //   Metodo de DAL Eliminar Administrador
    
    public void eliminarAvion(String id) throws GlobalException {
            sAdmin.eliminarAvion(id);
    }
    
    //   Metodo de DAL Listar Administrador
     public ArrayList<Avion> listarAavion() {
            return sAdmin.listarAviones();
    }
     
    //   Metodo de DAL Eliminar Administrador
    
    public Avion consultarAvion(String id) {
            return sAdmin.consultarAvion(id);
    }
    
    
    
    
    public ArrayList<Avion> consultarAvionID(String pos) throws GlobalException {
        
        ArrayList<Avion> al=new ArrayList<>(this.listarAavion());
        Avion aux=null;
        for (int i = 0; i < al.size(); i++) {
            if(pos.equals(al.get(i).getIdentificacion()))
            {
                aux=new Avion();
                aux.setCantidadPasajeros(al.get(i).getCantidadPasajeros());
                aux.setAnio(al.get(i).getAnio());
                aux.setIdentificacion(al.get(i).getIdentificacion());
                aux.setMarca(al.get(i).getMarca());
                aux.setModelo(al.get(i).getModelo());
                
                break;
            }
        }
        al.clear();
        al.add(aux);
        if(aux==null)
            throw new GlobalException("No Existe ese Registro");
        
        return al;
    }
    public Avion consultarAvion(int pos) {  
        ArrayList<Avion> al=this.listarAavion();
        Avion aux=null;
        for (int i = 0; i < al.size(); i++) {
            if(pos==i)
            {
                aux=al.get(i);
                break;
            }
        }
        return aux;
    }

  

   


}
