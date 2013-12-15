/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazdeusuario;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Modulo;

/**
 *
 * @author Jorge
 */
public class VistaVerCurso extends javax.swing.JFrame {

    /**
     * Creates new form VistaVerCurso
     */
    public VistaVerCurso() {
        initComponents();
    }
    
    public VistaVerCurso(Curso curso) {
        initComponents();
        this.nombreCurso.setText("Nombre: " + curso.getNombre());
        this.modulos = curso.getPlanDeEstudio().getModulos();
        llenarListaDeAsignaturas();
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
        nombreCurso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Curso");

        nombreCurso.setText("Nombre: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(301, 301, 301)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nombreCurso)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nombreCurso)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    private Vector llenarTitulosDeTabla() {
        Vector titulos = new Vector();
        titulos.add("Clave");
        titulos.add("Nombre");
        titulos.add("Fecha de Impartición");
        titulos.add("Duración(Semanas)");
        titulos.add("Módulo");
        return titulos;
    }

    /**
     * Método que crea y llena una fila de la tabla con datos de una asignatura.
     *
     * @param asignatura Instancia.
     * @return Vector<String> Vector fila con los datos de la asignatura.
     */
    private Vector<String> llenarFilaDatosDeAsignatura(Asignatura asignatura) {
        Asignatura asignaturaIndexada = asignatura;
        Vector<String> filaDatosDeAsignaturaIndexada = new Vector<String>();
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getClave());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getFechaImparticion());
        filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getDuracion() + "");
        return filaDatosDeAsignaturaIndexada;
    }

    /**
     * Método que llena la Tabla con las filas de las asignaturas.
     */
    private void llenarListaDeAsignaturas() {
        Vector titulosTabla = llenarTitulosDeTabla();
        Vector datosAsignaturas = new Vector<Vector<String>>();
        int numeroDeModulos = this.modulos.size();
        for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = modulos.get(i);
            int numeroDeAsigaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsigaturasDeModuloIndexado; j++) {
                Vector<String> filaDatosDeAsignaturaIndexada = llenarFilaDatosDeAsignatura(moduloIndexado.getAsignaturas().get(j));
                filaDatosDeAsignaturaIndexada.add(moduloIndexado.getNombre());
                datosAsignaturas.add(filaDatosDeAsignaturaIndexada);
            }
        }
        DefaultTableModel modelo = new DefaultTableModel(datosAsignaturas, titulosTabla) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.jTable1.setModel(modelo);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaVerCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVerCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVerCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVerCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VistaVerCurso().setVisible(true);
            }
        });
    }
    
    private ArrayList<Modulo> modulos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nombreCurso;
    // End of variables declaration//GEN-END:variables
}
