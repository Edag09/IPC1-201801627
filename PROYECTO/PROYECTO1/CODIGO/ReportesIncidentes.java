/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Org.EduardoAgustin.Ventanas;

import Org.EduardoAgustin.Clases.ControlNoAsegurados;
import Org.EduardoAgustin.Clases.ControladorCarga;
import Org.EduardoAgustin.Clases.ControladorIncidentes;
import Org.EduardoAgustin.Clases.ControladorPersonas;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo Agustin
 */
public class ReportesIncidentes extends javax.swing.JFrame {

    /**
     * Creates new form ReportesIncidentes
     */
    public ReportesIncidentes() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Reportes de Incidentes");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargas.datosMecanica(ListaServicios, "mecanica");
        cargas.datosRepuestos(ListaRepuestos, "repuesto");
        
        
    }
    ControladorCarga cargas = new ControladorCarga();
    ControladorIncidentes incidente = new ControladorIncidentes();
    ControladorPersonas persona = new ControladorPersonas();
    ControlNoAsegurados personaNo = new ControlNoAsegurados();
    double precioServicio,precioRepuesto,total;
    DecimalFormat df = new DecimalFormat("#.00");
    int contador;
    
    public void Datos(){
        try {
            if (cargas.nombreServicio(ListaServicios.getSelectedItem().toString()) == ListaServicios.getSelectedItem().toString()) {
                if (cargas.nombreRepuesto(ListaRepuestos.getSelectedItem().toString())== ListaRepuestos.getSelectedItem().toString()) {
                    precioServicio = cargas.costoServicio(ListaServicios.getSelectedItem().toString());
                    
                    precioRepuesto = cargas.precioRepuesto(ListaRepuestos.getSelectedItem().toString());
                    
                    incidente.Total(precioServicio, precioRepuesto);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public void LlenarTabla(){
        contador =0;
    String Columnas[]={"ID","Servicio","Repuesto","Total"};
    String Datos[][] = new String[ControladorIncidentes.cont][4];
        try {
            for (int fila = 0; fila < Datos.length; fila++) {
                if (Datos[fila][0] == null) {
                    
                    Datos[fila][0] = contador+"";
                    Datos[fila][1] = ControladorIncidentes.incidentes[fila].getServicio();
                    Datos[fila][2] = ControladorIncidentes.incidentes[fila].getRepuesto();
                    Datos[fila][3] = ControladorIncidentes.incidentes[fila].getTotal();
                    contador++;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trono");
        }
        TablaIncidentesReportes.setModel(new DefaultTableModel(Datos,Columnas));
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDpiAsegurado = new javax.swing.JTextField();
        txtDpiTercero = new javax.swing.JTextField();
        ListaServicios = new javax.swing.JComboBox();
        ListaRepuestos = new javax.swing.JComboBox();
        AseguradoCulpable = new javax.swing.JCheckBox();
        TerceroSeguro = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaIncidentesReportes = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        ReporteIncident = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel1.setText("DPI Asegurado");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel2.setText("DPI Terceros");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de Servicio");

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel4.setText("Repuestos");

        ListaServicios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige una Opcion." }));

        ListaRepuestos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige una Opcion." }));

        AseguradoCulpable.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        AseguradoCulpable.setText("El asegurado es culpable");

        TerceroSeguro.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        TerceroSeguro.setText("El tercero tiene seguro");

        TablaIncidentesReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaIncidentesReportes);

        Add.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos Proyecto/icons8-más-24.png"))); // NOI18N
        Add.setText("Agregar");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total");

        ReporteIncident.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        ReporteIncident.setText("Reportar Incidente");
        ReporteIncident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteIncidentActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos Proyecto/Regreso.png"))); // NOI18N
        Salir.setText(" Cancelar");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
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
                        .addComponent(ReporteIncident)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDpiTercero, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                    .addComponent(txtDpiAsegurado)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(52, 52, 52)
                                                .addComponent(ListaRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(78, 78, 78)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AseguradoCulpable)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(Add)
                                                .addComponent(TerceroSeguro))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(ListaServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDpiAsegurado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AseguradoCulpable))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDpiTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TerceroSeguro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ListaServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ListaRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReporteIncident)
                    .addComponent(Salir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        Administrador admin = new Administrador();
        admin.setVisible(true);
        ReportesIncidentes.this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        Datos();
        try {
            if (ListaServicios.getSelectedItem().equals("Elige una Opcion") || ListaRepuestos.getSelectedItem().equals("Elige una Opcion")) {
                JOptionPane.showMessageDialog(null, "Selecciona los Itemns");
            }else{
                String servicio = ListaServicios.getSelectedItem().toString();
                String repuesto = ListaRepuestos.getSelectedItem().toString();
                String tot = String.valueOf(incidente.Total(precioServicio, precioRepuesto));
                incidente.agregarIncidente(servicio, repuesto, tot);
                txtTotal.setText(tot);
                System.out.println(AseguradoCulpable.getSelectedIcon());;
                LlenarTabla();
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Laca");
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void ReporteIncidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteIncidentActionPerformed
        try {
            if (txtDpiAsegurado.getText().isEmpty() || txtDpiTercero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Llenar los campos requeridos");
            }else if(persona.ValidacionDPI(txtDpiAsegurado.getText())){
                    if (personaNo.ValidacionDPI(txtDpiTercero.getText())) {
                        JOptionPane.showMessageDialog(null, "Datos Guardados");
                        txtDpiAsegurado.setText("");
                        txtDpiTercero.setText("");
                        txtTotal.setText("");
                        ListaRepuestos.setSelectedIndex(0);
                        ListaServicios.setSelectedIndex(0);
                        AseguradoCulpable.setSelected(false);
                        TerceroSeguro.setSelected(false);
                }else{
                    JOptionPane.showMessageDialog(null, "El tercero aun no esta registrado");
                    IngresoNoAsegurados no = new IngresoNoAsegurados();
                    no.setVisible(true);
                    }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ReporteIncidentActionPerformed

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
            java.util.logging.Logger.getLogger(ReportesIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportesIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportesIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportesIncidentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesIncidentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JCheckBox AseguradoCulpable;
    private javax.swing.JComboBox ListaRepuestos;
    private javax.swing.JComboBox ListaServicios;
    private javax.swing.JButton ReporteIncident;
    private javax.swing.JButton Salir;
    private javax.swing.JTable TablaIncidentesReportes;
    private javax.swing.JCheckBox TerceroSeguro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDpiAsegurado;
    private javax.swing.JTextField txtDpiTercero;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
