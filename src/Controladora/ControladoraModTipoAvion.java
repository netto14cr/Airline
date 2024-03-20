/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.NoDataException;
import Modelo.Avion;
import Modelo.LineaDetalleVuelo;
import Modelo.Modelo;
import Modelo.Ruta;
import Modelo.Vuelo;
import Vista.ModTipoAviones;
import Vista.VentanaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author netto
 */
public class ControladoraModTipoAvion implements ActionListener, MouseListener, KeyListener{
    ModTipoAviones vMTA;
    VentanaAdministrador vAdmin;
    Modelo modelo;
    private int pos;
    
    public ControladoraModTipoAvion(VentanaAdministrador vAdmin, ModTipoAviones vMTA, Modelo modelo) {
        this.vAdmin = vAdmin;
        this.vMTA=vMTA;
        this.modelo=modelo;
        vMTA.setControl(this);
        vMTA.setModelo(modelo);
        pos=0;
        
        try {
            this.vMTA.mostrarTablaInicio();
        } catch (NoDataException ex) {
            this.vMTA.mostrarExecpcion(ex.getMessage());
        }
    }

  
    
    public void accionAgregar(){
            System.out.println("SELECCION Y AGREGAR!!");
            this.mostrarAvionesDisponibles();
            this.accion="buscarAvion";
    }
    
