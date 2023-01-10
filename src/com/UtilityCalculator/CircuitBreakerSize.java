package com.UtilityCalculator;

import javax.swing.*;
import static com.UtilityCalculator.NmdFunction.isNumeric;

public class CircuitBreakerSize {
    private JTextField inputKwh;
    private JLabel singleAmpere;
    private JLabel valueSingleCircuitBreaker;
    private JLabel threeAmpere;
    private JLabel valueThreeCircuitBreaker;
    private JButton calculateButton;
    private JPanel panelCircuit;
    private JButton infoButton;
    private JLabel warning;
    private JButton procedureButton;

    public JPanel getPanelCircuit() {
        return panelCircuit;
    }

    public CircuitBreakerSize() {
        calculateButton.addActionListener(e -> {
            if(!inputKwh.getText().equals("") && isNumeric(inputKwh.getText())) {
                warning.setVisible(false);
                double kwh = Integer.parseInt(inputKwh.getText());
                double singApplicable = ((kwh / 200) * 1000) / 230;
                if (singApplicable > 100) {
                    singleAmpere.setText("Not Available");
                    valueSingleCircuitBreaker.setText("Not Available");
                } else {
                    singleAmpere.setText(String.valueOf(Math.round(singApplicable * 100.0) / 100.0));
                    double singBreaker = Double.parseDouble(singleAmpere.getText()) * 1.25;
                    valueSingleCircuitBreaker.setText(String.valueOf((int) Math.ceil(singBreaker/10) * 10));
                }
                double threeApplicable = ((kwh/200)*1000)/(400*1.732);
                threeAmpere.setText(String.valueOf(Math.round(threeApplicable * 100.0) / 100.0));
                double threeBreaker = Double.parseDouble(threeAmpere.getText()) * 1.25;
                valueThreeCircuitBreaker.setText(String.valueOf((int) Math.ceil(threeBreaker/10) * 10));
            } else if (!isNumeric(inputKwh.getText())) {
                    warning.setText("Please enter only digits");
                    warning.setVisible(true);
            }
        });

        infoButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setContentPane(new CircuitBreakerInfo().getCircuitInfoPanel());
            dialog.setDefaultCloseOperation(dialog.getDefaultCloseOperation());
            dialog.setTitle("Circuit Breaker Info");
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        });

        procedureButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setContentPane(new CircuitBreakerProcedure().getCircuitProcedurePane());
            dialog.setDefaultCloseOperation(dialog.getDefaultCloseOperation());
            dialog.setTitle("RMS Virtual Downgrade Procedures");
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        });
    }
}
