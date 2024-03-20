/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import AccesoADatos.DALAdministrador;
import AccesoADatos.DALCliente;
import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.LineaDetalleAdministrador;
import Modelo.LineaDetalleCliente;
import Modelo.Modelo;
import Vista.VentanaAdministrador;
import Vista.VentanaCliente;
import Vista.VentanaLogin;
import Vista.VentanaPrincipal;
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
public class ControladorLogin implements ActionListener, MouseListener, KeyListener {

    //  Declaracion de Clases
    ControladoraAdministrador cAdmin;
    ControladoraCliente cCliente;
    Modelo modelo;
    VentanaPrincipal vPrincipal;
    VentanaLogin vLogin;
    VentanaAdministrador vAdmin;
    VentanaCliente vCliente;

    public ControladorLogin(VentanaLogin vLogin, VentanaPrincipal vPrincipal, Modelo modelo) {
        this.vLogin = vLogin;
        this.vPrincipal = vPrincipal;
        this.modelo = modelo;
        vLogin.setControl(this);
        vLogin.setModelo(modelo);

        // -------- PROBAR CON CLIENTE DEFAULT----------------------------------
        this.vLogin.getTxtUsuario().setText("ADMIN");
        this.vLogin.getTxtPassword().setText("ADMIN");


    }

    Cliente auxCl = null;
    Administrador admAux = null;
    String userDigitado = "", passwDigitado = "";
    String userClienteBD = "";
    String passwClienteBD = "";
    String userAdminBD = "";
    String passwAdminBD = "";

    //              VERIFICA QUE NO HAYAN CAMPOS VACIOS EN LOGIN
    public void vericarCamposCompletos() {
        userDigitado = this.vLogin.getTxtUsuario().getText();
        passwDigitado = this.vLogin.getTxtPassword().getText();

        if (userDigitado.isEmpty() || passwDigitado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puede dejar los campos vacios, por favor intente de nuevo!");
        } else {
            LineaDetalleAdministrador lAdmin = DALAdministrador.getInstance().consultarAdmininistradorID(userDigitado);
            LineaDetalleCliente lClient = DALCliente.getInstance().consultarClienteID(userDigitado);

            if (lAdmin != null) {
                System.out.print("Usuario : " + lAdmin.getId() + " , " + lAdmin.getContrasenia() + "\n");
                if (lAdmin.getContrasenia().equals(passwDigitado)) {
                    this.inicioModoAdmin();
                } else {
                    JOptionPane.showMessageDialog(null, " La contraseña digitada es incorrecta, por favor digitela nuevamente! ");
                }
            } else if (lClient != null) {
                if (lClient.getContrasenia().equals(passwDigitado)) {
                    this.inicioModoCliente();
                } else {
                    JOptionPane.showMessageDialog(null, " La contraseña digitada es incorrecta, por favor digitela nuevamente! ");
                }
            } else if (lAdmin == null && lClient == null) {
                JOptionPane.showMessageDialog(null, " El nombre de usuario no existe, por favor intente nuevamente!! ");
            }
            else if (lClient == null) {
                JOptionPane.showMessageDialog(null, " Este usuario en Tabla Clientes \n");
            } else if (lAdmin == null) {
                JOptionPane.showMessageDialog(null, " Este usuario en Tabla Administrador \n");
            }
        }
    }

    public void iniciarSesion() {
        this.vLogin.getPanelPruebas().setVisible(true);
    }

    // ----P R U E B A S------------
    public void prueba1() {//Admin
        this.inicioModoAdmin();
    }

    public void prueba2() {//Cliente
        this.inicioModoCliente();
    }

    public void inicioModoAdmin() {
        vAdmin = new VentanaAdministrador();
        cAdmin = new ControladoraAdministrador(vAdmin, vLogin, modelo);
        vLogin.setVisible(false);
        cAdmin.setIdentificacion(this.vLogin.getTxtUsuario().getText());
        System.out.println("Controladora.ControladorLogin.inicioModoAdmin()"+this.vLogin.getTxtUsuario().getText());

    }

    public void inicioModoCliente() {
        vCliente = new VentanaCliente();
        vCliente.setIdentificacion(this.vLogin.getTxtUsuario().getText());
        cCliente = new ControladoraCliente(vCliente, vLogin, modelo, vPrincipal);
        vLogin.setVisible(false);
        
       
    }

    public void opcionSalir() {
//        this.vPrincipal.setVisible(true);
        System.exit(0);
    }

    public void opcionAtras() {
//        this.vPrincipal.setVisible(true);
        this.vLogin.dispose();
        this.vPrincipal.dispose();
        this.vPrincipal=new VentanaPrincipal();
        new ControladorPrincipal(modelo, vPrincipal);
    }
    //  Metodo que minimiza ka ventana

    public void opcionMinimizar() {
        this.vLogin.setExtendedState(1);
    }

    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "IniciarSesion": {
                //  Boton Iniciar Sesion
                this.vericarCamposCompletos();
            }
            //this.iniciarSesion();
            break;

            case "Atras":
                //  Boton regresar atras
                this.opcionAtras();
                break;

            case "Minimizar":
                //  Boton minimizar
                this.opcionMinimizar();
                break;

            case "Salir":
                //  Boton para cerrar programa
                this.opcionSalir();
                break;

            //--------------------P R U E B A S
            case "ADMIN":
                this.prueba1();

                break;
            case "CLIENTE":
                this.prueba2();
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

}
