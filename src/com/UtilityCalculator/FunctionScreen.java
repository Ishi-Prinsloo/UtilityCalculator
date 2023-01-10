package com.UtilityCalculator;

import javax.swing.*;

public class FunctionScreen {
    JPanel panelMain;
    private JButton functionBreaker;
    private JButton functionNmd;
    private JButton functionLoadFactor;

    public FunctionScreen() {
        functionNmd.addActionListener(e -> {
            JFrame frame = new JFrame("NMD Calculator");
            frame.setContentPane(new NmdFunction().getPanelNmd());
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });

        functionBreaker.addActionListener(e -> {
            JFrame frame = new JFrame("Breaker Size Calculator");
            frame.setContentPane(new CircuitBreakerSize().getPanelCircuit());
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });

        functionLoadFactor.addActionListener(e -> {
            JFrame frame = new JFrame("Load Factor Calculator");
            frame.setContentPane(new LoadFactorFunction().getLFPane());
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
        });
    }
}
