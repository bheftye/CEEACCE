/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazdeusuario;

import controladorinterfacesdeusuario.ControladorInterfacesDeUsuario;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Asignatura;
import modelo.Modulo;

/**
 *
 * @author Jorge
 */
public class VistaModificarCalificaciones extends javax.swing.JFrame {
    private VistaAdministradorDeCalificaciones vistaAdministradorDeCalificaciones;
    private ArrayList<Modulo> modulos;

    /**
     * Creates new form VistaModificarCalificaciones
     */
    public VistaModificarCalificaciones() {
        initComponents();
        CentradorDeVistas.getCentradorDeVistas().centrarJFrame(this);
    }
    
    public VistaModificarCalificaciones(VistaAdministradorDeCalificaciones vistaAdministradorDeCalificaciones){
        initComponents();
        CentradorDeVistas.getCentradorDeVistas().centrarJFrame(this);
        this.vistaAdministradorDeCalificaciones = vistaAdministradorDeCalificaciones;
        this.nombreAlumno.setText("Calificaciones de Roberto");
        modulos = vistaAdministradorDeCalificaciones.getAlumnoSeleccionado().getPlanDeEstudio().getModulos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreAlumno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombreAlumno.setText("Calificaciones");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Módulo", "Asignatura", "Calificación"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(nombreAlumno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int numeroDeModulos = this.modulos.size();
        for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = modulos.get(i);
            int numeroDeAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsignaturasDeModuloIndexado; j++) {
            moduloIndexado.getAsignaturas().get(j).setCalificacion((Integer)jTable1.getValueAt(j, 2));
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

   /**
    * Método que llena la Tabla con las filas de las asignaturas.
    */
   protected void llenarListaAsignaturas(){
       Vector titulosTabla = llenarTitulosDeTabla();
       Vector datosAsignaturas = new Vector<Vector<String>>();
       int numeroDeModulos = this.modulos.size();
       for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = modulos.get(i);
            int numeroDeAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsignaturasDeModuloIndexado; j++) {
            Vector<String>  filaDatosDeAsignaturaIndexada = llenarFilaDatosDeAsignatura(moduloIndexado.getAsignaturas().get(j));
            filaDatosDeAsignaturaIndexada.add(moduloIndexado.getNombre());
            datosAsignaturas.add(filaDatosDeAsignaturaIndexada);
           }
       }
   DefaultTableModel modelo = new DefaultTableModel(datosAsignaturas,titulosTabla){
    public boolean isCellEditable(int row, int column){return false;}};
    this.jTable1.setModel(modelo);
}
   
   /**
    * Método que crea los titulos de la tabla a mostrar. 
    * @return Vector Títulos de la JTable. 
    */
   private Vector llenarTitulosDeTabla(){
       Vector titulos = new Vector();
       titulos.add("Asignatura");
       titulos.add("Módulo");
       titulos.add("Calificación");
       return titulos;
   }
   
   /**
    * Método que crea y llena una fila de la tabla con datos de una
    * asignatura.
    * @param asignatura Instancia. 
    * @return Vector<String> Vector fila con los datos de la asignatura.
    */
   private Vector<String> llenarFilaDatosDeAsignatura(Asignatura asignatura){
       Asignatura asignaturaIndexada = asignatura;
       Vector<String> filaDatosDeAsignaturaIndexada = new Vector<String>();
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getCalificacion() + "");
       return filaDatosDeAsignaturaIndexada;
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
            java.util.logging.Logger.getLogger(VistaModificarCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaModificarCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaModificarCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaModificarCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VistaModificarCalificaciones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nombreAlumno;
    // End of variables declaration//GEN-END:variables
}