    public void accionModificar(){
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y MODIFICAR!!");
            this.vMTA.getPanelModificacionVuelo().setVisible(true);
        }
    }
    
        public void accionEliminar() {
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y ELMINAR!!");
                this.modelo.eliminarVuelo(vueloAux.getIdentificacion());
        }
    }
    
    //  Metodo que minimiza ka ventana
    public void opcionMinimizar(){
        this.vMTA.setExtendedState(1);
    }
    
    // Método que cierra la ventana administrador y vuelve a Login
      public void opcionAtras(){
          this.vAdmin.setVisible(true);
          this.vMTA.dispose();
      }
      
      // Terminar la edicion de la talba y guarda nuevos datos
      public void opcionTerminarEdit(){
          this.vAdmin.setVisible(true);
          this.vMTA.dispose();
          
          
      }
      
      // Cierra el programa
      public void opcionSalir(){
          System.exit(0);
      }
    
    
    /*  Metodo que verifica que una columna o fila de la tabla se haya seleccionado
     *  y actualiza el valor de la posicion
      */
    public boolean elemSeleccionado(){
        boolean seleccionActiva;
        seleccionActiva=false;
        if (vMTA.getTablaDatos().getSelectedRow() == -1) {
        // Si no se ha seleccionado una fila
        this.vMTA.getPanelErrorSeleccion().setVisible(true);
        }else{
            // Fila o columna seleccionada
            pos= vMTA.getTablaDatos().getSelectedRow();
            seleccionActiva=true;
        }
        return seleccionActiva;
    }
    
    public void ocultarMenus(){
//        this.vMTA.getPanelMenuFlotante().setVisible(false);
        this.vMTA.getPopMenu().setVisible(false);
        this.vMTA.getTablaDatos().setSelectionMode(0);
    }
    
    public void ocultarPanelError(){
        this.vMTA.getPanelErrorSeleccion().setVisible(false);
        this.vMTA.getTablaDatos().setSelectionMode(0);
    }
      
      
     // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
     
        switch(e.getActionCommand()){
            
            //  -------------   OPCION MENUS  ------------
            case "Agregar":
                //  Boton agregar
                this.accionAgregar();
                break;
            case "Modificar":
                //  Boton Modificar
                this.accionModificar();
                break;   
                
            case "Eliminar":
                //  Boton Eliminar
                this.accionEliminar();
                break;      
            
            case "Cancelar":
                //  Boton Eliminar
                this.ocultarMenus();
                break;  
                        
            //  -------------   OPCION BOTONES VENTANA  ---------------
            case "Atras":
                //  Salir de modo administrador
                this.opcionAtras();
                break;

            case "Minimizar":
                //  Salir de modo administrador
                this.opcionMinimizar();
                break;

            case "Terminar":
                //  Salir de modo administrador
                this.opcionTerminarEdit();
                break;

            case "Salir":
                //  Cerrar programa
                this.opcionSalir();
                break;

            case "Aceptar":
                //  Boton Aceptar error seleccion
                this.ocultarMenus();
                this.ocultarPanelError();
                break;

            case "terminarEleccion":
                //  Boton Aceptar error seleccion
                this.vMTA.getPanelAgregarAvion().setVisible(false);
                
                System.out.print("estado de eleccion : "+this.vMTA.getTablaAgregarAvion().getSelectedRow()+" . \n");
                if(this.vMTA.getTablaAgregarAvion().getSelectedRow()==-1){
                    this.vMTA.mostrarExecpcion("no se selecciono ningun vuelo\n");
                    this.vMTA.getPanelAgregarAvion().setVisible(true);
                }else
                {
                  //...... se eligio un avion para crear el vuelo y se guardo en idAvion
                    this.vMTA.mostrarTablaRutas();
                }

                break;

            case "terminarEleccionRuta":
                //  Boton Aceptar error seleccion
                System.out.print("datos consegudos : " + this.vMTA.getTxtNuevoTipoVuelo().getText() + " , "
                        + this.vMTA.getTxtPrecioNuevoVuelo().getText() + "id de ruta : " + idRuta + ".\n");
                
                System.out.print("estado de eleccion Ruta : " + this.vMTA.getTablaAgragarRuta().getSelectedRow() + " . \n");
                if (this.vMTA.getTablaAgragarRuta().getSelectedRow() == -1 ) {
                    this.vMTA.mostrarExecpcion("no se selecciono ningun vuelo\n");
                    this.vMTA.getPanelAgregarRuta().setVisible(true);
                } else if (!this.vMTA.getTxtNuevoTipoVuelo().getText().isEmpty()
                        && !this.vMTA.getTxtPrecioNuevoVuelo().getText().isEmpty() &&!idRuta.isEmpty() ) {
                    System.out.print("procedemos a insertar el avion , id vuel : " + idVuelo + " .\n");
                    this.modelo.modificarVuelo(idVuelo, Integer.parseInt(this.vMTA.getTxtPrecioNuevoVuelo().getText()),
                            idRuta, this.vMTA.getTxtNuevoTipoVuelo().getText());
                    idRuta = "";
                    this.vMTA.getTxtNuevoTipoVuelo().setText("");
                    this.vMTA.getTxtPrecioNuevoVuelo().setText("");
                    this.vMTA.getPanelAgregarRuta().setVisible(false);
                } else if (!idRuta.isEmpty()) {
                    this.vMTA.getPanelAgregarRuta().setVisible(false);
                    this.agregarDatosVuelos();
//                    idRuta = "";
                }


                break;
            
            case "terminarDatosVuelo":
                this.agregarVuelo();
                this.vMTA.getPanelSolicitarDatosVuelo().setVisible(false);
                

                break;
            
            case "CancelarEleccionAgregarAvion":
                this.vMTA.getPanelAgregarAvion().setVisible(false);
                break;

            case "CancelarEleccionRuta":
                this.vMTA.getPanelAgregarRuta().setVisible(false);
                break;

            case "cancelarDatosVuelo":
                this.vMTA.getPanelSolicitarDatosVuelo().setVisible(false);
                break;
                
                case "aceptarCamvioVuelo":
                this.modificarVuelo();
                this.vMTA.getPanelModificacionVuelo().setVisible(false);
                break;
            case "listarVuelo":
                //  Cerrar programa
                this.opcionListar();
                break;
            case "consultaVuelo":
                //  Cerrar programa
                System.out.print("Estamos En Consulta1\n");
                this.consultarVuelo();
                break;
            case "cancelarCambioVuelo":
                //  Cerrar programa
                System.out.print("Estamos En Consulta1\n");
                this.vMTA.getPanelModificacionVuelo().setVisible(false);
                break;
        }

    }
    String accion="";
        LineaDetalleVuelo vueloAux=null;
     @Override
    public void mouseClicked(MouseEvent me) {
        
        if(!this.modelo.getIdConsulta().isEmpty())//si no esta vacio es porque esta consultadondo por id
        { 
           
            vueloAux=modelo.obtenerVuelo(modelo.getIdConsulta());
            modelo.setIdConsulta("");
            this.vMTA.getConsultaTxt().setText("");
            
//            System.out.print("Fila Seleccionada id :" + vueloAux.toString()+ "\n");
            
        }else {
            
            if (this.vMTA.getTablaDatos().getSelectedRow()!=-1&& this.modelo.getIdConsulta().isEmpty()
                && accion!="buscarAvion"   ) {
                            System.out.print("-> Estamos en el primer if de vuelo\n");
                int pos = this.vMTA.getTablaDatos().getSelectedRow();
                try {
                    vueloAux = modelo.consultarVuelo(pos);
              idVuelo=vueloAux.getIdentificacion();
              System.out.print("--> idVuelo : "+idVuelo+"\n");
                    System.out.print("Fila Seleccionada id :" + vueloAux.toString()+ "\n");
                } catch (NoDataException ex) {
                    this.vMTA.mostrarExecpcion(ex.getMessage());
                }
            }
            
            //--------------------------------------va a agregar un avion
            else
            if (this.vMTA.getTablaAgregarAvion().getSelectedRow() != -1 && this.modelo.getIdConsulta().isEmpty()) {

                int pos = this.vMTA.getTablaAgregarAvion().getSelectedRow();

                Avion a;
                try {
                    a = modelo.consultarAvionLibre(pos);
                    idAvion = a.getIdentificacion();
                    
                   System.out.print("Fila Seleccionada Agregar Avion :" + a.toString() + "\n");
                } catch (NoDataException ex) {
                    this.vMTA.mostrarExecpcion(ex.getMessage());
                }


                
            }
                if (this.vMTA.getTablaAgragarRuta().getSelectedRow() != -1 && this.modelo.getIdConsulta().isEmpty()) {

                int pos = this.vMTA.getTablaAgragarRuta().getSelectedRow();

                Ruta a = modelo.consultarRutaPos(pos);
                idRuta = a.getIdentificador();
                System.out.print("Fila Seleccionada Agregar Ruta :" + a.toString()+ "\n");
                
            }
        }
        
        
        
    }
    String idVuelo="";
    String idAvion="";
    String idRuta="";
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e){
       
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    private void mostrarAvionesDisponibles() {
       this.vMTA.mostrarTablaAvionesDisponibles();
    }

    private void agregarDatosVuelos() {
        this.vMTA.getPanelSolicitarDatosVuelo().setVisible(true);
        
    }

    private void agregarVuelo() {
        Avion a = modelo.obtenerAvion(idAvion);
        Ruta r = modelo.obtenerRuta(idRuta);

        // ya tenemos los datos de avion y ruta para asignarles al vuelo nuevo
//        LineaDetalleVuelo linea = new LineaDetalleVuelo();
//
//        linea.setIdentificacion(this.vMTA.getTxtNumVueloRuta().getText());
//        linea.setAnioLlegada(r.getHorario().getFechaLLegada().getAnio());
//        linea.setMesLlegada(r.getHorario().getFechaLLegada().getMes());
//        linea.setDiaLlegada(r.getHorario().getFechaLLegada().getDia());
//        //-------salida
//        linea.setAnioSalida(r.getHorario().getFechaSalida().getAnio());
//        linea.setMesSalida(r.getHorario().getFechaSalida().getMes());
//        linea.setDiaSalida(r.getHorario().getFechaSalida().getDia());
//        linea.setHoraLlegada(r.getHorario().getFechaLLegada().getHora());
//        linea.setHoraSalida(r.getHorario().getFechaSalida().getHora());
//
//        //----------------------------------------------------
//        linea.setPaisOrigen(r.getPaisOrigen());
//        linea.setPaisDestino(r.getPaisDestino());
//        linea.setCantidadPasajeros(a.getCantidadPasajeros());
//        linea.setPrecio(Integer.parseInt(this.vMTA.getTxtPrecioVuelo().getText()));
//        linea.setTipoVuelo(this.vMTA.getTxtTipoVuelo().getText());
        //----------fin llenado de datos vuelo
        Vuelo v = new Vuelo();
        v.setAvion(a);
        v.setRuta(r);
        v.setIdentificacion(this.vMTA.getTxtNumVueloRuta().getText());
        v.setPrecio(Integer.parseInt(this.vMTA.getTxtPrecioVuelo().getText()));
        v.setTipoVuelo(this.vMTA.getTxtTipoVuelo().getText());
        System.out.print("vuelo a insertar : " + v.toString());

        //-----------validacion espacios vacios
        if (v.getAvion() == null
                || a.getAnio().isEmpty()
                || v.getRuta() == null
                || v.getIdentificacion() == null
                || v.getPrecio() == 0
                || v.getTipoVuelo() == null) {
            System.out.print("vuelo oncompleto : " + v.toString() + "\n");
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
            this.vMTA.getPanelSolicitarDatosVuelo().setVisible(true);
                    idAvion = "";
                    idRuta = "";
                    a = null;
                    r = null;
                    v=null;
                   
                } else {
                    
                    this.modelo.insertarVuelo(v);
                    a = null;
                    r = null;
                    v=null;
                    idAvion = "";
        idRuta = "";
        
        }
    }

    private void modificarVuelo() {
      this.vMTA.mostrarTablaRutas();
        System.out.print("datos consegudos : " + this.vMTA.getTxtNuevoTipoVuelo().getText() + " , "
                + this.vMTA.getTxtPrecioNuevoVuelo().getText() + ".\n");

    }

    private void opcionListar() {
        this.modelo.listarTablaVuelos();
    }

    private void consultarVuelo() {
        if (this.vMTA.getConsultaTxt().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es necesario un numero de identificacion de Avion para la Consulta\n");
        } else {
             System.out.print("Estamos En Consulta2\n");
            modelo.consultarVueloID(this.vMTA.getConsultaTxt().getText());
        }
    }



    
    
   
    
    
    
    
    
    
}
