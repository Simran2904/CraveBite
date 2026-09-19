package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class OrderSuccessFrame extends JFrame {

    // Colors
    private final Color PINK = new Color(255, 105, 150);
    private final Color DARK_PINK = new Color(220, 70, 120);
    private final Color LIGHT_PINK = new Color(255, 240, 245);
    private final Color DARK_TEXT = new Color(70, 40, 50);

    public OrderSuccessFrame() {

        setTitle("Order Successful - CraveBite");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        createUI();

        setVisible(true);
    }

    private void createUI() {

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(LIGHT_PINK);

        // -------------------------------------------------
        // TOP BAR
        // -------------------------------------------------

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(DARK_PINK);
        topPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 15, 25
                )
        );

        JLabel titleLabel = new JLabel("🍴 CraveBite");
        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 25)
        );
        titleLabel.setForeground(Color.WHITE);

        JLabel orderLabel = new JLabel("ORDER CONFIRMATION");
        orderLabel.setFont(
                new Font("Arial", Font.BOLD, 16)
        );
        orderLabel.setForeground(Color.WHITE);

        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(orderLabel, BorderLayout.EAST);

        // -------------------------------------------------
        // CENTER CONTENT
        // -------------------------------------------------

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(
                new BoxLayout(
                        centerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        centerPanel.setBackground(LIGHT_PINK);
        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        45, 40, 30, 40
                )
        );

        // Success icon
        JLabel successIcon = new JLabel("✓");
        successIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
        successIcon.setHorizontalAlignment(
                SwingConstants.CENTER
        );
        successIcon.setOpaque(true);
        successIcon.setBackground(PINK);
        successIcon.setForeground(Color.WHITE);
        successIcon.setFont(
                new Font("Arial", Font.BOLD, 55)
        );

        successIcon.setPreferredSize(
                new Dimension(100, 100)
        );
        successIcon.setMaximumSize(
                new Dimension(100, 100)
        );
        successIcon.setMinimumSize(
                new Dimension(100, 100)
        );

        centerPanel.add(successIcon);

        centerPanel.add(
                Box.createVerticalStrut(25)
        );

        // Main success message
        JLabel successLabel =
                new JLabel("Order Placed Successfully!");

        successLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        successLabel.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        successLabel.setForeground(DARK_TEXT);

        centerPanel.add(successLabel);

        centerPanel.add(
                Box.createVerticalStrut(15)
        );

        // Thank you message
        JLabel thankYouLabel =
                new JLabel(
                        "Thank you for ordering with CraveBite ❤️"
                );

        thankYouLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        thankYouLabel.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        thankYouLabel.setForeground(
                new Color(100, 70, 80)
        );

        centerPanel.add(thankYouLabel);

        centerPanel.add(
                Box.createVerticalStrut(20)
        );

        // Order information
        JLabel infoLabel =
                new JLabel(
                        "Your delicious food is being prepared."
                );

        infoLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        infoLabel.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        infoLabel.setForeground(
                new Color(100, 80, 90)
        );

        centerPanel.add(infoLabel);

        centerPanel.add(
                Box.createVerticalStrut(8)
        );

        JLabel deliveryLabel =
                new JLabel(
                        "Sit back, relax and enjoy! 🍕🍔"
                );

        deliveryLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        deliveryLabel.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        deliveryLabel.setForeground(
                new Color(100, 80, 90)
        );

        centerPanel.add(deliveryLabel);

        // -------------------------------------------------
        // BUTTON PANEL
        // -------------------------------------------------

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        20
                )
        );

        buttonPanel.setBackground(LIGHT_PINK);

        // HOME BUTTON
        JButton homeButton =
                new JButton("🏠 BACK TO HOME");

        styleButton(homeButton);

        homeButton.addActionListener(e -> {

            dispose();

            new HomeFrame().setVisible(true);
        });

        // CART BUTTON
        JButton cartButton =
                new JButton("🛒 VIEW CART");

        styleButton(cartButton);

        cartButton.addActionListener(e -> {

            dispose();

            new CartFrame().setVisible(true);
        });

        buttonPanel.add(homeButton);
        buttonPanel.add(cartButton);

        // -------------------------------------------------
        // ADD EVERYTHING
        // -------------------------------------------------

        mainPanel.add(
                topPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);
    }

    // -------------------------------------------------
    // BUTTON STYLE
    // -------------------------------------------------

    private void styleButton(JButton button) {

        button.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        button.setForeground(Color.WHITE);
        button.setBackground(DARK_PINK);

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        button.setPreferredSize(
                new Dimension(190, 45)
        );
    }

    // -------------------------------------------------
    // MAIN METHOD
    // -------------------------------------------------

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new OrderSuccessFrame();
        });
    }
}