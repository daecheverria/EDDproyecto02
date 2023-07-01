/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import EDD.ArbolB;
import EDD.NodoABB;


/**
 *
 * @author Maria
 */
public class Busq_Reservacion extends javax.swing.JFrame {

    public static Menu v1;
    private ArbolB database1;
    
    public Busq_Reservacion(Menu v1, ArbolB database1) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.database1 = database1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        intro_ci_reserv = new javax.swing.JLabel();
        input_ci = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datos_reservacion = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();
        intro_ci_reserv1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        Titulo.setText("Busqueda de Reservacion");
        jPanel1.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        intro_ci_reserv.setText("(Sin letras ni caracteres especiales)");
        jPanel1.add(intro_ci_reserv, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        input_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_ciActionPerformed(evt);
            }
        });
        jPanel1.add(input_ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 210, -1));

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        datos_reservacion.setEditable(false);
        datos_reservacion.setColumns(20);
        datos_reservacion.setRows(5);
        datos_reservacion.setFocusable(false);
        jScrollPane1.setViewportView(datos_reservacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 210, 160));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 80, -1));

        intro_ci_reserv1.setText("Introduzca la cedula del cliente que reservo:");
        jPanel1.add(intro_ci_reserv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_ciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_ciActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        
        datos_reservacion.setText("");
        String hab= input_ci.getText().replaceAll("\\s+", "");
        try{
            int habitacion = Integer.parseInt(hab);
            
            NodoABB findings = database1.search(habitacion);
        
            String names = findings.GetInfo(findings);
            datos_reservacion.append(names);
            
        }catch (Exception e){
            datos_reservacion.setText("El valor introducido no se encontró\nen la base de datos");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.setVisible(false);
        Menu ventana1 = new Menu();
        ventana1.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(Busq_Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busq_Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busq_Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busq_Reservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArbolB database1 = new ArbolB();
                new Busq_Reservacion(v1, database1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton buscar;
    private javax.swing.JTextArea datos_reservacion;
    private javax.swing.JTextField input_ci;
    private javax.swing.JLabel intro_ci_reserv;
    private javax.swing.JLabel intro_ci_reserv1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
