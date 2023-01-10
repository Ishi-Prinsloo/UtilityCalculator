package com.UtilityCalculator;

import javax.swing.*;
import java.awt.event.*;

public class LoadPowerFactorProcedure extends JDialog {
    private JPanel loadFactorProcPane;

    public JPanel getLoadFactorProcPane() {
        return loadFactorProcPane;
    }

    public LoadPowerFactorProcedure() {
        setContentPane(loadFactorProcPane);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        loadFactorProcPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        LoadPowerFactorProcedure dialog = new LoadPowerFactorProcedure();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
