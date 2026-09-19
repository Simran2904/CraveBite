package org.example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CraveBite");

        frame.setSize(900, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        JLabel title = new JLabel(
                "Welcome to CraveBite!",
                SwingConstants.CENTER
        );

        title.setFont(
                new java.awt.Font(
                        "Arial",
                        java.awt.Font.BOLD,
                        30
                )
        );

        frame.add(title);

        frame.setVisible(true);
    }
}