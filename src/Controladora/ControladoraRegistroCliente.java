/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.GlobalException;
import Modelo.Cliente;
import Modelo.Fecha;
import Modelo.Horario;
import Modelo.Modelo;
import Modelo.Ruta;
import Vista.VentanaCliente;
import Vista.VentanaLogin;
import Vista.VentanaPrincipal;
import Vista.VentanaRegistroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static oracle.jdbc.OracleTypes.NULL;

/**
 *
 * @author Netto
 */
public class ControladoraRegistroCliente implements ActionListener, MouseListener, KeyListener {

    ControladoraCliente cClient;
    ControladorLogin cLogin;
    Modelo modelo;
    VentanaPrincipal vPrincipal;
    VentanaCliente vClient;
    VentanaLogin vLog;
    VentanaRegistroCliente vReg;

    public ControladoraRegistroCliente(VentanaRegistroCliente vReg, VentanaPrincipal vPrincipal, Modelo modelo) {
        this.vReg = vReg;
        this.vPrincipal = vPrincipal;
        this.modelo = modelo;
        vReg.setControl(this);
        vReg.setModelo(modelo);
    }

    public void ingresar(String id) {
        vLog = new VentanaLogin();
        cLogin = new ControladorLogin(vLog, vPrincipal, modelo);
        vLog.setVisible(false);
        vClient = new VentanaCliente();
        cClient = new ControladoraCliente(vClient, vLog, modelo, vPrincipal);
        cClient.setIdentificacion(id);
        vReg.dispose();
    }

    //  Metodo que minimiza ka ventana
    public void opcionMinimizar() {
        this.vReg.setExtendedState(1);
    }

    // Método que cierra la ventana administrador y vuelve a Login
    public void opcionAtras() {
        this.vPrincipal.setVisible(true);
        this.vReg.dispose();
    }

    // Método que cierra el programa
    public void opcionSalir() {
        System.exit(0);
    }

    public void verificarRegistro() throws GlobalException {
        String nombreAux = "", apellido1Aux = "", apellido2Aux = "", correoAux = "", 
                passAux="", dirAux = "", tTra = "", tCel = "";
        String diaAux,mesAux,anioAux,horaAux,identAux;
        Cliente cl=new Cliente();
        Fecha fs = new Fecha();
        //SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
        
        nombreAux = this.vReg.getTxtNombre().getText();
        apellido1Aux = this.vReg.getTxtApellido1().getText();
        apellido2Aux = this.vReg.getTxtApellido1().getText();
        identAux=this.vReg.getTxtIdentificacion().getText();
        correoAux=this.vReg.getTxtCorreo().getText();
        passAux=this.vReg.getTxtPassword().getText();
        dirAux=this.vReg.getTaDireecion().getText();
        tTra=this.vReg.getTxtTtrabajo().getText();
        tCel=this.vReg.getTxtTCelular().getText();
        cl.setNombre(nombreAux);
        cl.setApellido1(apellido1Aux);
        cl.setApellido2(apellido2Aux);
        cl.setIdentificacion(identAux);
        cl.setContrasenia(passAux);
        cl.setCorreoElectronico(correoAux);
        cl.setDireccion(dirAux);
        cl.setTelefonoTrabajo(tTra);
        cl.setCelular(tCel);
       
        if (this.vReg.getbFecha().getDate()==null || nombreAux.isEmpty()
        || apellido1Aux.isEmpty() || apellido2Aux.isEmpty()|| correoAux.isEmpty() 
        || dirAux.isEmpty() || tTra.isEmpty() || tCel.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios, por favor complete sus datos correctamente !");
            
        }else{   
            
        fs.setDia(""+this.vReg.getbFecha().getDate().getDate());
        fs.setMes(""+this.vReg.getbFecha().getDate().getMonth());
        fs.setAnio(""+(1900+this.vReg.getbFecha().getDate().getYear()));
        fs.setHora((Calendar.HOUR-5)+"");
        cl.setFechaNacimiento(fs);
        this.modelo.insertarCliente(cl);
        this.ingresar(identAux);
                
           // String dia, String hora, String mes, String anio, 
        }
    }

    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case "Completar":
        {
            try {
                // Completa los datos del registro e inicia en pantalla cliente
                this.verificarRegistro();
            } catch (GlobalException ex) {
                Logger.getLogger(ControladoraRegistroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Atras":
                // Modificar mis datos personales
                this.opcionAtras();
                break;

            case "Cancelar":
                // Modificar mis datos personales
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

}
