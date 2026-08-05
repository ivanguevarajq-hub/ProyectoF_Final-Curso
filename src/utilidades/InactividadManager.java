package utilidades;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import presentacion.FrmPrincipal;

public class InactividadManager {

    private static final int TIEMPO_INACTIVIDAD_MS =  5 * 60 * 1000;
    private final Timer timer;
    private final JFrame ventana;

    public InactividadManager(JFrame ventana) {
        this.ventana = ventana;
        this.timer = new Timer(TIEMPO_INACTIVIDAD_MS, e -> cerrarSesion());
        this.timer.setRepeats(false);
    }

    public void iniciar() {
        long eventMask = AWTEvent.MOUSE_EVENT_MASK
                | AWTEvent.MOUSE_MOTION_EVENT_MASK
                | AWTEvent.KEY_EVENT_MASK;

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if (event instanceof MouseEvent || event instanceof KeyEvent) {
                    reiniciarTimer();
                }
            }
        }, eventMask);

        timer.start();
    }

    private void reiniciarTimer() {
        if (timer.isRunning()) {
            timer.restart();
        }
    }

    public void detener() {
        if (timer != null) {
            timer.stop();
        }
    }

    private void cerrarSesion() {
        timer.stop();

        JOptionPane.showMessageDialog(ventana,
                "Su sesión ha expirado por inactividad (5 minutos).",
                "Sesión Expirada",
                JOptionPane.WARNING_MESSAGE);

        ventana.dispose();

        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });

    }
}
