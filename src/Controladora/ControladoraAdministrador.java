/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Administrador;
import Modelo.Modelo;
import Vista.ModAviones;
import Vista.ModRutas;
import Vista.ModTipoAviones;
import Vista.VentanaAdministrador;
import Vista.VentanaDatosPersonalesAdmin;
import Vista.VentanaLogin;
import Vista.VentanaRegistroAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

/**
 *
 * @author netto
 */
public class ControladoraAdministrador implements ActionListener, MouseListener, KeyListener{
    
     public ControladoraAdministrador(VentanaAdministrador vAdmin, VentanaLogin vLogin, Modelo modelo) {
        this.vAdmin = vAdmin;
        this.vLogin=vLogin;
        this.modelo=modelo;
        vAdmin.setControl(this);
        vAdmin.setModelo(modelo);
        this.identificacion="";
        
    }
    
     
      
      //    Método que muestra modificar Tipo aviones
      public void modificarTipoAvion(){
          this.vMTA=new ModTipoAviones();
          this.cMTA=new ControladoraModTipoAvion(vAdmin, vMTA, modelo);
          this.vAdmin.setVisible(false);
      }
      
      //    Método que muestra modificar Rutas
      public void modificarRutas(){
          this.vMR=new ModRutas();
          this.cMR=new ControladoraModRutas(vAdmin, vMR, modelo);
          this.vAdmin.setVisible(false);
          
      }
      
      //    Método que muestra crear administradores
      public void registrarAdmin(){
          vRegAdm=new VentanaRegistroAdmin();
          cRegAdm=new ControladoraRegistroAdmin(vRegAdm, vAdmin, modelo);
          this.vAdmin.setVisible(false);
          
      }
      
      //    Método que muestra modificar Aviones
      public void modificiarAviones(){
          this.vMA=new ModAviones();
          this.cMA=new ControladoraModAviones(vAdmin, vMA, modelo);
          
          this.vAdmin.setVisible(false);
      }
      
      //    Método que muestra reportes web de la aplicación
      public void editarDatosAdmin(){
          this.vDP=new VentanaDatosPersonalesAdmin();
           adminAux = modelo.obtenerAdmin(identificacion);
          this.cargaDatosPersonales(adminAux);
          this.cDP=new ControladoraDatosPersonalesAdmin(vAdmin, vDP, modelo);
          this.vAdmin.setVisible(false);
      }
      Administrador adminAux =null;
      
      //  Metodo que minimiza ka ventana
        public void opcionMinimizar(){
        this.vAdmin.setExtendedState(1);
    }
     
      // Método que cierra la ventana administrador y vuelve a Login
      public void opcionAtras(){
          this.vLogin.setVisible(true);
          this.vAdmin.dispose();
      }
      
      // Método que cierra el programa
      public void opcionSalir(){
          System.exit(0);
      }
      
      
      
      
      public void cargaDatosPersonales(Administrador cl) {
        this.vDP.getTxtNombre().setText(cl.getNombre());
        this.vDP.getTxtApellido1().setText(cl.getApellido1());
        this.vDP.getTxtApellido2().setText(cl.getApellido2());
        this.vDP.getTxtIdentificacion().setText(cl.getIdentificacion());
        this.vDP.getTaDireecion().setText(cl.getDireccion());
        this.vDP.getTxtCorreo().setText(cl.getCorreoElectronico());
        this.vDP.getTxtFecha().setDate(new Date(
                Integer.parseInt(cl.getFechaNacimiento().getAnio()) - 1900,
                Integer.parseInt(cl.getFechaNacimiento().getMes()),
                Integer.parseInt(cl.getFechaNacimiento().getDia())));

        this.vDP.getTxtPassword().setText(cl.getContrasenia());
        this.vDP.getTxtTtrabajo().setText(cl.getTelefonoTrabajo());
        this.vDP.getTxtTCelular().setText(cl.getCelular());
        this.vAdmin.setVisible(false);
    }
      
      
      
    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
     
        switch(e.getActionCommand()){
            case "mTipoAvion":
                // Modificar tabla de aviones
                this.modificarTipoAvion();
                break;
            case "mRutas":
                // Modificar las rutas
                this.modificarRutas();
                break;
            case "mHorarios":
                // Registrar administradores
                this.registrarAdmin();
                break;
            case "mAviones":
                // Modificar los aviones
                this.modificiarAviones();
                break;
            case "rWeb":
                // Ver los registro de la aplicacion web
                this.editarDatosAdmin();
                break;
            case "CerrarSesion":
                //  Salir de modo administrador
                this.opcionAtras();
                break;
                
            case "Minimizar":
                //  Minimiza la ventana
                this.opcionMinimizar();
                break;
                
            case "Salir":
                //  Salir de modo administrador
                this.opcionSalir();
                break;
        }
        
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    
    
    
    
    
     
    Administrador admin;
    
    
    //  Declaracion de Clases
    ControladoraModTipoAvion cMTA;
    ControladoraModRutas cMR;
    ControladoraRegistroAdmin cRegAdm;
    ControladoraModAviones cMA;
    ControladoraDatosPersonalesAdmin cDP;
    Modelo modelo;
    VentanaLogin vLogin;
    VentanaAdministrador vAdmin;
    ModTipoAviones vMTA;
    ModRutas vMR;
    VentanaRegistroAdmin vRegAdm;
    ModAviones vMA;
    VentanaDatosPersonalesAdmin vDP;
    
    String identificacion;
}
