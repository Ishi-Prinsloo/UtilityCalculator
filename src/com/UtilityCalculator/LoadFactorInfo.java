package com.UtilityCalculator;

import javax.swing.*;
import java.awt.event.*;

public class LoadFactorInfo extends JDialog {
    private JPanel loadFactorInfoPane;

    public JPanel getLoadFactorInfoPane() {
        return loadFactorInfoPane;
    }

    public LoadFactorInfo() {
        setContentPane(loadFactorInfoPane);
        setModal(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });


        loadFactorInfoPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        LoadFactorInfo dialog = new LoadFactorInfo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
