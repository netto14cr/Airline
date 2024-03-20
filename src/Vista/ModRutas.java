/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraModRutas;
import Excepciones.GlobalException;
import Modelo.Modelo; 
import Modelo.Ruta;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class ModRutas extends javax.swing.JFrame implements Observer{

    public DateFormat getDf() {
        return df;
    }

    
    DateFormat df=DateFormat.getDateInstance();
    
    /**
     * Creates new form ModTipoAviones
     */
    
    // Declaracion de clases
    ControladoraModRutas cMTA;
    Modelo modelo;
            
    public ModRutas() {
        initComponents();
        this.otrosComponentes();
    }

    public void mostrarExecepcion(String m) {
        JOptionPane.showMessageDialog(null, m);
    }
    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelMenuFlotante.setVisible(true);
        this.panelErrorSeleccion.setVisible(false);
        this.panelAgregar.setVisible(false);
        this.panelModificar.setVisible(false);
        this.numRutaModificarTxt.setEditable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    
    public void mostrarTablaInicio()
    {
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
            this.tablaDatos.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }
    
   public void setControl(ControladoraModRutas cMTA){
       this.cMTA=cMTA;
       
       //------- Delegar control de Mouse a Controladora Mod Tipo Avion --------
       tablaDatos.addMouseListener(cMTA);
       
       //------------Botones nuevos
       btnSalvarRuta.addActionListener(cMTA);
       btnCancelarRuta.addActionListener(cMTA);
       btnCancelarRutaModificada1.addActionListener(cMTA);
       btnSalvarRutaModificad1.addActionListener(cMTA);
       btnConsulta.addActionListener(cMTA);
       btnListar.addActionListener(cMTA);
       //-----------------------
       
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
       comboDestino.addKeyListener(cMTA);
       comboOrigen.addKeyListener(cMTA);
       
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

    public ControladoraModRutas getcMTA() {
        return cMTA;
    }

    public void setcMTA(ControladoraModRutas cMTA) {
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

    public JComboBox<String> getComboDestino() {
        return comboDestino;
    }

    public void setComboDestino(JComboBox<String> comboDestino) {
        this.comboDestino = comboDestino;
    }

    public JComboBox<String> getComboOrigen() {
        return comboOrigen;
    }

    public void setComboOrigen(JComboBox<String> comboOrigen) {
        this.comboOrigen = comboOrigen;
    }

    public JComboBox<String> getComboDestinoAgregar() {
        return comboDestinoAgregar;
    }

    public void setComboDestinoAgregar(JComboBox<String> comboDestinoAgregar) {
        this.comboDestinoAgregar = comboDestinoAgregar;
    }

    public JComboBox<String> getComboOrigenAgregar() {
        return comboOrigenAgregar;
    }

    public void setComboOrigenAgregar(JComboBox<String> comboOrigenAgregar) {
        this.comboOrigenAgregar = comboOrigenAgregar;
    }
    
    
    
    
     @Override
    public void update(Observable updatedModel, Object param) {
      
            System.out.println("Ingresa");
            
            Modelo m = (Modelo) updatedModel;
            System.out.println(m.getAccionRutas());
            System.out.println("\n"+m.getIdConsulta()+"\n");
            if ("insertarRuta".equals(m.getAccionRutas()))
                this.mostrarTablaInicio();
        if ("consulta".equals(m.getAccionRutas())) {   System.out.println("Mostrando Consutal\n");
            try {
                System.out.println("Mostrando Consutal\n");
                this.mostrarConsulta();
            } catch (GlobalException ex) {
                this.mostrarExecepcion(ex.getMessage());
            }
        }
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
        panelAgregar = new javax.swing.JPanel();
        btnFechaSalida = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFechaLlegada = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        numRutaTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        horaSalidatxt = new javax.swing.JTextField();
        horaLlegadaTxt = new javax.swing.JTextField();
        btnSalvarRuta = new javax.swing.JButton();
        btnCancelarRuta = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        comboOrigenAgregar = new javax.swing.JComboBox<>();
        comboDestinoAgregar = new javax.swing.JComboBox<>();
        LfONDO = new javax.swing.JLabel();
        panelModificar = new javax.swing.JPanel();
        btnFechaSalidaModificartxt = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnFechaLlegadaModificarTxt = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        numRutaModificarTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        horaSalidaModificartxt1 = new javax.swing.JTextField();
        horaLlegadaModificarTxt1 = new javax.swing.JTextField();
        btnSalvarRutaModificad1 = new javax.swing.JButton();
        btnCancelarRutaModificada1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        comboOrigen = new javax.swing.JComboBox<>();
        comboDestino = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
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
        btnListar = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
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
        bTerminar.setText("Terminar");
        bTerminar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 102)));
        bTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(bTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 240, 60));

        panelAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFechaSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnFechaSalida.setForeground(new java.awt.Color(51, 51, 51));
        panelAgregar.add(btnFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 164, 38));

        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha Salida : ");
        panelAgregar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 176, 44));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha Llegada : ");
        panelAgregar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, 32));

        btnFechaLlegada.setBackground(new java.awt.Color(255, 255, 255));
        btnFechaLlegada.setForeground(new java.awt.Color(51, 51, 51));
        panelAgregar.add(btnFechaLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 164, 32));

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("AGREGAR RUTA");
        panelAgregar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 11, 230, 40));

        numRutaTxt.setBackground(new java.awt.Color(255, 255, 255));
        numRutaTxt.setForeground(new java.awt.Color(51, 51, 51));
        panelAgregar.add(numRutaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 164, 31));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Pais Origen : ");
        panelAgregar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 176, 34));

        jLabel7.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Pais Destino : ");
        panelAgregar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 176, 31));

        jLabel8.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Hora Salida : ");
        panelAgregar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 176, 36));

        jLabel9.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Hora Llegada : ");
        panelAgregar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 176, 41));

        horaSalidatxt.setBackground(new java.awt.Color(255, 255, 255));
        horaSalidatxt.setForeground(new java.awt.Color(51, 51, 51));
        panelAgregar.add(horaSalidatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 164, 36));

        horaLlegadaTxt.setBackground(new java.awt.Color(255, 255, 255));
        horaLlegadaTxt.setForeground(new java.awt.Color(51, 51, 51));
        panelAgregar.add(horaLlegadaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 164, 33));

        btnSalvarRuta.setBackground(new java.awt.Color(255, 255, 255));
        btnSalvarRuta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvarRuta.setForeground(new java.awt.Color(51, 51, 51));
        btnSalvarRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        btnSalvarRuta.setText("Agregar");
        btnSalvarRuta.setActionCommand("salvarRuta");
        panelAgregar.add(btnSalvarRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, 47));

        btnCancelarRuta.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarRuta.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelarRuta.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelarRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        btnCancelarRuta.setText("Cancelar");
        btnCancelarRuta.setActionCommand("cacelarRuta");
        panelAgregar.add(btnCancelarRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, -1, 47));

        jLabel20.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Número de Ruta : ");
        panelAgregar.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 70, 200, 31));

        comboOrigenAgregar.setBackground(new java.awt.Color(255, 255, 255));
        comboOrigenAgregar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        comboOrigenAgregar.setForeground(new java.awt.Color(51, 51, 51));
        comboOrigenAgregar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Costa Rica", "México", "Estados Unidos", "Panamá", "Brasil" }));
        panelAgregar.add(comboOrigenAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 160, 30));

        comboDestinoAgregar.setBackground(new java.awt.Color(255, 255, 255));
        comboDestinoAgregar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        comboDestinoAgregar.setForeground(new java.awt.Color(51, 51, 51));
        comboDestinoAgregar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Estados Unidos", "Costa Rica", "México", "Panamá", "Brasil" }));
        panelAgregar.add(comboDestinoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 160, 30));

        LfONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMorado.png"))); // NOI18N
        LfONDO.setAlignmentY(0.0F);
        panelAgregar.add(LfONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 520));

        getContentPane().add(panelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 810, 490));

        panelModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFechaSalidaModificartxt.setBackground(new java.awt.Color(255, 255, 255));
        btnFechaSalidaModificartxt.setForeground(new java.awt.Color(51, 51, 51));
        panelModificar.add(btnFechaSalidaModificartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 226, 205, 40));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Fecha Salida : ");
        panelModificar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 220, 176, 46));

        jLabel11.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Fecha Llegada : ");
        panelModificar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 321, -1, 42));

        btnFechaLlegadaModificarTxt.setBackground(new java.awt.Color(255, 255, 255));
        btnFechaLlegadaModificarTxt.setForeground(new java.awt.Color(51, 51, 51));
        panelModificar.add(btnFechaLlegadaModificarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 321, 205, 42));

        jLabel12.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Modificar Rutas");
        panelModificar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 15, 211, 40));

        numRutaModificarTxt.setBackground(new java.awt.Color(255, 255, 255));
        numRutaModificarTxt.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        numRutaModificarTxt.setForeground(new java.awt.Color(51, 51, 51));
        panelModificar.add(numRutaModificarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 73, 205, 40));

        jLabel13.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Pais Origen : ");
        panelModificar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 125, 176, 38));

        jLabel14.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Pais Destino : ");
        panelModificar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 175, 176, 39));

        jLabel15.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Hora Salida : ");
        panelModificar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 272, 176, 43));

        jLabel16.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Hora Llegada : ");
        panelModificar.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 375, 176, 39));

        horaSalidaModificartxt1.setBackground(new java.awt.Color(255, 255, 255));
        horaSalidaModificartxt1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        horaSalidaModificartxt1.setForeground(new java.awt.Color(51, 51, 51));
        panelModificar.add(horaSalidaModificartxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 272, 205, 43));

        horaLlegadaModificarTxt1.setBackground(new java.awt.Color(255, 255, 255));
        horaLlegadaModificarTxt1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        horaLlegadaModificarTxt1.setForeground(new java.awt.Color(51, 51, 51));
        panelModificar.add(horaLlegadaModificarTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 375, 205, 39));

        btnSalvarRutaModificad1.setBackground(new java.awt.Color(0, 102, 102));
        btnSalvarRutaModificad1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnSalvarRutaModificad1.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarRutaModificad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        btnSalvarRutaModificad1.setText("Agregar");
        btnSalvarRutaModificad1.setActionCommand("salvarRutaModificada");
        panelModificar.add(btnSalvarRutaModificad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 426, -1, 45));

        btnCancelarRutaModificada1.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelarRutaModificada1.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnCancelarRutaModificada1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarRutaModificada1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        btnCancelarRutaModificada1.setText("Cancelar");
        btnCancelarRutaModificada1.setActionCommand("cacelarRutaModificada");
        panelModificar.add(btnCancelarRutaModificada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 426, 143, 45));

        jLabel17.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("# Ruta : ");
        panelModificar.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 81, 176, 40));

        comboOrigen.setBackground(new java.awt.Color(255, 255, 255));
        comboOrigen.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        comboOrigen.setForeground(new java.awt.Color(51, 51, 51));
        comboOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Estados Unidos", "Costa Rica", "México", "Panamá", "Brasil" }));
        panelModificar.add(comboOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 200, 30));

        comboDestino.setBackground(new java.awt.Color(255, 255, 255));
        comboDestino.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        comboDestino.setForeground(new java.awt.Color(51, 51, 51));
        comboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Costa Rica", "México", "Estados Unidos", "Panamá", "Brasil" }));
        panelModificar.add(comboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 200, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoAzul.jpg"))); // NOI18N
        panelModificar.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 480));

        getContentPane().add(panelModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 810, 480));

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
                "# ruta", "Pais Origen", "Pais Destino", "Fecha Salida", "Fecha Llegada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDatos.setComponentPopupMenu(popMenu);
        tablaDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 810, 480));

        panelMenuFlotante.setBackground(new java.awt.Color(255, 255, 255));
        panelMenuFlotante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));

        bAgregar.setBackground(new java.awt.Color(255, 255, 255));
        bAgregar.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        bAgregar.setForeground(new java.awt.Color(51, 51, 51));
        bAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new.png"))); // NOI18N
        bAgregar.setText("Agregar");
        bAgregar.setToolTipText("Agrega un nuevo dato");
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

        btnListar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/h2.png"))); // NOI18N
        btnListar.setText("Listar");
        btnListar.setActionCommand("listar");

        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnConsulta.setActionCommand("consultaR");

        consultaTxt.setBackground(new java.awt.Color(255, 255, 255));
        consultaTxt.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelMenuFlotanteLayout = new javax.swing.GroupLayout(panelMenuFlotante);
        panelMenuFlotante.setLayout(panelMenuFlotanteLayout);
        panelMenuFlotanteLayout.setHorizontalGroup(
            panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuFlotanteLayout.createSequentialGroup()
                        .addComponent(btnConsulta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consultaTxt))
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(panelMenuFlotanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsulta)
                    .addComponent(consultaTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(panelMenuFlotante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 170, 310));

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
        lAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maps.png"))); // NOI18N
        lAdministrador.setText("Modificar Rutas");
        lAdministrador.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lAdministrador);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 440, 80));

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

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/q66.jpg"))); // NOI18N
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
            java.util.logging.Logger.getLogger(ModRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModRutas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LfONDO;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bTerminar;
    private javax.swing.JButton btnCancelarRuta;
    private javax.swing.JButton btnCancelarRutaModificada1;
    private javax.swing.JButton btnConsulta;
    private com.toedter.calendar.JDateChooser btnFechaLlegada;
    private com.toedter.calendar.JDateChooser btnFechaLlegadaModificarTxt;
    private com.toedter.calendar.JDateChooser btnFechaSalida;
    private com.toedter.calendar.JDateChooser btnFechaSalidaModificartxt;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSalvarRuta;
    private javax.swing.JButton btnSalvarRutaModificad1;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboDestinoAgregar;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JComboBox<String> comboOrigenAgregar;
    private javax.swing.JTextField consultaTxt;
    private javax.swing.JTextField horaLlegadaModificarTxt1;
    private javax.swing.JTextField horaLlegadaTxt;
    private javax.swing.JTextField horaSalidaModificartxt1;
    private javax.swing.JTextField horaSalidatxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lAdministrador;
    private javax.swing.JLabel lAdministrador1;
    private javax.swing.JLabel lAdministrador2;
    private javax.swing.JLabel lFondo;
    private javax.swing.JTextField numRutaModificarTxt;
    private javax.swing.JTextField numRutaTxt;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelErrorSeleccion;
    private javax.swing.JPanel panelMenuFlotante;
    private javax.swing.JPanel panelModificar;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCancelarRuta() {
        return btnCancelarRuta;
    }

    public void setBtnCancelarRuta(JButton btnCancelarRuta) {
        this.btnCancelarRuta = btnCancelarRuta;
    }

    public JButton getBtnConsulta() {
        return btnConsulta;
    }

    public void setBtnConsulta(JButton btnConsulta) {
        this.btnConsulta = btnConsulta;
    }

    public JDateChooser getBtnFechaLlegada() {
        return btnFechaLlegada;
    }

    public void setBtnFechaLlegada(JDateChooser btnFechaLlegada) {
        this.btnFechaLlegada = btnFechaLlegada;
    }

    public JDateChooser getBtnFechaSalida() {
        return btnFechaSalida;
    }

    public void setBtnFechaSalida(JDateChooser btnFechaSalida) {
        this.btnFechaSalida = btnFechaSalida;
    }

    public JButton getBtnListar() {
        return btnListar;
    }

    public void setBtnListar(JButton btnListar) {
        this.btnListar = btnListar;
    }

    public JButton getBtnSalvarRuta() {
        return btnSalvarRuta;
    }

    public void setBtnSalvarRuta(JButton btnSalvarRuta) {
        this.btnSalvarRuta = btnSalvarRuta;
    }

    public JTextField getConsultaTxt() {
        return consultaTxt;
    }

    public void setConsultaTxt(JTextField consultaTxt) {
        this.consultaTxt = consultaTxt;
    }

    public JTextField getHoraLlegadaTxt() {
        return horaLlegadaTxt;
    }

    public void setHoraLlegadaTxt(JTextField horaLlegadaTxt) {
        this.horaLlegadaTxt = horaLlegadaTxt;
    }

    public JTextField getHoraSalidatxt() {
        return horaSalidatxt;
    }

    public void setHoraSalidatxt(JTextField horaSalidatxt) {
        this.horaSalidatxt = horaSalidatxt;
    }

    public JTextField getNumRutaTxt() {
        return numRutaTxt;
    }

    public void setNumRutaTxt(JTextField numRutaTxt) {
        this.numRutaTxt = numRutaTxt;
    }

    public JPanel getPanelAgregar() {
        return panelAgregar;
    }

    public void setPanelAgregar(JPanel panelAgregar) {
        this.panelAgregar = panelAgregar;
    }

    public JComboBox<String> getComboDestinoAgre() {
        return comboOrigenAgregar;
    }

    public void setComboDestinoAgre(JComboBox<String> comboDestinoAgre) {
        this.comboOrigenAgregar = comboDestinoAgre;
    }

    public JComboBox<String> getComboOrigenAgre() {
        return comboDestinoAgregar;
    }

    public void setComboOrigenAgre(JComboBox<String> comboOrigenAgre) {
        this.comboDestinoAgregar = comboOrigenAgre;
    }

 

    public JButton getBtnCancelarRutaModificada1() {
        return btnCancelarRutaModificada1;
    }

    public void setBtnCancelarRutaModificada1(JButton btnCancelarRutaModificada1) {
        this.btnCancelarRutaModificada1 = btnCancelarRutaModificada1;
    }

    public JDateChooser getBtnFechaLlegadaModificarTxt() {
        return btnFechaLlegadaModificarTxt;
    }

    public void setBtnFechaLlegadaModificarTxt(JDateChooser btnFechaLlegadaModificarTxt) {
        this.btnFechaLlegadaModificarTxt = btnFechaLlegadaModificarTxt;
    }

    public JDateChooser getBtnFechaSalidaModificartxt() {
        return btnFechaSalidaModificartxt;
    }

    public void setBtnFechaSalidaModificartxt(JDateChooser btnFechaSalidaModificartxt) {
        this.btnFechaSalidaModificartxt = btnFechaSalidaModificartxt;
    }

    public JButton getBtnSalvarRutaModificad1() {
        return btnSalvarRutaModificad1;
    }

    public void setBtnSalvarRutaModificad1(JButton btnSalvarRutaModificad1) {
        this.btnSalvarRutaModificad1 = btnSalvarRutaModificad1;
    }

    public JTextField getNumRutaModificarTxt() {
        return numRutaModificarTxt;
    }

    public void setNumRutaModificarTxt(JTextField numRutaModificarTxt) {
        this.numRutaModificarTxt = numRutaModificarTxt;
    }


    public JPanel getPanelModificar() {
        return panelModificar;
    }

    public void setPanelModificar(JPanel panelModificar) {
        this.panelModificar = panelModificar;
    }

    public JTextField getHoraLlegadaModificarTxt1() {
        return horaLlegadaModificarTxt1;
    }

    public void setHoraLlegadaModificarTxt1(JTextField horaLlegadaModificarTxt1) {
        this.horaLlegadaModificarTxt1 = horaLlegadaModificarTxt1;
    }

    public JTextField getHoraSalidaModificartxt1() {
        return horaSalidaModificartxt1;
    }

    public void setHoraSalidaModificartxt1(JTextField horaSalidaModificartxt1) {
        this.horaSalidaModificartxt1 = horaSalidaModificartxt1;
    }

    private void mostrarConsulta() throws GlobalException {
        try {
            ArrayList<Ruta> al;
            al = modelo.consultarRutaID(modelo.getIdConsulta());
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
                this.tablaDatos.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(null, "Consulta Invalida");
            }
        } catch (GlobalException ex) {
            throw ex;
        }
    }


  
}
