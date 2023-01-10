package com.UtilityCalculator;

import javax.swing.*;

public class NmdFunction {
    private JPanel panelNmd;
    private JRadioButton threePhase;
    private JTextField breakerSizeText;
    private JLabel nmdValue;
    private JComboBox<Object> volts;
    private JRadioButton singlePhase;
    private JButton calculateButton;
    private JButton info;

    private void createUIComponents() {
        volts = new JComboBox<>();
        volts.addItem(makeObj("380"));
        volts.addItem(makeObj("400"));
    }

    private Object makeObj  (final String item) {
        return new Object() {
            public  String toString() {return item;}
        };
    }

    public NmdFunction() {

        singlePhase.addActionListener(e -> {
            volts.removeAllItems();
            volts.addItem("230");
        });

        threePhase.addActionListener(e -> {
            volts.removeAllItems();
            volts.addItem("380");
            volts.addItem("400");
        });

        calculateButton.addActionListener(e -> {
            if(breakerSizeText.getText().contains(".")) {
                nmdValue.setText("Please enter only whole numbers");
            } else if(breakerSizeText.getText().equals("")) {
                nmdValue.setText("0 kVa");
            } else if(isNumeric(breakerSizeText.getText())) {
                nmdValue.setText(nmd(breakerSizeText.getText()) + " kVa");
            } else {
                nmdValue.setText("Please enter only digits");
            }
        });

        info.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setContentPane(new NmdInfo().getNmdInfoPane());
            dialog.setDefaultCloseOperation(dialog.getDefaultCloseOperation());
            dialog.setTitle("NMD Info");
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        });
    }

    private String nmd(String breakerSize) {
        int BreakerSizeInt = Integer.parseInt(breakerSize);
        double voltageDivThou;
        if (volts.getSelectedItem() == null) {
            volts.getItemAt(0);
        }
        voltageDivThou = Double.parseDouble(volts.getSelectedItem().toString()) / 1000;
        String result = "";

        if (singlePhase.isSelected()) {
            result = (Math.round(BreakerSizeInt * voltageDivThou)) + " ";
        } else if (threePhase.isSelected()) {
            result = (Math.round(1.7321 * BreakerSizeInt * voltageDivThou)) + " ";
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public JPanel getPanelNmd() {
        return panelNmd;
    }
}
