/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

//import Controlador.ControladorLogin;
//import Controlador.ControladorPrincipal;
import Controladora.ControladorLogin;
import Modelo.Modelo;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




/**
 *
 * @author netto
 */
public class VentanaLogin extends javax.swing.JFrame{

    /**
     * Creates new form VentanaLogin
     */
    
    
    
    //  Declaracion de Clases
    ControladorLogin cLogin;
    Modelo modelo;
    VentanaPrincipal vPrincipal;
    VentanaAdministrador vAdministrador;
    VentanaCliente vCliente;
    
    
    
    //  Declaracion de variables
    TextPrompt mensajeFondo; 
   
    
    //ControladorLogin cLogin;  // No se implementa por el momento
    public VentanaLogin() {
        initComponents();
        this.otrosComponentes();
    }

    public void otrosComponentes() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.panelPruebas.setVisible(false);
        this.agregarMensajeFondo();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
                  
   public void agregarMensajeFondo(){
        mensajeFondo=new TextPrompt("Usuario", txtUsuario);
        mensajeFondo.setForeground(Color.BLACK);
        mensajeFondo=new TextPrompt("Contraseña", txtPassword);
        mensajeFondo.setForeground(Color.BLACK);
   }
   
   public void setControl(ControladorLogin cLogin){
       this.cLogin=cLogin;
       
       // Delegar control de Mouse a ControladoraLogin
       bLoguear.addMouseListener(cLogin);
       bMinimizar.addMouseListener(cLogin);
       bCerrar.addMouseListener(cLogin);
       bAtras.addMouseListener(cLogin);
       
       // Delegar control de Accion a ControladoraLogin
       bLoguear.addActionListener(cLogin);
       bMinimizar.addActionListener(cLogin);
       bCerrar.addActionListener(cLogin);
       bAtras.addActionListener(cLogin);
       
       
       // PRUEBAS---
       bLoguear1.addActionListener(cLogin);
       bLoguear2.addActionListener(cLogin);
       
       // Delegar control de Teclado a ControladoraLogin
       bLoguear.addKeyListener(cLogin);
       bMinimizar.addKeyListener(cLogin);
       bCerrar.addKeyListener(cLogin);
       bAtras.addKeyListener(cLogin);
       
       // Escuchar los eventos del teclado y mouse 
       this.addKeyListener(cLogin);
       this.addMouseListener(cLogin);
    }
   
  
    public void setModelo(Modelo modelo){
        this.modelo=modelo;
    }

    public ControladorLogin getcLogin() {
        return cLogin;
    }

    public void setcLogin(ControladorLogin cLogin) {
        this.cLogin = cLogin;
    }

    public VentanaPrincipal getvPrincipal() {
        return vPrincipal;
    }

    public void setvPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    public VentanaAdministrador getvAdministrador() {
        return vAdministrador;
    }

    public void setvAdministrador(VentanaAdministrador vAdministrador) {
        this.vAdministrador = vAdministrador;
    }

    public VentanaCliente getvCliente() {
        return vCliente;
    }

    public void setvCliente(VentanaCliente vCliente) {
        this.vCliente = vCliente;
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

    public JButton getbCerrar() {
        return bCerrar;
    }

    public void setbCerrar(JButton bCerrar) {
        this.bCerrar = bCerrar;
    }

    public JButton getbLoguear() {
        return bLoguear;
    }

    public void setbLoguear(JButton bLoguear) {
        this.bLoguear = bLoguear;
    }


    public JLabel getlFondo() {
        return lFondo;
    }

    public void setlFondo(JLabel lFondo) {
        this.lFondo = lFondo;
    }

    public JLabel getlTituloIniciarSesion() {
        return lTituloIniciarSesion;
    }

    public void setlTituloIniciarSesion(JLabel lTituloIniciarSesion) {
        this.lTituloIniciarSesion = lTituloIniciarSesion;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public JButton getbLoguear1() {
        return bLoguear1;
    }

    public void setbLoguear1(JButton bLoguear1) {
        this.bLoguear1 = bLoguear1;
    }

    public JButton getbLoguear2() {
        return bLoguear2;
    }

    public void setbLoguear2(JButton bLoguear2) {
        this.bLoguear2 = bLoguear2;
    }

    public JButton getbMinimizar() {
        return bMinimizar;
    }

    public void setbMinimizar(JButton bMinimizar) {
        this.bMinimizar = bMinimizar;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getlTituloIniciarSesion1() {
        return lTituloIniciarSesion1;
    }

    public void setlTituloIniciarSesion1(JLabel lTituloIniciarSesion1) {
        this.lTituloIniciarSesion1 = lTituloIniciarSesion1;
    }

    public JPanel getPanelPruebas() {
        return panelPruebas;
    }

    public void setPanelPruebas(JPanel panelPruebas) {
        this.panelPruebas = panelPruebas;
    }
    
    
   
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        bLoguear = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();
        bAtras = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        panelPruebas = new javax.swing.JPanel();
        lTituloIniciarSesion1 = new javax.swing.JLabel();
        bLoguear1 = new javax.swing.JButton();
        bLoguear2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lTituloIniciarSesion = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(231, 225, 225));
        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 250, 39));

