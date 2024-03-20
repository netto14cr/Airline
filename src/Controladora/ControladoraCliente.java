/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.NoDataException;
import Modelo.Cliente;
import Modelo.LineaDetalleHistoricoCompras;
import Modelo.Modelo;
import Vista.VentanaCliente;
import Vista.VentanaComprar;
import Vista.VentanaDatosPersonalesCliente;
import Vista.VentanaLogin;
import Vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

/**
 *
 * @author Netto
 */
public class ControladoraCliente implements ActionListener, MouseListener, KeyListener {

    public ControladoraCliente(VentanaCliente vCliente, VentanaLogin vLogin, Modelo modelo,
            VentanaPrincipal vPrincipal) {
        this.vCliente = vCliente;
        this.vLogin = vLogin;
        this.vPrincipal = vPrincipal;
        this.modelo = modelo;
        vCliente.setControl(this);
        vCliente.setModelo(modelo);
        this.identificacion="";
        
        
         try {
                this.vCliente.mostrarTablaHistorico();
                this.vCliente.getTablaHC().setEnabled(false);
                } catch (NoDataException ex) {
                 this.vCliente.mostrarExecpcion(ex.getMessage());
                }
        
    }
        
        
    

    

   

    public void opcionBuscarVuelos() {
        
        
        this.vCompra=new VentanaComprar();
        this.cCompra=new ControladoraComprar(vCliente, vCompra, modelo);
        this.vCliente.setVisible(false);
        
    }



    public void opcionHistorialCompras() {
        
        
        try {
                this.vCliente.mostrarTablaHistorico();
                this.vCliente.getTablaHC().setEnabled(false);
                } catch (NoDataException ex) {
                 this.vCliente.mostrarExecpcion(ex.getMessage());
                }
        this.vCliente.getPanelHistorialCompras().setVisible(true);

    }
    Cliente clienteAux = null;

    
    
    public void cargaDatosPersonales(Cliente cl) {
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
        this.vCliente.setVisible(false);
    }

    public void opcionModDatosPersonales() {

        vDP = new VentanaDatosPersonalesCliente();
        this.cargaDatosPersonales(clienteAux);
        cDP = new ControladoraDatosPersonales(vCliente, vDP, modelo);
        this.vCliente.setVisible(false);
    }

    //  Metodo que minimiza ka ventana
    public void opcionMinimizar() {
        this.vCliente.setExtendedState(1);
    }

    // Método que cierra la ventana administrador y vuelve a Login
    public void opcionCerrarSesion() {
        VentanaLogin vLogin = new VentanaLogin();
        
        ControladorLogin cLogin = new ControladorLogin(vLogin, vPrincipal, modelo);
        this.vCliente.dispose();
    }

    // Método que cierra el programa
    public void opcionSalir() {
        System.exit(0);
    }

    public void ocultarPaneles() {
        this.vCliente.getPanelHistorialCompras().setVisible(false);
        this.muestraBotones();
    }

    public void ocultarBotones() {
        this.vCliente.getbDatosPersonales().setVisible(false);
        this.vCliente.getbBusquedaVuelo().setVisible(false);
        this.vCliente.getbHistorial().setVisible(false);
        this.vCliente.getbCerrar().setVisible(false);
    }

    public void muestraBotones() {
        this.vCliente.getbDatosPersonales().setVisible(true);
        this.vCliente.getbBusquedaVuelo().setVisible(true);
        this.vCliente.getbHistorial().setVisible(true);
        this.vCliente.getbCerrar().setVisible(true);
    }

    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
     
            case "bCV":
                // Busqueda y consulta de vuelos
                this.opcionBuscarVuelos();
                break;
        
            case "mHC":
                // Mostrar Historial de compras
                
                this.opcionHistorialCompras();
                
                break;
            case "mDP":
                // Modificar mis datos personales
                
                clienteAux = modelo.obtenerCliente(this.vCliente.getIdentificacion());
                this.opcionModDatosPersonales();
                break;
            case "CerrarSesion":
                //  Salir de modo administrador
                this.opcionCerrarSesion();
                break;

            case "Minimizar":
                //  Minimiza la ventana
                this.opcionMinimizar();
                break;

            case "Salir":
                //  Salir de modo administrador
                this.opcionSalir();
                break;

            case "oK":
                //  Salir de modo administrador
                this.ocultarPaneles();
                break;
        }
    }
    
    
    
    
    
    
    private void opcionListar() {
        this.modelo.listarTabla();
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

    //  Declaracion de Clases
    Cliente cliente;
    ControladoraDatosPersonales cDP;
    Modelo modelo;
    VentanaLogin vLogin;
    VentanaCliente vCliente;
    VentanaDatosPersonalesCliente vDP;
    VentanaPrincipal vPrincipal;
    VentanaComprar vCompra;
    ControladoraComprar cCompra;

    // Declaracion variable
    String identificacion;
}
