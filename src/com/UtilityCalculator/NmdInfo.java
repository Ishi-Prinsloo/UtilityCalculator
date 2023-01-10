package com.UtilityCalculator;

import javax.swing.*;
import java.awt.event.*;

public class NmdInfo extends JDialog {
    public JPanel getNmdInfoPane() {
        return nmdInfoPane;
    }

    private JPanel nmdInfoPane;


    public NmdInfo() {
        setContentPane(nmdInfoPane);
        setModal(true);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        nmdInfoPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        NmdInfo dialog = new NmdInfo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
