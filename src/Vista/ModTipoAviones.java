/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraModTipoAvion;
import Excepciones.NoDataException;
import Modelo.LineaDetalleVuelo;
import Modelo.Modelo;
import Modelo.Ruta;
import Modelo.Vuelo;
import java.awt.Point;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author netto
 */
public class ModTipoAviones extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form ModTipoAviones
     */
    
    // Declaracion de clases
    ControladoraModTipoAvion cMTA;
    Modelo modelo;
            
    public ModTipoAviones() {
        initComponents();
        this.otrosComponentes();
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelMenuFlotante.setVisible(true);
        this.panelErrorSeleccion.setVisible(false);
        this.panelAgregarAvion.setVisible(false);
        this.panelAgregarRuta.setVisible(false);
        this.panelSolicitarDatosVuelo.setVisible(false);
        this.panelModificacionVuelo.setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
   public void setControl(ControladoraModTipoAvion cMTA){
       this.cMTA=cMTA;
       
       //------- Delegar control de Mouse a Controladora Mod Tipo Avion --------
       
       tablaDatos.addMouseListener(cMTA);
       tablaAgregarAvion.addMouseListener(cMTA);
       tablaAgragarRuta.addMouseListener(cMTA);
       this.terminarEleccion.addActionListener(cMTA);
       this.btnConsultar.addActionListener(cMTA);
       this.btnListar.addActionListener(cMTA);
       this.btnTerminarEleccionRuta.addActionListener(cMTA);
       this.terminarBotonVuelo.addActionListener(cMTA);
       this.btnCancelarAgregarAvion.addActionListener(cMTA);
       this.cancelarEleccionRuta.addActionListener(cMTA);
       this.btnCancelarBotonVuelo.addActionListener(cMTA);
       this.btnAceptarCambioVuelo.addActionListener(cMTA);
       this.btnCancelarCambioVuelo.addActionListener(cMTA);
       this.btnListar.addActionListener(cMTA);
       
        //_--------------------
       
       
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
   
    public void setModelo(Modelo modelo){
        this.modelo=modelo;
        this.modelo.addObserver(this);
    }

    public ControladoraModTipoAvion getcMTA() {
        return cMTA;
    }

    public void setcMTA(ControladoraModTipoAvion cMTA) {
        this.cMTA = cMTA;
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
         Modelo m = (Modelo) updatedModel;
         System.out.print("-> ojas ojas ojas "+m.getAccionVuelos()+"\n");
         if ("eliminarVuelo".equals(m.getAccionVuelos())) {
             System.out.print("-> ACTUALIZANDO LOS DATOS \n");
             try {
                 this.mostrarTablaInicio();
             } catch (NoDataException ex) {
                 this.mostrarExecpcion(ex.getMessage());
             }
         }
         
         else if ("consulta".equals(m.getAccionVuelos())) {
             this.mostrarConsulta();
         }
         else
         {
             System.out.print(" -> "+m.getAccionAviones()+" es diferente de : eliminarVuelo");
         }
         UpdateTable();
    }
    
    
    public void mostrarTablaInicio() throws NoDataException
    {
        ArrayList<LineaDetalleVuelo> al;
        al = modelo.listarVuelos();
        if (al != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] columnNames = {"#Vuelo", "Precio", "TipoVuelo",
                "PaisOrigen", "PaisDestino","FechaSalida","FechaLlegada"
            ,"Pasajeros"};// en las columnas van el tipo de dato...
            tableModel.setColumnIdentifiers(columnNames);
            Object[] fila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < al.size(); i++) {

                fila[0] = al.get(i).getIdentificacion();
                fila[1] = al.get(i).getPrecio();
                fila[2] = al.get(i).getTipoVuelo();
                fila[3] = al.get(i).getPaisOrigen();
                fila[4] = al.get(i).getPaisDestino();
                fila[5]=al.get(i).getDiaSalida()+"/"+
                        al.get(i).getMesSalida()+
                        "/"+al.get(i).getAnioSalida()+
                        " , "+al.get(i).getHoraSalida();
                fila[6] = al.get(i).getDiaLlegada()+"/"+
                        al.get(i).getMesLlegada()+"/"+
                        al.get(i).getAnioLlegada()+", "
                        +al.get(i).getHoraLlegada();
                fila[7] = al.get(i).getCantidadPasajeros();
                
                tableModel.addRow(fila);
            }
            this.tablaDatos.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
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
        panelErrorSeleccion = new javax.swing.JPanel();
        lAdministrador1 = new javax.swing.JLabel();
        lAdministrador2 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
        panelSolicitarDatosVuelo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        terminarBotonVuelo = new javax.swing.JButton();
        btnCancelarBotonVuelo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumVueloRuta = new javax.swing.JTextField();
        txtPrecioVuelo = new javax.swing.JTextField();
        txtTipoVuelo = new javax.swing.JTextField();
        lAdministrador5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelModificacionVuelo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioNuevoVuelo = new javax.swing.JTextField();
        txtNuevoTipoVuelo = new javax.swing.JTextField();
        btnAceptarCambioVuelo = new javax.swing.JButton();
        btnCancelarCambioVuelo = new javax.swing.JButton();
        panelAgregarRuta = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaAgragarRuta = new javax.swing.JTable();
        btnTerminarEleccionRuta = new javax.swing.JButton();
        cancelarEleccionRuta = new javax.swing.JButton();
        lAdministrador4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelAgregarAvion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAgregarAvion = new javax.swing.JTable();
        terminarEleccion = new javax.swing.JButton();
        btnCancelarAgregarAvion = new javax.swing.JButton();
        lAdministrador3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        panelMenuFlotante = new javax.swing.JPanel();
        bAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        consultaTxt = new javax.swing.JTextField();
        bCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lAdministrador = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();

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
        bTerminar.setText("Guardar");
        bTerminar.setActionCommand("Terminar");
        bTerminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 102)));
        bTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(bTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 630, 240, 60));

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

        panelSolicitarDatosVuelo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero Vuelo : ");
        panelSolicitarDatosVuelo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 160, 40));

        terminarBotonVuelo.setBackground(new java.awt.Color(0, 0, 153));
        terminarBotonVuelo.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        terminarBotonVuelo.setForeground(new java.awt.Color(255, 255, 255));
        terminarBotonVuelo.setText("Aceptar");
        terminarBotonVuelo.setActionCommand("terminarDatosVuelo");
        panelSolicitarDatosVuelo.add(terminarBotonVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 150, 60));

        btnCancelarBotonVuelo.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelarBotonVuelo.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelarBotonVuelo.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarBotonVuelo.setText("Cancelar");
        btnCancelarBotonVuelo.setActionCommand("cancelarDatosVuelo");
        panelSolicitarDatosVuelo.add(btnCancelarBotonVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 140, 60));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio : ");
        panelSolicitarDatosVuelo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 40));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo Vuelo : ");
        panelSolicitarDatosVuelo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 205, 160, 40));

        txtNumVueloRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtNumVueloRuta.setForeground(new java.awt.Color(51, 51, 51));
        panelSolicitarDatosVuelo.add(txtNumVueloRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 70, 160, 40));

        txtPrecioVuelo.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioVuelo.setForeground(new java.awt.Color(51, 51, 51));
        panelSolicitarDatosVuelo.add(txtPrecioVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 139, 160, 40));

        txtTipoVuelo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoVuelo.setForeground(new java.awt.Color(51, 51, 51));
        panelSolicitarDatosVuelo.add(txtTipoVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 160, 50));

        lAdministrador5.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lAdministrador5.setForeground(new java.awt.Color(255, 255, 255));
        lAdministrador5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipoAvion.png"))); // NOI18N
        lAdministrador5.setText("Registrar");
        lAdministrador5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelSolicitarDatosVuelo.add(lAdministrador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 240, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMorado.png"))); // NOI18N
        panelSolicitarDatosVuelo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 420));

        getContentPane().add(panelSolicitarDatosVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 250, -1, -1));

        jLabel6.setText("Precio Nuevo : ");

        jLabel7.setText("Tipo de Vuelo Nuevo : ");

        btnAceptarCambioVuelo.setText("aceptar");
        btnAceptarCambioVuelo.setActionCommand("aceptarCamvioVuelo");

        btnCancelarCambioVuelo.setText("cancelar");
        btnCancelarCambioVuelo.setActionCommand("cancelarCambioVuelo");

        javax.swing.GroupLayout panelModificacionVueloLayout = new javax.swing.GroupLayout(panelModificacionVuelo);
        panelModificacionVuelo.setLayout(panelModificacionVueloLayout);
        panelModificacionVueloLayout.setHorizontalGroup(
            panelModificacionVueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificacionVueloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificacionVueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificacionVueloLayout.createSequentialGroup()
                        .addComponent(btnAceptarCambioVuelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnCancelarCambioVuelo))
                    .addGroup(panelModificacionVueloLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNuevoTipoVuelo))
                    .addGroup(panelModificacionVueloLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecioNuevoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        panelModificacionVueloLayout.setVerticalGroup(
            panelModificacionVueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificacionVueloLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelModificacionVueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioNuevoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificacionVueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNuevoTipoVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(panelModificacionVueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarCambioVuelo)
                    .addComponent(btnCancelarCambioVuelo))
                .addGap(42, 42, 42))
        );

        getContentPane().add(panelModificacionVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        panelAgregarRuta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAgragarRuta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "# Ruta"
            }
        ));
        jScrollPane3.setViewportView(tablaAgragarRuta);

        panelAgregarRuta.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 683, 216));

        btnTerminarEleccionRuta.setBackground(new java.awt.Color(0, 0, 102));
        btnTerminarEleccionRuta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnTerminarEleccionRuta.setForeground(new java.awt.Color(255, 255, 255));
        btnTerminarEleccionRuta.setText("terminarEleccion");
        btnTerminarEleccionRuta.setActionCommand("terminarEleccionRuta");
        panelAgregarRuta.add(btnTerminarEleccionRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 336, -1, 53));

        cancelarEleccionRuta.setBackground(new java.awt.Color(204, 0, 0));
        cancelarEleccionRuta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        cancelarEleccionRuta.setText("CancelarEleccion");
        cancelarEleccionRuta.setActionCommand("CancelarEleccionRuta");
        panelAgregarRuta.add(cancelarEleccionRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 336, -1, 53));

        lAdministrador4.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lAdministrador4.setForeground(new java.awt.Color(255, 255, 255));
        lAdministrador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipoAvion.png"))); // NOI18N
        lAdministrador4.setText("Ruta disponibles");
        lAdministrador4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelAgregarRuta.add(lAdministrador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 12, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoAzul.jpg"))); // NOI18N
        panelAgregarRuta.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 3, 690, 480));

        getContentPane().add(panelAgregarRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, 490));

        panelAgregarAvion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAgregarAvion.setBackground(new java.awt.Color(255, 255, 255));
        tablaAgregarAvion.setForeground(new java.awt.Color(51, 51, 51));
        tablaAgregarAvion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "#Avion Disponible"
            }
        ));
        tablaAgregarAvion.setComponentPopupMenu(popMenu);
        tablaAgregarAvion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tablaAgregarAvion);

        panelAgregarAvion.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 82, 605, 174));

        terminarEleccion.setBackground(new java.awt.Color(255, 255, 255));
        terminarEleccion.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        terminarEleccion.setForeground(new java.awt.Color(51, 51, 51));
        terminarEleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit.png"))); // NOI18N
        terminarEleccion.setText("terminarEleccion");
        panelAgregarAvion.add(terminarEleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 188, 61));

        btnCancelarAgregarAvion.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelarAgregarAvion.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelarAgregarAvion.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarAgregarAvion.setText("CancelarEleccion");
        btnCancelarAgregarAvion.setActionCommand("CancelarEleccionAgregarAvion");
        panelAgregarAvion.add(btnCancelarAgregarAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, 59));

        lAdministrador3.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lAdministrador3.setForeground(new java.awt.Color(255, 255, 255));
        lAdministrador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipoAvion.png"))); // NOI18N
        lAdministrador3.setText("Aviones Disponibles");
        lAdministrador3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panelAgregarAvion.add(lAdministrador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 12, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoGris.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        panelAgregarAvion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 720, 490));

        getContentPane().add(panelAgregarAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 720, 510));

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
                "#Vuelo", "Precio", "IdAvion", "IdRuta", "TipoVuelo"
            }
        ));
        tablaDatos.setComponentPopupMenu(popMenu);
        tablaDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 630, 480));

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

        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report.png"))); // NOI18N
        btnListar.setActionCommand("listarVuelo");

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnConsultar.setActionCommand("consultaVuelo");

        javax.swing.GroupLayout panelMenuFlotanteLayout = new javax.swing.GroupLayout(panelMenuFlotante);
        panelMenuFlotante.setLayout(panelMenuFlotanteLayout);
        panelMenuFlotanteLayout.setHorizontalGroup(
            panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuFlotanteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                        .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnListar))
                            .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListar)
                .addGap(35, 35, 35))
        );

        getContentPane().add(panelMenuFlotante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 160, 310));

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
        lAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipoAvion.png"))); // NOI18N
        lAdministrador.setText("Modificar Tipo de Aviones");
        lAdministrador.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lAdministrador);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 530, 80));

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

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/q7.jpg"))); // NOI18N
        lFondo.setAlignmentY(0.0F);
        lFondo.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
            java.util.logging.Logger.getLogger(ModTipoAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModTipoAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModTipoAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModTipoAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModTipoAviones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bTerminar;
    private javax.swing.JButton btnAceptarCambioVuelo;
    private javax.swing.JButton btnCancelarAgregarAvion;
    private javax.swing.JButton btnCancelarBotonVuelo;
    private javax.swing.JButton btnCancelarCambioVuelo;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnTerminarEleccionRuta;
    private javax.swing.JButton cancelarEleccionRuta;
    private javax.swing.JTextField consultaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lAdministrador;
    private javax.swing.JLabel lAdministrador1;
    private javax.swing.JLabel lAdministrador2;
    private javax.swing.JLabel lAdministrador3;
    private javax.swing.JLabel lAdministrador4;
    private javax.swing.JLabel lAdministrador5;
    private javax.swing.JLabel lFondo;
    private javax.swing.JPanel panelAgregarAvion;
    private javax.swing.JPanel panelAgregarRuta;
    private javax.swing.JPanel panelErrorSeleccion;
    private javax.swing.JPanel panelMenuFlotante;
    private javax.swing.JPanel panelModificacionVuelo;
    private javax.swing.JPanel panelSolicitarDatosVuelo;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tablaAgragarRuta;
    private javax.swing.JTable tablaAgregarAvion;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JButton terminarBotonVuelo;
    private javax.swing.JButton terminarEleccion;
    private javax.swing.JTextField txtNuevoTipoVuelo;
    private javax.swing.JTextField txtNumVueloRuta;
    private javax.swing.JTextField txtPrecioNuevoVuelo;
    private javax.swing.JTextField txtPrecioVuelo;
    private javax.swing.JTextField txtTipoVuelo;
    // End of variables declaration//GEN-END:variables

    public JButton getbCerrar() {
        return bCerrar;
    }

    public void setbCerrar(JButton bCerrar) {
        this.bCerrar = bCerrar;
    }

    public JTextField getConsultaTxt() {
        return consultaTxt;
    }

    public void setConsultaTxt(JTextField consultaTxt) {
        this.consultaTxt = consultaTxt;
    }

    public void mostrarExecpcion(String message) {
        
        JOptionPane.showMessageDialog(null, message+"\n");
    }

    public void mostrarTablaAvionesDisponibles() {
        
        this.panelAgregarAvion.setVisible(true);
        try {
            this.modelo.listarAvionesDisponibles();
            
            ArrayList<String> al;
            al = modelo.listarAvionesDisponibles();
            System.out.print(al.size() + " , " + al.toString());
            if (al != null) {
                DefaultTableModel tableModel = new DefaultTableModel();
                String[] columnNames = {"#AvionDisponible"};// en las columnas van el tipo de dato...
                tableModel.setColumnIdentifiers(columnNames);
                Object[] fila = new Object[tableModel.getColumnCount()];
                for (int i = 0; i < al.size(); i++) {
                    
                    fila[0] = al.get(i);
                    tableModel.addRow(fila);
                }
                this.tablaAgregarAvion.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(null, "Consulta Invalida");
            }
            
        } catch (NoDataException ex) {
            this.mostrarExecpcion(ex.getMessage());
        }
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public void setBtnListar(JButton btnListar) {
        this.btnListar = btnListar;
    }

    public JPanel getPanelAgregarAvion() {
        return panelAgregarAvion;
    }

    public void setPanelAgregarAvion(JPanel panelAgregarAvion) {
        this.panelAgregarAvion = panelAgregarAvion;
    }

    public JTable getTablaAgregarAvion() {
        return tablaAgregarAvion;
    }

    public void setTablaAgregarAvion(JTable tablaAgregarAvion) {
        this.tablaAgregarAvion = tablaAgregarAvion;
    }

    public JButton getTerminarEleccion() {
        return terminarEleccion;
    }

    public void setTerminarEleccion(JButton terminarEleccion) {
        this.terminarEleccion = terminarEleccion;
    }

    public JButton getBtnTerminarEleccionRuta() {
        return btnTerminarEleccionRuta;
    }

    public void setBtnTerminarEleccionRuta(JButton btnTerminarEleccionRuta) {
        this.btnTerminarEleccionRuta = btnTerminarEleccionRuta;
    }

    public JPanel getPanelAgregarRuta() {
        return panelAgregarRuta;
    }

    public void setPanelAgregarRuta(JPanel panelAgregarRuta) {
        this.panelAgregarRuta = panelAgregarRuta;
    }

    public JTable getTablaAgragarRuta() {
        return tablaAgragarRuta;
    }

    public void setTablaAgragarRuta(JTable tablaAgragarRuta) {
        this.tablaAgragarRuta = tablaAgragarRuta;
    }

    public JButton getBtnCancelarBotonVuelo() {
        return btnCancelarBotonVuelo;
    }

    public void setBtnCancelarBotonVuelo(JButton btnCancelarBotonVuelo) {
        this.btnCancelarBotonVuelo = btnCancelarBotonVuelo;
    }

    public JPanel getPanelSolicitarDatosVuelo() {
        return panelSolicitarDatosVuelo;
    }

    public void setPanelSolicitarDatosVuelo(JPanel panelSolicitarDatosVuelo) {
        this.panelSolicitarDatosVuelo = panelSolicitarDatosVuelo;
    }

    public JButton getTerminarBotonVuelo() {
        return terminarBotonVuelo;
    }

    public void setTerminarBotonVuelo(JButton terminarBotonVuelo) {
        this.terminarBotonVuelo = terminarBotonVuelo;
    }

    public JTextField getTxtNumVueloRuta() {
        return txtNumVueloRuta;
    }

    public void setTxtNumVueloRuta(JTextField txtNumVueloRuta) {
        this.txtNumVueloRuta = txtNumVueloRuta;
    }

    public JTextField getTxtPrecioVuelo() {
        return txtPrecioVuelo;
    }

    public void setTxtPrecioVuelo(JTextField txtPrecioVuelo) {
        this.txtPrecioVuelo = txtPrecioVuelo;
    }

    public JTextField getTxtTipoVuelo() {
        return txtTipoVuelo;
    }

    public void setTxtTipoVuelo(JTextField txtTipoVuelo) {
        this.txtTipoVuelo = txtTipoVuelo;
    }

    public JButton getBtnCancelarAgregarAvion() {
        return btnCancelarAgregarAvion;
    }

    public void setBtnCancelarAgregarAvion(JButton btnCancelarAgregarAvion) {
        this.btnCancelarAgregarAvion = btnCancelarAgregarAvion;
    }

    public void mostrarTablaRutas() {
        
       this.getPanelAgregarRuta().setVisible(true);
           ArrayList<Ruta> al;
        al = modelo.listarRutas();
        if (al != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] columnNames = {"#Ruta", "Pais Origen", "Pais Destino",
                "Fecha Salida","Fecha Llegada"};// en las columnas van el tipo de dato...
            tableModel.setColumnIdentifiers(columnNames);
            Object[] fila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < al.size(); i++) {

                fila[0] = al.get(i).getIdentificador();
                fila[1] = al.get(i).getPaisOrigen();
                fila[2] = al.get(i).getPaisDestino();
                fila[3] = al.get(i).getHorario().getFechaSalida().toString();
                fila[4] = al.get(i).getHorario().getFechaLLegada().toString();

                tableModel.addRow(fila);
            }
            this.tablaAgragarRuta.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
         
    }

    public JButton getBtnAceptarCambioVuelo() {
        return btnAceptarCambioVuelo;
    }

    public void setBtnAceptarCambioVuelo(JButton btnAceptarCambioVuelo) {
        this.btnAceptarCambioVuelo = btnAceptarCambioVuelo;
    }

    public JButton getBtnCancelarCambioVuelo() {
        return btnCancelarCambioVuelo;
    }

    public void setBtnCancelarCambioVuelo(JButton btnCancelarCambioVuelo) {
        this.btnCancelarCambioVuelo = btnCancelarCambioVuelo;
    }

    public JButton getCancelarEleccionRuta() {
        return cancelarEleccionRuta;
    }

    public void setCancelarEleccionRuta(JButton cancelarEleccionRuta) {
        this.cancelarEleccionRuta = cancelarEleccionRuta;
    }

    public JPanel getPanelModificacionVuelo() {
        return panelModificacionVuelo;
    }

    public void setPanelModificacionVuelo(JPanel panelModificacionVuelo) {
        this.panelModificacionVuelo = panelModificacionVuelo;
    }

    public JTextField getTxtNuevoTipoVuelo() {
        return txtNuevoTipoVuelo;
    }

    public void setTxtNuevoTipoVuelo(JTextField txtNuevoTipoVuelo) {
        this.txtNuevoTipoVuelo = txtNuevoTipoVuelo;
    }

    public JTextField getTxtPrecioNuevoVuelo() {
        return txtPrecioNuevoVuelo;
    }

    public void setTxtPrecioNuevoVuelo(JTextField txtPrecioNuevoVuelo) {
        this.txtPrecioNuevoVuelo = txtPrecioNuevoVuelo;
    }

    private void mostrarConsulta() {
          ArrayList<LineaDetalleVuelo> al=null;
        try {
            al = modelo.consultarVueloIDConsulta(modelo.getIdConsulta());//devueleve un arrayList con 
        } catch (NoDataException ex) {
           this.mostrarExecpcion(ex.getMessage());
        }
        //con solamente el vuelo a consultar
        if (al != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] columnNames = {"#Vuelo", "Precio", "TipoVuelo",
                "PaisOrigen", "PaisDestino","FechaSalida","FechaLlegada"
            ,"Pasajeros"};// en las columnas van el tipo de dato...
            tableModel.setColumnIdentifiers(columnNames);
            Object[] fila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < al.size(); i++) {

                fila[0] = al.get(i).getIdentificacion();
                fila[1] = al.get(i).getPrecio();
                fila[2] = al.get(i).getTipoVuelo();
                fila[3] = al.get(i).getPaisOrigen();
                fila[4] = al.get(i).getPaisDestino();
                fila[5]=al.get(i).getDiaSalida()+"/"+
                        al.get(i).getMesSalida()+
                        "/"+al.get(i).getAnioSalida()+
                        " , "+al.get(i).getHoraSalida();
                fila[6] = al.get(i).getDiaLlegada()+"/"+
                        al.get(i).getMesLlegada()+"/"+
                        al.get(i).getAnioLlegada()+", "
                        +al.get(i).getHoraLlegada();
                fila[7] = al.get(i).getCantidadPasajeros();
                
                tableModel.addRow(fila);
            }
            this.tablaDatos.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }

   

  
}
