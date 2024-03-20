/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Modelo;
import Modelo.Vuelo;
import Vista.VentanaLogin;
import Vista.VentanaPrincipal;
import Vista.VentanaRegistroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Netto
 */
public class ControladorPrincipal implements ActionListener, KeyListener, MouseListener{
    
   
   
      public ControladorPrincipal(Modelo modelo, VentanaPrincipal vPrincipal) {
        this.modelo=modelo;
        this.vPrincipal = vPrincipal;
        this.vPrincipal.setControl(this);
        this.vPrincipal.setModelo(modelo);
        this.select="";
        this.origenAux="";
        this.destAux="";
        
    }
      
     
    
      public void opcionSalir(){
          System.exit(0);
      }
      
      
      public void opcionLoguear(){
          
          this.vPrincipal.getTablaDatos().setVisible(false);
          vLogin=new VentanaLogin();
          cLogin=new ControladorLogin(vLogin, vPrincipal,modelo);
          
        
          this.vPrincipal.setVisible(false);
          
      }
      
      public void opcionRegistrarse(){
          
        this.vPrincipal.getTablaDatos().setVisible(false);
          vRegistro=new VentanaRegistroCliente();
          cRegistro=new ControladoraRegistroCliente(vRegistro,vPrincipal,modelo);
          this.vPrincipal.setVisible(false);
      }
       //  Metodo que minimiza ka ventana
        public void opcionMinimizar(){
        this.vPrincipal.setExtendedState(1);
    }

   
    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            
            case "IniciarSesion":
                //  Boton agregar
                this.opcionLoguear();
                break;
                
            case "Registrarse":
                //  Boton agregar
                this.opcionRegistrarse();
                break;
           
                
            case "Minimizar":
                //  Salir de modo administrador
                this.opcionMinimizar();
                break;
                
            case "Salir":
                //  Boton agregar
                this.opcionSalir();
                break;
                
            case "ok":
                this.ocultarDatos();
                break;
            
            case "comboO":
                this.filtarTablaOrigen();
                break;
                
            case "comboD":
                this.filtarTablaDestino();
                break;    
                
                     
            case "Buscar":
                //  Boton agregar
                break;
        }
        
    }
    
    public void filtarTablaOrigen(){
                
                origenAux=this.vPrincipal.getComboOrigen().getSelectedItem().toString();
                
                this.vPrincipal.setSeleccion(origenAux);
                this.vPrincipal.setSeleccion(origenAux);
                this.modelo.filtraTablaPrincipalOrigen(origenAux);
                this.vPrincipal.getPanelTabla().setVisible(true);
                
    }
    
    public void filtarTablaDestino(){
                this.vPrincipal.setSeleccion(destAux);
                destAux=this.vPrincipal.getComboDestino().getSelectedItem().toString();
                this.vPrincipal.setSeleccion(destAux);
                this.modelo.filtraTablaPrincipalDestino(destAux);
                this.vPrincipal.getPanelTabla().setVisible(true);
    }
    
    public void ocultarDatos(){
        this.vPrincipal.getPanelTabla().setVisible(false);
        this.vPrincipal.getTablaDatos().setVisible(false);
        
    }
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
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
    public void mouseExited(MouseEvent e) {
        
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

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }
    
    
    
    //  Declaracion de Clases
    ControladorLogin cLogin;
    ControladoraRegistroCliente cRegistro;
    Modelo modelo;
    VentanaPrincipal vPrincipal;
    VentanaLogin vLogin;
    VentanaRegistroCliente vRegistro;
    
    //  Declaracion de variables
    String select,origenAux,destAux;
    
    
    
}
