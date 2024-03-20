/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import AccesoADatos.DALAdministrador;
import AccesoADatos.DALAvion;
import AccesoADatos.DALCliente;
import AccesoADatos.DALHistoricoCompras;
import AccesoADatos.DALRuta;
import AccesoADatos.DALVuelo;
import Controladora.ControladorPrincipal;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Netto
 */

/*

hacer procedimientos y funciones almacenadas para 
 Vuelo 
de la ( base datos ) para cada uno.
-> consultar

-----------------
Hacer los servicios para 
-Vuelo 
-servicio Vuelo
*/

public class Modelo extends Observable {

    
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //--------------------------------------  I N I C I O  __ A V I O N E S -----------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    public Modelo() {
        idConsulta="";
        accionAviones="";
        accionRutas="";
        accionVuelos="";
        accionPublico="";
    }

    public String getAccionPublico() {
        return accionPublico;
    }

    public void setAccionPublico(String accionPublico) {
        this.accionPublico = accionPublico;
    }
    
    private  String accionAviones;
    private  String accionRutas;
    private  String accionVuelos;

    public String getAccionRutas() {
        return accionRutas;
    }

    public void setAccionRutas(String accionRutas) {
        this.accionRutas = accionRutas;
    }
    
    public ArrayList listarAviones()
    {
        return DALAvion.getInstance().listarAavion();
    }

    public void insertarAvion(Avion avion) {
        DALAvion.getInstance().insertarAvion(avion);
        accionAviones="insercionAvion";
        this.setChanged();
        this.notifyObservers();
        
    }
    
    public Avion consultarAvion(int pos)
    {
       return DALAvion.getInstance().consultarAvion(pos);
    }
      public Avion consultarAvionLibre(int pos) throws NoDataException {
        ArrayList<String> al= DALVuelo.getInstance().listarAvionesDisponibles();
          for (int i = 0; i < al.size(); i++) {
              if(pos==i)
              {
                  return DALAvion.getInstance().consultarAvion(al.get(i));
              }
          }
          return null;
      }
    
    
    private String idConsulta;

    
    public void listarTabla()
    {
        accionAviones="insercionAvion";
        this.setAccionAviones(accionAviones);
        this.setChanged();
        this.notifyObservers();
    }
    
    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    public void consultarAvion(String id) {
        accionAviones = "consulta";
        setIdConsulta(id);
//        this.consultarAvionID(id);
        this.setChanged();
        this.notifyObservers();
    } 
    
    
    public Avion obtenerAvion(String id) {
        return DALAvion.getInstance().consultarAvion(id);
    }
    
    public ArrayList<Avion> consultarAvionID(String id) throws GlobalException
    {
        try {
            return DALAvion.getInstance().consultarAvionID(id);
        } catch (GlobalException ex) {
            throw ex;
        }
        
    }
    
    public void modificarAvion(Avion avion)
    {
        DALAvion.getInstance().modificarAvion(avion);
        accionAviones="insercionAvion";
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarAvion(String id) throws GlobalException
    {
        DALAvion.getInstance().eliminarAvion(id);
        accionAviones="insercionAvion";
        this.setChanged();
        this.notifyObservers();
    }
    
    public String getAccionAviones() {
        return accionAviones;
    }

    public void setAccionAviones(String accionAviones) {
        this.accionAviones = accionAviones;
    }
    
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------- F I N __ A V I O N E S -----------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------

    public ArrayList<Ruta> listarRutas() {
        return DALRuta.getInstance().listarRuta();
    }
 public void listarTablaRutas() {
        this.setAccionRutas("insertarRuta");
        this.setChanged();
        this.notifyObservers();
        accionRutas = "";
    }

    public void insertarRuta(Ruta r) throws GlobalException {
        DALRuta.getInstance().insertarRuta(r);
        this.setAccionRutas("insertarRuta");
        this.setChanged();
        this.notifyObservers();
        accionRutas = "";
    }

    public Ruta obtenerRuta(String id)
    {
        return DALRuta.getInstance().consultarRuta(id);
    }

    public Ruta consultarRutaPos(int pos) {
        return DALRuta.getInstance().consultarRuta(pos);
    }
    public void consultarRuta(String id) {
        accionRutas = "consulta";
        this.setIdConsulta(id);
        this.setChanged();
        this.notifyObservers();
        accionRutas="";
    }

    public void modificarRuta(Ruta ruta) {
        System.out.print("-> ruta modificada DAL :  " + ruta.toString() + "\n");
        DALRuta.getInstance().modificarRuta(ruta);
        this.setAccionRutas("insertarRuta");
        this.setChanged();
        this.notifyObservers();
        accionRutas = "";
    }

    public void eliminarRuta(String identificador) throws GlobalException {
        DALRuta.getInstance().eliminarRuta(identificador);
        
        this.setAccionRutas("insertarRuta");
        this.setChanged();
        this.notifyObservers();
        accionRutas = "";
    }

    public ArrayList<Ruta> consultarRutaID(String idConsulta) throws GlobalException {
       return  DALRuta.getInstance().consultarRutaID(idConsulta);
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
    //------------------- S E C C I O N  _____ V U E L O S ------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<LineaDetalleVuelo> listarVuelos() throws NoDataException {
        return DALVuelo.getInstance().listarVuelo();
    }

    public LineaDetalleVuelo obtenerVuelo(String idConsulta) {
        return DALVuelo.getInstance().consultarVuelo(idConsulta);
    }

    public LineaDetalleVuelo consultarVuelo(int pos) throws NoDataException {
        return DALVuelo.getInstance().consultarVuelo(pos);
    }

    public String getAccionVuelos() {
        return accionVuelos;
    }

    public void setAccionVuelos(String accionVuelos) {
        this.accionVuelos = accionVuelos;
    }
    
    public void eliminarVuelo(String identificacion) {
        DALVuelo.getInstance().eliminarVuelo(identificacion);
        this.setAccionVuelos("eliminarVuelo");
        this.setChanged();
        this.notifyObservers();
        accionVuelos = "";
    }

    public ArrayList<String> listarAvionesDisponibles() throws NoDataException {
        return DALVuelo.getInstance().listarAvionesDisponibles();
    }

    public void insertarVuelo(Vuelo vuelo) {
        DALVuelo.getInstance().insertarVuelo(vuelo);
        this.setAccionVuelos("eliminarVuelo");
        this.setChanged();
        this.notifyObservers();
        accionVuelos = "";
    }


    public void modificarVuelo(String idVuelo, int parseInt, String idRuta, String text) {
        DALVuelo.getInstance().modificarVuelo(idVuelo, parseInt, idRuta, text);
        
        this.setAccionVuelos("eliminarVuelo");
        this.setChanged();
        this.notifyObservers();
        accionVuelos = "";
    }

    public void listarTablaVuelos() {
        this.setAccionVuelos("eliminarVuelo");
        this.setChanged();
        this.notifyObservers();
        accionVuelos = "";
    }

    public void consultarVueloID(String text) {
        this.setAccionVuelos("consulta");
         System.out.print("Estamos En Consulta3\n");
        setIdConsulta(text);
        this.setChanged();
        this.notifyObservers();
    }

    public ArrayList<LineaDetalleVuelo> consultarVueloIDConsulta(String idConsulta) throws NoDataException {
        return DALVuelo.getInstance().consultarVueloIDConsulta(idConsulta);
    }
    
    //_____________________________________________________________________________________________
    // Metodo que filtra en la tabla el pais origen
    
    public ArrayList<LineaDetalleVuelo> filtrarOrigen(String idConsulta) throws NoDataException {
        return DALVuelo.getInstance().filtrarOrigen(idConsulta);
    }
    
    // Metodo que filtra en la tabla el pais destino
    public ArrayList<LineaDetalleVuelo> filtrarDestino(String idConsulta) throws NoDataException {
        return DALVuelo.getInstance().filtrarDestino(idConsulta);
    }
    //_____________________________________________________________________________________________
    
    
//________________________    ADMIN     ________________________________________    
    
    public void insertarAdministrador(Administrador ad) throws GlobalException {
       DALAdministrador.getInstance().insertarAdministrador(ad);
       this.setAccionAdmin("insertarAdmin");
       this.setChanged();
       this.notifyObservers();
    }
        
        
   
    
    
//________________________    FIN ADMIN   ________________________________________ 
    
    
//________________________    LOGIN   ________________________________________
    

    
    
    /*__________________________________________________________________________
    ________________________  METODOS CLIENTE     ____________________________*/
    
     public void insertarCliente(Cliente  cl) throws GlobalException {
       DALCliente.getInstance().insertarCliente(cl);
       this.setAccionCliente("insertarCliente");
       this.setChanged();
       this.notifyObservers();
    }
    //                          CONSULTAR CLIENTE 
     public void consultarCliente (String id){
         DALCliente.getInstance().consultarCliente(id);
         this.setAccionCliente("consultarCliente");
         this.setChanged();
         this.notifyObservers();
     }
     
        //                      ELIMINAR CLIENTE 
     public void eliminarCliente(String id){
         DALCliente.getInstance().eliminarCliente(id);
         this.setChanged();
         this.notifyObservers();
         this.setAccionCliente("eliminarCliente");
     }
     
     
     //                        MODIFICAR CLIENTE     
     public void modificarCliente(Cliente cl){
         DALCliente.getInstance().modificarCliente(cl);
         this.setChanged();
         this.notifyObservers();
         this.setAccionCliente("modificarCliente");
     }
     
     
     // consulta un cliente por id
     public Cliente obtenerCliente(String id) {
        return DALCliente.getInstance().consultarCliente(id);
    }
     
      
      // consulta un Administrador por id
     public Administrador obtenerAdmin(String id) {
        return DALAdministrador.getInstance().consultarAdministrador(id);
    }
     
     //_____________________________    FIN CLIENTE     ________________________
     
     // ________________________ VENTANA PRINCIPAL  ____________________________
     
     //--------------   FILTRA LOS VUELOS POR PAIS ORIGEN       ----------------
    public void filtraTablaPrincipalOrigen(String origenAux) {
        this.setAccionPublico("filtroOrigen");
        this.setChanged();
        this.notifyObservers();
    }
    
    //--------------   FILTRA LOS VUELOS POR PAIS DESTINO       ----------------
    public void filtraTablaPrincipalDestino(String destAux) {
         this.setAccionPublico("filtroDestino");
        this.setChanged();
        this.notifyObservers();
    }
    
    
    
    
     //                        MODIFICAR ADMINISTRADOR     
     public void modificarAdministrador(Administrador ad){
         DALAdministrador.getInstance().modificarAdministrador(ad);
         this.setChanged();
         this.notifyObservers();
         this.setAccionCliente("modificarAdmin");
     }
     
     
     
     // Lista el historico de compras
     public ArrayList<LineaDetalleHistoricoCompras> listarHistorico(String idConsulta) throws NoDataException {
        return DALHistoricoCompras.getInstance().listarLineaDetalleHistoricoCompras(idConsulta);
    }
     
     
     public ArrayList<LineaDetalleHistoricoCompras> listarTodo() throws NoDataException {
        return DALHistoricoCompras.getInstance().listarTodo();
    }
     
     
     
    
     
     public void listarTablahistorico() {
        this.setAccionVuelos("listarHistorico");
        this.setChanged();
        this.notifyObservers();
        accionCliente = "";
    }
     

    public String getAccionCliente() {
        return accionCliente;
    }

    public void setAccionCliente(String accionCliente) {
        this.accionCliente = accionCliente;
    }

    public String getAccionAdmin() {
        return accionAdmin;
    }

    public void setAccionAdmin(String accionAdmin) {
        this.accionAdmin = accionAdmin;
    }

    
    
    
  String accionCliente, accionAdmin,accionPublico;  
    
    
    
    
    
  
    
    
}
