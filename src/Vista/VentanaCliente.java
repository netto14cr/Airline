/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraCliente;
import Excepciones.NoDataException;
import Modelo.LineaDetalleHistoricoCompras;
import Modelo.Modelo;
import java.util.ArrayList;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author netto
 */
public class VentanaCliente extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form VentanaAdministrador
     */
    
    
    ControladoraCliente cCliente;
    VentanaPrincipal vPrincipal;
    Modelo modelo;
    
    public VentanaCliente() {
        initComponents();
          this.otrosComponentes();
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelHistorialCompras.setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
      public void setControl(ControladoraCliente cCliente){
       this.cCliente=cCliente;
       
        // Delegar control de Mouse a Controladora Cliente
       
       bBusquedaVuelo.addMouseListener(cCliente);
       
       bHistorial.addMouseListener(cCliente);
       bDatosPersonales.addMouseListener(cCliente);
       bCerrar.addMouseListener(cCliente);
       bMinimizar.addMouseListener(cCliente);
       bSalir.addMouseListener(cCliente);
       panelHistorialCompras.addMouseListener(cCliente);
       tablaHC.addMouseListener(cCliente);
       
       
       
       // Delegar control de Accion a Controladora Cliente
       
       bBusquedaVuelo.addActionListener(cCliente);
       
       bHistorial.addActionListener(cCliente);
       bDatosPersonales.addActionListener(cCliente);
       bCerrar.addActionListener(cCliente);
       bMinimizar.addActionListener(cCliente);
       bSalir.addActionListener(cCliente);
       bOK1.addActionListener(cCliente);
       
       
       
       // Delegar control de Teclado a Controladora Cliente
       
       bBusquedaVuelo.addKeyListener(cCliente);
       
       bHistorial.addKeyListener(cCliente);
       bDatosPersonales.addKeyListener(cCliente);
       bCerrar.addKeyListener(cCliente);
       bSalir.addKeyListener(cCliente);
       bMinimizar.addKeyListener(cCliente);
       tablaHC.addKeyListener(cCliente);
       panelHistorialCompras.addKeyListener(cCliente);
       
       // Escuchar los eventos del teclado y mouse 
       this.addKeyListener(cCliente);
       this.addMouseListener(cCliente);
      }
      
      
       public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }
       

    public ControladoraCliente getcCliente() {
        return cCliente;
    }

    public void setcCliente(ControladoraCliente cCliente) {
        this.cCliente = cCliente;
    }

    public VentanaPrincipal getvPrincipal() {
        return vPrincipal;
    }

    public void setvPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    public JButton getbBusquedaVuelo() {
        return bBusquedaVuelo;
    }

    public void setbBusquedaVuelo(JButton bBusquedaVuelo) {
        this.bBusquedaVuelo = bBusquedaVuelo;
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public void setbCerrar(JButton bCerrar) {
        this.bCerrar = bCerrar;
    }

    public JButton getbDatosPersonales() {
        return bDatosPersonales;
    }

    public void setbDatosPersonales(JButton bDatosPersonales) {
        this.bDatosPersonales = bDatosPersonales;
    }

    public JButton getbHistorial() {
        return bHistorial;
    }

    public void setbHistorial(JButton bHistorial) {
        this.bHistorial = bHistorial;
    }

    public JButton getbMinimizar() {
        return bMinimizar;
    }

    public void setbMinimizar(JButton bMinimizar) {
        this.bMinimizar = bMinimizar;
    }


    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }


    public JMenu getjMenu1() {
        return jMenu1;
    }

    public void setjMenu1(JMenu jMenu1) {
        this.jMenu1 = jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public void setjMenu2(JMenu jMenu2) {
        this.jMenu2 = jMenu2;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
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


    public JButton getbOK1() {
        return bOK1;
    }

    public void setbOK1(JButton bOK1) {
        this.bOK1 = bOK1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JPanel getPanelHistorialCompras() {
        return panelHistorialCompras;
    }

    public void setPanelHistorialCompras(JPanel panelHistorialCompras) {
        this.panelHistorialCompras = panelHistorialCompras;
    }

    public JTable getTablaHC() {
        return tablaHC;
    }

    public void setTablaHC(JTable tablaHC) {
        this.tablaHC = tablaHC;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panelHistorialCompras = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaHC = new javax.swing.JTable();
        bOK1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bDatosPersonales = new javax.swing.JButton();
        bBusquedaVuelo = new javax.swing.JButton();
        bHistorial = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lAdministrador = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();
        bMinimizar = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHistorialCompras.setBackground(new java.awt.Color(51, 51, 51));
        panelHistorialCompras.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 255)));
        panelHistorialCompras.setPreferredSize(new java.awt.Dimension(650, 500));
        panelHistorialCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaHC.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#Vuelo", "PaisOrigen", "PaisDestino", "Precio", "Fecha", "Hora", "NumVuelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaHC);
        if (tablaHC.getColumnModel().getColumnCount() > 0) {
            tablaHC.getColumnModel().getColumn(0).setResizable(false);
            tablaHC.getColumnModel().getColumn(1).setResizable(false);
            tablaHC.getColumnModel().getColumn(2).setResizable(false);
            tablaHC.getColumnModel().getColumn(3).setResizable(false);
            tablaHC.getColumnModel().getColumn(4).setResizable(false);
            tablaHC.getColumnModel().getColumn(5).setResizable(false);
            tablaHC.getColumnModel().getColumn(6).setResizable(false);
        }

        panelHistorialCompras.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 890, 300));

        bOK1.setBackground(new java.awt.Color(255, 255, 255));
        bOK1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bOK1.setForeground(new java.awt.Color(51, 0, 102));
        bOK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ok.png"))); // NOI18N
        bOK1.setText("ACEPTAR");
        bOK1.setActionCommand("oK");
        bOK1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 102)));
        bOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOK1ActionPerformed(evt);
            }
        });
        panelHistorialCompras.add(bOK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 220, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51)));

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/h2.png"))); // NOI18N
        jLabel2.setText("Historial de compras ");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel2);

        panelHistorialCompras.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 440, 80));

        getContentPane().add(panelHistorialCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 920, -1));

        bDatosPersonales.setBackground(new java.awt.Color(255, 255, 255));
        bDatosPersonales.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bDatosPersonales.setForeground(new java.awt.Color(0, 102, 102));
        bDatosPersonales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dates.png"))); // NOI18N
        bDatosPersonales.setText("Modificar datos personales");
        bDatosPersonales.setActionCommand("mDP");
        bDatosPersonales.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        bDatosPersonales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDatosPersonalesActionPerformed(evt);
            }
        });
        getContentPane().add(bDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 420, 80));

        bBusquedaVuelo.setBackground(new java.awt.Color(255, 255, 255));
        bBusquedaVuelo.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bBusquedaVuelo.setForeground(new java.awt.Color(0, 102, 102));
        bBusquedaVuelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airpplane.png"))); // NOI18N
        bBusquedaVuelo.setText("Busqueda y consulta vuelos");
        bBusquedaVuelo.setActionCommand("bCV");
        bBusquedaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        bBusquedaVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBusquedaVueloActionPerformed(evt);
            }
        });
        getContentPane().add(bBusquedaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 420, 80));

        bHistorial.setBackground(new java.awt.Color(255, 255, 255));
        bHistorial.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bHistorial.setForeground(new java.awt.Color(0, 102, 102));
        bHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/h2.png"))); // NOI18N
        bHistorial.setText("Mostrar historial de compras");
        bHistorial.setActionCommand("mHC");
        bHistorial.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        bHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHistorialActionPerformed(evt);
            }
        });
        getContentPane().add(bHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 420, 80));

        bCerrar.setBackground(new java.awt.Color(255, 255, 255));
        bCerrar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bCerrar.setForeground(new java.awt.Color(0, 102, 102));
        bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ssss.png"))); // NOI18N
        bCerrar.setText("Salir y cerrar sesion");
        bCerrar.setActionCommand("CerrarSesion");
        bCerrar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));
        bCerrar.setName("CerrarSesion"); // NOI18N
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 420, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 102, 102)));

        lAdministrador.setFont(new java.awt.Font("Elephant", 0, 48)); // NOI18N
        lAdministrador.setForeground(new java.awt.Color(0, 102, 102));
        lAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mac.png"))); // NOI18N
        lAdministrador.setText("Cliente");
        jPanel1.add(lAdministrador);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 550, 80));

        bSalir.setBackground(new java.awt.Color(255, 0, 0));
        bSalir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bSalir.setForeground(new java.awt.Color(255, 255, 255));
        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        bSalir.setActionCommand("Salir");
        bSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        getContentPane().add(bSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 30, 30));

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

        lFondo.setBackground(new java.awt.Color(255, 255, 255));
        lFondo.setForeground(new java.awt.Color(102, 102, 102));
        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/A6.png"))); // NOI18N
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bDatosPersonalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDatosPersonalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bDatosPersonalesActionPerformed

    private void bHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bHistorialActionPerformed

    private void bBusquedaVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBusquedaVueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBusquedaVueloActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed

    }//GEN-LAST:event_bCerrarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSalirActionPerformed

    private void bMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMinimizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMinimizarActionPerformed

    private void bOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bOK1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBusquedaVuelo;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bDatosPersonales;
    private javax.swing.JButton bHistorial;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bOK1;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lAdministrador;
    private javax.swing.JLabel lFondo;
    private javax.swing.JPanel panelHistorialCompras;
    private javax.swing.JTable tablaHC;
    // End of variables declaration//GEN-END:variables

    public void setIdentificacion(String identificacion) {
        this.identificacion=identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    String identificacion="";

    public void mostrarExecpcion(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
      @Override
    public void update(java.util.Observable updatedModel, Object param) {
         Modelo m = (Modelo) updatedModel;
         System.out.print("-> ojas ojas ojas "+m.getAccionVuelos()+"\n");
         if ("eliminarCliente".equals(m.getAccionCliente())) {
             System.out.print("-> ACTUALIZANDO LOS DATOS \n");
             try {
                 this.mostrarTablaHistorico();
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
       
       
       
    public void mostrarTablaHistorico() throws NoDataException
    {
        ArrayList<LineaDetalleHistoricoCompras> al;
        al = modelo.listarHistorico(this.getIdentificacion());
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
                fila[3] = al.get(i).getPrecio();
                fila[4]=al.get(i).getDia()+"/"+
                        al.get(i).getMes()+
                        "/"+al.get(i).getAnio();
                fila[5]=al.get(i).getHora();
                fila[6] = al.get(i).getNumVuelo();
                
                tableModel.addRow(fila);
            }
            this.tablaHC.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }
       
    
    
    
    public void mostrarTablaInicio() throws NoDataException
    {
        ArrayList<LineaDetalleHistoricoCompras> al;
        al = modelo.listarTodo();
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
                fila[3] = al.get(i).getPrecio();
                fila[4]=al.get(i).getDia()+"/"+
                        al.get(i).getMes()+
                        "/"+al.get(i).getAnio();
                fila[5]=al.get(i).getHora();
                fila[6] = al.get(i).getNumVuelo();
                
                tableModel.addRow(fila);
            }
            this.tablaHC.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(null, "Consulta Invalida");
        }
    }
    
    
       
    
    
    
}
