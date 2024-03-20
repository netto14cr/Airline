/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import AccesoADatosBD.servicioVuelo;
import Excepciones.NoDataException;
import Modelo.LineaDetalleVuelo;
import Modelo.Vuelo;
import java.util.ArrayList;
import oracle.net.aso.i;

/**
 *
 * @author gabri
 */
public class DALVuelo {
    
    private static DALVuelo mInstance;
    private final servicioVuelo sAdmin;

    public static DALVuelo getInstance() {
        if (mInstance == null) {
            mInstance = new DALVuelo();
        }
        return mInstance;
    }
    
    public ArrayList<String> listarAvionesDisponibles() throws NoDataException
    {
        return sAdmin.listarAvionesDisponibles();
    }
    
    
    
    private DALVuelo() {
          sAdmin=new servicioVuelo();
    }

    
    //   Metodo de DAL Insertar Administrador
    public void insertarVuelo(Vuelo adminnistrador) {
            sAdmin.insertarVuelo(adminnistrador);
    }

    //   Metodo de DAL Actualizar Administrador
    public void modificarVuelo(Vuelo adminnistrador){
            sAdmin.modificarVuelo(adminnistrador);
    }public void modificarVuelo(String id,int pre,String idr,String ti){
            sAdmin.modificarVuelo(id, pre, idr, ti);
    }
    
    //   Metodo de DAL Eliminar Administrador
    
    public void eliminarVuelo(String id) {
            sAdmin.eliminarVuelo(id);
    }
    
        //   Metodo de DAL Listar Vuelo
     public ArrayList listarVuelo() throws NoDataException {
            return sAdmin.listarVuelos();
    }
     
    //   Metodo de DAL Eliminar Administrador
    
    public LineaDetalleVuelo consultarVuelo(String id) {
            return sAdmin.consultarVuelo(id);
    }

    public LineaDetalleVuelo consultarVuelo(int pos) throws NoDataException {
          ArrayList<LineaDetalleVuelo> al=this.listarVuelo();
        LineaDetalleVuelo aux=null;
        for (int i = 0; i < al.size(); i++) {
            if(pos==i)
            {
                aux=al.get(i);
                break;
            }
        }
        return aux;
    }

    public ArrayList<LineaDetalleVuelo> consultarVueloIDConsulta(String idConsulta) throws NoDataException {
         ArrayList<LineaDetalleVuelo> al=new ArrayList<>(this.listarVuelo());
        LineaDetalleVuelo linea=null;
        int cont=0;
        for (int i = 0; i < al.size(); i++) {
            if(idConsulta.equals(al.get(i).getIdentificacion()) )
            {
                linea =new LineaDetalleVuelo();
                linea.setIdentificacion(al.get(i).getIdentificacion());
                linea.setPrecio(al.get(i).getPrecio());
                linea.setTipoVuelo(al.get(i).getTipoVuelo());
                linea.setPaisOrigen(al.get(i).getPaisOrigen());
                linea.setPaisDestino(al.get(i).getPaisDestino());
                linea.setDiaSalida(al.get(i).getDiaSalida());
                linea.setMesSalida(al.get(i).getMesSalida());
                linea.setAnioSalida(al.get(i).getAnioSalida());
                linea.setHoraSalida(al.get(i).getHoraSalida());
                linea.setDiaLlegada(al.get(i).getDiaLlegada());
                linea.setMesLlegada(al.get(i).getMesLlegada());
                linea.setAnioLlegada(al.get(i).getAnioLlegada());
                linea.setHoraLlegada(al.get(i).getHoraLlegada());
                linea.setCantidadPasajeros(al.get(i).getCantidadPasajeros());
                cont++;
                break;
            }
            
        }
        if(cont!=0)
        {
            
        al.clear();
        al.add(linea);
        
        return al;
        }else
        {
            return null;
        }
        
    }
    
    
       
        public ArrayList<LineaDetalleVuelo> filtrarOrigen(String origen)throws NoDataException {
            ArrayList<LineaDetalleVuelo> al=DALVuelo.getInstance().listarVuelo();
            ArrayList<LineaDetalleVuelo> aux=new ArrayList<>();
            for (int i = 0; i < al.size(); i++) 
                if(al.get(i).getPaisOrigen().equals(origen)){
                    aux.add(al.get(i));
                }
                if(aux.size()==0){
            System.out.print("_no hay coincidencias con ese pais\n");
                }
                return aux;
        }
                
        
        
        public ArrayList<LineaDetalleVuelo> filtrarDestino(String des)throws NoDataException {
            ArrayList<LineaDetalleVuelo> al=DALVuelo.getInstance().listarVuelo();
            ArrayList<LineaDetalleVuelo> aux=new ArrayList<>();
            for (int i = 0; i < al.size(); i++) 
                if(al.get(i).getPaisDestino().equals(des)){
                    aux.add(al.get(i));
                }
                if(aux.size()==0){
            System.out.print("_no hay coincidencias con ese pais\n");
                }
                return aux;
        }
    
    

    
    }
    
    
