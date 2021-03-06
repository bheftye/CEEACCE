/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import modelo.Asignatura;

/**
 *
 * @author brentheftye
 */
public class VistaAgregarAsignatura extends javax.swing.JFrame implements Observer{
    
    
    /**
     * Creates new form VistaAgregarAsignatura
     */
    public VistaAgregarAsignatura() {
        initComponents();
        CentradorDeVistas.getCentradorDeVistas().centrarJFrame(this);
    }
    
    
    /**
     * Creates new form VistaAgregarAsignatura
     */
    public VistaAgregarAsignatura(VistaAltaPlanDeEstudio vistaAltaPlanDeEstudio) {
        initComponents();
        CentradorDeVistas.getCentradorDeVistas().centrarJFrame(this);
        this.vistaAltaPlanDeEstudio = vistaAltaPlanDeEstudio;
        helper = new HelperVistaAgregarAsignatura();
        helper.addObserver(this);
        update(helper, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        claveAsignatura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombreAsignatura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        creditosAsignatura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        duracionAsignatura = new javax.swing.JTextField();
        moduloAsignatura = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        botonAgregarAsignatura = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asignatura");

        jLabel2.setText("Clave:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Creditos:");

        jLabel5.setText("Duración(Semanas):");

        moduloAsignatura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Módulo I", "Módulo II", "Módulo III", "Módulo IV", "Módulo V", "Módulo VI" }));

        jLabel6.setText("Módulo:");

        botonAgregarAsignatura.setText("Agregar");
        botonAgregarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAsignaturaActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel1)
                .add(216, 216, 216))
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel3)
                    .add(jLabel2)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jLabel6))
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(moduloAsignatura, 0, 184, Short.MAX_VALUE)
                            .add(claveAsignatura)
                            .add(nombreAsignatura)
                            .add(creditosAsignatura)
                            .add(duracionAsignatura))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(0, 115, Short.MAX_VALUE)
                        .add(botonAgregarAsignatura)
                        .add(18, 18, 18)
                        .add(botonCancelar)
                        .add(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(claveAsignatura, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreAsignatura, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(9, 9, 9)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(creditosAsignatura, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(duracionAsignatura, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(moduloAsignatura, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 35, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonAgregarAsignatura)
                    .add(botonCancelar))
                .add(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAsignaturaActionPerformed
        // TODO add your handling code here:
        update(helper,null);
        boolean camposLlenos = helper.validaLlenadoDeCampos();
        if(camposLlenos){
            String clave = this.claveAsignatura.getText();
            String nombre = this.nombreAsignatura.getText();
            String creditos = this.creditosAsignatura.getText();
            String duracion = this.duracionAsignatura.getText();
            int modulo = this.moduloAsignatura.getSelectedIndex();
 
            Asignatura asignatura = new Asignatura();
            asignatura.setClave(clave);
            asignatura.setCreditos(Double.parseDouble(creditos));
            asignatura.setNombreAsignatura(nombre);
            asignatura.setDuracion(Integer.parseInt(duracion));
            vistaAltaPlanDeEstudio.getModulos().get(modulo).getAsignaturas().add(asignatura);
            vistaAltaPlanDeEstudio.aumentaNumeroDeAsignaturas();
            this.dispose();
           
        }
        else{
            JOptionPane.showMessageDialog(this, "Verifica que todos los campos estén llenos.");
        }
    }//GEN-LAST:event_botonAgregarAsignaturaActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAgregarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAgregarAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAgregarAsignatura().setVisible(true);
            }
        });
    }
    
    @Override
    public void update(Observable o, Object o1) {
        helper.setClave(claveAsignatura.getText());
        helper.setNombre(nombreAsignatura.getText());
        helper.setCreditos(creditosAsignatura.getText());
        helper.setDuracion(duracionAsignatura.getText());
    }
    
    private VistaAltaPlanDeEstudio vistaAltaPlanDeEstudio;
    private HelperVistaAgregarAsignatura helper;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarAsignatura;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField claveAsignatura;
    private javax.swing.JTextField creditosAsignatura;
    private javax.swing.JTextField duracionAsignatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox moduloAsignatura;
    private javax.swing.JTextField nombreAsignatura;
    // End of variables declaration//GEN-END:variables
}
