/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.interfazdeusuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import modelo.ListaDeCursos;

/**
 *
 * @author brentheftye
 */
public class VistaAdministradorDeCursos extends javax.swing.JFrame {

    /**
     * Creates new form VistaAdministradorDeCursos
     */
    public VistaAdministradorDeCursos() {
        initComponents();
        CentradorDeVistas.getCentradorDeVistas().centrarJFrame(this);
        //llenarJListConCursos();
        setListListener();
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
        textoABuscarField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        botonBuscarCurso = new javax.swing.JButton();
        botonVerCurso = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonCrearCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar Curso:");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        botonBuscarCurso.setText("Buscar");

        botonVerCurso.setText("Ver");

        botonSalir.setText("Salir");

        botonCrearCurso.setText("Crear");
        botonCrearCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCursoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(textoABuscarField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 311, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(botonBuscarCurso)
                        .add(0, 231, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(botonVerCurso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(botonSalir, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(botonCrearCurso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(textoABuscarField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(botonBuscarCurso))
                        .add(32, 32, 32)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(botonCrearCurso)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(botonVerCurso)
                        .add(64, 64, 64)
                        .add(botonSalir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCursoActionPerformed
        // TODO add your handling code here:
        //Crear ventana de alta.
        new VistaAltaCurso().setVisible(true);
    }//GEN-LAST:event_botonCrearCursoActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAdministradorDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministradorDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministradorDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministradorDeCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdministradorDeCursos().setVisible(true);
            }
        });
    }
    
    private void llenarJListConCursos(){
        DefaultListModel listModel = helper.llenarJListConCursos();
        jList1.setModel(listModel);
    }
    
    private void setListListener() {
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int indexEnJList = list.locationToIndex(evt.getPoint());
                    new VistaVerCurso(ListaDeCursos.getListaDeCursos().getCursos().get(indexEnJList)).setVisible(true);

                }
            }
        });
    }
    private HelperVistaAdministradorDeCursos helper = new HelperVistaAdministradorDeCursos();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarCurso;
    private javax.swing.JButton botonCrearCurso;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonVerCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textoABuscarField;
    // End of variables declaration//GEN-END:variables
}
