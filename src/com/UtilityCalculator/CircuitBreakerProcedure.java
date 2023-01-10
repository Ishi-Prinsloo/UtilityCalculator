package com.UtilityCalculator;

import javax.swing.*;
import java.awt.event.*;

public class CircuitBreakerProcedure extends JDialog {
    public JPanel getCircuitProcedurePane() {
        return circuitProcedurePane;
    }

    private JPanel circuitProcedurePane;

    public CircuitBreakerProcedure() {
        setContentPane(circuitProcedurePane);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        circuitProcedurePane.registerKeyboardAction(e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        CircuitBreakerProcedure dialog = new CircuitBreakerProcedure();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
