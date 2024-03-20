/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Avion;
import Modelo.Modelo;
import Vista.ModAviones;
import Vista.VentanaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author netto
 */
public class ControladoraModAviones implements ActionListener, MouseListener, KeyListener {

    ModAviones vMTA;
    VentanaAdministrador vAdmin;
    Modelo modelo;
    private int pos;

    public ControladoraModAviones(VentanaAdministrador vAdmin, ModAviones vMTA, Modelo modelo) {
        this.vAdmin = vAdmin;
        this.vMTA = vMTA;
        this.modelo = modelo;
        vMTA.setControl(this);
        vMTA.setModelo(modelo);
        this.vMTA.mostrarTablaInicio();
        System.out.print("---------------C O N S T R U C T O R ---------------\n");
        System.out.print("-> nulo " + modelo.getIdConsulta() + "\n");
        if (modelo == null) {
            System.out.print("-> nulo" + modelo.getIdConsulta() + "\n");
        }
        pos = 0;
        try {
            this.listarTabla();
        } catch (GlobalException ex) {
            Logger.getLogger(ControladoraModAviones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoDataException ex) {
            Logger.getLogger(ControladoraModAviones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listarTabla() throws GlobalException, NoDataException {

        // this.modelo.listarDatosBase(); // Metodo que llama a listar datos a modelo
        this.modelo.listarAviones();

    }

    public void accionAgregar() {

        System.out.println("SELECCION Y AGREGAR!!");
        this.vMTA.getPanel_agregar().setVisible(true);

    }

    public void accionModificar() {
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y MODIFICAR!!");
            this.modificarDatosAvion(avionAux);
            this.vMTA.getPanelModificar().setVisible(true);
        }
    }

    public void accionEliminar() throws GlobalException {
        if (elemSeleccionado()) {
            System.out.println("SELECCION Y ELMINAR!!");
            System.out.print("id : " + avionAux.getIdentificacion());
            this.modelo.eliminarAvion(avionAux.getIdentificacion());
        }
    }

    //  Metodo que minimiza ka ventana
    public void opcionMinimizar() {
        this.vMTA.setExtendedState(1);
    }

    // Método que cierra la ventana administrador y vuelve a Login
    public void opcionAtras() {
        this.vAdmin.setVisible(true);
        this.vMTA.dispose();
    }

    // Terminar la edicion de la talba y guarda nuevos datos
    public void opcionTerminarEdit() {
        this.vAdmin.setVisible(true);
        this.vMTA.dispose();
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
        if (vMTA.getTablaDatos().getSelectedRow() == -1) {
            // Si no se ha seleccionado una fila
            this.vMTA.getPanelErrorSeleccion().setVisible(true);
        } else {
            // Fila o columna seleccionada
            pos = vMTA.getTablaDatos().getSelectedRow();
            seleccionActiva = true;
        }
        return seleccionActiva;
    }

    public void ocultarMenus() {
//        this.vMTA.getPanelMenuFlotante().setVisible(false);
        this.vMTA.getPopMenu().setVisible(false);
        this.vMTA.getTablaDatos().setSelectionMode(0);

    }

    public void ocultarPanelError() {
        this.vMTA.getPanelErrorSeleccion().setVisible(false);
        this.vMTA.getTablaDatos().setSelectionMode(0);
    }

    // Metodo con el que se detecta el click de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.print("-> " + e.getActionCommand() + "\n");
        switch (e.getActionCommand()) {

            //  -------------   OPCION MENUS  ------------
            case "Agregar":
                //  Boton agregar
                System.out.println("SELECCION Y AGREGAR!!");
                this.accionAgregar();
                break;
            case "Modificar":
                //  Boton Modificar
                this.accionModificar();
                break;

            case "Eliminar": {
                try {
                    //  Boton Eliminar
                    this.accionEliminar();
                } catch (GlobalException ex) {
                    this.vMTA.mostrarExecepcion(ex.getMessage());
                }
            }
            break;

            case "Cancelar":
                //  Boton Eliminar
                this.vMTA.getPanel_agregar().setVisible(false);
                break;
            case "consulta":
                this.realizarConsultaAvion();
                break;

            case "salvar":
                this.actualizarDatosAvion();
                break;
            case "salvarModificacion":
                System.out.print("entro modificacion\n");
                this.realizarModificacionDatosAvion();
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
            case "listarAviones":
                //  Cerrar programa
                this.opcionListar();
                break;

            case "Aceptar":
                //  Boton Aceptar error seleccion
                this.ocultarMenus();
                this.ocultarPanelError();
                break;
            case "cancelarModificacion":
                this.vMTA.getPanelModificar().setVisible(false);

        }

    }

   
    
    Avion avionAux = null;

    @Override
    public void mouseClicked(MouseEvent me) {

        if (!this.modelo.getIdConsulta().isEmpty())//si no esta vacio es porque esta consultadondo por id
        {

            avionAux = modelo.obtenerAvion(modelo.getIdConsulta());
            modelo.setIdConsulta("");
            this.vMTA.getConsulta_txt().setText("");

            System.out.print("Fila Seleccionada id :" + avionAux.getIdentificacion() + "\n");

        } else {
            if (this.vMTA.getTablaDatos().getSelectedRow() != -1 && this.modelo.getIdConsulta().isEmpty()) {

                int pos = this.vMTA.getTablaDatos().getSelectedRow();
                avionAux = modelo.consultarAvion(pos);
                System.out.print("Fila Seleccionada id :" + avionAux.getIdentificacion() + "\n");
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

    public void actualizarDatosAvion() {

        String identi, anio, mode, marca;

        identi = this.vMTA.getId_agregartxt().getText();
        anio = this.vMTA.getAnio_agregar_txt().getText();
        mode = this.vMTA.getModelo_agregartxt().getText();
        marca = this.vMTA.getMarca_agregartxt().getText();

        if (identi.isEmpty() || anio.isEmpty() || mode.isEmpty() || marca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
        } else {
            modelo.insertarAvion(new Avion(identi, anio, mode, marca));
            this.vMTA.getPanel_agregar().setVisible(false);
        }

        //

    }

    String idAnt, modeloAnt, marcaAnt, anioAnt;
    String idAux, modeloAux, marcaAux, anioAux;

    private void modificarDatosAvion(Avion avion) {

        // Seteo de los campos de la nueva ventana
        this.vMTA.getId_modificartxt2().setText(avion.getIdentificacion());
        this.vMTA.getModelo_modificartxt2().setText(avion.getModelo());
        this.vMTA.getMarca_modificartxt2().setText(avion.getMarca());
        this.vMTA.getAnio_modificar_txt2().setText(avion.getAnio());

        //------------llenamos los datos seleccionados
        System.out.print("->>>" + avion.toString() + "\n");
        // Salvamos los datos anterioes
        idAnt = this.vMTA.getId_modificartxt2().getText();
        modeloAnt = this.vMTA.getModelo_modificartxt2().getText();
        marcaAnt = this.vMTA.getMarca_modificartxt2().getText();
        anioAnt = this.vMTA.getAnio_modificar_txt2().getText();
    }

    private void realizarModificacionDatosAvion() {

        idAux = this.vMTA.getId_modificartxt2().getText();
        modeloAux = this.vMTA.getModelo_modificartxt2().getText();
        marcaAux = this.vMTA.getMarca_modificartxt2().getText();
        anioAux = this.vMTA.getAnio_modificar_txt2().getText();
        System.out.println("Controladora.ControladoraModAviones.realizarModificacionDatosAvion()"+modeloAux);
        if (this.vMTA.getAnio_modificar_txt2().getText().isEmpty()
                || this.vMTA.getModelo_modificartxt2().getText().isEmpty()
                || this.vMTA.getMarca_modificartxt2().getText().isEmpty()
                || this.vMTA.getId_modificartxt2().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos Incompletos o Vacios !");
        } else if (idAnt.equals(idAux) && modeloAnt.equals(modeloAux)
                && marcaAnt.equals(marcaAux) && anioAnt.equals(anioAux)) {
            JOptionPane.showMessageDialog(null, "Los datos no pueden ser modificados por que son iguales !");

        } else {
            Avion avion = new Avion();
            avion.setIdentificacion(idAux);
            avion.setAnio(anioAux);
            avion.setMarca(marcaAux);
            avion.setModelo(modeloAux);
            avion.setCantidadPasajeros(avionAux.getCantidadPasajeros());
            System.out.print("-> " + avion.toString() + "\n");
            modelo.modificarAvion(avion);
            avionAux = null;
            this.vMTA.getPanelModificar().setVisible(false);
        }
    }

    private void realizarConsultaAvion() {
        if (this.vMTA.getConsulta_txt().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es Necesario un numero de identificacion de Avion para la Consulta\n");
        } else {
            modelo.consultarAvion(this.vMTA.getConsulta_txt().getText());
        }
    }

    private void opcionListar() {
        this.modelo.listarTabla();
    }

}