        bLoguear.setBackground(new java.awt.Color(255, 255, 255));
        bLoguear.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        bLoguear.setForeground(new java.awt.Color(0, 0, 102));
        bLoguear.setText("Iniciar sesión");
        bLoguear.setActionCommand("IniciarSesion");
        bLoguear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        bLoguear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoguearActionPerformed(evt);
            }
        });
        getContentPane().add(bLoguear, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 250, 50));

        txtPassword.setBackground(new java.awt.Color(231, 225, 225));
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 250, 38));

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
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 30, 30));

        panelPruebas.setBackground(new java.awt.Color(255, 255, 255));
        panelPruebas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 51)));

        lTituloIniciarSesion1.setFont(new java.awt.Font("Engravers MT", 1, 18)); // NOI18N
        lTituloIniciarSesion1.setForeground(new java.awt.Color(0, 0, 0));
        lTituloIniciarSesion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloIniciarSesion1.setText("PRUEBAS");
        panelPruebas.add(lTituloIniciarSesion1);

        bLoguear1.setBackground(new java.awt.Color(51, 0, 51));
        bLoguear1.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        bLoguear1.setForeground(new java.awt.Color(255, 255, 255));
        bLoguear1.setText("ADMIN");
        bLoguear1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 51)));
        bLoguear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoguear1ActionPerformed(evt);
            }
        });
        panelPruebas.add(bLoguear1);

        bLoguear2.setBackground(new java.awt.Color(0, 102, 102));
        bLoguear2.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        bLoguear2.setForeground(new java.awt.Color(255, 255, 255));
        bLoguear2.setText("CLIENTE");
        bLoguear2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        bLoguear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoguear2ActionPerformed(evt);
            }
        });
        panelPruebas.add(bLoguear2);

        getContentPane().add(panelPruebas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 190, 70));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));

        lTituloIniciarSesion.setFont(new java.awt.Font("Engravers MT", 1, 24)); // NOI18N
        lTituloIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        lTituloIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTituloIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/client3.png"))); // NOI18N
        lTituloIniciarSesion.setText("Iniciar Sesion");
        lTituloIniciarSesion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lTituloIniciarSesion);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 370, 60));

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

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/s3.jpg"))); // NOI18N
        getContentPane().add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoguearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoguearActionPerformed
        
//        if (clienteUserDefault.equalsIgnoreCase(txtUsuario.getText()) 
//                && clientePassDefault.equalsIgnoreCase(txtPassword.getText()))
//                {
//                    vCliente=new VentanaCliente();
//                    vCliente.setVisible(true);
//                    dispose();
//                }
//                
//                else if (rootUser.equalsIgnoreCase(txtUsuario.getText()) 
//                && rootPassword.equalsIgnoreCase(txtPassword.getText()))
//                 {
//                    vAdministrador=new VentanaAdministrador();
//                    vAdministrador.setVisible(true);
//                    dispose();
//                 }
//                else if ("".equalsIgnoreCase(txtUsuario.getText()) 
//                && "".equalsIgnoreCase(txtPassword.getText()))
//                {
//                    JOptionPane.showMessageDialog(null, "No te pases de list@,\n"
//                    + "no puedes dejar los campos en blanco!");
//                    
//                }
//                
//                
//                else{
//                    JOptionPane.showMessageDialog(null, "Nombre se usuario o contraseña invalidos,\n"
//                    + "por favor intente de nuevo!");
//                    txtUsuario.setText("");
//                    txtPassword.setText("");
//                    
//                }
        

    }//GEN-LAST:event_bLoguearActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
      
        
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_bCerrarActionPerformed

    private void bLoguear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoguear1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLoguear1ActionPerformed

    private void bLoguear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoguear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bLoguear2ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               
            }
        });
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bLoguear;
    private javax.swing.JButton bLoguear1;
    private javax.swing.JButton bLoguear2;
    private javax.swing.JButton bMinimizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lFondo;
    private javax.swing.JLabel lTituloIniciarSesion;
    private javax.swing.JLabel lTituloIniciarSesion1;
    private javax.swing.JPanel panelPruebas;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
