/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.Usuarios.vista;

import com.unicauca.parqueadero.negocio.Bahia;
import com.unicauca.parqueadero.negocio.GestorConductores;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author w
 */
public class GUILiberarCupo extends javax.swing.JFrame {
    private ArrayList<Bahia> bahias;
    private GestorConductores gestor;
    
    /**
     * Creates new form GUILiberarCupo
     */
    public GUILiberarCupo() {
        initComponents();

        gestor = new GestorConductores();
        bahias = (ArrayList<Bahia>) gestor.consultarConductor(null, 5);
        for(int i = 0; i < bahias.size(); i++){
         jComboBoxBahias.addItem("Bahia " + bahias.get(i).getNumero());   
        }
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNorte = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelSur = new javax.swing.JPanel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnAceptar = new javax.swing.JButton();
        jPanelCentro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxBahias = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(3, 0));

        jPanelNorte.setBackground(new java.awt.Color(232, 239, 249));
        jPanelNorte.setAlignmentX(20.0F);
        jPanelNorte.setAlignmentY(20.0F);
        jPanelNorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Liberar Cupo");
        jPanelNorte.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, 30));

        getContentPane().add(jPanelNorte, java.awt.BorderLayout.PAGE_START);

        jPanelSur.setBackground(new java.awt.Color(232, 239, 249));
        jPanelSur.setPreferredSize(new java.awt.Dimension(400, 40));

        jBtnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPanelSur.add(jBtnCancelar);

        jBtnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jBtnAceptarMouseMoved(evt);
            }
        });
        jBtnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAceptarMouseClicked(evt);
            }
        });
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });
        jPanelSur.add(jBtnAceptar);

        getContentPane().add(jPanelSur, java.awt.BorderLayout.PAGE_END);

        jPanelCentro.setBackground(new java.awt.Color(200, 221, 242));
        jPanelCentro.setBorder(javax.swing.BorderFactory.createTitledBorder("Bahia"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Numero de bahia:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 17));

        jComboBoxBahias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar bahia" }));
        jComboBoxBahias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBahiasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentroLayout = new javax.swing.GroupLayout(jPanelCentro);
        jPanelCentro.setLayout(jPanelCentroLayout);
        jPanelCentroLayout.setHorizontalGroup(
            jPanelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentroLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jComboBoxBahias, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanelCentroLayout.setVerticalGroup(
            jPanelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentroLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBahias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        getContentPane().add(jPanelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxBahiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBahiasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBoxBahiasActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();//cierra la ventana cuando se preciona el boton cancelar
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jBtnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAceptarMouseClicked
        // TODO add your handling code here:
        for(int i = 0; i < 30; i++){
            if(jComboBoxBahias.getSelectedItem().toString().equals("Bahia " + Integer.toString(i))){
                JOptionPane.showMessageDialog(null, "seleccionada la bahia " + i);
            }
        }
            
    }//GEN-LAST:event_jBtnAceptarMouseClicked

    private void jBtnAceptarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAceptarMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAceptarMouseMoved

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
            java.util.logging.Logger.getLogger(GUILiberarCupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUILiberarCupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUILiberarCupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUILiberarCupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUILiberarCupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JComboBox jComboBoxBahias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelCentro;
    private javax.swing.JPanel jPanelNorte;
    private javax.swing.JPanel jPanelSur;
    // End of variables declaration//GEN-END:variables
}
