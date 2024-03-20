/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraAdministrador;
import Modelo.Modelo;
import javax.swing.WindowConstants;

/**
 *
 * @author Netto
 */
public class VentanaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdministrador
     */
    
    VentanaPrincipal vPrincipal;
    Modelo modelo;
    ControladoraAdministrador cAdmin;
    
    public VentanaAdministrador() {
        initComponents();
        this.otrosComponentes();
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
   public void setControl(ControladoraAdministrador cAdmin){
       this.cAdmin=cAdmin;
       
       // Delegar control de Mouse a Controladora Admin
       bTipoAviones.addMouseListener(cAdmin);
       bTipoAviones1.addMouseListener(cAdmin);
       bTipoAviones2.addMouseListener(cAdmin);
       bTipoAviones3.addMouseListener(cAdmin);
       bTipoAviones4.addMouseListener(cAdmin);
       bCerrar.addMouseListener(cAdmin);
       bMinimizar.addMouseListener(cAdmin);
       bSalir.addMouseListener(cAdmin);
       
       // Delegar control de Accion a Controladora Admin
       bTipoAviones.addActionListener(cAdmin);
       bTipoAviones1.addActionListener(cAdmin);
       bTipoAviones2.addActionListener(cAdmin);
       bTipoAviones3.addActionListener(cAdmin);
       bTipoAviones4.addActionListener(cAdmin);
       bCerrar.addActionListener(cAdmin);
       bMinimizar.addActionListener(cAdmin);
       bSalir.addActionListener(cAdmin);
       
       // Delegar control de Teclado a Controladora Admin
       bTipoAviones.addKeyListener(cAdmin);
       bTipoAviones1.addKeyListener(cAdmin);
       bTipoAviones2.addKeyListener(cAdmin);
       bTipoAviones3.addKeyListener(cAdmin);
       bTipoAviones4.addKeyListener(cAdmin);
       bCerrar.addKeyListener(cAdmin);
       bSalir.addKeyListener(cAdmin);
       bMinimizar.addKeyListener(cAdmin);
       
       // Escuchar los eventos del teclado y mouse 
       this.addKeyListener(cAdmin);
       this.addMouseListener(cAdmin);
       
       
    }
   
    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCerrar = new javax.swing.JButton();
        bTipoAviones = new javax.swing.JButton();
        bTipoAviones1 = new javax.swing.JButton();
        bTipoAviones2 = new javax.swing.JButton();
        bTipoAviones3 = new javax.swing.JButton();
        bTipoAviones4 = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lAdministrador = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bCerrar.setBackground(new java.awt.Color(255, 255, 255));
        bCerrar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bCerrar.setForeground(new java.awt.Color(51, 0, 102));
        bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exitS.png"))); // NOI18N
        bCerrar.setText("Cerrar sesion");
        bCerrar.setActionCommand("CerrarSesion");
        bCerrar.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 102)));
        bCerrar.setName("CerrarSesion"); // NOI18N
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 420, 80));

        bTipoAviones.setBackground(new java.awt.Color(255, 255, 255));
        bTipoAviones.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bTipoAviones.setForeground(new java.awt.Color(51, 0, 102));
        bTipoAviones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/horario.png"))); // NOI18N
        bTipoAviones.setText("Registro administrador");
        bTipoAviones.setActionCommand("mHorarios");
        bTipoAviones.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 102)));
        bTipoAviones.setName("mHorarios"); // NOI18N
        bTipoAviones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTipoAvionesActionPerformed(evt);
            }
        });
        getContentPane().add(bTipoAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 420, 80));

        bTipoAviones1.setBackground(new java.awt.Color(255, 255, 255));
        bTipoAviones1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bTipoAviones1.setForeground(new java.awt.Color(51, 0, 102));
        bTipoAviones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report.png"))); // NOI18N
        bTipoAviones1.setText("Editar datos administrador");
        bTipoAviones1.setActionCommand("rWeb");
        bTipoAviones1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 51)));
        bTipoAviones1.setName("rWeb"); // NOI18N
        bTipoAviones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTipoAviones1ActionPerformed(evt);
            }
        });
        getContentPane().add(bTipoAviones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 420, 80));

        bTipoAviones2.setBackground(new java.awt.Color(255, 255, 255));
        bTipoAviones2.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bTipoAviones2.setForeground(new java.awt.Color(51, 0, 102));
        bTipoAviones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maps.png"))); // NOI18N
        bTipoAviones2.setText("Modificar rutas");
        bTipoAviones2.setActionCommand("mRutas");
        bTipoAviones2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 102)));
        bTipoAviones2.setName("mRutas"); // NOI18N
        bTipoAviones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTipoAviones2ActionPerformed(evt);
            }
        });
        getContentPane().add(bTipoAviones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 420, 80));

        bTipoAviones3.setBackground(new java.awt.Color(255, 255, 255));
        bTipoAviones3.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bTipoAviones3.setForeground(new java.awt.Color(51, 0, 102));
        bTipoAviones3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tipoAvion.png"))); // NOI18N
        bTipoAviones3.setText("Modificar vuelos");
        bTipoAviones3.setActionCommand("mTipoAvion");
        bTipoAviones3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 102)));
        bTipoAviones3.setName("mTipoAvion"); // NOI18N
        bTipoAviones3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTipoAviones3ActionPerformed(evt);
            }
        });
        getContentPane().add(bTipoAviones3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 420, 80));

        bTipoAviones4.setBackground(new java.awt.Color(255, 255, 255));
        bTipoAviones4.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        bTipoAviones4.setForeground(new java.awt.Color(51, 0, 102));
        bTipoAviones4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/airplane.png"))); // NOI18N
        bTipoAviones4.setText("Modificar aviones");
        bTipoAviones4.setActionCommand("mAviones");
        bTipoAviones4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(51, 0, 102)));
        bTipoAviones4.setName("mAviones"); // NOI18N
        bTipoAviones4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTipoAviones4ActionPerformed(evt);
            }
        });
        getContentPane().add(bTipoAviones4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 420, 80));

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51)));

        lAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        lAdministrador.setFont(new java.awt.Font("Elephant", 0, 48)); // NOI18N
        lAdministrador.setForeground(new java.awt.Color(102, 0, 153));
        lAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/admin.png"))); // NOI18N
        lAdministrador.setText("Administrador");
        jPanel1.add(lAdministrador);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 550, 80));

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
        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tA4.jpg"))); // NOI18N
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
       
    }//GEN-LAST:event_bCerrarActionPerformed

    private void bTipoAviones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTipoAviones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTipoAviones1ActionPerformed

    private void bTipoAviones3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTipoAviones3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTipoAviones3ActionPerformed

    private void bTipoAviones4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTipoAviones4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTipoAviones4ActionPerformed

    private void bTipoAviones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTipoAviones2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTipoAviones2ActionPerformed

    private void bTipoAvionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTipoAvionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTipoAvionesActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSalirActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bTipoAviones;
    private javax.swing.JButton bTipoAviones1;
    private javax.swing.JButton bTipoAviones2;
    private javax.swing.JButton bTipoAviones3;
    private javax.swing.JButton bTipoAviones4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lAdministrador;
    private javax.swing.JLabel lFondo;
    // End of variables declaration//GEN-END:variables
}
