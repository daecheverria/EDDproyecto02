/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import EDD.ArbolB;
import EDD.NodoABB;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Maria
 */
public class Historico extends javax.swing.JFrame {

    public static Menu v1;
    private ArbolB database;
    
    public Historico(Menu v1, ArbolB database) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.database = database;
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
        TITULO = new javax.swing.JLabel();
        ingresa_num_hab = new javax.swing.JLabel();
        num_hab = new javax.swing.JTextField();
        buscar_hab = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datos_hab_buscado = new javax.swing.JTextArea();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TITULO.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        TITULO.setText("Historico de Habitaciones");
        jPanel1.add(TITULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        ingresa_num_hab.setText("Ingresa el numero de habitacion:");
        jPanel1.add(ingresa_num_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, 20));

        num_hab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_habActionPerformed(evt);
            }
        });
        jPanel1.add(num_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 180, -1));

        buscar_hab.setText("Buscar");
        buscar_hab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_habActionPerformed(evt);
            }
        });
        jPanel1.add(buscar_hab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        datos_hab_buscado.setEditable(false);
        datos_hab_buscado.setColumns(20);
        datos_hab_buscado.setRows(5);
        datos_hab_buscado.setFocusable(false);
        jScrollPane1.setViewportView(datos_hab_buscado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 230, 150));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void num_habActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_habActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_habActionPerformed

    private void buscar_habActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_habActionPerformed
        
        datos_hab_buscado.setText("");
        String hab= num_hab.getText().replaceAll("\\s+", "");
        try{
            int habitacion = Integer.parseInt(hab);
            NodoABB findings = database.search(habitacion);
        
            String names = findings.Getnames(findings);
            datos_hab_buscado.append(names);
            
        }catch (Exception e){
            System.out.println(e);
            datos_hab_buscado.setText("El valor introducido no se encontró\nen la base de datos");
        }
        
        
        
    }//GEN-LAST:event_buscar_habActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.setVisible(false);
        Menu ventana1 = new Menu(database);
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
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArbolB database = new ArbolB();
                new Historico(v1, database).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TITULO;
    private javax.swing.JButton buscar_hab;
    private javax.swing.JTextArea datos_hab_buscado;
    private javax.swing.JLabel ingresa_num_hab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField num_hab;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
