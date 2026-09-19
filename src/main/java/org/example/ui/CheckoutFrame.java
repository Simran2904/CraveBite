package org.example.ui;

import org.example.database.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.*;

public class CheckoutFrame extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JComboBox<String> paymentBox;

    public CheckoutFrame() {

        setTitle("CraveBite - Checkout");

        setSize(1100, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        // =========================================================
        // MAIN PANEL
        // =========================================================

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 245, 245)
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        JPanel topPanel =
                new JPanel(new BorderLayout());

        topPanel.setBackground(Color.WHITE);

        topPanel.setBorder(
                new EmptyBorder(
                        18,
                        25,
                        18,
                        25
                )
        );

        JLabel titleLabel =
                new JLabel("❤️ CraveBite - Checkout");

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        JButton backButton =
                new JButton("← Back to Cart");

        backButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        backButton.setFocusPainted(false);

        backButton.addActionListener(e -> {

            dispose();

            new CartFrame();
        });

        topPanel.add(
                titleLabel,
                BorderLayout.WEST
        );

        topPanel.add(
                backButton,
                BorderLayout.EAST
        );

        mainPanel.add(
                topPanel,
                BorderLayout.NORTH
        );

        // =========================================================
        // CENTER CONTENT
        // =========================================================

        JPanel centerPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                25,
                                0
                        )
                );

        centerPanel.setBackground(
                new Color(245, 245, 245)
        );

        centerPanel.setBorder(
                new EmptyBorder(
                        25,
                        35,
                        25,
                        35
                )
        );

        // =========================================================
        // DELIVERY INFORMATION
        // =========================================================

        JPanel deliveryPanel =
                new JPanel();

        deliveryPanel.setLayout(
                new BoxLayout(
                        deliveryPanel,
                        BoxLayout.Y_AXIS
                )
        );

        deliveryPanel.setBackground(
                Color.WHITE
        );

        deliveryPanel.setBorder(
                new EmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

        JLabel deliveryTitle =
                new JLabel(
                        "Delivery Information"
                );

        deliveryTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        deliveryPanel.add(deliveryTitle);

        deliveryPanel.add(
                Box.createVerticalStrut(25)
        );

        // NAME

        JLabel nameLabel =
                new JLabel("Full Name");

        nameLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        deliveryPanel.add(nameLabel);

        deliveryPanel.add(
                Box.createVerticalStrut(5)
        );

        nameField =
                new JTextField();

        nameField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        nameField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        deliveryPanel.add(nameField);

        deliveryPanel.add(
                Box.createVerticalStrut(18)
        );

        // PHONE

        JLabel phoneLabel =
                new JLabel("Phone Number");

        phoneLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        deliveryPanel.add(phoneLabel);

        deliveryPanel.add(
                Box.createVerticalStrut(5)
        );

        phoneField =
                new JTextField();

        phoneField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        phoneField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        deliveryPanel.add(phoneField);

        deliveryPanel.add(
                Box.createVerticalStrut(18)
        );

        // ADDRESS

        JLabel addressLabel =
                new JLabel("Delivery Address");

        addressLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        deliveryPanel.add(addressLabel);

        deliveryPanel.add(
                Box.createVerticalStrut(5)
        );

        addressField =
                new JTextField();

        addressField.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        addressField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        deliveryPanel.add(addressField);

        deliveryPanel.add(
                Box.createVerticalStrut(18)
        );

        // PAYMENT

        JLabel paymentLabel =
                new JLabel("Payment Method");

        paymentLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        deliveryPanel.add(paymentLabel);

        deliveryPanel.add(
                Box.createVerticalStrut(5)
        );

        String[] paymentMethods = {
                "Cash on Delivery",
                "UPI",
                "Credit / Debit Card"
        };

        paymentBox =
                new JComboBox<>(
                        paymentMethods
                );

        paymentBox.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        paymentBox.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        deliveryPanel.add(paymentBox);

        centerPanel.add(deliveryPanel);

        // =========================================================
        // ORDER SUMMARY
        // =========================================================

        JPanel summaryPanel =
                new JPanel();

        summaryPanel.setLayout(
                new BoxLayout(
                        summaryPanel,
                        BoxLayout.Y_AXIS
                )
        );

        summaryPanel.setBackground(
                Color.WHITE
        );

        summaryPanel.setBorder(
                new EmptyBorder(
                        25,
                        25,
                        25,
                        25
                )
        );

        JLabel summaryTitle =
                new JLabel(
                        "Order Summary"
                );

        summaryTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        summaryPanel.add(summaryTitle);

        summaryPanel.add(
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // ITEMS
        // =========================================================

        for (Items item : Manager.getItems()) {

            JPanel itemRow =
                    new JPanel(
                            new BorderLayout()
                    );

            itemRow.setBackground(
                    Color.WHITE
            );

            JLabel itemName =
                    new JLabel(
                            item.getName()
                                    + " x "
                                    + item.getQuantity()
                    );

            itemName.setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            15
                    )
            );

            JLabel itemPrice =
                    new JLabel(
                            "₹"
                                    + item.getTotalPrice()
                    );

            itemPrice.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            15
                    )
            );

            itemRow.add(
                    itemName,
                    BorderLayout.WEST
            );

            itemRow.add(
                    itemPrice,
                    BorderLayout.EAST
            );

            itemRow.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            35
                    )
            );

            summaryPanel.add(itemRow);

            summaryPanel.add(
                    Box.createVerticalStrut(8)
            );
        }

        // =========================================================
        // SEPARATOR
        // =========================================================

        JSeparator separator =
                new JSeparator();

        separator.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        1
                )
        );

        summaryPanel.add(
                Box.createVerticalStrut(10)
        );

        summaryPanel.add(separator);

        summaryPanel.add(
                Box.createVerticalStrut(15)
        );

        // =========================================================
        // TOTAL
        // =========================================================

        JPanel totalPanel =
                new JPanel(
                        new BorderLayout()
                );

        totalPanel.setBackground(
                Color.WHITE
        );

        JLabel totalText =
                new JLabel("TOTAL");

        totalText.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        JLabel totalAmount =
                new JLabel(
                        "₹"
                                + Manager.getTotalPrice()
                );

        totalAmount.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        totalAmount.setForeground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        totalPanel.add(
                totalText,
                BorderLayout.WEST
        );

        totalPanel.add(
                totalAmount,
                BorderLayout.EAST
        );

        totalPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        summaryPanel.add(totalPanel);

        summaryPanel.add(
                Box.createVerticalStrut(30)
        );

        // =========================================================
        // PLACE ORDER BUTTON
        // =========================================================

        JButton placeOrderButton =
                new JButton(
                        "PLACE ORDER ❤️"
                );

        placeOrderButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        placeOrderButton.setForeground(
                Color.WHITE
        );

        placeOrderButton.setBackground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        placeOrderButton.setFocusPainted(false);

        placeOrderButton.setBorderPainted(false);

        placeOrderButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        placeOrderButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        summaryPanel.add(
                placeOrderButton
        );

        // =========================================================
        // PLACE ORDER ACTION
        // =========================================================

        placeOrderButton.addActionListener(e -> {

            placeOrder();
        });

        centerPanel.add(summaryPanel);

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        add(mainPanel);

        setVisible(true);
    }

    // =============================================================
    // PLACE ORDER
    // =============================================================

    private void placeOrder() {

        String name =
                nameField
                        .getText()
                        .trim();

        String phone =
                phoneField
                        .getText()
                        .trim();

        String address =
                addressField
                        .getText()
                        .trim();

        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your name.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (phone.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your phone number.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (address.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your delivery address.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (Manager.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Your cart is empty.",
                    "Empty Cart",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String payment =
                (String) paymentBox.getSelectedItem();

        int total =
                Manager.getTotalPrice();

        // =========================================================
        // SAVE ORDER TO DATABASE
        // =========================================================

        String orderSQL =
                "INSERT INTO orders " +
                        "(user_id, total_amount, status) " +
                        "VALUES (?, ?, ?)";

        String itemSQL =
                "INSERT INTO order_items " +
                        "(order_id, item_name, category, price, quantity, item_total) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = null;

        try {

            connection =
                    DBConnection.getConnection();

            // Start transaction
            connection.setAutoCommit(false);

            int orderId;

            // =====================================================
            // INSERT MAIN ORDER
            // =====================================================

            try (PreparedStatement orderStatement =
                         connection.prepareStatement(
                                 orderSQL,
                                 Statement.RETURN_GENERATED_KEYS
                         )) {

                // user_id is currently NULL because
                // CheckoutFrame does not yet have the logged-in
                // user's ID.

                orderStatement.setNull(
                        1,
                        Types.INTEGER
                );

                orderStatement.setBigDecimal(
                        2,
                        new BigDecimal(total)
                );

                orderStatement.setString(
                        3,
                        "Placed"
                );

                orderStatement.executeUpdate();

                // =================================================
                // GET GENERATED ORDER ID
                // =================================================

                try (ResultSet generatedKeys =
                             orderStatement.getGeneratedKeys()) {

                    if (!generatedKeys.next()) {

                        throw new SQLException(
                                "Could not get generated order ID."
                        );
                    }

                    orderId =
                            generatedKeys.getInt(1);
                }
            }

            // =====================================================
            // INSERT ORDER ITEMS
            // =====================================================

            try (PreparedStatement itemStatement =
                         connection.prepareStatement(itemSQL)) {

                for (Items item : Manager.getItems()) {

                    itemStatement.setInt(
                            1,
                            orderId
                    );

                    itemStatement.setString(
                            2,
                            item.getName()
                    );

                    itemStatement.setString(
                            3,
                            item.getCategory()
                    );

                    itemStatement.setBigDecimal(
                            4,
                            new BigDecimal(
                                    item.getPriceAsInt()
                            )
                    );

                    itemStatement.setInt(
                            5,
                            item.getQuantity()
                    );

                    itemStatement.setBigDecimal(
                            6,
                            new BigDecimal(
                                    item.getTotalPrice()
                            )
                    );

                    itemStatement.addBatch();
                }

                itemStatement.executeBatch();
            }

            // =====================================================
            // COMMIT
            // =====================================================

            connection.commit();

            // =====================================================
            // SUCCESS MESSAGE
            // =====================================================

            JOptionPane.showMessageDialog(
                    this,
                    "Order placed successfully! ❤️\n\n"
                            + "Order ID: "
                            + orderId
                            + "\n"
                            + "Customer: "
                            + name
                            + "\n"
                            + "Phone: "
                            + phone
                            + "\n"
                            + "Payment: "
                            + payment
                            + "\n\n"
                            + "Total: ₹"
                            + total
                            + "\n\n"
                            + "Thank you for ordering from CraveBite!",
                    "Order Confirmed",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // =====================================================
            // CLEAR CART ONLY AFTER DATABASE SUCCESS
            // =====================================================

            Manager.clearItems();

            dispose();

            // Open your existing success screen
            new OrderSuccessFrame();

        } catch (SQLException ex) {

            // =====================================================
            // ROLLBACK IF ANYTHING FAILS
            // =====================================================

            if (connection != null) {

                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to place the order.\n\n"
                            + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );

            ex.printStackTrace();

        } finally {

            // =====================================================
            // CLOSE CONNECTION
            // =====================================================

            if (connection != null) {

                try {
                    connection.setAutoCommit(true);
                    connection.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                CheckoutFrame::new
        );
    }
}
