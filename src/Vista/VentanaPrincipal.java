/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

//import Controlador.ControladorLogin;
import Controladora.ControladorPrincipal;
import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.LineaDetalleVuelo;
import Modelo.Modelo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

//import Controlador.ControladorPrincipal;
/**
 *
 * @author Netto
 */
public class VentanaPrincipal extends javax.swing.JFrame  implements Observer {

    /**
     * Creates new form VentanaPrincipal
     */
    
    ControladorPrincipal cPrincipal;
    Modelo modelo;
    VentanaLogin vLogin;
    VentanaRegistroCliente vRegistro;
    ImageIcon icon;
    ImageIcon iconScale;
    Image img;
    Timer timer;
    

    public VentanaPrincipal() {

        initComponents();
       this.otrosComponentes();
       this.slideShow();
       
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelTabla.setVisible(false);
        this.seleccion="";
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    public void setControl(ControladorPrincipal cPrincipal){
        this.cPrincipal=cPrincipal;
        
        // Delegar control de Mouse a Controladora Principal
        bIniciarSesion.addMouseListener(cPrincipal);
        bRegistrarse.addMouseListener(cPrincipal);
        bMinimizar.addMouseListener(cPrincipal);
        bCerrar.addMouseListener(cPrincipal);
        comboOrigen.addMouseListener(cPrincipal);
        comboDestino.addMouseListener(cPrincipal);
        
        // Delegar control de Accion a Controladora Principal
        bIniciarSesion.addActionListener(cPrincipal);
        bRegistrarse.addActionListener(cPrincipal);
        bMinimizar.addActionListener(cPrincipal);
        bCerrar.addActionListener(cPrincipal);
        comboOrigen.addActionListener(cPrincipal);
        comboDestino.addActionListener(cPrincipal);
        
        // Delegar control de Teclado a Controladora Principal
        bIniciarSesion.addKeyListener(cPrincipal);
        bRegistrarse.addKeyListener(cPrincipal);
        bMinimizar.addKeyListener(cPrincipal);
        bCerrar.addKeyListener(cPrincipal);
        comboOrigen.addKeyListener(cPrincipal);
        comboDestino.addKeyListener(cPrincipal);
        
        
        // Escuchar los eventos del teclado y mouse 
        this.addKeyListener(cPrincipal);
        this.addMouseListener(cPrincipal);
    }
    
    
    public void setModelo(Modelo modelo){
        this.modelo=modelo;
        this.modelo.addObserver(this);
    }
    
    
    public void slideShow() {
        
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            count++;
            cadena ="/Imagenes/"+count+".png";
            //icon = new ImageIcon(cadena);
            //iconScale=new ImageIcon(icon.getImage().getScaledInstance(lSlider.getWidth(), lSlider.getHeight(), java.awt.Image.SCALE_DEFAULT));
            lSlider.setIcon(new ImageIcon(getClass().getResource(cadena)));
            if (count == 6) {
                count = 0;
            }
        }
        }
        );
        timer.start();
    }



    public JComboBox<String> getcBxDestino() {
        return comboDestino;
    }

    public void setcBxDestino(JComboBox<String> cBxDestino) {
        this.comboDestino = cBxDestino;
    }

    public JComboBox<String> getcBxOrigen() {
        return comboOrigen;
    }

    public void setcBxOrigen(JComboBox<String> cBxOrigen) {
        this.comboOrigen = cBxOrigen;
    }

    public JPanel getPanelBuscar() {
        return panelBuscar;
    }

    public void setPanelBuscar(JPanel panelBuscar) {
        this.panelBuscar = panelBuscar;
    }

    public JPanel getPanelTabla() {
        return panelTabla;
    }

    public void setPanelTabla(JPanel panelTabla) {
        this.panelTabla = panelTabla;
    }

    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(JTable tablaDatos) {
        this.tablaDatos = tablaDatos;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
  

   
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bIniciarSesion = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        lTitulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        panelBuscar = new javax.swing.JPanel();
        lBuscar = new javax.swing.JLabel();
        lOrigen = new javax.swing.JLabel();
        comboDestino = new javax.swing.JComboBox<>();
        lOrigen1 = new javax.swing.JLabel();
        comboOrigen = new javax.swing.JComboBox<>();
        rayaBusqueda = new javax.swing.JLabel();
        bRegistrarse = new javax.swing.JButton();
        rayaTitulo = new javax.swing.JLabel();
        bCerrar = new javax.swing.JButton();
        lSlider = new javax.swing.JLabel();
        lTitulo = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        mBotones = new javax.swing.JLabel();
        lFondo = new javax.swing.JLabel();
        panelTitulo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bIniciarSesion.setBackground(new java.awt.Color(0, 0, 153));
        bIniciarSesion.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        bIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        bIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/looo.png"))); // NOI18N
        bIniciarSesion.setText("Iniciar Sesion");
        bIniciarSesion.setActionCommand("IniciarSesion");
        bIniciarSesion.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(bIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 210, 50));

        panelTabla.setBackground(new java.awt.Color(0, 102, 102));

        lTitulo1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        lTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitulo1.setText("VUELOS FILTRADOS");

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#Vuelo", "PaisOrigen", "PaisDestino", "FechaSalida", "FechaRegrego", "NPasajeros", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaDatos);
        if (tablaDatos.getColumnModel().getColumnCount() > 0) {
            tablaDatos.getColumnModel().getColumn(0).setResizable(false);
            tablaDatos.getColumnModel().getColumn(1).setResizable(false);
            tablaDatos.getColumnModel().getColumn(2).setResizable(false);
            tablaDatos.getColumnModel().getColumn(3).setResizable(false);
            tablaDatos.getColumnModel().getColumn(4).setResizable(false);
            tablaDatos.getColumnModel().getColumn(5).setResizable(false);
            tablaDatos.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(lTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lTitulo1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 720, 370));

        panelBuscar.setBackground(new java.awt.Color(244, 240, 240));
        panelBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 102)));

        lBuscar.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lBuscar.setForeground(new java.awt.Color(51, 51, 51));
        lBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airplane3.png"))); // NOI18N
        lBuscar.setText("Buscar vuelo");

        lOrigen.setBackground(new java.awt.Color(255, 255, 255));
        lOrigen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lOrigen.setForeground(new java.awt.Color(51, 51, 51));
        lOrigen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lOrigen.setText("Origen:");

        comboDestino.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        comboDestino.setForeground(new java.awt.Color(51, 51, 51));
        comboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "México", "Estados Unidos", "Panamá", "Brasil", "Costa Rica", "s" }));
        comboDestino.setActionCommand("comboD");
        comboDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDestinoActionPerformed(evt);
            }
        });

        lOrigen1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lOrigen1.setForeground(new java.awt.Color(51, 51, 51));
        lOrigen1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lOrigen1.setText("Destino:");

        comboOrigen.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        comboOrigen.setForeground(new java.awt.Color(51, 51, 51));
        comboOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No seleccionado", "Costa Rica", "México", "Estados Unidos", "Panamá", "Brasil" }));
        comboOrigen.setActionCommand("comboO");
        comboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrigenActionPerformed(evt);
            }
        });

        rayaBusqueda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 51)));

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lOrigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lOrigen1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(rayaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBuscarLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rayaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lOrigen)
                    .addComponent(comboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lOrigen1))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(panelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 720, 200));

        bRegistrarse.setBackground(new java.awt.Color(153, 153, 153));
        bRegistrarse.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        bRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        bRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reee.png"))); // NOI18N
        bRegistrarse.setText("Registrarse");
        bRegistrarse.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(bRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 210, 50));

        rayaTitulo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(rayaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 53, 720, 10));

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

        lSlider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        getContentPane().add(lSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 760, 370));

        lTitulo.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo.setText("AEORLINEA INFINITY SKY");
        getContentPane().add(lTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 640, 60));

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

        mBotones.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        getContentPane().add(mBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 230, 130));

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/s6.jpg"))); // NOI18N
        lFondo.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 1000, 710));
        getContentPane().add(panelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 660, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIniciarSesionActionPerformed
        

    }//GEN-LAST:event_bIniciarSesionActionPerformed

    private void bRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarseActionPerformed
        
    }//GEN-LAST:event_bRegistrarseActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_bCerrarActionPerformed

    private void comboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrigenActionPerformed

    private void bMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMinimizarActionPerformed

    private void comboDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDestinoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }

 
    
    
    
    private static int count;
    private String cadena;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bIniciarSesion;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bRegistrarse;
    private javax.swing.JComboBox<String> comboDestino;
    private javax.swing.JComboBox<String> comboOrigen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lBuscar;
    private javax.swing.JLabel lFondo;
    private javax.swing.JLabel lOrigen;
    private javax.swing.JLabel lOrigen1;
    private javax.swing.JLabel lSlider;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lTitulo1;
    private javax.swing.JLabel mBotones;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel rayaBusqueda;
    private javax.swing.JLabel rayaTitulo;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables

    
    
    @Override
    public void update(java.util.Observable updatedModel, Object param) {
         Modelo m = (Modelo) updatedModel;
         System.out.print("-> ojas ojas ojas "+m.getAccionVuelos()+"\n");
         if ("filtroOrigen".equals(m.getAccionPublico())) {
             System.out.print("-> ACTUALIZANDO LOS DATOSpor Origen\n");
             try {
                 this.mostrarListaDeAviones();
             } catch (NoDataException ex) {
                 this.mostrarExecpcion(ex.getMessage());
             }
         }else if ("filtroDestino".equals(m.getAccionPublico())) {
             System.out.print("-> ACTUALIZANDO LOS DATOSpor Origen\n");
             try {
                 this.mostrarListaDeAvionesDestino();
             } catch (NoDataException ex) {
                 this.mostrarExecpcion(ex.getMessage());
             }
         }
         
         
         else if ("consultarCliente".equals(m.getAccionVuelos())) {
             
         }
         else
         {
             System.out.print(" -> "+m.getAccionAviones()+" es diferente de : eliminarVuelo");
         }
         
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
       
    
//    public void mostrarListaVuelosDefectos()
//    {
//         ArrayList<LineaDetalleVuelo> al;
//        al = modelo.filtrarOrigen(this.seleccion);
//        if (al != null) {
//            DefaultTableModel tableModel = new DefaultTableModel();
//            String[] columnNames = {"#Vuelo", "PaisOrigen", "PaisDestino",
//                "Precio", "Fecha","Hora","NumVuelo"};// en las columnas van el tipo de dato...
//            tableModel.setColumnIdentifiers(columnNames);
//            Object[] fila = new Object[tableModel.getColumnCount()];
//            for (int i = 0; i < al.size(); i++) {
//
//                fila[0] = al.get(i).getIdentificacion();
//                fila[1] = al.get(i).getPaisOrigen();
//                fila[2] = al.get(i).getPaisDestino();
//                fila[3]=al.get(i).getDiaSalida()+"/"+
//                        al.get(i).getMesSalida()+
//                        "/"+al.get(i).getAnioSalida();
//                fila[4]=al.get(i).getDiaLlegada()+"/"+
//                        al.get(i).getAnioLlegada();
//                fila[5] = al.get(i).getCantidadPasajeros();
//                fila[6] = al.get(i).getHoraSalida();
//                
//                tableModel.addRow(fila);
//            }
//            this.tablaDatos.setModel(tableModel);
//        } else {
//            JOptionPane.showMessageDialog(null, "Consulta Invalida");
//        }
//    }
       
    public void mostrarListaDeAviones() throws NoDataException
    {
        ArrayList<LineaDetalleVuelo> al;
        al = modelo.filtrarOrigen(this.seleccion);
        if (al != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] columnNames = {"#Vuelo", "PaisOrigen", "PaisDestino",
                "Precio", "Fecha","Hora","NumVuelo"};// en las columnas van el tipo de dato...
            tableModel.setColumnIdentifiers(columnNames);
            Object[] fila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < al.size(); i++) {

                fila[0] = al.get(i).getIdentificacion();
                fila[1] = al.get(i).getPaisOrigen();
                fila[2] = al.get(i).getPaisDestino();
                fila[3]=al.get(i).getDiaSalida()+"/"+
                        al.get(i).getMesSalida()+
                        "/"+al.get(i).getAnioSalida();
                fila[4]=al.get(i).getDiaLlegada()+"/"+
                        al.get(i).getAnioLlegada();
                fila[5] = al.get(i).getCantidadPasajeros();
                fila[6] = al.get(i).getHoraSalida();
                
                tableModel.addRow(fila);
            }
            this.tablaDatos.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }
       
    
    
    
