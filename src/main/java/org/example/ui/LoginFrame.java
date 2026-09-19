package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private RomanticBackground backgroundPanel;

    public LoginFrame() {

        setTitle("CraveBite ❤️");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Open maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 650));

        // Create animated background
        backgroundPanel = new RomanticBackground();

        // Main layout
        backgroundPanel.setLayout(new GridBagLayout());

        // =========================================================
        // LEFT SIDE - ROMANTIC MESSAGE
        // =========================================================

        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)
        );

        JLabel heartLogo = new JLabel("♥");
        heartLogo.setFont(
                new Font("Serif", Font.BOLD, 70)
        );
        heartLogo.setForeground(
                new Color(255, 105, 140)
        );
        heartLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logo = new JLabel("CRAVEBITE");
        logo.setFont(
                new Font("Serif", Font.BOLD, 48)
        );
        logo.setForeground(
                new Color(255, 220, 150)
        );
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagline = new JLabel(
                "Some stories begin with dinner."
        );
        tagline.setFont(
                new Font("Serif", Font.ITALIC, 21)
        );
        tagline.setForeground(
                new Color(255, 235, 240)
        );
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel romanticMessage = new JLabel(
                "<html><div style='text-align:center;'>"
                        + "Good food brings people closer.<br>"
                        + "Maybe tonight is the beginning of<br>"
                        + "something delicious. ❤️"
                        + "</div></html>"
        );

        romanticMessage.setFont(
                new Font("Serif", Font.PLAIN, 18)
        );

        romanticMessage.setForeground(
                new Color(225, 190, 200)
        );

        romanticMessage.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(heartLogo);

        leftPanel.add(
                Box.createVerticalStrut(5)
        );

        leftPanel.add(logo);

        leftPanel.add(
                Box.createVerticalStrut(12)
        );

        leftPanel.add(tagline);

        leftPanel.add(
                Box.createVerticalStrut(30)
        );

        leftPanel.add(romanticMessage);

        leftPanel.add(Box.createVerticalGlue());

        // =========================================================
        // RIGHT SIDE - LOGIN CARD
        // =========================================================

        JPanel loginCard = new JPanel();

        loginCard.setPreferredSize(
                new Dimension(430, 500)
        );

        loginCard.setLayout(
                new BoxLayout(
                        loginCard,
                        BoxLayout.Y_AXIS
                )
        );

        loginCard.setBackground(
                new Color(30, 12, 20, 235)
        );

        loginCard.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(180, 70, 100),
                                2
                        ),

                        BorderFactory.createEmptyBorder(
                                40,
                                45,
                                40,
                                45
                        )
                )
        );

        // =========================================================
        // LOGIN TITLE
        // =========================================================

        JLabel loginHeart = new JLabel("♥");

        loginHeart.setFont(
                new Font("Serif", Font.BOLD, 42)
        );

        loginHeart.setForeground(
                new Color(255, 90, 130)
        );

        loginHeart.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel welcome = new JLabel(
                "Welcome Back, Love"
        );

        welcome.setFont(
                new Font("Serif", Font.BOLD, 30)
        );

        welcome.setForeground(Color.WHITE);

        welcome.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitle = new JLabel(
                "Ready for another delicious date?"
        );

        subtitle.setFont(
                new Font("Serif", Font.ITALIC, 15)
        );

        subtitle.setForeground(
                new Color(220, 180, 195)
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =========================================================
        // EMAIL
        // =========================================================

        JLabel emailLabel = new JLabel("EMAIL");

        emailLabel.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        emailLabel.setForeground(
                new Color(255, 190, 205)
        );

        emailLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JTextField emailField = new JTextField();

        emailField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        emailField.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        emailField.setForeground(Color.WHITE);

        emailField.setCaretColor(Color.WHITE);

        emailField.setBackground(
                new Color(55, 20, 33)
        );

        emailField.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(120, 50, 75)
                        ),

                        BorderFactory.createEmptyBorder(
                                8,
                                12,
                                8,
                                12
                        )
                )
        );

        // =========================================================
        // PASSWORD
        // =========================================================

        JLabel passwordLabel = new JLabel(
                "PASSWORD"
        );

        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 12)
        );

        passwordLabel.setForeground(
                new Color(255, 190, 205)
        );

        passwordLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JPasswordField passwordField =
                new JPasswordField();

        passwordField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        passwordField.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        passwordField.setForeground(Color.WHITE);

        passwordField.setCaretColor(Color.WHITE);

        passwordField.setBackground(
                new Color(55, 20, 33)
        );

        passwordField.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(120, 50, 75)
                        ),

                        BorderFactory.createEmptyBorder(
                                8,
                                12,
                                8,
                                12
                        )
                )
        );

        // =========================================================
        // FORGOT PASSWORD
        // =========================================================

        JButton forgotButton =
                new JButton("Forgot password?");

        forgotButton.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );

        forgotButton.setForeground(
                new Color(255, 150, 175)
        );

        forgotButton.setBackground(
                new Color(30, 12, 20)
        );

        forgotButton.setBorderPainted(false);
        forgotButton.setFocusPainted(false);

        forgotButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        forgotButton.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        // =========================================================
        // LOGIN BUTTON
        // =========================================================

        JButton loginButton =
                new JButton("CONTINUE  ♥");

        loginButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        loginButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        loginButton.setForeground(Color.WHITE);

        loginButton.setBackground(
                new Color(225, 55, 95)
        );

        loginButton.setBorderPainted(false);

        loginButton.setFocusPainted(false);

        loginButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        // Login button hover
        loginButton.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        loginButton.setBackground(
                                new Color(255, 90, 125)
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        loginButton.setBackground(
                                new Color(225, 55, 95)
                        );
                    }
                }
        );

        // =========================================================
        // REGISTER
        // =========================================================

        JLabel newUser = new JLabel(
                "Don't have an account?"
        );

        newUser.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        newUser.setForeground(
                new Color(190, 160, 170)
        );

        newUser.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JButton registerButton =
                new JButton("Create an account ♥");

        registerButton.setFont(
                new Font("Arial", Font.BOLD, 13)
        );

        registerButton.setForeground(
                new Color(255, 125, 155)
        );

        registerButton.setBackground(
                new Color(30, 12, 20)
        );

        registerButton.setBorderPainted(false);
        registerButton.setFocusPainted(false);

        registerButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        registerButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // =========================================================
        // ADD COMPONENTS TO CARD
        // =========================================================

        loginCard.add(loginHeart);

        loginCard.add(
                Box.createVerticalStrut(5)
        );

        loginCard.add(welcome);

        loginCard.add(
                Box.createVerticalStrut(7)
        );

        loginCard.add(subtitle);

        loginCard.add(
                Box.createVerticalStrut(30)
        );

        loginCard.add(emailLabel);

        loginCard.add(
                Box.createVerticalStrut(7)
        );

        loginCard.add(emailField);

        loginCard.add(
                Box.createVerticalStrut(18)
        );

        loginCard.add(passwordLabel);

        loginCard.add(
                Box.createVerticalStrut(7)
        );

        loginCard.add(passwordField);

        loginCard.add(
                Box.createVerticalStrut(5)
        );

        loginCard.add(forgotButton);

        loginCard.add(
                Box.createVerticalStrut(20)
        );

        loginCard.add(loginButton);

        loginCard.add(
                Box.createVerticalStrut(22)
        );

        loginCard.add(newUser);

        loginCard.add(
                Box.createVerticalStrut(2)
        );

        loginCard.add(registerButton);

        // =========================================================
        // COMBINE LEFT + RIGHT
        // =========================================================

        JPanel content = new JPanel(
                new GridBagLayout()
        );

        content.setOpaque(false);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(30, 50, 30, 50);

        // Left side
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.55;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        content.add(
                leftPanel,
                gbc
        );

        // Right side
        gbc.gridx = 1;
        gbc.weightx = 0.45;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        content.add(
                loginCard,
                gbc
        );

        backgroundPanel.add(content);

        setContentPane(backgroundPanel);

        // =========================================================
        // LOGIN BUTTON ACTION
        // =========================================================

        loginButton.addActionListener(e -> {

            String email =
                    emailField.getText().trim();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            if (email.isEmpty() ||
                    password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter your email and password ❤️",
                        "Almost there!",
                        JOptionPane.WARNING_MESSAGE
                );

            } else {

                dispose();

                new HomeFrame().setVisible(true);
            }
        });

        // =========================================================
        // REGISTER BUTTON ACTION
        // =========================================================

        registerButton.addActionListener(e -> {

            dispose();

            new RegisterFrame().setVisible(true);
        });

        // =========================================================
        // START
        // =========================================================

        setVisible(true);
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                LoginFrame::new
        );
    }
}