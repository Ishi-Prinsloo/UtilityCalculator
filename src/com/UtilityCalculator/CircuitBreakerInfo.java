package com.UtilityCalculator;

import javax.swing.*;
import java.awt.event.*;

public class CircuitBreakerInfo extends JDialog {
    public JPanel getCircuitInfoPanel() {
        return circuitInfoPanel;
    }

    private JPanel circuitInfoPanel;

    public CircuitBreakerInfo() {
        setContentPane(circuitInfoPanel);
        setModal(true);



        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        circuitInfoPanel.registerKeyboardAction(e ->
                onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CircuitBreakerInfo dialog = new CircuitBreakerInfo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