//    public void mostrarTablaInicio() throws NoDataException
//    {
//        ArrayList<LineaDetalleVuelo> al;
//        al = modelo.listarVuelos();
//        if (al != null) {
//            DefaultTableModel tableModel = new DefaultTableModel();
//            String[] columnNames = {"#Vuelo", "PaisOrigen", "PaisDestino",
//                "Precio", "Fecha","Hora","NumVuelo"};// en las columnas van el tipo de dato...
//            tableModel.setColumnIdentifiers(columnNames);
//            Object[] fila = new Object[tableModel.getColumnCount()];
//            for (int i = 0; i < al.size(); i++) {
//
//                fila[0] = al.get(i).getIdentificacion();
//                fila[1] = al.get(i).getPaisOrigen();
//                fila[2] = al.get(i).getPaisDestino();
//                fila[3] = al.get(i).getPrecio();
//                fila[4]=al.get(i).getDia()+"/"+
//                        al.get(i).getMes()+
//                        "/"+al.get(i).getAnio();
//                fila[5]=al.get(i).getHora();
//                fila[6] = al.get(i).getNumVuelo();
//                
//                tableModel.addRow(fila);
//            }
//            this.tablaHC.setModel(tableModel);
//        } else {
//            JOptionPane.showMessageDialog(null, "Consulta Invalida");
//        }
//        
//    }
//    
    
    String seleccion="";

    private void mostrarExecpcion(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarListaDeAvionesDestino() throws NoDataException {
       
        ArrayList<LineaDetalleVuelo> al;
        al = modelo.filtrarDestino(this.seleccion);
        if (al != null) {
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] columnNames = {"#Vuelo", "PaisOrigen", "PaisDestino",
                "Precio", "Fecha","Hora","NumVuelo"};// en las columnas van el tipo de dato...
            tableModel.setColumnIdentifiers(columnNames);
            Object[] fila = new Object[tableModel.getColumnCount()];
            for (int i = 0; i < al.size(); i++) {

                fila[0] = al.get(i).getIdentificacion();
                fila[1] = al.get(i).getPaisOrigen();
                fila[2] = al.get(i).getPaisDestino();
                fila[3]=al.get(i).getDiaSalida()+"/"+
                        al.get(i).getMesSalida()+
                        "/"+al.get(i).getAnioSalida();
                fila[4]=al.get(i).getDiaLlegada()+"/"+
                        al.get(i).getAnioLlegada();
                fila[5] = al.get(i).getCantidadPasajeros();
                fila[6] = al.get(i).getHoraSalida();
                
                tableModel.addRow(fila);
            }
            this.tablaDatos.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }

    
    
    
    
    }
