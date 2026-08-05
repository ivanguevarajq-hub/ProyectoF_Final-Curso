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
public class FrmRecepcionista extends javax.swing.JFrame {

    private InactividadManager inactividadManager;

    public FrmRecepcionista() {
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
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuPaciente = new javax.swing.JMenu();
        mniPaciente = new javax.swing.JMenuItem();
        mniModificar = new javax.swing.JMenuItem();
        mniConsulta = new javax.swing.JMenuItem();
        mniBuscar = new javax.swing.JMenuItem();
        mnuCitas = new javax.swing.JMenu();
        mniRegistrarCita = new javax.swing.JMenuItem();
        mniReprogramar = new javax.swing.JMenuItem();
        mniCancelar = new javax.swing.JMenuItem();
        mnuOtro = new javax.swing.JMenu();
        mniRegistrarInfo = new javax.swing.JMenuItem();
        mniConsultaMedicos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú - Recepcionista");
        setResizable(false);

        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("Bienvenido!");

        lblPregunta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("Que va a hacer hoy?");

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        dppFondo.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(lblPregunta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dppFondo.setLayer(btnCerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dppFondoLayout = new javax.swing.GroupLayout(dppFondo);
        dppFondo.setLayout(dppFondoLayout);
        dppFondoLayout.setHorizontalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dppFondoLayout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(238, 238, 238))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dppFondoLayout.createSequentialGroup()
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dppFondoLayout.createSequentialGroup()
                        .addComponent(btnCerrarSesion)
                        .addGap(300, 300, 300))))
        );
        dppFondoLayout.setVerticalGroup(
            dppFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dppFondoLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        mnuPaciente.setText("Paciente");

        mniPaciente.setText("Registrar Paciente");
        mniPaciente.addActionListener(this::mniPacienteActionPerformed);
        mnuPaciente.add(mniPaciente);

        mniModificar.setText("Modificar Paciente");
        mniModificar.addActionListener(this::mniModificarActionPerformed);
        mnuPaciente.add(mniModificar);

        mniConsulta.setText("Consultar Paciente");
        mniConsulta.addActionListener(this::mniConsultaActionPerformed);
        mnuPaciente.add(mniConsulta);

        mniBuscar.setText("Buscar Paciente");
        mniBuscar.addActionListener(this::mniBuscarActionPerformed);
        mnuPaciente.add(mniBuscar);

        jMenuBar1.add(mnuPaciente);

        mnuCitas.setText("Cita");

        mniRegistrarCita.setText("Registrar Cita Medica");
        mniRegistrarCita.addActionListener(this::mniRegistrarCitaActionPerformed);
        mnuCitas.add(mniRegistrarCita);

        mniReprogramar.setText("Reprogramar Cita");
        mniReprogramar.addActionListener(this::mniReprogramarActionPerformed);
        mnuCitas.add(mniReprogramar);

        mniCancelar.setText("Cancelar Cita");
        mniCancelar.addActionListener(this::mniCancelarActionPerformed);
        mnuCitas.add(mniCancelar);

        jMenuBar1.add(mnuCitas);

        mnuOtro.setText("Otro");

        mniRegistrarInfo.setText("Registrar Info del Seguro Medico");
        mniRegistrarInfo.addActionListener(this::mniRegistrarInfoActionPerformed);
        mnuOtro.add(mniRegistrarInfo);

        mniConsultaMedicos.setText("Consultar Disponibilidad de Medicos");
        mniConsultaMedicos.addActionListener(this::mniConsultaMedicosActionPerformed);
        mnuOtro.add(mniConsultaMedicos);

        jMenuBar1.add(mnuOtro);

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

    private void mniPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPacienteActionPerformed
        IfrmRegistrarPaciente registrarPaciente = new IfrmRegistrarPaciente();
        centrarInternalFrame(registrarPaciente);
    }//GEN-LAST:event_mniPacienteActionPerformed

    private void mniConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultaActionPerformed
        IfrmConsultarPaciente consultarPaciente = new IfrmConsultarPaciente();
        centrarInternalFrame(consultarPaciente);
    }//GEN-LAST:event_mniConsultaActionPerformed

    private void mniModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniModificarActionPerformed
        IfrmModificarPaciente modificarPaciente = new IfrmModificarPaciente();
        centrarInternalFrame(modificarPaciente);
    }//GEN-LAST:event_mniModificarActionPerformed

    private void mniBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarActionPerformed
        IfrmBuscarPacientes buscarPaciente = new IfrmBuscarPacientes();
        centrarInternalFrame(buscarPaciente);
    }//GEN-LAST:event_mniBuscarActionPerformed

    private void mniRegistrarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistrarCitaActionPerformed
        IfrmRegistrarCita registrarCita = new IfrmRegistrarCita();
        centrarInternalFrame(registrarCita);
    }//GEN-LAST:event_mniRegistrarCitaActionPerformed

    private void mniCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCancelarActionPerformed
        IfrmCancelarCita cancelarCita = new IfrmCancelarCita();
        centrarInternalFrame(cancelarCita);
    }//GEN-LAST:event_mniCancelarActionPerformed

    private void mniReprogramarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniReprogramarActionPerformed
        IfrmReprogramarCita reprogramarCita = new IfrmReprogramarCita();
        centrarInternalFrame(reprogramarCita);
    }//GEN-LAST:event_mniReprogramarActionPerformed

    private void mniRegistrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistrarInfoActionPerformed
        IfrmInfoSeguroMedico infoSeguroMedico = new IfrmInfoSeguroMedico();
        centrarInternalFrame(infoSeguroMedico);
    }//GEN-LAST:event_mniRegistrarInfoActionPerformed

    private void mniConsultaMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniConsultaMedicosActionPerformed
        IfrmConsultarMedicos consultarMedicos = new IfrmConsultarMedicos();
        centrarInternalFrame(consultarMedicos);
    }//GEN-LAST:event_mniConsultaMedicosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        if (inactividadManager != null) {
            inactividadManager.detener();
        }
        this.dispose();
        FrmPrincipal principal = new FrmPrincipal();
        principal.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JMenuItem mniBuscar;
    private javax.swing.JMenuItem mniCancelar;
    private javax.swing.JMenuItem mniConsulta;
    private javax.swing.JMenuItem mniConsultaMedicos;
    private javax.swing.JMenuItem mniModificar;
    private javax.swing.JMenuItem mniPaciente;
    private javax.swing.JMenuItem mniRegistrarCita;
    private javax.swing.JMenuItem mniRegistrarInfo;
    private javax.swing.JMenuItem mniReprogramar;
    private javax.swing.JMenu mnuCitas;
    private javax.swing.JMenu mnuOtro;
    private javax.swing.JMenu mnuPaciente;
    // End of variables declaration//GEN-END:variables
}
