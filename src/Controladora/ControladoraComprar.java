/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import AccesoADatos.DALHistoricoCompras;
import Excepciones.NoDataException;
import Modelo.Avion;
import Modelo.LineaDetalleHistoricoCompras;
import Modelo.LineaDetalleVuelo;
import Modelo.Modelo;
import Modelo.Ruta;
import Modelo.Vuelo;
import Vista.VentanaCliente;
import Vista.VentanaComprar;
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
public class ControladoraComprar implements ActionListener, MouseListener, KeyListener {

    VentanaCliente vCliente;
    VentanaComprar vCompra;
    Modelo modelo;
    private int pos;

    public ControladoraComprar(VentanaCliente vCliente, VentanaComprar vCompra, Modelo modelo) {
        this.vCliente = vCliente;
        this.vCompra = vCompra;
        this.modelo = modelo;
        vCompra.setControl(this);
        vCompra.setModelo(modelo);
        pos = 0;

        try {
            this.vCompra.mostrarTablaInicio();
        } catch (NoDataException ex) {
            this.vCompra.mostrarExecpcion(ex.getMessage());
        }
    }

    public void accionModificar() {
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y MODIFICAR!!");
        }
    }

    //  Metodo que minimiza ka ventana
    public void opcionMinimizar() {
        this.vCompra.setExtendedState(1);
    }

    // Método que cierra la ventana administrador y vuelve a Login
    public void opcionAtras() {
        this.vCliente.setVisible(true);
        this.vCompra.dispose();

    }

    // Terminar la edicion de la talba y guarda nuevos datos
    public void opcionTerminarEdit() {

    }

    // Cierra el programa
    public void opcionSalir() {
        System.exit(0);
    }

    /*  Metodo que verifica que una columna o fila de la tabla se haya seleccionado
     *  y actualiza el valor de la posicion
     */
    public boolean elemSeleccionado() {
        boolean seleccionActiva;
        seleccionActiva = false;
        if (vCompra.getTablaDatos().getSelectedRow() == -1) {
            // Si no se ha seleccionado una fila
            this.vCompra.getPanelErrorSeleccion().setVisible(true);
        } else {
            // Fila o columna seleccionada
            pos = vCompra.getTablaDatos().getSelectedRow();
            seleccionActiva = true;
        }
        return seleccionActiva;
    }

    public void ocultarMenus() {

        this.vCompra.getPopMenu().setVisible(false);
        this.vCompra.getTablaDatos().setSelectionMode(0);
    }

    public void ocultarPanelError() {
        this.vCompra.getPanelErrorSeleccion().setVisible(false);
        this.vCompra.getTablaDatos().setSelectionMode(0);
    }

    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            //  -------------   OPCION MENUS  ------------
            case "Modificar":
                //  Boton Modificar
                this.accionModificar();
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
            case "Terminar":
                //  Salir de modo administrador
                this.opcionAtras();
                try {
                    this.vCliente.mostrarTablaHistorico();
                    this.vCliente.getTablaHC().setEnabled(false);
                } catch (NoDataException ex) {
                    this.vCliente.mostrarExecpcion(ex.getMessage());
                }

                break;

            case "Minimizar":
                //  Salir de modo administrador
                this.opcionMinimizar();
                break;

