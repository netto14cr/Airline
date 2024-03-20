/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Fecha;
import Modelo.Horario;
import Modelo.Modelo;
import Modelo.Ruta;
import Vista.ModRutas;
import Vista.VentanaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author netto
 */
public class ControladoraModRutas implements ActionListener, MouseListener, KeyListener{
    ModRutas vMTA;
    VentanaAdministrador vAdmin;
    Modelo modelo;
    private int pos;
    
    public ControladoraModRutas(VentanaAdministrador vAdmin, ModRutas vMTA, Modelo modelo) {
        this.vAdmin = vAdmin;
        this.vMTA=vMTA;
        this.modelo=modelo;
        vMTA.setControl(this);
        vMTA.setModelo(modelo);
        pos=0;
        this.vMTA.mostrarTablaInicio();
        try {
            this.listarTabla();
        } catch (GlobalException ex) {
            Logger.getLogger(ControladoraModRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(ControladoraModRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void listarTabla() throws GlobalException, NoDataException{
        
       // this.modelo.listarDatosBase(); // Metodo que llama a listar datos a modelo
    }
    
    public void accionAgregar(){
        this.vMTA.getPanelAgregar().setVisible(true);
            System.out.println("SELECCION Y AGREGAR!!");
        
    }
    
    public void accionModificar(){
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y MODIFICAR!!");
            this.modificarDatosRuta(rutaAux);
            this.vMTA.getPanelModificar().setVisible(true);
        }
    }
    
    
    public void accionEliminar(){
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y ELMINAR!!");
            try {
                this.modelo.eliminarRuta(rutaAux.getIdentificador());
            } catch (GlobalException ex) {
                this.vMTA.mostrarExecepcion(ex.getMessage());
            }
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
          this.vMTA.dispose();
          this.vAdmin.setVisible(true);
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
        this.vMTA.getPanelAgregar().setVisible(false);
        this.vMTA.getPanelModificar().setVisible(false);
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
            case "salvarRuta":
                //  Boton Eliminar
                System.out.print("insertando Ruta : \n");
        {
            try {
                this.agregarRuta();
            } catch (GlobalException ex) {
                this.vMTA.mostrarExecepcion(ex.getMessage());
                
            }
        }
                
                break;
            case "cacelarRuta":
                //  Boton Eliminar
                System.out.print("Candelando Ruta : \n");
                this.vMTA.getPanelAgregar().setVisible(false);
                break;

            case "cacelarRutaModificada":
                //  Boton Eliminar
                System.out.print("Candelando Ruta modificada : \n");
                this.vMTA.getPanelModificar().setVisible(false);
                break;


            case "salvarRutaModificada":
                System.out.print("entro modificacion\n");
                 {
                    try {
                        this.realizarModificacionDatosRutas();
                        this.vMTA.getPanelModificar().setVisible(false);
                        
                    } catch (GlobalException ex) {
                        this.vMTA.mostrarExecepcion(ex.getMessage());
                    }
                }
                
                break;
              
            case "consultaR":
                System.out.print("entro Consulta\n");
                this.realizarConsulta();
                break;
            case "listar":
                System.out.print("entro listar\n");
                this.listarRutas();
                break;
        }

    }
    
    Ruta rutaAux=null;
     @Override
    public void mouseClicked(MouseEvent me) {
        
      if(!this.modelo.getIdConsulta().isEmpty())//si no esta vacio es porque esta consultadondo por id
        { 
           
            rutaAux=modelo.obtenerRuta(modelo.getIdConsulta());
            modelo.setIdConsulta("");
            this.vMTA.getConsultaTxt().setText("");
            
            System.out.print("Fila Seleccionada id :" + rutaAux.toString()+ "\n");
            
        }else {
            if (this.vMTA.getTablaDatos().getSelectedRow()!=-1&& this.modelo.getIdConsulta().isEmpty()) {
                
                int pos = this.vMTA.getTablaDatos().getSelectedRow();
                rutaAux = modelo.consultarRutaPos(pos);
                System.out.print("Fila Seleccionada id :" + rutaAux.toString()+ "\n");
            }
        }
        
    }

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

    private void agregarRuta() throws GlobalException {
       
        this.vMTA.getPanelAgregar().setVisible(true);
        
        String identi, paisOrigen, paisDestino;
        Horario h = new Horario();
        Fecha fs = new Fecha();
        Fecha fl = new Fecha();
        
        Ruta r=new Ruta();
        
        
        System.out.print("F_sald : "+fs.toString()+"\n");
        System.out.print("F_Lleg : "+fl.toString()+"\n");
//        -- no hace falta hacer eso (borrar cuando todo funcione)....
//        fs.setDia(Integer.parseInt(fs.getDia())+1+"");
//        fl.setDia(Integer.parseInt(fl.getDia())+1+"");
//        
//        fs.setMes(Integer.parseInt(fs.getMes())+1+"");
//        fl.setMes(Integer.parseInt(fs.getMes())+1+"");
        
        r.setHorario(h);
        
        identi = this.vMTA.getNumRutaTxt().getText();
        paisOrigen=(String) this.vMTA.getComboOrigenAgregar().getSelectedItem().toString();
        paisDestino= (String)this.vMTA.getComboDestinoAgregar().getSelectedItem().toString();
        
//        this.vMTA.getComboOrigen().setSelectedItem(avion.getPaisOrigen());
//        this.vMTA.getComboDestino().setSelectedItem(avion.getPaisDestino());
        System.out.print("Mostrando los datos ComboBox : "+paisOrigen+" , des : "+paisDestino+"\n");
        r.setIdentificador(identi);
        r.setPaisDestino(paisDestino);
        r.setPaisOrigen(paisOrigen);
        
        h.getFechaSalida().setHora(this.vMTA.getHoraSalidatxt().getText());
        h.getFechaLLegada().setHora(this.vMTA.getHoraLlegadaTxt().getText());
        
        System.out.print("Horas  :  "+h.getFechaSalida().getHora()+" , "+h.getFechaLLegada().getHora()+"\n");
        
        
//        if(identi.isEmpty() || fs.getAnio().isEmpty() || fs.getDia().isEmpty() || fs.getMes().isEmpty()
//                || fl.getAnio().isEmpty() || fl.getDia().isEmpty() || fl.getMes().isEmpty()
//                ||
//                paisOrigen.isEmpty() || paisDestino.isEmpty()
//                
//                )
//            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
        if (paisOrigen.equals("No Seleccionado")
                || paisDestino.equals("No Seleccionado")) {
            System.out.print("ENTROOOOOOOOOOOOOOOOOO\n");
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
            throw new GlobalException("No ha seleccionado un Origen o un Destino");
        }
        
        if (identi.isEmpty() || this.vMTA.getBtnFechaSalida().getDate() == null
                || this.vMTA.getBtnFechaLlegada().getDate() == null
                || paisOrigen.isEmpty() || paisDestino.isEmpty() 
                || h.getFechaSalida().getHora().isEmpty()
                || h.getFechaLLegada().getHora().isEmpty()
                || r.getPaisOrigen().isEmpty()
                || r.getPaisDestino().isEmpty()
                
                )

            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
        else
        {  
                
       
        
        fs.setDia(""+this.vMTA.getBtnFechaSalida().getDate().getDate());
        fs.setMes(""+this.vMTA.getBtnFechaSalida().getDate().getMonth());
        fs.setAnio(""+(1900+this.vMTA.getBtnFechaSalida().getDate().getYear()));
        fs.setHora(h.getFechaSalida().getHora());
        fl.setDia(""+this.vMTA.getBtnFechaLlegada().getDate().getDate());
        fl.setMes(""+this.vMTA.getBtnFechaLlegada().getDate().getMonth());
        fl.setAnio(""+(1900+this.vMTA.getBtnFechaLlegada().getDate().getYear()));
        fl.setHora(h.getFechaLLegada().getHora()); 
        h.setFechaLLegada(fl);
        h.setFechaSalida(fs);
            try {
                System.out.print("-> ruta a insertar : "+r.toString()+"\n");
            modelo.insertarRuta(r);
            this.vMTA.getPanelAgregar().setVisible(false);
            } catch (GlobalException ex) {
                this.vMTA.mostrarExecepcion(ex.getMessage());
            }
//        this.vMTA.mostrarTablaInicio();
        }
       
        
    }

    private void modificarDatosRuta(Ruta avion) {
      
        
        this.vMTA.getNumRutaModificarTxt().setText(avion.getIdentificador());
        
        this.vMTA.getBtnFechaSalidaModificartxt().setDate(new Date(
                Integer.parseInt(avion.getHorario().getFechaSalida().getAnio())-1900,
                Integer.parseInt(avion.getHorario().getFechaSalida().getMes())
                , Integer.parseInt(avion.getHorario().getFechaSalida().getDia())));
        //-----------btnFechaLlegada igual 
        
        this.vMTA.getBtnFechaLlegadaModificarTxt().setDate(new Date(
                Integer.parseInt(avion.getHorario().getFechaLLegada().getAnio())-1900,
                Integer.parseInt(avion.getHorario().getFechaLLegada().getMes())
                , Integer.parseInt(avion.getHorario().getFechaLLegada().getDia())));
        
        this.vMTA.getComboOrigen().setSelectedItem(avion.getPaisOrigen());
        this.vMTA.getComboDestino().setSelectedItem(avion.getPaisDestino());
        
        this.vMTA.getHoraSalidaModificartxt1().setText(avion.getHorario().getFechaSalida().getHora());
        this.vMTA.getHoraLlegadaModificarTxt1().setText(avion.getHorario().getFechaLLegada().getHora());
        
        //------------llenamos los datos seleccionados
//        System.out.print("->>>"+avion.toString()+"\n");
//..............esto debe ir cuando se realiza el cambio
//        System.out.print("\n---> seleccionado box = "+this.vMTA.getComboOrigen().getSelectedItem()+".\n");
//        System.out.print("\n---> seleccionado box des = "+this.vMTA.getComboDestino().getSelectedItem()+".\n");
//        if(this.vMTA.getNumRutaModificarTxt().getText().isEmpty() ||
//                this.vMTA.getBtnFechaSalidaModificartxt().getDateFormatString().isEmpty() ||
//                this.vMTA.getBtnFechaLlegadaModificarTxt().getDateFormatString().isEmpty() ||
//                this.vMTA.getComboOrigen().getSelectedItem().equals("No seleccionado")==true ||
//                this.vMTA.getHoraSalidaModificartxt1().getText().isEmpty() ||
//                this.vMTA.getHoraLlegadaModificarTxt1().getText().isEmpty() ||
//                this.vMTA.getComboDestino().getSelectedItem().equals("No seleccionado")
////                this.vMTA.getPasajeros_txt_modificar().getText().isEmpty() 
//                )
//            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
//        
//        if(this.vMTA.getComboOrigen().getSelectedItem().equals("No seleccionado") ||
//                this.vMTA.getComboDestino().getSelectedItem().equals("No seleccionado"))
//        {
//            System.out.print("ENTROOOOOOOOOOOOOOOOOO\n");
//            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
//        }
        
        
        
    }

    private void realizarModificacionDatosRutas() throws GlobalException {
         String identi, paisOrigen, paisDestino;
        Horario h = new Horario();
        Fecha fs = new Fecha();
        Fecha fl = new Fecha();
        
        Ruta r=new Ruta();
        
        fs.setDia(""+this.vMTA.getBtnFechaSalidaModificartxt().getDate().getDate());
        fs.setMes(""+this.vMTA.getBtnFechaSalidaModificartxt().getDate().getMonth());
        fs.setAnio(""+(1900+this.vMTA.getBtnFechaSalidaModificartxt().getDate().getYear()));
        
        fl.setDia(""+this.vMTA.getBtnFechaLlegadaModificarTxt().getDate().getDate());
        fl.setMes(""+this.vMTA.getBtnFechaLlegadaModificarTxt().getDate().getMonth());
        fl.setAnio(""+(1900+this.vMTA.getBtnFechaLlegadaModificarTxt().getDate().getYear()));
        
        h.setFechaLLegada(fl);
        h.setFechaSalida(fs);
        System.out.print("-> nueva fecha salida :  "+fs.toString()+"\n");
        System.out.print("-> nueva fecha llegada :  "+fl.toString()+"\n");
        
        identi = this.vMTA.getNumRutaModificarTxt().getText();
        paisOrigen=this.vMTA.getComboOrigen().getSelectedItem().toString();
        paisDestino=this.vMTA.getComboDestino().getSelectedItem().toString();
        r.setIdentificador(identi);
        r.setPaisDestino(paisDestino);
        r.setPaisOrigen(paisOrigen);
        h.getFechaSalida().setHora(this.vMTA.getHoraSalidaModificartxt1().getText());
        h.getFechaLLegada().setHora(this.vMTA.getHoraLlegadaModificarTxt1().getText());
        r.setHorario(h);
        
          System.out.print("\n---> seleccionado box = "+this.vMTA.getComboOrigen().getSelectedItem()+".\n");
        System.out.print("\n---> seleccionado box des = "+this.vMTA.getComboDestino().getSelectedItem()+".\n");
        if(this.vMTA.getNumRutaModificarTxt().getText().isEmpty() ||
                this.vMTA.getBtnFechaSalidaModificartxt().getDateFormatString().isEmpty() ||
                this.vMTA.getBtnFechaLlegadaModificarTxt().getDateFormatString().isEmpty() ||
                this.vMTA.getComboOrigen().getSelectedItem().equals("No seleccionado") ||
                this.vMTA.getHoraSalidaModificartxt1().getText().isEmpty() ||
                this.vMTA.getHoraLlegadaModificarTxt1().getText().isEmpty() ||
                this.vMTA.getComboDestino().getSelectedItem().equals("No seleccionado")
//                this.vMTA.getPasajeros_txt_modificar().getText().isEmpty() 
                )
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
        
        if(this.vMTA.getComboOrigen().getSelectedItem().equals("No seleccionado") ||
                this.vMTA.getComboDestino().getSelectedItem().equals("No seleccionado"))
        {
            System.out.print("ENTROOOOOOOOOOOOOOOOOO\n");
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
            throw new GlobalException("No ha seleccionado un Origen o un Destino");
        }
        
        System.out.print("-> ruta modificada :  " + r.toString() + "\n");
        modelo.modificarRuta(r);
//        this.vMTA.mostrarTablaInicio();//actualizar a lo rudo
        rutaAux = null;
    }

    private void realizarConsulta() {
         if(this.vMTA.getConsultaTxt().getText().isEmpty())
           JOptionPane.showMessageDialog(null, "Es Necesario un numero de identificacion de Avion para la Consulta\n");
       else
       {
           modelo.consultarRuta(this.vMTA.getConsultaTxt().getText());
       }
    }

    private void listarRutas() {
        
        this.modelo.listarTablaRutas();
        
    }
    
    
    
    
    
   
    
    
    
    
    
    
}
