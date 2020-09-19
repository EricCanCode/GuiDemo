/**
Author: Eric Haynes

Program: Sales Tax Calculator Program

File: Project 2.java

Description: Main class to present GUI to allow user to input various vehicle specs
             and performs calculations based on predefined mathematical formulas

Date: Created 09-15-2020
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Project2 {
    private static final int MAX_IN_LIST = 5;

    public static void main(String[] Args) {
        ArrayList<String> automobile = new ArrayList<>(5);

        //create frame and panels
        JFrame frame = new JFrame();
        JPanel main = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel radio = new JPanel(new GridLayout(3, 3, 5, 5));
        JPanel buttons = new JPanel(new GridLayout(2, 2, 5, 5));
        frame.add(main);

        //main panel
        main.add(panel, BorderLayout.NORTH);
        main.add(radio, BorderLayout.CENTER);
        main.add(buttons, BorderLayout.SOUTH);

        //panel panel
        JLabel makeLabel = new JLabel("         Make and Model");
        JLabel priceLabel = new JLabel("         Sales price");
        JTextField priceField = new JTextField("");
        JTextField makeField = new JTextField("");

        //add items to panel
        panel.add(makeLabel);
        panel.add(makeField);
        panel.add(priceLabel);
        panel.add(priceField);

        //radio panel
        Border blueLine = BorderFactory.createTitledBorder("Automobile Type");
        JLabel weightLabel = new JLabel("Weight in Pounds", JLabel.CENTER);
        JLabel mpgLabel = new JLabel("Miles Per Gallon", JLabel.CENTER);
        JTextField weightField = new JTextField("", JTextField.RIGHT);
        JTextField mpgField = new JTextField("", JTextField.RIGHT);

        // hybrid radiobutton
        JRadioButton hybridButton = new JRadioButton("Hybrid");

        //electric radiobutton
        JRadioButton electricButton = new JRadioButton("Electric");

        //other radiobutton
        JRadioButton otherButton = new JRadioButton("Other");

        // add radio buttons to group
        ButtonGroup autoType = new ButtonGroup();
        autoType.add(hybridButton);
        autoType.add(electricButton);
        autoType.add(otherButton);

        //add items to radio panel
        radio.setBorder(blueLine);
        radio.add(hybridButton);
        radio.add(mpgLabel);
        radio.add(mpgField);
        radio.add(electricButton);
        radio.add(weightLabel);
        radio.add(weightField);
        radio.add(otherButton);

        //button panel
        JTextField resultTxt = new JTextField();
        resultTxt.setBackground(Color.LIGHT_GRAY);
        resultTxt.setEditable(false);
        JButton compute = new JButton("Compute Sales Tax");

        //compute button
        compute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int price = Integer.parseInt(priceField.getText());
                    String make = makeField.getText();

                    if (hybridButton.isSelected()) {
                        int mpg = Integer.parseInt(mpgField.getText());
                        Hybrid hyb = new Hybrid(make, price, mpg);
                        resultTxt.setText(String.valueOf(hyb.SalesTax()));
                        automobile.add(hyb.toString());
                    }
                    if (electricButton.isSelected()) {
                        int weight = Integer.parseInt(weightField.getText());
                        Electric elec = new Electric(make, price, weight);
                        resultTxt.setText(String.valueOf(elec.SalesTax()));
                        automobile.add(elec.toString());
                    }
                    if (otherButton.isSelected()) {
                        Automobile auto = new Automobile(make, price);
                        resultTxt.setText(String.valueOf(auto.SalesTax()));
                        automobile.add(auto.toString());
                    }
                    if (automobile.size() > MAX_IN_LIST) {
                        automobile.remove(0);
                    }

                } catch (Exception D) {
                    JOptionPane.showMessageDialog(buttons, "You entered an invalid entry");
                }
            }
        });

        //clear button
        JButton clear = new JButton("Clear Fields");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTxt.setText("");
                mpgField.setText("");
                weightField.setText("");
                makeField.setText("");
                priceField.setText("");
            }
        });

        //display button
        JButton display = new JButton("Display Report");
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";

                for (int i = 0; i < automobile.size(); i++) {
                    String k = automobile.get(i);
                    s = s + k + "\n";
                }
                JOptionPane.showMessageDialog(buttons, s);
            }
        });

        //add items to button panel
        buttons.add(compute);
        buttons.add(resultTxt);
        buttons.add(clear);
        buttons.add(display);

        //JFrame parameters
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Automobile SalesTax Calculator");

    }
}
