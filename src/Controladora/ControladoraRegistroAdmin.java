/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.GlobalException;
import Modelo.Administrador;
import Modelo.Fecha;
import Modelo.Modelo;
import Vista.VentanaAdministrador;
import Vista.VentanaLogin;
import Vista.VentanaPrincipal;
import Vista.VentanaRegistroAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Netto
 */
public class ControladoraRegistroAdmin implements ActionListener, MouseListener, KeyListener {

    ControladoraAdministrador cAdmin;
    Modelo modelo;
    VentanaPrincipal vPrincipal;
    VentanaAdministrador vAdmin;
    VentanaLogin vLog;
    VentanaRegistroAdmin vRegAdm;

    public ControladoraRegistroAdmin(VentanaRegistroAdmin vRegAdm, VentanaAdministrador vAdmin, Modelo modelo) {
        this.vRegAdm = vRegAdm;
        this.vAdmin = vAdmin;
        this.modelo = modelo;
        vRegAdm.setControl(this);
        vRegAdm.setModelo(modelo);
    }

    public void ingresar(String id) {
        
        vAdmin = new VentanaAdministrador();
        cAdmin = new ControladoraAdministrador(vAdmin, vLog, modelo);
        vRegAdm.dispose();
    }

    //  Metodo que minimiza ka ventana
    public void opcionMinimizar() {
        this.vRegAdm.setExtendedState(1);
    }

    // Método que cierra la ventana administrador y vuelve a Login
    public void opcionAtras() {
        this.vAdmin.setVisible(true);
        this.vRegAdm.dispose();
    }

    // Método que cierra el programa
    public void opcionSalir() {
        System.exit(0);
    }

    public void verificarRegistro() throws GlobalException {
        String nombreAux = "", apellido1Aux = "", apellido2Aux = "", correoAux = "", 
                passAux="", dirAux = "", tTra = "", tCel = "";
        String diaAux,mesAux,anioAux,horaAux,identAux;
        Administrador cl=new Administrador();
        Fecha fs = new Fecha();
        //SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
        
        nombreAux = this.vRegAdm.getTxtNombre().getText();
        apellido1Aux = this.vRegAdm.getTxtApellido1().getText();
        apellido2Aux = this.vRegAdm.getTxtApellido1().getText();
        identAux=this.vRegAdm.getTxtIdentificacion().getText();
        correoAux=this.vRegAdm.getTxtCorreo().getText();
        passAux=this.vRegAdm.getTxtPassword().getText();
        dirAux=this.vRegAdm.getTaDireecion().getText();
        tTra=this.vRegAdm.getTxtTtrabajo().getText();
        tCel=this.vRegAdm.getTxtTCelular().getText();
        cl.setNombre(nombreAux);
        cl.setApellido1(apellido1Aux);
        cl.setApellido2(apellido2Aux);
        cl.setIdentificacion(identAux);
        cl.setContrasenia(passAux);
        cl.setCorreoElectronico(correoAux);
        cl.setDireccion(dirAux);
        cl.setTelefonoTrabajo(tTra);
        cl.setCelular(tCel);
       
        if (this.vRegAdm.getbFecha().getDate()==null || nombreAux.isEmpty()
        || apellido1Aux.isEmpty() || apellido2Aux.isEmpty()|| correoAux.isEmpty() 
        || dirAux.isEmpty() || tTra.isEmpty() || tCel.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios, por favor complete sus datos correctamente !");
            
        }else{   
            
        fs.setDia(""+this.vRegAdm.getbFecha().getDate().getDate());
        fs.setMes(""+this.vRegAdm.getbFecha().getDate().getMonth());
        fs.setAnio(""+(1900+this.vRegAdm.getbFecha().getDate().getYear()));
        fs.setHora((Calendar.HOUR-5)+"");
        cl.setFechaNacimiento(fs);
        this.modelo.insertarAdministrador(cl);
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
                Logger.getLogger(ControladoraRegistroAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
