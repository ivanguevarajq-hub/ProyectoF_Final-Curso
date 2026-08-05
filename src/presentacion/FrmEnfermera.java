/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import javax.swing.JInternalFrame;

/**
 *
 * @author Lenovo
 */
public class FrmEnfermera extends javax.swing.JFrame {
    
    public FrmEnfermera() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dppFondo = new javax.swing.JDesktopPane();
        lblBienvenida = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnSignosVitales = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("Bienvenido!");

        lblPregunta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("Que va a hacer hoy?");

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");

        btnSignosVitales.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSignosVitales.setText("Registrar Signos Vitales");
        btnSignosVitales.addActionListener(this::btnSignosVitalesActionPerformed);

        dppFondo.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(lblPregunta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnCerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnSignosVitales, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dppFondoLayout = new javax.swing.GroupLayout(dppFondo);
        dppFondo.setLayout(dppFondoLayout);
        dppFondoLayout.setHorizontalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dppFondoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSignosVitales)))
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btnCerrarSesion)))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        dppFondoLayout.setVerticalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(btnSignosVitales, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dppFondo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dppFondo, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignosVitalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignosVitalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignosVitalesActionPerformed

    /**
     * @param args the command line arguments
     */

    private void centrarInternalFrame(JInternalFrame interna) {
        int x = dppFondo.getWidth() / 2 - interna.getWidth() / 2;
        int y = dppFondo.getHeight() / 2 - interna.getHeight() / 2;
        if (interna.isShowing()) {
            interna.setLocation(x, y);
        } else {
            dppFondo.add(interna);
            interna.setLocation(x, y);
            interna.show();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnSignosVitales;
    private javax.swing.JDesktopPane dppFondo;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPregunta;
    // End of variables declaration//GEN-END:variables
}
