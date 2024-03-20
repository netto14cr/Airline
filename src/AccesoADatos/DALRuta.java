/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatosBD.servicioRuta;
import Excepciones.GlobalException;
import Modelo.Ruta;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class DALRuta {
    
    
    private static DALRuta mInstance;
    private final servicioRuta sAdmin;

    public static DALRuta getInstance() {
        if (mInstance == null) {
            mInstance = new DALRuta();
        }
        return mInstance;
    }

    private DALRuta() {
          sAdmin=new servicioRuta();
    }

    
    //   Metodo de DAL Insertar Administrador
    public void insertarRuta(Ruta adminnistrador) throws GlobalException {
            sAdmin.insertarRuta(adminnistrador);
    }

    //   Metodo de DAL Actualizar Administrador
    public void modificarRuta(Ruta adminnistrador){
        System.out.print("-> ruta modificada DAL 3  :  "+adminnistrador.toString()+"\n");
            sAdmin.modificarRuta(adminnistrador);
    }
    
    //   Metodo de DAL Eliminar Administrador
    
    public void eliminarRuta(String id) throws GlobalException {
            sAdmin.eliminarRuta(id);
    }
    
    //   Metodo de DAL Listar Administrador
     public ArrayList listarRuta() {
            return sAdmin.listarRutas();
    }
     
    //   Metodo de DAL Eliminar Administrador
    
    public Ruta consultarRuta(String id) {
            return sAdmin.consultarRuta(id);
    }
    public Ruta consultarRuta(int pos) {  
        ArrayList<Ruta> al=this.listarRuta();
        Ruta aux=null;
        for (int i = 0; i < al.size(); i++) {
            if(pos==i)
            {
                aux=al.get(i);
                break;
            }
        }
        return aux;
    }
    public ArrayList<Ruta> consultarRutaID(String id) throws GlobalException
    {
         
        ArrayList<Ruta> al=new ArrayList<>(this.listarRuta());
        Ruta aux=null;
        for (int i = 0; i < al.size(); i++) {
            if(id.equals(al.get(i).getIdentificador()))
            {
                aux=new Ruta();
                aux.setIdentificador(al.get(i).getIdentificador());
                aux.setHorario(al.get(i).getHorario());
                aux.setPaisOrigen(al.get(i).getPaisOrigen());
                aux.setPaisDestino(al.get(i).getPaisDestino());
                
                break;
            }
        }
        al.clear();
        al.add(aux);
        if(aux==null)
            throw new GlobalException("No Existe ese Registro");
        
        return al;
    }
}
