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
public class FrmFarmaceutico extends javax.swing.JFrame {

    public FrmFarmaceutico() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        dppFondo = new javax.swing.JDesktopPane();
        lblBienvenida = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMedicamentos = new javax.swing.JMenu();
        mniRegistro = new javax.swing.JMenuItem();
        mniMedicos = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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

        dppFondo.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(lblPregunta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnCerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dppFondoLayout = new javax.swing.GroupLayout(dppFondo);
        dppFondo.setLayout(dppFondoLayout);
        dppFondoLayout.setHorizontalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dppFondoLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnCerrarSesion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dppFondoLayout.createSequentialGroup()
                .addGap(0, 172, Short.MAX_VALUE)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        dppFondoLayout.setVerticalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        mnuMedicamentos.setText("Medicamentos");

        mniRegistro.setText("Registrar entrega de medicamentos");
        mniRegistro.addActionListener(this::mniRegistroActionPerformed);
        mnuMedicamentos.add(mniRegistro);

        mniMedicos.setText("Consultar stock de medicamentos");
        mnuMedicamentos.add(mniMedicos);

        jMenuBar1.add(mnuMedicamentos);

        setJMenuBar(jMenuBar1);

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

    private void mniRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniRegistroActionPerformed


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
    private javax.swing.JDesktopPane dppFondo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JMenuItem mniMedicos;
    private javax.swing.JMenuItem mniRegistro;
    private javax.swing.JMenu mnuMedicamentos;
    // End of variables declaration//GEN-END:variables
}