//            case "Terminar":
//                //  Salir de modo administrador
//                this.opcionTerminarEdit();
//                break;
            case "Salir":
                //  Cerrar programa
                this.opcionSalir();
                break;

            case "Aceptar":
                //  Boton Aceptar error seleccion
                this.ocultarMenus();
                this.ocultarPanelError();
                break;

            case "aceptarCamvioVuelo":
                this.modificarVuelo();
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

            case "Comprar":
                  this.opcionComprar();
                break;
        }

    }
    
    
    
    String accion = "";
    LineaDetalleVuelo vueloAux = null;

    public void opcionComprar(){
        if (this.vCompra.getTablaDatos().getSelectedRow() != -1){
            System.out.println("TABLA SELECCIONADA");
                this.comprarVuelo();
            
        }else{
            this.vCompra.mostrarExecpcion("Debe seleccionar un vuelo en la tabla que desea comprar!");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {

        if (!this.modelo.getIdConsulta().isEmpty())//si no esta vacio es porque esta consultadondo por id
        {

            vueloAux = modelo.obtenerVuelo(modelo.getIdConsulta());
            modelo.setIdConsulta("");
            this.vCompra.getConsultaTxt().setText("");

            System.out.print("Fila Seleccionada id Vuelo :" + vueloAux.toString() + "\n");

        } else {

            if (this.vCompra.getTablaDatos().getSelectedRow() != -1 && this.modelo.getIdConsulta().isEmpty()
                    && accion != "buscarAvion") {
                System.out.print("-> Estamos en el primer if de vuelo\n");
                int pos = this.vCompra.getTablaDatos().getSelectedRow();
                try {
                    vueloAux = modelo.consultarVuelo(pos);
                    idVuelo = vueloAux.getIdentificacion();
                    System.out.print("--> idVuelo : " + idVuelo + "\n");
                    System.out.print("Fila Seleccionada id :" + vueloAux.toString() + "\n");
                } catch (NoDataException ex) {
                    this.vCompra.mostrarExecpcion(ex.getMessage());
                }
            }

            //--------------------------------------va a agregar un avion
//            else
//            if (this.vCompra.getTablaDatos().getSelectedRow() != -1 && this.modelo.getIdConsulta().isEmpty()) {
//
//                int pos = this.vCompra.getTablaDatos().getSelectedRow();
//
//                Avion a;
//                try {
//                    a = modelo.consultarAvionLibre(pos);
//                    idAvion = a.getIdentificacion();
//                    
//                   System.out.print("Fila Seleccionada Agregar Avion :" + a.toString() + "\n");
//                } catch (NoDataException ex) {
//                    this.vCompra.mostrarExecpcion(ex.getMessage());
//                }
//
//
//                
//            }
//                if (this.vCompra.getTablaDatos().getSelectedRow() != -1 && this.modelo.getIdConsulta().isEmpty()) {
//
//                int pos = this.vCompra.getTablaDatos().getSelectedRow();
//
//                Ruta a = modelo.consultarRutaPos(pos);
//                idRuta = a.getIdentificador();
//                System.out.print("Fila Seleccionada Agregar Ruta :" + a.toString()+ "\n");
//                
//            }
        }

    }
    String idVuelo = "";
    String idAvion = "";
    String idRuta = "";

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

    private void mostrarAvionesDisponibles() {
        this.vCompra.mostrarTablaAvionesDisponibles();
    }

    private void agregarDatosVuelos() {

    }

    private void agregarVuelo() {
        Avion a = modelo.obtenerAvion(idAvion);
        Ruta r = modelo.obtenerRuta(idRuta);

        Vuelo v = new Vuelo();
        v.setAvion(a);
        v.setRuta(r);
//        v.setIdentificacion(this.vCompra.getTxtNumVueloRuta().getText());
//        v.setPrecio(Integer.parseInt(this.vCompra.getTxtPrecioVuelo().getText()));
//        v.setTipoVuelo(this.vCompra.getTxtTipoVuelo().getText());
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

            idAvion = "";
            idRuta = "";
            a = null;
            r = null;
            v = null;

        } else {

            this.modelo.insertarVuelo(v);
            a = null;
            r = null;
            v = null;
            idAvion = "";
            idRuta = "";

        }
    }

    private void modificarVuelo() {
        this.vCompra.mostrarTablaRutas();
//        System.out.print("datos consegudos : " + this.vCompra.getTxtNuevoTipoVuelo().getText() + " , "
//                + this.vCompra.getTxtPrecioNuevoVuelo().getText() + ".\n");

    }

    private void opcionListar() {
        this.modelo.listarTablaVuelos();
    }

    private void consultarVuelo() {
        if (this.vCompra.getConsultaTxt().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es necesario un numero de identificacion de Avion para la Consulta\n");
        } else {
            System.out.print("Estamos En Consulta2\n");
            modelo.consultarVueloID(this.vCompra.getConsultaTxt().getText());
        }
    }

    private void comprarVuelo() {
        LineaDetalleVuelo lin = vueloAux;
        this.comprarVueloConVueloObtenido(lin);
        this.vCompra.mostrarExecpcion("Compra Realizada Correctamente");
        try {
            this.vCompra.mostrarTablaInicio();
        } catch (NoDataException ex) {
            this.vCompra.mostrarExecpcion(ex.getMessage());
        }

    }

    private void comprarVueloConVueloObtenido(LineaDetalleVuelo lin) {
        LineaDetalleHistoricoCompras lineaHisto = new LineaDetalleHistoricoCompras();
        lineaHisto.setNumVuelo(lin.getIdentificacion());
        lineaHisto.setIdentificacion(this.vCliente.getIdentificacion());
        lineaHisto.setAnio(lin.getAnioSalida());
        lineaHisto.setDia(lin.getDiaSalida());
        lineaHisto.setHora(lin.getHoraSalida());
        lineaHisto.setMes(lin.getMesSalida());
        lineaHisto.setPaisDestino(lin.getPaisDestino());
        lineaHisto.setPaisOrigen(lin.getPaisOrigen());
        lineaHisto.setPrecio("" + lin.getPrecio());
        // se llena los datos de la linea de detalle de historial...
        DALHistoricoCompras.getInstance().insertarLineaDetalleHistoricoCompras(lineaHisto);
    }

}
