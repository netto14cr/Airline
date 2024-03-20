/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraRegistroCliente;
import Modelo.Cliente;
import Modelo.Modelo;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.util.Set;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author netto
 */
public class VentanaRegistroCliente extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    ControladoraRegistroCliente cReg;
    Modelo modelo;
    VentanaPrincipal vPrincipal;
    TextPrompt mensajeFondo; 
    public VentanaRegistroCliente() {
        initComponents();
        this.otrosComponentes();
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.agregarMensajeFondo();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void agregarMensajeFondo(){
        mensajeFondo=new TextPrompt("Nombre", txtNombre);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Primer apellido", txtApellido1);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Segundo apellido", txtApellido2);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Identificación", txtIdentificacion);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Correo electronico", txtCorreo);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Contraseña", txtPassword);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Direccion", taDireecion);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Telefono Trabajo", txtTtrabajo);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Telefono Celular", txtTCelular);
        mensajeFondo.setForeground(Color.BLACK);
        
    }
    
   
   public void setControl(ControladoraRegistroCliente cReg){
       this.cReg=cReg;
       
       // Delegar control de Mouse a Controladora Registro
       bCompletar.addMouseListener(cReg);
       bCancelar.addMouseListener(cReg);
       bFecha.addMouseListener(cReg);
       bAtras.addMouseListener(cReg);
       bCerrar.addMouseListener(cReg);
       bMinimizar.addMouseListener(cReg);
       
       // Delegar control de Accion a Controladora Registro
       bCompletar.addActionListener(cReg);
       bCancelar.addActionListener(cReg);
       bAtras.addActionListener(cReg);
       bCerrar.addActionListener(cReg);
       bMinimizar.addActionListener(cReg);
      
       
       // Delegar control de Teclado a Controladora Registro
       bCompletar.addKeyListener(cReg);
       bCancelar.addKeyListener(cReg);
       bAtras.addKeyListener(cReg);
       bCerrar.addKeyListener(cReg);
       bMinimizar.addKeyListener(cReg);
       
       // Escuchar los eventos del teclado y mouse 
       this.addMouseListener(cReg);
       this.addKeyListener(cReg);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtNombre = new javax.swing.JTextField();
        lNombre = new javax.swing.JLabel();
        lApellido1 = new javax.swing.JLabel();
        lApellido2 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        lCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lPassword = new javax.swing.JLabel();
        lApellido5 = new javax.swing.JLabel();
        lFechaNac = new javax.swing.JLabel();
        bFecha = new com.toedter.calendar.JDateChooser();
        bCompletar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lRegistro = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        txtTCelular = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTtrabajo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDireecion = new javax.swing.JTextArea();
        txtIdentificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lFondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setName("ventanaPrincipal"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(51, 51, 51));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 300, 30));

        lNombre.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lNombre.setForeground(new java.awt.Color(255, 255, 255));
        lNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNombre.setText("Nombre:");
        getContentPane().add(lNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 120, -1));

        lApellido1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lApellido1.setForeground(new java.awt.Color(255, 255, 255));
        lApellido1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lApellido1.setText("Primer apellido:");
        getContentPane().add(lApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 200, 32));

        lApellido2.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lApellido2.setForeground(new java.awt.Color(255, 255, 255));
        lApellido2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lApellido2.setText("Segundo apellido:");
        getContentPane().add(lApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, 32));

        txtApellido2.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtApellido2.setForeground(new java.awt.Color(51, 51, 51));
        txtApellido2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 300, 30));

        txtApellido1.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtApellido1.setForeground(new java.awt.Color(51, 51, 51));
        txtApellido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 300, 30));

        lCorreo.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lCorreo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lCorreo.setText("Correo electronico:");
        getContentPane().add(lCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, 32));

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 300, 30));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 300, 30));

        lPassword.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lPassword.setForeground(new java.awt.Color(255, 255, 255));
        lPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lPassword.setText("Contraseña:");
        getContentPane().add(lPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, 32));

        lApellido5.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lApellido5.setForeground(new java.awt.Color(255, 255, 255));
        lApellido5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lApellido5.setText("Direccion:");
        getContentPane().add(lApellido5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, 40));

        lFechaNac.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lFechaNac.setText("Fecha nacimento:");
        getContentPane().add(lFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, 40));

        bFecha.setBackground(new java.awt.Color(255, 255, 255));
        bFecha.setForeground(new java.awt.Color(51, 51, 51));
        bFecha.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        getContentPane().add(bFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 300, 30));

        bCompletar.setBackground(new java.awt.Color(255, 255, 255));
        bCompletar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bCompletar.setForeground(new java.awt.Color(0, 0, 51));
        bCompletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check.png"))); // NOI18N
        bCompletar.setText("Completar");
        bCompletar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 51)));
        bCompletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCompletarActionPerformed(evt);
            }
        });
        getContentPane().add(bCompletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 230, 70));

        bCancelar.setBackground(new java.awt.Color(0, 0, 51));
        bCancelar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        bCancelar.setForeground(new java.awt.Color(255, 255, 255));
        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/canc.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 230, 70));

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
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51), new java.awt.Color(51, 0, 51)));

        lRegistro.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lRegistro.setForeground(new java.awt.Color(51, 51, 51));
        lRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/passport.png"))); // NOI18N
        lRegistro.setText("Registro cliente");
        jPanel1.add(lRegistro);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 440, 80));

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

        txtTCelular.setBackground(new java.awt.Color(255, 255, 255));
        txtTCelular.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTCelular.setForeground(new java.awt.Color(51, 51, 51));
        txtTCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTCelular.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(txtTCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, 300, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Telefono celular:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 260, -1));

        txtTtrabajo.setBackground(new java.awt.Color(255, 255, 255));
        txtTtrabajo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtTtrabajo.setForeground(new java.awt.Color(51, 51, 51));
        txtTtrabajo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTtrabajo.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(txtTtrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 300, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Telefono trabajo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 260, -1));

        taDireecion.setBackground(new java.awt.Color(255, 255, 255));
        taDireecion.setColumns(20);
        taDireecion.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        taDireecion.setForeground(new java.awt.Color(51, 51, 51));
        taDireecion.setRows(5);
        taDireecion.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setViewportView(taDireecion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 300, 60));

        txtIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtIdentificacion.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        txtIdentificacion.setForeground(new java.awt.Color(51, 51, 51));
        txtIdentificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 300, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Identificacion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 240, 30));

        lFondo2.setBackground(new java.awt.Color(51, 51, 51));
        lFondo2.setForeground(new java.awt.Color(255, 255, 255));
        lFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/A3.jpg"))); // NOI18N
        lFondo2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(lFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1ActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void bCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCompletarActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_bCompletarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new VentanaRegistroCliente().setVisible(true);
        });
    }

    public ControladoraRegistroCliente getcReg() {
        return cReg;
    }

    public void setcReg(ControladoraRegistroCliente cReg) {
        this.cReg = cReg;
    }

    public VentanaPrincipal getvPrincipal() {
        return vPrincipal;
    }

    public void setvPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    public TextPrompt getMensajeFondo() {
        return mensajeFondo;
    }

    public void setMensajeFondo(TextPrompt mensajeFondo) {
        this.mensajeFondo = mensajeFondo;
    }

    public JButton getbAtras() {
        return bAtras;
    }

    public void setbAtras(JButton bAtras) {
        this.bAtras = bAtras;
    }

    public JButton getbCancelar() {
        return bCancelar;
    }

    public void setbCancelar(JButton bCancelar) {
        this.bCancelar = bCancelar;
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public void setbCerrar(JButton bCerrar) {
        this.bCerrar = bCerrar;
    }

    public JButton getbCompletar() {
        return bCompletar;
    }

    public void setbCompletar(JButton bCompletar) {
        this.bCompletar = bCompletar;
    }

    public JDateChooser getbFecha() {
        return bFecha;
    }

    public void setbFecha(JDateChooser bFecha) {
        this.bFecha = bFecha;
    }

   

    public JButton getbMinimizar() {
        return bMinimizar;
    }

    public void setbMinimizar(JButton bMinimizar) {
        this.bMinimizar = bMinimizar;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getlApellido1() {
        return lApellido1;
    }

    public void setlApellido1(JLabel lApellido1) {
        this.lApellido1 = lApellido1;
    }

    public JLabel getlApellido2() {
        return lApellido2;
    }

    public void setlApellido2(JLabel lApellido2) {
        this.lApellido2 = lApellido2;
    }

    public JLabel getlApellido5() {
        return lApellido5;
    }

    public void setlApellido5(JLabel lApellido5) {
        this.lApellido5 = lApellido5;
    }

    public JLabel getlCorreo() {
        return lCorreo;
    }

    public void setlCorreo(JLabel lCorreo) {
        this.lCorreo = lCorreo;
    }

    public JLabel getlFechaNac() {
        return lFechaNac;
    }

    public void setlFechaNac(JLabel lFechaNac) {
        this.lFechaNac = lFechaNac;
    }

    public JLabel getlFondo2() {
        return lFondo2;
    }

    public void setlFondo2(JLabel lFondo2) {
        this.lFondo2 = lFondo2;
    }

    public JLabel getlNombre() {
        return lNombre;
    }

    public void setlNombre(JLabel lNombre) {
        this.lNombre = lNombre;
    }

    public JLabel getlPassword() {
        return lPassword;
    }

    public void setlPassword(JLabel lPassword) {
        this.lPassword = lPassword;
    }

    public JLabel getlRegistro() {
        return lRegistro;
    }

    public void setlRegistro(JLabel lRegistro) {
        this.lRegistro = lRegistro;
    }

    public JTextArea getTaDireecion() {
        return taDireecion;
    }

    public void setTaDireecion(JTextArea taDireecion) {
        this.taDireecion = taDireecion;
    }

    public JTextField getTxtApellido1() {
        return txtApellido1;
    }

    public void setTxtApellido1(JTextField txtApellido1) {
        this.txtApellido1 = txtApellido1;
    }

    public JTextField getTxtApellido2() {
        return txtApellido2;
    }

    public void setTxtApellido2(JTextField txtApellido2) {
        this.txtApellido2 = txtApellido2;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JTextField getTxtTCelular() {
        return txtTCelular;
    }

    public void setTxtTCelular(JTextField txtTCelular) {
        this.txtTCelular = txtTCelular;
    }

    public JTextField getTxtTtrabajo() {
        return txtTtrabajo;
    }

    public void setTxtTtrabajo(JTextField txtTtrabajo) {
        this.txtTtrabajo = txtTtrabajo;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JTextField getTxtIdentificacion() {
        return txtIdentificacion;
    }

    public void setTxtIdentificacion(JTextField txtIdentificacion) {
        this.txtIdentificacion = txtIdentificacion;
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bCompletar;
    private com.toedter.calendar.JDateChooser bFecha;
    private javax.swing.JButton bMinimizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lApellido1;
    private javax.swing.JLabel lApellido2;
    private javax.swing.JLabel lApellido5;
    private javax.swing.JLabel lCorreo;
    private javax.swing.JLabel lFechaNac;
    private javax.swing.JLabel lFondo2;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lRegistro;
    private javax.swing.JTextArea taDireecion;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTCelular;
    private javax.swing.JTextField txtTtrabajo;
    // End of variables declaration//GEN-END:variables
}
