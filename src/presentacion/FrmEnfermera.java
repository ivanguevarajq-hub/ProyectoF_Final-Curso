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

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("Bienvenido!");

        lblPregunta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("¿Qué va a hacer hoy?");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dppFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSignosVitales)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dppFondoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(295, 295, 295))
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(btnCerrarSesion)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        dppFondoLayout.setVerticalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btnSignosVitales, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dppFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dppFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignosVitalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignosVitalesActionPerformed
        IfrmRegistroSignosVitales ventana = new IfrmRegistroSignosVitales();
        centrarInternalFrame(ventana);
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
