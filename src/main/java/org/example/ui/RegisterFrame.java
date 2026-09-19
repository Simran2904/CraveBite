package org.example.ui;

import org.example.database.UserDAO;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegisterFrame() {

        setTitle("CraveBite ❤️ - Create Account");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(new Dimension(1000, 650));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // =========================================================
        // ROMANTIC ANIMATED BACKGROUND
        // =========================================================

        RomanticBackground background = new RomanticBackground();

        setContentPane(background);

        background.setLayout(
                new GridBagLayout()
        );

        // =========================================================
        // REGISTRATION CARD
        // =========================================================

        JPanel card = new JPanel();

        card.setPreferredSize(
                new Dimension(450, 610)
        );

        card.setBackground(
                new Color(35, 10, 20, 245)
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(180, 70, 100),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                25,
                                35,
                                25,
                                35
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        // =========================================================
        // LOGO
        // =========================================================

        JLabel logo = new JLabel(
                "♥ CraveBite"
        );

        logo.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        30
                )
        );

        logo.setForeground(
                new Color(255, 190, 200)
        );

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(logo);

        card.add(
                Box.createVerticalStrut(5)
        );

        // =========================================================
        // HEADING
        // =========================================================

        JLabel heading = new JLabel(
                "Create Your Account"
        );

        heading.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        heading.setForeground(
                Color.WHITE
        );

        heading.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(heading);

        card.add(
                Box.createVerticalStrut(5)
        );

        // =========================================================
        // ROMANTIC MESSAGE
        // =========================================================

        JLabel message = new JLabel(
                "Your next delicious story starts here ♥"
        );

        message.setFont(
                new Font(
                        "SansSerif",
                        Font.ITALIC,
                        13
                )
        );

        message.setForeground(
                new Color(220, 170, 180)
        );

        message.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(message);

        card.add(
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // NAME
        // =========================================================

        card.add(
                createLabel("Full Name")
        );

        nameField = createTextField(
                "Enter your name"
        );

        card.add(nameField);

        card.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // EMAIL
        // =========================================================

        card.add(
                createLabel("Email")
        );

        emailField = createTextField(
                "Enter your email"
        );

        card.add(emailField);

        card.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // PHONE
        // =========================================================

        card.add(
                createLabel("Phone Number")
        );

        phoneField = createTextField(
                "Enter your phone number"
        );

        card.add(phoneField);

        card.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // PASSWORD
        // =========================================================

        card.add(
                createLabel("Password")
        );

        passwordField =
                new JPasswordField();

        stylePasswordField(
                passwordField
        );

        card.add(passwordField);

        card.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // CONFIRM PASSWORD
        // =========================================================

        card.add(
                createLabel("Confirm Password")
        );

        confirmPasswordField =
                new JPasswordField();

        stylePasswordField(
                confirmPasswordField
        );

        card.add(
                confirmPasswordField
        );

        card.add(
                Box.createVerticalStrut(15)
        );

        // =========================================================
        // TERMS CHECKBOX
        // =========================================================

        JCheckBox termsCheckBox =
                new JCheckBox(
                        "I agree to the CraveBite terms ❤️"
                );

        termsCheckBox.setForeground(
                new Color(220, 190, 200)
        );

        termsCheckBox.setBackground(
                new Color(35, 10, 20)
        );

        termsCheckBox.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        termsCheckBox.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(
                termsCheckBox
        );

        card.add(
                Box.createVerticalStrut(15)
        );

        // =========================================================
        // CREATE ACCOUNT BUTTON
        // =========================================================

        JButton registerButton =
                new JButton(
                        "CREATE ACCOUNT  ♥"
                );

        registerButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        registerButton.setPreferredSize(
                new Dimension(300, 45)
        );

        registerButton.setMaximumSize(
                new Dimension(350, 45)
        );

        registerButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        registerButton.setForeground(
                Color.WHITE
        );

        registerButton.setBackground(
                new Color(180, 50, 85)
        );

        registerButton.setFocusPainted(
                false
        );

        registerButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );

        registerButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        card.add(
                registerButton
        );

        // =========================================================
        // CREATE ACCOUNT ACTION
        // =========================================================

        registerButton.addActionListener(e -> {

            // -----------------------------------------------------
            // GET VALUES FROM FORM
            // -----------------------------------------------------

            String name =
                    nameField
                            .getText()
                            .trim();

            String email =
                    emailField
                            .getText()
                            .trim();

            String phone =
                    phoneField
                            .getText()
                            .trim();

            String password =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            String confirmPassword =
                    new String(
                            confirmPasswordField
                                    .getPassword()
                    );

            // -----------------------------------------------------
            // VALIDATION
            // -----------------------------------------------------

            if (name.isEmpty()
                    || email.isEmpty()
                    || phone.isEmpty()
                    || password.isEmpty()
                    || confirmPassword.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all fields ❤️",
                        "Almost there!",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // -----------------------------------------------------
            // EMAIL VALIDATION
            // -----------------------------------------------------

            if (!email.contains("@")) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a valid email address.",
                        "Invalid Email",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // -----------------------------------------------------
            // PASSWORD MATCH
            // -----------------------------------------------------

            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Passwords do not match.",
                        "Oops!",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // -----------------------------------------------------
            // TERMS
            // -----------------------------------------------------

            if (!termsCheckBox.isSelected()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please accept the terms first ❤️",
                        "One little thing...",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // =====================================================
            // SAVE USER TO MYSQL
            // =====================================================

            try {

                boolean registered =
                        UserDAO.registerUser(
                                name,
                                email,
                                phone,
                                password
                        );

                // -------------------------------------------------
                // SUCCESS
                // -------------------------------------------------

                if (registered) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Welcome to CraveBite, "
                                    + name
                                    + "! ❤️\n\n"
                                    + "Your delicious story "
                                    + "is about to begin.",
                            "Account Created!",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    // Go back to login
                    dispose();

                    new LoginFrame();

                }

            } catch (Exception ex) {

                // =================================================
                // DATABASE ERROR
                // =================================================

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Unable to create your account.\n\n"
                                + "Database Error:\n"
                                + ex.getMessage(),
                        "Registration Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // =========================================================
        // ALREADY HAVE ACCOUNT
        // =========================================================

        card.add(
                Box.createVerticalStrut(12)
        );

        JButton loginButton =
                new JButton(
                        "Already have an account? Login"
                );

        loginButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginButton.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        loginButton.setForeground(
                new Color(255, 170, 190)
        );

        loginButton.setBackground(
                new Color(35, 10, 20)
        );

        loginButton.setBorderPainted(
                false
        );

        loginButton.setFocusPainted(
                false
        );

        loginButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        card.add(
                loginButton
        );

        // =========================================================
        // LOGIN BUTTON ACTION
        // =========================================================

        loginButton.addActionListener(e -> {

            dispose();

            new LoginFrame();

        });

        // =========================================================
        // ADD CARD TO BACKGROUND
        // =========================================================

        background.add(card);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =============================================================
    // CREATE LABEL
    // =============================================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(
                new Color(
                        240,
                        210,
                        220
                )
        );

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }

    // =============================================================
    // CREATE TEXT FIELD
    // =============================================================

    private JTextField createTextField(
            String placeholder
    ) {

        JTextField field =
                new JTextField();

        field.setMaximumSize(
                new Dimension(
                        350,
                        38
                )
        );

        field.setPreferredSize(
                new Dimension(
                        350,
                        38
                )
        );

        field.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        field.setForeground(
                Color.WHITE
        );

        field.setBackground(
                new Color(
                        55,
                        20,
                        35
                )
        );

        field.setCaretColor(
                Color.WHITE
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        120,
                                        50,
                                        75
                                )
                        ),

                        BorderFactory.createEmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );

        field.setToolTipText(
                placeholder
        );

        return field;
    }

    // =============================================================
    // STYLE PASSWORD FIELD
    // =============================================================

    private void stylePasswordField(
            JPasswordField field
    ) {

        field.setMaximumSize(
                new Dimension(
                        350,
                        38
                )
        );

        field.setPreferredSize(
                new Dimension(
                        350,
                        38
                )
        );

        field.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        field.setForeground(
                Color.WHITE
        );

        field.setBackground(
                new Color(
                        55,
                        20,
                        35
                )
        );

        field.setCaretColor(
                Color.WHITE
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        120,
                                        50,
                                        75
                                )
                        ),

                        BorderFactory.createEmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                RegisterFrame::new
        );
    }
}