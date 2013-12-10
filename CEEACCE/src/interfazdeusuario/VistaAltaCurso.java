/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazdeusuario;

import controladorinterfacesdeusuario.ControladorInterfacesDeUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author brentheftye
 */
public class VistaAltaCurso extends javax.swing.JFrame {

    /**
     * Creates new form VistaAltaCurso
     */
    public VistaAltaCurso() {
        initComponents();
        CentradorDeVistas.getCentradorDeVistas().centrarJFrame(this);
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
        nombreCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        planesDeEstudioCombo = new javax.swing.JComboBox();
        botonAsignarFecha = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        botonCrearCurso = new javax.swing.JButton();
        botonVaciarPlan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

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

        jLabel2.setText("Plan de Estudio:");

        planesDeEstudioCombo = new javax.swing.JComboBox(llenaPlanesDeEstudio().toArray());
        planesDeEstudioCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonAsignarFecha.setText("Asignar Fecha");
        botonAsignarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarFechaActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonCrearCurso.setText("Crear");
        botonCrearCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCursoActionPerformed(evt);
            }
        });

        botonVaciarPlan.setText("Vaciar Plan en Tabla");
        botonVaciarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVaciarPlanActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(botonAsignarFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(botonCrearCurso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .add(18, 18, 18)
                                .add(planesDeEstudioCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 171, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(botonVaciarPlan))
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(18, 18, 18)
                                .add(nombreCurso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 301, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(nombreCurso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel2)
                        .add(planesDeEstudioCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, botonVaciarPlan))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(284, 284, 284)
                        .add(botonAsignarFecha)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(botonCrearCurso)
                        .add(86, 86, 86)
                        .add(jButton1)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAsignarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarFechaActionPerformed
        // TODO add your handling code here:
        new VistaAsignacionFechaAsignatura().setVisible(true);
    }//GEN-LAST:event_botonAsignarFechaActionPerformed

    private void botonVaciarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVaciarPlanActionPerformed
        // TODO add your handling code here:
        llenarListaAsignaturas();
    }//GEN-LAST:event_botonVaciarPlanActionPerformed

    private void botonCrearCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCursoActionPerformed
        // TODO add your handling code here:
        String nombreCurso = this.nombreCurso.getText();
        PlanDeEstudio planDeEstudioDeCurso = planDeEstudioSeleccionado;
        ArrayList<Modulo> modulosAModificar = planDeEstudioDeCurso.getModulos();
        int numeroDeModulos = modulosAModificar.size();
        int contadorDeFilaDeAsignatura = 0;
        for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = modulosAModificar.get(i);
            int numeroDeAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsignaturasDeModuloIndexado; j++) {
                moduloIndexado.getAsignaturas().get(j).setFechaImparticion((String)jTable1.getValueAt(contadorDeFilaDeAsignatura, 2));
                contadorDeFilaDeAsignatura++;
            }
        }
        planDeEstudioDeCurso.setModulos(modulosAModificar);
        Curso cursoNuevo = new Curso(nombreCurso,planDeEstudioDeCurso);
        ControladorInterfacesDeUsuario.getControladorInterfacesDeUsuario().agregarCurso(cursoNuevo);
    }//GEN-LAST:event_botonCrearCursoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private ArrayList llenaPlanesDeEstudio(){
        ArrayList<String> nombresPlanesEstudio = new ArrayList();
        nombresPlanesEstudio.add("Selecciona un plan de estudio");
        ArrayList<PlanDeEstudio> planesDeEstudio = ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().getPlanesDeEstudio();
        for (int i = 0; i < planesDeEstudio.size(); i++) {
            nombresPlanesEstudio.add(planesDeEstudio.get(i).getNombre());
        }
        return nombresPlanesEstudio;
    }
    
   private void llenarListaAsignaturas(){
       planDeEstudioSeleccionado = ListaDePlanesDeEstudio.getListaDePlanesDeEstudio().getPlanesDeEstudio().get(planesDeEstudioCombo.getSelectedIndex()-1);
       Vector titulosTabla = llenarTitulosDeTabla();
       Vector datosAsignaturas = new Vector<Vector<String>>();
       modulos = planDeEstudioSeleccionado.getModulos();
       int numeroDeModulos = this.modulos.size();
       for (int i = 0; i < numeroDeModulos; i++) {
            Modulo moduloIndexado = modulos.get(i);
            int numeroDeAsignaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
            for (int j = 0; j < numeroDeAsignaturasDeModuloIndexado; j++) {
            Vector<String>  filaDatosDeAsignaturaIndexada = llenarFilaDatosDeAsignatura(moduloIndexado.getAsignaturas().get(j));
            filaDatosDeAsignaturaIndexada.add(0,moduloIndexado.getNombre());
            datosAsignaturas.add(filaDatosDeAsignaturaIndexada);
           }
       }
   DefaultTableModel modelo = new DefaultTableModel(datosAsignaturas,titulosTabla){
    public boolean isCellEditable(int row, int column){return false;}};
    this.jTable1.setModel(modelo);
}
   
   private Vector llenarTitulosDeTabla(){
       Vector titulos = new Vector();
       titulos.add("Módulo");
       titulos.add("Asignatura");
       titulos.add("Fecha de Impartición");
       titulos.add("Duración");
       return titulos;
   }
   
   private Vector<String> llenarFilaDatosDeAsignatura(Asignatura asignatura){
       Asignatura asignaturaIndexada = asignatura;
       Vector<String> filaDatosDeAsignaturaIndexada = new Vector<String>();
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getFechaImparticion());
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getDuracion() + "");
       return filaDatosDeAsignaturaIndexada;
   }
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
            java.util.logging.Logger.getLogger(VistaAltaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAltaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAltaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAltaCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAltaCurso().setVisible(true);
            }
        });
    }
    
    private ArrayList<Modulo> modulos;
    private PlanDeEstudio planDeEstudioSeleccionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAsignarFecha;
    private javax.swing.JButton botonCrearCurso;
    private javax.swing.JButton botonVaciarPlan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreCurso;
    private javax.swing.JComboBox planesDeEstudioCombo;
    // End of variables declaration//GEN-END:variables
}
