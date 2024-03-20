/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Administrador;
import Modelo.Fecha;
import Modelo.Modelo;
import Vista.VentanaAdministrador;
import Vista.VentanaDatosPersonalesAdmin;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author netto
 */
public class ControladoraDatosPersonalesAdmin implements ActionListener, MouseListener, KeyListener {

    VentanaDatosPersonalesAdmin vDP;
    VentanaAdministrador vAdmin;
    Modelo modelo;
    private int pos;

    public ControladoraDatosPersonalesAdmin(VentanaAdministrador vAdmin, VentanaDatosPersonalesAdmin vDP, Modelo modelo) {
        this.vAdmin = vAdmin;
        this.vDP = vDP;
        this.modelo = modelo;
        vDP.setControl(this);
        vDP.setModelo(modelo);
        pos = 0;
        nombreAnt = "";
        ape1Ant = "";
        ape2Ant = "";
        idAux = "";
        correoAnt = "";
        dirAnt = "";
        passAnt = "";
        fechaNaAnt = "";
        telTrabAnt = "";
        telCelAnt = "";
        diaAnt = "";
        mesAnt = "";
        anoAnt = "";
        fechaAnt="";

        try {
            this.listarTabla();
        } catch (GlobalException ex) {
            Logger.getLogger(ControladoraDatosPersonalesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(ControladoraDatosPersonalesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.respladoDeDatos();

    }

    public void respladoDeDatos() {

        Fecha fs = new Fecha();
        nombreAnt = this.vDP.getTxtNombre().getText();
        ape1Ant = this.vDP.getTxtApellido1().getText();
        ape2Ant = this.vDP.getTxtApellido2().getText();
        idAux = this.vDP.getTxtIdentificacion().getText();
        dirAnt = this.vDP.getTaDireecion().getText();
        correoAnt = this.vDP.getTxtCorreo().getText();
        passAnt=this.vDP.getTxtPassword().getText();
        telTrabAnt=this.vDP.getTxtTtrabajo().getText();
        telCelAnt=this.vDP.getTxtTCelular().getText();
        fechaAnt=this.vDP.getTxtFecha().getDate().toString();
    }

    public void listarTabla() throws GlobalException, NoDataException {

        // this.modelo.listarDatosBase(); // Metodo que llama a listar datos a modelo
    }

    //  Metodo que minimiza ka ventana
    public void opcionMinimizar() {
        this.vDP.setExtendedState(1);
    }

    // Método que cierra la ventana administrador y vuelve a Login
    public void opcionAtras() {
        this.vAdmin.setVisible(true);
        this.vDP.dispose();
    }

    // Terminar la edicion de la talba y guarda nuevos datos
    public void opcionTerminarEdit() {

    }

    // Cierra el programa
    public void opcionSalir() {
        System.exit(0);
    }

    public void guardarDatosActualizados() {
        String nombreAux = "", apellido1Aux = "", apellido2Aux = "", correoAux = "", passAux = "", dirAux = "", tTra = "", tCel = "";
        String diaAux = "", mesAux = "", anioAux = "", horaAux = "", identAux = "";
        Administrador cl = new Administrador();
        Fecha fs = new Fecha();
        String fechaAux="";
        //SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");

        nombreAux = this.vDP.getTxtNombre().getText();
        apellido1Aux = this.vDP.getTxtApellido1().getText();
        apellido2Aux = this.vDP.getTxtApellido2().getText();
        identAux = this.vDP.getTxtIdentificacion().getText();
        correoAux = this.vDP.getTxtCorreo().getText();
        passAux = this.vDP.getTxtPassword().getText();
        dirAux = this.vDP.getTaDireecion().getText();
        tTra = this.vDP.getTxtTtrabajo().getText();
        tCel = this.vDP.getTxtTCelular().getText();
        fechaAux=this.vDP.getTxtFecha().getDate().toString();
        cl.setNombre(nombreAux);
        cl.setApellido1(apellido1Aux);
        cl.setApellido2(apellido2Aux);
        cl.setIdentificacion(identAux);
        cl.setContrasenia(passAux);
        cl.setCorreoElectronico(correoAux);
        cl.setDireccion(dirAux);
        cl.setTelefonoTrabajo(tTra);
        cl.setCelular(tCel);
        fs.setDia(""+this.vDP.getTxtFecha().getDate().getDate());
        fs.setMes(""+this.vDP.getTxtFecha().getDate().getMonth());
        fs.setAnio(""+(1900+this.vDP.getTxtFecha().getDate().getYear()));
        fs.setHora((Calendar.HOUR-5)+"");
            System.out.println("Cambio fecha --->"+fs.toString());

        if (this.vDP.getTxtFecha().getDate() == null || nombreAux.isEmpty()
                || apellido1Aux.isEmpty() || apellido2Aux.isEmpty() || correoAux.isEmpty()
                || dirAux.isEmpty() || tTra.isEmpty() || tCel.isEmpty() || passAux.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios, por favor complete sus datos correctamente !");
            

        }else if (nombreAnt.equals(nombreAux) && ape1Ant.equals(apellido1Aux) &&
                ape2Ant.equals(apellido2Aux) && dirAnt.equals(dirAux) && telTrabAnt.equals(tTra)
                && telCelAnt.equals(tCel) && correoAnt.equals(correoAux) && passAnt.equals(passAux)
                && fechaAnt.equals(fechaAux)){
            JOptionPane.showMessageDialog(null, "Datos no han sido modificados, no se puedan actualizar!"); 
            this.respladoDeDatos();
        }
            else {

            
//            JOptionPane.showMessageDialog(null, "Los datos fueron actualizados correctamente!");
            System.out.println("Los datos fueron actualizados correctamente!");
            cl.setFechaNacimiento(fs);
            this.modelo.modificarAdministrador(cl);
            this.opcionAtras();

            // String dia, String hora, String mes, String anio, 
        }
    }

    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            //  -------------   OPCION MENUS  ------------
            case "Agregar":
                //  Boton agregar
                System.out.print("Estamos en la implementacion del boton agregar...\n");
                break;
            case "Modificar":
                //  Boton Modificar

                break;

            case "Eliminar":
                //  Boton Eliminar

                break;

            case "Cancelar":
                //  Boton Eliminar
                this.opcionAtras();
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
                this.guardarDatosActualizados();
                System.out.println("Hola");
                break;

            case "Salir":
                //  Cerrar programa
                this.opcionSalir();
                break;

          
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

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

    
    // Declaracion de Variables
    String nombreAnt, ape1Ant, ape2Ant, idAux, correoAnt, dirAnt, passAnt, fechaNaAnt,
            telTrabAnt, telCelAnt, diaAnt, mesAnt, anoAnt, fechaAnt;
}
