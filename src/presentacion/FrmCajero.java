/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import javax.swing.JInternalFrame;
import utilidades.InactividadManager;

/**
 *
 * @author Lenovo
 */
public class FrmCajero extends javax.swing.JFrame {

    private InactividadManager inactividadManager;

    public FrmCajero() {

        initComponents();
        inactividadManager = new InactividadManager(this);
        inactividadManager.iniciar();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dppFondo = new javax.swing.JDesktopPane();
        lblBienvenida = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnComprobante = new javax.swing.JButton();

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
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        btnPagos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPagos.setText("Registrar Pago");
        btnPagos.addActionListener(this::btnPagosActionPerformed);

        btnComprobante.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnComprobante.setText("Emitir Comprobante");

        dppFondo.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(lblPregunta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnCerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnPagos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnComprobante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dppFondoLayout = new javax.swing.GroupLayout(dppFondo);
        dppFondo.setLayout(dppFondoLayout);
        dppFondoLayout.setHorizontalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dppFondoLayout.createSequentialGroup()
                .addGap(0, 172, Short.MAX_VALUE)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnCerrarSesion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPagos)
                .addGap(70, 70, 70)
                .addComponent(btnComprobante)
                .addGap(57, 57, 57))
        );
        dppFondoLayout.setVerticalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        if (inactividadManager != null) {
            inactividadManager.detener();
        }
        this.dispose();
        FrmPrincipal principal = new FrmPrincipal();
        principal.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagosActionPerformed

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
    private javax.swing.JButton btnComprobante;
    private javax.swing.JButton btnPagos;
    private javax.swing.JDesktopPane dppFondo;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPregunta;
    // End of variables declaration//GEN-END:variables
}
