package com.UtilityCalculator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.UtilityCalculator.NmdFunction.isNumeric;

public class LoadFactorFunction {
    private JTextField kwh01;
    private JTextField kva01;
    private JTextField kwh02;
    private JTextField kva02;
    private JTextField kwh03;
    private JTextField kva03;
    private JTextField kwhR01;
    private JTextField kwhR02;
    private JTextField kwhR03;
    private JTextField kwhR04;
    private JTextField kwhR05;
    private JTextField kwhR06;
    private JTextField kwhR07;
    private JTextField kwhR08;
    private JTextField kwhR09;
    private JTextField kwhR10;
    private JTextField kwhR11;
    private JTextField kwhR12;
    private JPanel lFPane;
    private JButton calculateLeftButton;
    private JButton calculateRightButton;
    private JLabel lP01;
    private JLabel lP02;
    private JLabel lP03;
    private JLabel kV01;
    private JLabel kV02;
    private JLabel kV03;
    private JLabel kV04;
    private JLabel kV05;
    private JLabel kV06;
    private JLabel kV07;
    private JLabel kV08;
    private JLabel kV09;
    private JLabel kV10;
    private JLabel kV11;
    private JLabel kV12;
    private JTextField averagePercentTextField;
    private JLabel averagePercent;
    private JLabel warningKva;
    private JButton infoButton;
    private JButton procedureButton;

    public JPanel getLFPane() {
        return lFPane;
    }

    List<JTextField> kwhTextField = Arrays.asList(kwh01, kwh02, kwh03);

    List<JTextField> kvaTextField = Arrays.asList(kva01, kva02, kva03);

    List<JLabel> lineLFP = Arrays.asList(lP01, lP02, lP03);

    List<JTextField> kwhRTextField = Arrays.asList(kwhR01, kwhR02, kwhR03, kwhR04, kwhR05, kwhR06, kwhR07, kwhR08,
            kwhR09, kwhR10, kwhR11, kwhR12);

    List<JLabel> kvaRTextFields = Arrays.asList(kV01, kV02, kV03, kV04, kV05, kV06, kV07, kV08, kV09, kV10, kV11, kV12);

    public LoadFactorFunction() {

        calculateLeftButton.addActionListener(e -> calculateLineLF());

        calculateRightButton.addActionListener(e -> {
            warningKva.setVisible(false);
            calculateKvA();
        });

        infoButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setContentPane(new LoadFactorInfo().getLoadFactorInfoPane());
            dialog.setDefaultCloseOperation(dialog.getDefaultCloseOperation());
            dialog.setTitle("Load-Power Factor Info");
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        });
        procedureButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setContentPane(new LoadPowerFactorProcedure().getLoadFactorProcPane());
            dialog.setDefaultCloseOperation(dialog.getDefaultCloseOperation());
            dialog.setTitle("Load-Power Factor Procedure");
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        });
    }

    private void calculateKvA() {
        int x;
        for(x = 0; x < kwhRTextField.size(); x++) {
            if(!averagePercentTextField.getText().equals("")) {
                if(!kwhRTextField.get(x).getText().equals("") ) {
                    double a = Double.parseDouble(kwhRTextField.get(x).getText());
                    double b = Double.parseDouble(averagePercentTextField.getText());
                    double c = Math.round(((a / 720) / b * 100 ) * 100) / 100d;
                    kvaRTextFields.get(x).setText(c + " ");
                }
            } else if(!isNumeric(averagePercentTextField.getText())) {
                warningKva.setText("Please enter only digits");
                warningKva.setVisible(true);
            } else {
                warningKva.setText("Please enter an average load-power factor");
            }
        }
    }

    private void calculateAveragePercent() {
        int x;
        List<Double> percentValues = new ArrayList<>();

        for (x = 0; x < lineLFP.size(); x++) {
            if(!lineLFP.get(x).getText().equals("0.00 % ")){
                StringBuilder sb = new StringBuilder();
                sb.append(lineLFP.get(x).getText());
                sb.deleteCharAt(sb.length() -1);
                percentValues.add(Double.valueOf(sb.toString()));
            }
        }
        double total = 0.00;
        int y;
        for(y = 0; y < percentValues.size(); y++) {
            total += percentValues.get(y);
        }
        averagePercent.setText(Math.round((total / percentValues.size()) * 100) / 100d + "%");
    }

    private void calculateLineLF() {
        int x;
        for(x = 0; x < lineLFP.size(); x++) {
            double d;
            double c;
            if (!kvaTextField.get(x).getText().equals("")) {
                double a = Double.parseDouble(kwhTextField.get(x).getText());
                double b = Double.parseDouble(kvaTextField.get(x).getText());

                c = a/(b * 720);
                d = c * 100;

                lineLFP.get(x).setText(Math.round(d * 100) / 100d  + "%");
            }
        }
        calculateAveragePercent();
    }
}
