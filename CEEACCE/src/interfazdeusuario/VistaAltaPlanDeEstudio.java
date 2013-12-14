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
import modelo.PlanDeEstudio;

/**
 *
 * @author brentheftye
 */
public class VistaAltaPlanDeEstudio extends javax.swing.JFrame {
    private ArrayList<Modulo> modulos;
    private int numAsignaturas = 0;
    /**
     * Creates new form VistaAltaPlanDeEstudio
     */
    public VistaAltaPlanDeEstudio() {
        initComponents();
        modulos = new ArrayList();
        creaModulos();
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
        jLabel2 = new javax.swing.JLabel();
        nombrePlanDeEstudio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botonAgregarAsignatura = new javax.swing.JButton();
        botonCrearPlanDeEstudio = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Plan De Estudio");

        jLabel2.setText("Nombre:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Créditos", "Duración", "Módulo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        botonAgregarAsignatura.setText("Agregar Asignatura");
        botonAgregarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAsignaturaActionPerformed(evt);
            }
        });

        botonCrearPlanDeEstudio.setText("Crear");
        botonCrearPlanDeEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearPlanDeEstudioActionPerformed(evt);
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
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(jLabel2)
                        .add(18, 18, 18)
                        .add(nombrePlanDeEstudio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(319, 319, 319)
                        .add(jLabel1)))
                .add(0, 0, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(botonAgregarAsignatura)
                        .add(18, 18, 18)
                        .add(botonCrearPlanDeEstudio)
                        .add(53, 53, 53)
                        .add(botonCancelar))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(nombrePlanDeEstudio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonAgregarAsignatura)
                    .add(botonCrearPlanDeEstudio)
                    .add(botonCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAgregarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAsignaturaActionPerformed
        // TODO add your handling code here
        VistaAltaPlanDeEstudio vistaActual = this;
        new VistaAgregarAsignatura(vistaActual).setVisible(true);
    }//GEN-LAST:event_botonAgregarAsignaturaActionPerformed

    private void botonCrearPlanDeEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearPlanDeEstudioActionPerformed
        // TODO add your handling code here:
        int numeroDeAsignaturasNecesarias = 40;
        String nombreDePlanDeEstudio = nombrePlanDeEstudio.getText(); 
        boolean campoNombrePlanDeEstudioVacio = "".equals(nombreDePlanDeEstudio);
        if(numAsignaturas == numeroDeAsignaturasNecesarias && !campoNombrePlanDeEstudioVacio ){
            //En el numeor de clave se puso para retener el error
            PlanDeEstudio planDeEstudioNuevo = new PlanDeEstudio(nombreDePlanDeEstudio, modulos);
            boolean agregoPlanDeEstudio = ControladorInterfacesDeUsuario.getControladorInterfacesDeUsuario().agregarPlanDeEstudio(planDeEstudioNuevo);
            if(agregoPlanDeEstudio){
                JOptionPane.showMessageDialog(this, "Se agregó el plan de estudio exitosamente.");
                new VistaPrincipal().setVisible(true);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Hubo un problema; no se agregó el plan de estudio.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            int asignaturasFaltantes = numeroDeAsignaturasNecesarias - numAsignaturas;
            JOptionPane.showMessageDialog(this,"Faltan "+ asignaturasFaltantes + " asignatura(s).");
        }
    }//GEN-LAST:event_botonCrearPlanDeEstudioActionPerformed

    
   /**
    * Método que aumenta el contador de las asignaturas creadas.
    */ 
   protected void aumentaNumeroDeAsignaturas(){
       numAsignaturas++;
       actualizarListaDeAsignaturasCreadas();
   } 
   
   /**
    * Método de acceso a los módulos creados. 
    */
   protected ArrayList<Modulo> getModulos(){
       return modulos;
   }
    
   /**
    * Método que crea los 6 módulos. 
    */
   private void creaModulos(){
       int numeroDeModulosPorCrear = 6;
       for (int i = 0; i < numeroDeModulosPorCrear; i++) {
           Modulo modulo = new Modulo("Módulo "+(i+1));
           modulo.setAsignaturas(new ArrayList<Asignatura>());
           modulos.add(modulo);
       }
   }
  
   /**
    * Método que crea los titulos de la tabla a mostrar. 
    * @return Vector Títulos de la JTable. 
    */
   private Vector llenarTitulosDeTabla(){
       Vector titulos = new Vector();
       titulos.add("Clave");
       titulos.add("Nombre");
       titulos.add("Créditos");
       titulos.add("Duración(Semanas)");
       titulos.add("Módulo");
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
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getClave());
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getNombreAsignatura());
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getCreditos() + "");
       filaDatosDeAsignaturaIndexada.add(asignaturaIndexada.getDuracion() + "");
       return filaDatosDeAsignaturaIndexada;
   }
   
   /**
    * Método que llena la Tabla con las filas de las asignaturas.
    */
   private void llenarListaDeAsignaturasCreadas(){
       Vector titulosTabla = llenarTitulosDeTabla();
       Vector datosAsignaturas = new Vector<Vector<String>>();
       int numeroDeModulos = this.modulos.size();
       for (int i = 0; i < numeroDeModulos; i++) {
           Modulo moduloIndexado = modulos.get(i);
           int numeroDeAsigaturasDeModuloIndexado = moduloIndexado.getAsignaturas().size();
           for (int j = 0; j < numeroDeAsigaturasDeModuloIndexado; j++) {
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
    *Método que dispara la actualización de la JTable. 
    */
   private void actualizarListaDeAsignaturasCreadas(){
    llenarListaDeAsignaturasCreadas();
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
            java.util.logging.Logger.getLogger(VistaAltaPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAltaPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAltaPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAltaPlanDeEstudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAltaPlanDeEstudio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarAsignatura;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCrearPlanDeEstudio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombrePlanDeEstudio;
    // End of variables declaration//GEN-END:variables
}
