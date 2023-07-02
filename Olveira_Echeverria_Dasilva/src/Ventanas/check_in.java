/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import EDD.ArbolB;
import EDD.Cliente;
import EDD.Habitacion;
import EDD.NodoABB;
import EDD.Lista;
import EDD.TablaHabitaciones;
import EDD.TablaRegistro;

/**
 *
 * @author Maria
 */
public class check_in extends javax.swing.JFrame {

    public static Menu v1;
    private ArbolB database1;
    private TablaRegistro registro;
    private TablaHabitaciones TablaHab;

    public check_in(Menu v1, ArbolB database1, TablaRegistro registro, TablaHabitaciones TablaHab) {
        initComponents();
        this.v1 = v1;
        v1.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.database1 = database1;
        this.registro = registro;
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
        introduzca_ci_titulo = new javax.swing.JLabel();
        input_ci = new javax.swing.JTextField();
        empezar_estadia = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Info_hab_asig = new javax.swing.JTextArea();
        introduzca_ci_titulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TITULO.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        TITULO.setText("Check In");
        jPanel1.add(TITULO, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        introduzca_ci_titulo.setText("(Sin letras ni caracteres especiales)");
        jPanel1.add(introduzca_ci_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 20));

        input_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_ciActionPerformed(evt);
            }
        });
        jPanel1.add(input_ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 230, -1));

        empezar_estadia.setText("Empezar Estadia");
        empezar_estadia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empezar_estadiaActionPerformed(evt);
            }
        });
        jPanel1.add(empezar_estadia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        Info_hab_asig.setEditable(false);
        Info_hab_asig.setColumns(20);
        Info_hab_asig.setRows(5);
        Info_hab_asig.setFocusable(false);
        jScrollPane1.setViewportView(Info_hab_asig);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 230, 180));

        introduzca_ci_titulo1.setText("Introduzca la cedula del cliente que reservo:");
        jPanel1.add(introduzca_ci_titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_ciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_ciActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.setVisible(false);
        Menu ventana1 = new Menu();
        ventana1.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void empezar_estadiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezar_estadiaActionPerformed
        Info_hab_asig.setText("");
        String hab = input_ci.getText().replaceAll("\\s+", "");
        try {
            int habitacion = Integer.parseInt(hab);
            NodoABB findings = database1.search(habitacion);

            Lista names = findings.getNames();
            Lista lastnames = findings.getLastnames();
            Lista emails = findings.getCorreo();
            Lista generos = findings.getGenero();
            Lista tipos_hab = findings.getTipo_hab();
            Lista celulares = findings.getCelular();
            Lista llegadas = findings.getLlegada();
            Lista salidas = findings.getSalida();

            //Variables a utilizar
            String ci = input_ci.getText();
            String name = names.getpFirst().getInfo().toString();
            String lastname = lastnames.getpFirst().getInfo().toString();
            String email = emails.getpFirst().getInfo().toString();
            String genero = generos.getpFirst().getInfo().toString();
            String tipo_hab = tipos_hab.getpFirst().getInfo().toString();
            String celular = celulares.getpFirst().getInfo().toString();
            String llegada = llegadas.getpFirst().getInfo().toString();
            String salida = salidas.getpFirst().getInfo().toString();
            TablaHab = TablaHabitaciones.getInstancia();
            TablaHab.getHabitacionesTabla();
            Habitacion habitacionDisponible = TablaHab.buscarHabitacionDisponible(tipo_hab);
            if (habitacionDisponible != null) {
                String numeroHabitacion = habitacionDisponible.getNumeroHabitacion();
                Cliente cliente = new Cliente(ci, name, lastname, email, genero, numeroHabitacion, celular, llegada, salida);
                registro.registroTabla.agregar(name, lastname, cliente);
                Info_hab_asig.setText("Su habitacion es: " + numeroHabitacion);
            } else {
                Info_hab_asig.setText("No se encontró ninguna habitación disponible del tipo reservado");
            }
        } catch (Exception e) {
            System.out.println(e);
            Info_hab_asig.setText("El valor introducido no se encontró\nen la base de datos");
        }

    }//GEN-LAST:event_empezar_estadiaActionPerformed

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
            java.util.logging.Logger.getLogger(check_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(check_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(check_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(check_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArbolB database1 = new ArbolB();
                TablaRegistro registro = new TablaRegistro();
                TablaHabitaciones TablaHab = new TablaHabitaciones();
                new check_in(v1, database1, registro, TablaHab);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Info_hab_asig;
    private javax.swing.JLabel TITULO;
    private javax.swing.JButton empezar_estadia;
    private javax.swing.JTextField input_ci;
    private javax.swing.JLabel introduzca_ci_titulo;
    private javax.swing.JLabel introduzca_ci_titulo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
