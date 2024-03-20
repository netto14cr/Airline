/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraModAviones;
import Excepciones.GlobalException;
import Modelo.Avion;
import Modelo.Modelo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Netto
 */
public class ModAviones extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form ModTipoAviones
     */
    
    // Declaracion de clases
    ControladoraModAviones cMTA;
    Modelo modelo;
    TextPrompt mensajeFondo; 
    public ModAviones() {
        initComponents();
        this.otrosComponentes();
       
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelMenuFlotante.setVisible(true);
        this.panelErrorSeleccion.setVisible(false);
        this.panel_agregar.setVisible(false);
        this.panelModificar.setVisible(false);
        this.agregarMensajeFondo();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    
     public void agregarMensajeFondo(){
        mensajeFondo=new TextPrompt("Identificacion", id_agregartxt);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Modelo de avion", modelo_agregartxt);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Marca de avion", marca_agregartxt);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Año del avion", anio_agregar_txt);
        mensajeFondo.setForeground(Color.BLACK);
        
    }

    public Modelo getModelo() {
        return modelo;
    }

    public JButton getAgregar_txt_btn() {
        return agregar_txt_btn;
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public JButton getCancelar_txt_agregar() {
        return cancelar_txt_agregar;
    }

    public JTextField getId_agregartxt() {
        return id_agregartxt;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JTextField getMarca_agregartxt() {
        return marca_agregartxt;
    }

    public JTextField getModelo_agregartxt() {
        return modelo_agregartxt;
    }

    public JPanel getPanel_agregar() {
        return panel_agregar;
    }

   
    public JTextField getMarca_modificartxt2() {
        return marca_modificartxt2;
    }

 

    public JTextField getModelo_modificartxt2() {
        return modelo_modificartxt2;
    }

    public JPanel getPanelModificar() {
        return panelModificar;
    }

    public void setAnio_modificar_txt2(JTextField anio_modificar_txt2) {
        this.anio_modificar_txt2 = anio_modificar_txt2;
    }

    public void setMarca_modificartxt2(JTextField marca_modificartxt2) {
        this.marca_modificartxt2 = marca_modificartxt2;
    }

    public void setModelo_modificartxt2(JTextField modelo_modificartxt2) {
        this.modelo_modificartxt2 = modelo_modificartxt2;
    }
    
    public void mostrarTablaInicio()
    {
        ArrayList<Avion> al;
        al = modelo.listarAviones();
        if (al != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] columnNames = {"Identificacion", "Año", "Modelo",
                "Marca", "Cantidad Pasajero"};// en las columnas van el tipo de dato...
            tableModel.setColumnIdentifiers(columnNames);
            Object[] fila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < al.size(); i++) {

                fila[0] = al.get(i).getIdentificacion();
                fila[1] = al.get(i).getAnio();
                fila[2] = al.get(i).getModelo();
                fila[3] = al.get(i).getMarca();
                fila[4] = al.get(i).getCantidadPasajeros();

                tableModel.addRow(fila);
            }
            this.tablaDatos.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }
    
    public void mostrarExecepcion(String m)
    {
        JOptionPane.showMessageDialog(null, m);
    }
    
    public JTextField getConsulta_txt() {
        return consulta_txt;
    }

    public void setConsulta_txt(JTextField consulta_txt) {
        this.consulta_txt = consulta_txt;
    }
    
   public void setControl(ControladoraModAviones cMTA){
       this.cMTA=cMTA;
       
       //-----------nueva ventana de agregar avion
       
       this.agregar_txt_btn.addActionListener(cMTA);
       this.cancelar_txt_agregar.addActionListener(cMTA);
       this.modificar_txt_btn2.addActionListener(cMTA);
       this.cancelar_txt_agregar2.addActionListener(cMTA);
       this.pasajeros_txt_modificar.addActionListener(cMTA);
       this.boton_consulta.addActionListener(cMTA);
       this.btnListar.addActionListener(cMTA);
       //------------fin
       
       
       //------- Delegar control de Mouse a Controladora Mod Tipo Avion --------
       tablaDatos.addMouseListener(cMTA);
       
       // Panel menú flotante
       panelMenuFlotante.addMouseListener(cMTA);
       bAgregar.addMouseListener(cMTA);
       bModificar.addMouseListener(cMTA);
       bEliminar.addMouseListener(cMTA);
       
       // Pop menú
       popMenu.addMouseListener(cMTA);
       jMenuItem1.addMouseListener(cMTA);
       jMenuItem2.addMouseListener(cMTA);
       jMenuItem3.addMouseListener(cMTA);
       jMenuItem4.addMouseListener(cMTA);
       
       // Botones ventana
       bAtras.addMouseListener(cMTA);
       bMinimizar.addMouseListener(cMTA);
       bTerminar.addMouseListener(cMTA);
       bCerrar.addKeyListener(cMTA);
       
       // Panel error Seleccion
       panelErrorSeleccion.addMouseListener(cMTA);
       bAceptar.addMouseListener(cMTA);
       
       
       //-------- Delegar control de Accion a Controladora Mod Tipo Avion ------
       
       // Panel menú flotante
       bAgregar.addActionListener(cMTA);
       bModificar.addActionListener(cMTA);
       bEliminar.addActionListener(cMTA);
       
       // Pop menú 
       jMenuItem1.addActionListener(cMTA);
       jMenuItem2.addActionListener(cMTA);
       jMenuItem3.addActionListener(cMTA);
       jMenuItem4.addActionListener(cMTA);
       
       // Botones ventana
       bAtras.addActionListener(cMTA);
       bMinimizar.addActionListener(cMTA);
       bTerminar.addActionListener(cMTA);
       bCerrar.addActionListener(cMTA);
       
       // Panel error Seleccion
       bAceptar.addActionListener(cMTA);
       
       
       //------ Delegar control de Teclado a Controladora Mod Tipo Avion -------
       
       tablaDatos.addKeyListener(cMTA);
       // Pop menú
       jMenuItem1.addKeyListener(cMTA);
       jMenuItem2.addKeyListener(cMTA);
       jMenuItem3.addKeyListener(cMTA);
       jMenuItem4.addKeyListener(cMTA);
       
       // Panel menú flotante
       bAgregar.addKeyListener(cMTA);
       bModificar.addKeyListener(cMTA);
       bEliminar.addKeyListener(cMTA);
       
       // Botones ventana
       bAtras.addKeyListener(cMTA);
       bMinimizar.addKeyListener(cMTA);
       bTerminar.addKeyListener(cMTA);
       bCerrar.addKeyListener(cMTA);
       
       // Panel error Seleccion
       panelErrorSeleccion.addKeyListener(cMTA);
       bAceptar.addKeyListener(cMTA);
       
       
       // Escuchar los eventos del teclado y mouse 
       this.addKeyListener(cMTA);
       this.addMouseListener(cMTA);
       
       
    }

    public JTextField getPasajeros_txt_modificar() {
        return pasajeros_txt_modificar;
    }

    public void setPasajeros_txt_modificar(JTextField pasajeros_txt_modificar) {
        this.pasajeros_txt_modificar = pasajeros_txt_modificar;
    }
   
    public void setModelo(Modelo modelo){
        this.modelo=modelo;
        this.modelo.addObserver(this);
    }

    public ControladoraModAviones getcMTA() {
        return cMTA;
    }

    public void setcMTA(ControladoraModAviones cMTA) {
        this.cMTA = cMTA;
    }

  

    public JButton getCancelar_txt_agregar2() {
        return cancelar_txt_agregar2;
    }

    public void setCancelar_txt_agregar2(JButton cancelar_txt_agregar2) {
        this.cancelar_txt_agregar2 = cancelar_txt_agregar2;
    }

    public JButton getbAtras() {
        return bAtras;
    }

    public void setbAtras(JButton bAtras) {
        this.bAtras = bAtras;
    }

    public JButton getbTerminar() {
        return bTerminar;
    }

    public void setbTerminar(JButton bTerminar) {
        this.bTerminar = bTerminar;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getlAdministrador() {
        return lAdministrador;
    }

    public void setlAdministrador(JLabel lAdministrador) {
        this.lAdministrador = lAdministrador;
    }

    public JLabel getlFondo() {
        return lFondo;
    }

    public void setlFondo(JLabel lFondo) {
        this.lFondo = lFondo;
    }


    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(JTable tablaDatos) {
        this.tablaDatos = tablaDatos;
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }

    public JButton getbMinimizar() {
        return bMinimizar;
    }

    public void setbMinimizar(JButton bMinimizar) {
        this.bMinimizar = bMinimizar;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JMenuItem getjMenuItem2() {
        return jMenuItem2;
    }

    public void setjMenuItem2(JMenuItem jMenuItem2) {
        this.jMenuItem2 = jMenuItem2;
    }

    public JMenuItem getjMenuItem3() {
        return jMenuItem3;
    }

    public void setjMenuItem3(JMenuItem jMenuItem3) {
        this.jMenuItem3 = jMenuItem3;
    }

    public JMenuItem getjMenuItem4() {
        return jMenuItem4;
    }

    public void setjMenuItem4(JMenuItem jMenuItem4) {
        this.jMenuItem4 = jMenuItem4;
    }

    public JPopupMenu.Separator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JPopupMenu.Separator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JPopupMenu.Separator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JPopupMenu.Separator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JPopupMenu.Separator getjSeparator3() {
        return jSeparator3;
    }

    public void setjSeparator3(JPopupMenu.Separator jSeparator3) {
        this.jSeparator3 = jSeparator3;
    }

    public JPopupMenu getPopMenu() {
        return popMenu;
    }

    public void setPopMenu(JPopupMenu popMenu) {
        this.popMenu = popMenu;
    }

    public JButton getbAgregar() {
        return bAgregar;
    }

    public void setbAgregar(JButton bAgregar) {
        this.bAgregar = bAgregar;
    }

    public JButton getbEliminar() {
        return bEliminar;
    }

    public JTextField getId_modificartxt2() {
        return id_modificartxt2;
    }

    public void setId_modificartxt2(JTextField id_modificartxt2) {
        this.id_modificartxt2 = id_modificartxt2;
    }

    public void setbEliminar(JButton bEliminar) {
        this.bEliminar = bEliminar;
    }

    public JButton getbModificar() {
        return bModificar;
    }

    public void setbModificar(JButton bModificar) {
        this.bModificar = bModificar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getPanelMenuFlotante() {
        return panelMenuFlotante;
    }

    public void setPanelMenuFlotante(JPanel panelMenuFlotante) {
        this.panelMenuFlotante = panelMenuFlotante;
    }

    public JButton getbAceptar() {
        return bAceptar;
    }

    public void setbAceptar(JButton bAceptar) {
        this.bAceptar = bAceptar;
    }

    

    public JLabel getlAdministrador1() {
        return lAdministrador1;
    }

    public void setlAdministrador1(JLabel lAdministrador1) {
        this.lAdministrador1 = lAdministrador1;
    }

    public JLabel getlAdministrador2() {
        return lAdministrador2;
    }

    public void setlAdministrador2(JLabel lAdministrador2) {
        this.lAdministrador2 = lAdministrador2;
    }

    public JPanel getPanelErrorSeleccion() {
        return panelErrorSeleccion;
    }

    public void setPanelErrorSeleccion(JPanel panelErrorSeleccion) {
        this.panelErrorSeleccion = panelErrorSeleccion;
    }
    
    
    
    
     @Override
    public void update(Observable updatedModel, Object param) {
        try {
            System.out.println("Ingresa");
            UpdateTable();
            Modelo m = (Modelo) updatedModel;
            if ("insercionAvion".equals(m.getAccionAviones()))
                this.mostrarTablaInicio();
            if("consulta".equals(m.getAccionAviones()))
                this.mostrarConsulta();
        } catch (GlobalException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void UpdateTable() {
        
        
        
        /*
        ArrayList<Estudiante> al;
        al = modelo.listar();
        System.out.println("Size = "+al.size()+"\n");
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] columnNames = {"ID", "Nombre", "Edad"};// en las columnas van el tipo de dato...
        tableModel.setColumnIdentifiers(columnNames);
        // en el vector de fula van los objetos de la table ...
        Object[] fila = new Object[tableModel.getColumnCount()];
        //actualizamos la tabla con los datos modificados , si se inserto
        // , modifico , elimino etc...
        for (int i = 0; i < al.size(); i++) {

            fila[0] = al.get(i).getId();
            fila[1] = al.get(i).getNombre();
            fila[2] = al.get(i).getEdad();
            tableModel.addRow(fila);
        }
        
        tablaDatos.setModel(tableModel);
        
    }
    */
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        bTerminar = new javax.swing.JButton();
        panelModificar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        id_modificartxt2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        modelo_modificartxt2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        marca_modificartxt2 = new javax.swing.JTextField();
        modificar_txt_btn2 = new javax.swing.JButton();
        cancelar_txt_agregar2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        anio_modificar_txt2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        panel_agregar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        id_agregartxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        modelo_agregartxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        marca_agregartxt = new javax.swing.JTextField();
        agregar_txt_btn = new javax.swing.JButton();
        cancelar_txt_agregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        anio_agregar_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        panelErrorSeleccion = new javax.swing.JPanel();
        lAdministrador1 = new javax.swing.JLabel();
        lAdministrador2 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        panelMenuFlotante = new javax.swing.JPanel();
        bAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        boton_consulta = new javax.swing.JButton();
        consulta_txt = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lAdministrador = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();
        pasajeros_txt_modificar = new javax.swing.JTextField();

        popMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51)));

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        jMenuItem1.setText("Agregar datos");
        jMenuItem1.setToolTipText("Agrega un dato nuevo");
        jMenuItem1.setActionCommand("Agregar");
        popMenu.add(jMenuItem1);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        popMenu.add(jSeparator1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mod.png"))); // NOI18N
        jMenuItem2.setText("Modificar datos");
        jMenuItem2.setToolTipText("Modifica un dato existente");
        jMenuItem2.setActionCommand("Modificar");
        popMenu.add(jMenuItem2);
        popMenu.add(jSeparator2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        jMenuItem3.setText("Eliminar datos");
        jMenuItem3.setToolTipText("Elimina un dato");
        jMenuItem3.setActionCommand("Eliminar");
        popMenu.add(jMenuItem3);
        popMenu.add(jSeparator3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        jMenuItem4.setText("Cancelar acción");
        jMenuItem4.setToolTipText("Cancela la edicion del dato");
        jMenuItem4.setActionCommand("Cancelar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        popMenu.add(jMenuItem4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bTerminar.setBackground(new java.awt.Color(255, 255, 255));
        bTerminar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bTerminar.setForeground(new java.awt.Color(102, 0, 102));
        bTerminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/safe.png"))); // NOI18N
        bTerminar.setText("Terminar");
        bTerminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 102)));
        bTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(bTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, 240, 60));

        panelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Identificacion : ");
        panelModificar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 39, -1, 45));

        id_modificartxt2.setEditable(false);
        id_modificartxt2.setBackground(new java.awt.Color(255, 255, 255));
        id_modificartxt2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        id_modificartxt2.setForeground(new java.awt.Color(51, 51, 51));
        id_modificartxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_modificartxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_modificartxt2ActionPerformed(evt);
            }
        });
        panelModificar.add(id_modificartxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 41, 190, 45));

        jLabel12.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Modelo : ");
        panelModificar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 111, 125, 43));

        modelo_modificartxt2.setBackground(new java.awt.Color(255, 255, 255));
        modelo_modificartxt2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        modelo_modificartxt2.setForeground(new java.awt.Color(51, 51, 51));
        modelo_modificartxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelModificar.add(modelo_modificartxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 111, 190, 43));

        jLabel13.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Marca : ");
        panelModificar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 172, 125, 43));

        marca_modificartxt2.setBackground(new java.awt.Color(255, 255, 255));
        marca_modificartxt2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        marca_modificartxt2.setForeground(new java.awt.Color(51, 51, 51));
        marca_modificartxt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelModificar.add(marca_modificartxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 172, 190, 43));

        modificar_txt_btn2.setBackground(new java.awt.Color(0, 102, 102));
        modificar_txt_btn2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        modificar_txt_btn2.setForeground(new java.awt.Color(255, 255, 255));
        modificar_txt_btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mod.png"))); // NOI18N
        modificar_txt_btn2.setText("Modificar");
        modificar_txt_btn2.setActionCommand("salvarModificacion");
        panelModificar.add(modificar_txt_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 334, -1, 44));

        cancelar_txt_agregar2.setBackground(new java.awt.Color(153, 0, 0));
        cancelar_txt_agregar2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        cancelar_txt_agregar2.setForeground(new java.awt.Color(255, 255, 255));
        cancelar_txt_agregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        cancelar_txt_agregar2.setText("Cancelar");
        cancelar_txt_agregar2.setActionCommand("cancelarModificacion");
        panelModificar.add(cancelar_txt_agregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 334, -1, 44));

        jLabel14.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Año : ");
        panelModificar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 233, 114, 50));

        anio_modificar_txt2.setBackground(new java.awt.Color(255, 255, 255));
        anio_modificar_txt2.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        anio_modificar_txt2.setForeground(new java.awt.Color(51, 51, 51));
        anio_modificar_txt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        anio_modificar_txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anio_modificar_txt2ActionPerformed(evt);
            }
        });
        panelModificar.add(anio_modificar_txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 233, 190, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoVerde.jpg"))); // NOI18N
        panelModificar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 700, 520));

        getContentPane().add(panelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 690, 520));

        panel_agregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Identificacion : ");
        jLabel3.setAlignmentY(0.0F);
        panel_agregar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 61, -1, 36));

        id_agregartxt.setBackground(new java.awt.Color(255, 255, 255));
        id_agregartxt.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        id_agregartxt.setForeground(new java.awt.Color(51, 51, 51));
        id_agregartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_agregartxtActionPerformed(evt);
            }
        });
        panel_agregar.add(id_agregartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 61, 192, 36));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Modelo : ");
        jLabel4.setAlignmentY(0.0F);
        panel_agregar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 115, 187, 41));

        modelo_agregartxt.setBackground(new java.awt.Color(255, 255, 255));
        modelo_agregartxt.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        modelo_agregartxt.setForeground(new java.awt.Color(51, 51, 51));
        panel_agregar.add(modelo_agregartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 112, 192, 41));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Marca : ");
        jLabel5.setAlignmentY(0.0F);
        panel_agregar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 181, 187, 42));

        marca_agregartxt.setBackground(new java.awt.Color(255, 255, 255));
        marca_agregartxt.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        marca_agregartxt.setForeground(new java.awt.Color(51, 51, 51));
        panel_agregar.add(marca_agregartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 184, 192, 42));

        agregar_txt_btn.setBackground(new java.awt.Color(0, 0, 51));
        agregar_txt_btn.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        agregar_txt_btn.setForeground(new java.awt.Color(255, 255, 255));
        agregar_txt_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        agregar_txt_btn.setText("Agregar");
        agregar_txt_btn.setActionCommand("salvar");
        panel_agregar.add(agregar_txt_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, -1, 40));

        cancelar_txt_agregar.setBackground(new java.awt.Color(153, 0, 0));
        cancelar_txt_agregar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        cancelar_txt_agregar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar_txt_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        cancelar_txt_agregar.setText("Cancelar");
        panel_agregar.add(cancelar_txt_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, 40));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Año : ");
        jLabel6.setAlignmentY(0.0F);
        panel_agregar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 244, 187, 42));

        anio_agregar_txt.setBackground(new java.awt.Color(255, 255, 255));
        anio_agregar_txt.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        anio_agregar_txt.setForeground(new java.awt.Color(51, 51, 51));
        anio_agregar_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anio_agregar_txtActionPerformed(evt);
            }
        });
        panel_agregar.add(anio_agregar_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 244, 192, 42));

        jLabel7.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMorado.png"))); // NOI18N
        panel_agregar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        getContentPane().add(panel_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 650, 500));

        panelErrorSeleccion.setBackground(new java.awt.Color(255, 255, 255));
        panelErrorSeleccion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        panelErrorSeleccion.setForeground(new java.awt.Color(255, 255, 255));

        lAdministrador1.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        lAdministrador1.setForeground(new java.awt.Color(51, 51, 51));
        lAdministrador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador1.setText("Opcion no valida!!");

        lAdministrador2.setBackground(new java.awt.Color(51, 51, 51));
        lAdministrador2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        lAdministrador2.setForeground(new java.awt.Color(51, 51, 51));
        lAdministrador2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lAdministrador2.setText("Seleccione un elemento de la tabla primero");

        bAceptar.setBackground(new java.awt.Color(0, 0, 51));
        bAceptar.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        bAceptar.setForeground(new java.awt.Color(255, 255, 255));
        bAceptar.setText("Aceptar");
        bAceptar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 51, 102)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/error.png"))); // NOI18N

        javax.swing.GroupLayout panelErrorSeleccionLayout = new javax.swing.GroupLayout(panelErrorSeleccion);
        panelErrorSeleccion.setLayout(panelErrorSeleccionLayout);
        panelErrorSeleccionLayout.setHorizontalGroup(
            panelErrorSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelErrorSeleccionLayout.createSequentialGroup()
                .addGroup(panelErrorSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelErrorSeleccionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lAdministrador2))
                    .addGroup(panelErrorSeleccionLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lAdministrador1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelErrorSeleccionLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelErrorSeleccionLayout.setVerticalGroup(
            panelErrorSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelErrorSeleccionLayout.createSequentialGroup()
                .addGroup(panelErrorSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelErrorSeleccionLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lAdministrador1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelErrorSeleccionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lAdministrador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(panelErrorSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 410, -1));

        bAtras.setBackground(new java.awt.Color(0, 0, 0));
        bAtras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bAtras.setForeground(new java.awt.Color(255, 255, 255));
        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        bAtras.setActionCommand("Atras");
        bAtras.setBorder(null);
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(bAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        tablaDatos.setForeground(new java.awt.Color(51, 51, 51));
        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identificacion", "Año", "Modelo", "Marca", "CantidadPasajeros"
            }
        ));
        tablaDatos.setComponentPopupMenu(popMenu);
        tablaDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 630, 480));

        panelMenuFlotante.setBackground(new java.awt.Color(255, 255, 255));
        panelMenuFlotante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));

        bAgregar.setBackground(new java.awt.Color(255, 255, 255));
        bAgregar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        bAgregar.setForeground(new java.awt.Color(51, 51, 51));
        bAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        bAgregar.setText(" Agregar");
        bAgregar.setToolTipText("Agrega un nuevo dato");
        bAgregar.setActionCommand("Agregar");
        bAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51)));
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        jLabel1.setText("EDITAR TABLA");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(51, 0, 51)));

        bModificar.setBackground(new java.awt.Color(255, 255, 255));
        bModificar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        bModificar.setForeground(new java.awt.Color(51, 51, 51));
        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mod.png"))); // NOI18N
        bModificar.setText("Modificar");
        bModificar.setToolTipText("Modifica un dato");
        bModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51)));
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bEliminar.setBackground(new java.awt.Color(255, 255, 255));
        bEliminar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        bEliminar.setForeground(new java.awt.Color(51, 51, 51));
        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        bEliminar.setText("Eliminar");
        bEliminar.setToolTipText("Elimina un dato");
        bEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 51)));
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        boton_consulta.setBackground(new java.awt.Color(255, 255, 255));
        boton_consulta.setForeground(new java.awt.Color(51, 51, 51));
        boton_consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        boton_consulta.setActionCommand("consulta");

        consulta_txt.setBackground(new java.awt.Color(255, 255, 255));
        consulta_txt.setForeground(new java.awt.Color(51, 51, 51));

        btnListar.setBackground(new java.awt.Color(255, 255, 255));
        btnListar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnListar.setForeground(new java.awt.Color(0, 0, 102));
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/h2.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.setActionCommand("listarAviones");

        javax.swing.GroupLayout panelMenuFlotanteLayout = new javax.swing.GroupLayout(panelMenuFlotante);
        panelMenuFlotante.setLayout(panelMenuFlotanteLayout);
        panelMenuFlotanteLayout.setHorizontalGroup(
            panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                        .addComponent(boton_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consulta_txt))
                    .addComponent(bAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                        .addComponent(btnListar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMenuFlotanteLayout.setVerticalGroup(
            panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consulta_txt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelMenuFlotante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 320));

        bCerrar.setBackground(new java.awt.Color(255, 0, 0));
        bCerrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bCerrar.setForeground(new java.awt.Color(255, 255, 255));
        bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        bCerrar.setActionCommand("Salir");
        bCerrar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51)));

        lAdministrador.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lAdministrador.setForeground(new java.awt.Color(51, 51, 51));
        lAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airplane.png"))); // NOI18N
        lAdministrador.setText("Modificar Aviones");
        lAdministrador.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lAdministrador);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 410, 80));

        bMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        bMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar.png"))); // NOI18N
        bMinimizar.setActionCommand("Minimizar");
        bMinimizar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        bMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(bMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 30, 30));

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/q2.jpg"))); // NOI18N
        lFondo.setAlignmentY(0.0F);
        lFondo.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(pasajeros_txt_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 63, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTerminarActionPerformed

    }//GEN-LAST:event_bTerminarActionPerformed

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bCerrarActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMinimizarActionPerformed

    private void id_agregartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_agregartxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_agregartxtActionPerformed

    private void anio_agregar_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anio_agregar_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anio_agregar_txtActionPerformed

    private void id_modificartxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_modificartxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_modificartxt2ActionPerformed

    private void anio_modificar_txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anio_modificar_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anio_modificar_txt2ActionPerformed

    public JTextField getAnio_modificar_txt2() {
        return anio_modificar_txt2;
    }

    public JTextField getAnio_agregar_txt() {
        return anio_agregar_txt;
    }

    public void setAnio_agregar_txt(JTextField anio_agregar_txt) {
        this.anio_agregar_txt = anio_agregar_txt;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModAviones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar_txt_btn;
    private javax.swing.JTextField anio_agregar_txt;
    private javax.swing.JTextField anio_modificar_txt2;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bTerminar;
    private javax.swing.JButton boton_consulta;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton cancelar_txt_agregar;
    private javax.swing.JButton cancelar_txt_agregar2;
    private javax.swing.JTextField consulta_txt;
    private javax.swing.JTextField id_agregartxt;
    private javax.swing.JTextField id_modificartxt2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lAdministrador;
    private javax.swing.JLabel lAdministrador1;
    private javax.swing.JLabel lAdministrador2;
    private javax.swing.JLabel lFondo;
    private javax.swing.JTextField marca_agregartxt;
    private javax.swing.JTextField marca_modificartxt2;
    private javax.swing.JTextField modelo_agregartxt;
    private javax.swing.JTextField modelo_modificartxt2;
    private javax.swing.JButton modificar_txt_btn2;
    private javax.swing.JPanel panelErrorSeleccion;
    private javax.swing.JPanel panelMenuFlotante;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPanel panel_agregar;
    private javax.swing.JTextField pasajeros_txt_modificar;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables

    private void mostrarConsulta() throws GlobalException {
        try {
            ArrayList<Avion> al;
            al = modelo.consultarAvionID(modelo.getIdConsulta());
            if (al != null) {
                DefaultTableModel tableModel = new DefaultTableModel();
                String[] columnNames = {"Identificacion", "Año", "Modelo",
                    "Marca", "Cantidad Pasajero"};// en las columnas van el tipo de dato...
                tableModel.setColumnIdentifiers(columnNames);
                System.out.print("numero de elementos : "+al.size()+"\n");
                Object[] fila = new Object[tableModel.getColumnCount()];
                for (int i = 0; i < al.size(); i++) {
                    
                    fila[0] = al.get(i).getIdentificacion();
                    fila[1] = al.get(i).getAnio();
                    fila[2] = al.get(i).getModelo();
                    fila[3] = al.get(i).getMarca();
                    fila[4] = al.get(i).getCantidadPasajeros();
                    
                    tableModel.addRow(fila);
                }
                this.tablaDatos.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(null, "Consulta Invalida");
            }
        } catch (GlobalException ex) {
            throw ex;
        }
    }

   
    

  
}
