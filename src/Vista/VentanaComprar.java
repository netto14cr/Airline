/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraComprar;
import Excepciones.NoDataException;
import Modelo.LineaDetalleVuelo;
import Modelo.Modelo;
import Modelo.Ruta;
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
 * @author netto
 */
public class VentanaComprar extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form ModTipoAviones
     */
    
    // Declaracion de clases
    ControladoraComprar cCompra;
    Modelo modelo;
            
    public VentanaComprar() {
        initComponents();
        this.otrosComponentes();
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelErrorSeleccion.setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
   public void setControl(ControladoraComprar cCompra){
       this.cCompra=cCompra;
       
       //------- Delegar control de Mouse a Controladora Mod Tipo Avion --------
       
       tablaDatos.addMouseListener(cCompra);
       this.btnConsultar.addActionListener(cCompra);
       this.btnListar.addActionListener(cCompra);
       this.btnListar.addActionListener(cCompra);
       this.bTerminar.addActionListener(cCompra);
        //_--------------------
       
       
       // Pop menú
       popMenu.addMouseListener(cCompra);
       jMenuItem1.addMouseListener(cCompra);
       jMenuItem2.addMouseListener(cCompra);
       jMenuItem3.addMouseListener(cCompra);
       jMenuItem4.addMouseListener(cCompra);
       
       // Botones ventana
       bAtras3.addMouseListener(cCompra);
       bMinimizar.addMouseListener(cCompra);
       bTerminar.addMouseListener(cCompra);
       bCerrar.addKeyListener(cCompra);
       
       // Panel error Seleccion
       panelErrorSeleccion.addMouseListener(cCompra);
       bAceptar.addMouseListener(cCompra);
       
       
       //-------- Delegar control de Accion a Controladora Mod Tipo Avion ------
       
       
       // Pop menú 
       jMenuItem1.addActionListener(cCompra);
       jMenuItem2.addActionListener(cCompra);
       jMenuItem3.addActionListener(cCompra);
       jMenuItem4.addActionListener(cCompra);
       
       // Botones ventana
       bAtras3.addActionListener(cCompra);
       bMinimizar.addActionListener(cCompra);
       bTerminar.addActionListener(cCompra);
       bCerrar.addActionListener(cCompra);
       
       // Panel error Seleccion
       bAceptar.addActionListener(cCompra);
       bComprar.addActionListener(cCompra);
       
       
       //------ Delegar control de Teclado a Controladora Mod Tipo Avion -------
       
       tablaDatos.addKeyListener(cCompra);
       // Pop menú
       jMenuItem1.addKeyListener(cCompra);
       jMenuItem2.addKeyListener(cCompra);
       jMenuItem3.addKeyListener(cCompra);
       jMenuItem4.addKeyListener(cCompra);
       
       
       // Botones ventana
       bAtras3.addKeyListener(cCompra);
       bMinimizar.addKeyListener(cCompra);
       bTerminar.addKeyListener(cCompra);
       bCerrar.addKeyListener(cCompra);
       
       // Panel error Seleccion
       panelErrorSeleccion.addKeyListener(cCompra);
       bAceptar.addKeyListener(cCompra);
       
       
       // Escuchar los eventos del teclado y mouse 
       this.addKeyListener(cCompra);
       this.addMouseListener(cCompra);
       
       
    }
   
    public void setModelo(Modelo modelo){
        this.modelo=modelo;
        this.modelo.addObserver(this);
    }

    public ControladoraComprar getcCompra() {
        return cCompra;
    }

    public void setcCompra(ControladoraComprar cCompra) {
        this.cCompra = cCompra;
    }

    public JButton getbAtras() {
        return bAtras3;
    }

    public void setbAtras(JButton bAtras) {
        this.bAtras3 = bAtras;
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
        bAtras3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        bCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lAdministrador = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnListar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        consultaTxt = new javax.swing.JTextField();
        lAdministrador3 = new javax.swing.JLabel();
        bComprar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        getContentPane().add(bTerminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 240, 60));

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

        getContentPane().add(panelErrorSeleccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 410, -1));

        bAtras3.setBackground(new java.awt.Color(0, 0, 0));
        bAtras3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bAtras3.setForeground(new java.awt.Color(255, 255, 255));
        bAtras3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png"))); // NOI18N
        bAtras3.setActionCommand("Atras");
        bAtras3.setBorder(null);
        bAtras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtras3ActionPerformed(evt);
            }
        });
        getContentPane().add(bAtras3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 730, 200));

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
        lAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airpplane.png"))); // NOI18N
        lAdministrador.setText("Busqueda y comprar vuelos");
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

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnListar.setBackground(new java.awt.Color(0, 0, 102));
        btnListar.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report.png"))); // NOI18N
        btnListar.setText("Mostrar todos los vuelos");
        btnListar.setActionCommand("listarVuelo");
        jPanel2.add(btnListar, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 110, -1, -1));

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnConsultar.setActionCommand("consultaVuelo");
        jPanel2.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 50, 104, -1));

        consultaTxt.setBackground(new java.awt.Color(255, 255, 255));
        consultaTxt.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(consultaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 264, 40));

        lAdministrador3.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        lAdministrador3.setForeground(new java.awt.Color(255, 255, 255));
        lAdministrador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador3.setText("Buscar vuelo");
        jPanel2.add(lAdministrador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 50, 190, 40));

        bComprar.setBackground(new java.awt.Color(255, 255, 255));
        bComprar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bComprar.setForeground(new java.awt.Color(102, 0, 102));
        bComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        bComprar.setText("Comprar");
        bComprar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 102)));
        bComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bComprarActionPerformed(evt);
            }
        });
        jPanel2.add(bComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 108, 213, 74));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoMorado.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 240));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 730, 240));

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/q4.jpg"))); // NOI18N
        lFondo.setAlignmentY(0.0F);
        lFondo.setPreferredSize(new java.awt.Dimension(1000, 700));
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTerminarActionPerformed

    }//GEN-LAST:event_bTerminarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bCerrarActionPerformed

    private void bAtras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtras3ActionPerformed

    }//GEN-LAST:event_bAtras3ActionPerformed

    private void bMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMinimizarActionPerformed

    private void bComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bComprarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaComprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaComprar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bAtras3;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bComprar;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bTerminar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnListar;
    private javax.swing.JTextField consultaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lAdministrador;
    private javax.swing.JLabel lAdministrador1;
    private javax.swing.JLabel lAdministrador2;
    private javax.swing.JLabel lAdministrador3;
    private javax.swing.JLabel lFondo;
    private javax.swing.JPanel panelErrorSeleccion;
    private javax.swing.JPopupMenu popMenu;
    private javax.swing.JTable tablaDatos;
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


    public void mostrarTablaRutas() {
        
     
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
     //       this.tablaAgragarRuta.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
         
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
