package org.example.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class CartFrame extends JFrame {

    private GifBackground backgroundPanel;
    private JPanel cartPanel;
    private JLabel totalLabel;
    private JLabel itemCountLabel;

    public CartFrame() {

        // =============================================================
        // FRAME SETTINGS
        // =============================================================

        setTitle("CraveBite ❤️ - My Cart");

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );

        setMinimumSize(
                new Dimension(1000, 650)
        );

        // =============================================================
        // ROMANTIC GIF BACKGROUND
        // =============================================================

        backgroundPanel = new GifBackground();

        backgroundPanel.setLayout(
                new BorderLayout()
        );

        setContentPane(
                backgroundPanel
        );

        // =============================================================
        // TOP BAR
        // =============================================================

        createTopBar();

        // =============================================================
        // MAIN CART AREA
        // =============================================================

        JPanel mainContent = new JPanel();

        mainContent.setOpaque(false);

        mainContent.setLayout(
                new BorderLayout()
        );

        mainContent.setBorder(
                new EmptyBorder(
                        25,
                        60,
                        25,
                        60
                )
        );

        // =============================================================
        // CART TITLE
        // =============================================================

        JPanel titlePanel = new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel =
                new JLabel(
                        "Your Love Basket ❤️"
                );

        titleLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        38
                )
        );

        titleLabel.setForeground(
                Color.WHITE
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        titlePanel.add(titleLabel);

        titlePanel.add(
                Box.createVerticalStrut(5)
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Everything you chose for your perfect meal ✨"
                );

        subtitleLabel.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        18
                )
        );

        subtitleLabel.setForeground(
                new Color(
                        255,
                        210,
                        220
                )
        );

        subtitleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        titlePanel.add(subtitleLabel);

        titlePanel.add(
                Box.createVerticalStrut(8)
        );

        itemCountLabel =
                new JLabel();

        itemCountLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        itemCountLabel.setForeground(
                new Color(
                        230,
                        190,
                        200
                )
        );

        itemCountLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        titlePanel.add(itemCountLabel);

        mainContent.add(
                titlePanel,
                BorderLayout.NORTH
        );

        // =============================================================
        // CART PANEL
        // =============================================================

        cartPanel = new JPanel();

        cartPanel.setOpaque(false);

        cartPanel.setLayout(
                new BoxLayout(
                        cartPanel,
                        BoxLayout.Y_AXIS
                )
        );

        cartPanel.setBorder(
                new EmptyBorder(
                        25,
                        20,
                        20,
                        20
                )
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        cartPanel
                );

        scrollPane.setOpaque(false);

        scrollPane.getViewport()
                .setOpaque(false);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        mainContent.add(
                scrollPane,
                BorderLayout.CENTER
        );

        backgroundPanel.add(
                mainContent,
                BorderLayout.CENTER
        );

        // =============================================================
        // BOTTOM CHECKOUT BAR
        // =============================================================

        createBottomBar();

        // =============================================================
        // LOAD CART
        // =============================================================

        loadCart();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =============================================================
    // TOP BAR
    // =============================================================

    private void createTopBar() {

        JPanel topBar =
                new JPanel(
                        new BorderLayout()
                );

        topBar.setOpaque(false);

        topBar.setBorder(
                new EmptyBorder(
                        18,
                        35,
                        10,
                        35
                )
        );

        // -------------------------------------------------------------
        // LOGO
        // -------------------------------------------------------------

        JLabel logo =
                new JLabel(
                        "♥ CRAVEBITE"
                );

        logo.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        28
                )
        );

        logo.setForeground(
                new Color(
                        255,
                        220,
                        150
                )
        );

        topBar.add(
                logo,
                BorderLayout.WEST
        );

        // -------------------------------------------------------------
        // NAVIGATION
        // -------------------------------------------------------------

        JPanel navPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        navPanel.setOpaque(false);

        JButton homeButton =
                createNavButton("HOME");

        JButton menuButton =
                createNavButton("MENU");

        JButton ordersButton =
                createNavButton("MY ORDERS");

        JButton profileButton =
                createNavButton("PROFILE");

        navPanel.add(homeButton);
        navPanel.add(menuButton);
        navPanel.add(ordersButton);
        navPanel.add(profileButton);

        topBar.add(
                navPanel,
                BorderLayout.EAST
        );

        backgroundPanel.add(
                topBar,
                BorderLayout.NORTH
        );

        // -------------------------------------------------------------
        // HOME
        // -------------------------------------------------------------

        homeButton.addActionListener(e -> {

            dispose();

            new HomeFrame().setVisible(true);
        });

        // -------------------------------------------------------------
        // MENU
        // -------------------------------------------------------------

        menuButton.addActionListener(e -> {

            dispose();

            new MenuFrame("Pizza");
        });

        // -------------------------------------------------------------
        // ORDERS
        // -------------------------------------------------------------

        ordersButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your previous orders will appear here ❤️\n\n"
                            + "Order history can be connected to MySQL next.",
                    "My Orders",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // -------------------------------------------------------------
        // PROFILE
        // -------------------------------------------------------------

        profileButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your CraveBite profile ❤️\n\n"
                            + "Profile functionality can be connected next.",
                    "Profile",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
    }

    // =============================================================
    // BOTTOM BAR
    // =============================================================

    private void createBottomBar() {

        JPanel bottomBar =
                new JPanel(
                        new BorderLayout()
                );

        bottomBar.setOpaque(false);

        bottomBar.setBorder(
                new EmptyBorder(
                        15,
                        60,
                        20,
                        60
                )
        );

        // -------------------------------------------------------------
        // TOTAL CARD
        // -------------------------------------------------------------

        JPanel totalCard =
                new JPanel();

        totalCard.setLayout(
                new BoxLayout(
                        totalCard,
                        BoxLayout.Y_AXIS
                )
        );

        totalCard.setOpaque(true);

        totalCard.setBackground(
                new Color(
                        35,
                        10,
                        20,
                        235
                )
        );

        totalCard.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        180,
                                        70,
                                        100
                                ),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                10,
                                20,
                                10,
                                20
                        )
                )
        );

        JLabel totalSmall =
                new JLabel(
                        "YOUR TOTAL"
                );

        totalSmall.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        totalSmall.setForeground(
                new Color(
                        220,
                        170,
                        185
                )
        );

        totalLabel =
                new JLabel();

        totalLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        25
                )
        );

        totalLabel.setForeground(
                new Color(
                        255,
                        210,
                        130
                )
        );

        totalCard.add(totalSmall);

        totalCard.add(
                totalLabel
        );

        bottomBar.add(
                totalCard,
                BorderLayout.WEST
        );

        // -------------------------------------------------------------
        // CHECKOUT BUTTON
        // -------------------------------------------------------------

        JButton checkoutButton =
                new JButton(
                        "PROCEED TO CHECKOUT  ♥"
                );

        checkoutButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        checkoutButton.setForeground(
                Color.WHITE
        );

        checkoutButton.setBackground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        checkoutButton.setFocusPainted(false);

        checkoutButton.setBorderPainted(false);

        checkoutButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        checkoutButton.setPreferredSize(
                new Dimension(
                        260,
                        50
                )
        );

        // =============================================================
        // CHECKOUT ACTION
        // =============================================================

        checkoutButton.addActionListener(e -> {

            if (Manager.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Your cart is empty ❤️\n\n"
                                + "Add something delicious first!",
                        "Empty Cart",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // Open CheckoutFrame
            new CheckoutFrame();

            // Close CartFrame
            dispose();
        });

        // =============================================================
        // HOVER EFFECT
        // =============================================================

        checkoutButton.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e
                    ) {

                        checkoutButton.setBackground(
                                new Color(
                                        240,
                                        75,
                                        110
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e
                    ) {

                        checkoutButton.setBackground(
                                new Color(
                                        200,
                                        55,
                                        90
                                )
                        );
                    }
                }
        );

        bottomBar.add(
                checkoutButton,
                BorderLayout.EAST
        );

        backgroundPanel.add(
                bottomBar,
                BorderLayout.SOUTH
        );
    }

    // =============================================================
    // LOAD CART
    // =============================================================

    private void loadCart() {

        cartPanel.removeAll();

        List<Items> items =
                Manager.getItems();

        itemCountLabel.setText(
                Manager.getTotalItems()
                        + " item(s) in your basket ❤️"
        );

        if (items.isEmpty()) {

            showEmptyCart();

        } else {

            for (Items item : items) {

                JPanel card =
                        createCartItem(item);

                cartPanel.add(card);

                cartPanel.add(
                        Box.createVerticalStrut(12)
                );
            }
        }

        totalLabel.setText(
                "₹" + Manager.getTotalPrice()
        );

        cartPanel.revalidate();

        cartPanel.repaint();
    }

    // =============================================================
    // EMPTY CART
    // =============================================================

    private void showEmptyCart() {

        JPanel emptyPanel =
                new JPanel();

        emptyPanel.setOpaque(false);

        emptyPanel.setLayout(
                new BoxLayout(
                        emptyPanel,
                        BoxLayout.Y_AXIS
                )
        );

        emptyPanel.add(
                Box.createVerticalStrut(80)
        );

        JLabel heart =
                new JLabel(
                        "♡"
                );

        heart.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        70
                )
        );

        heart.setForeground(
                new Color(
                        255,
                        180,
                        195
                )
        );

        heart.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        emptyPanel.add(heart);

        emptyPanel.add(
                Box.createVerticalStrut(10)
        );

        JLabel title =
                new JLabel(
                        "Your basket is waiting for love..."
                );

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        24
                )
        );

        title.setForeground(
                Color.WHITE
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        emptyPanel.add(title);

        emptyPanel.add(
                Box.createVerticalStrut(8)
        );

        JLabel message =
                new JLabel(
                        "Add something delicious to make it complete ❤️"
                );

        message.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        16
                )
        );

        message.setForeground(
                new Color(
                        255,
                        210,
                        220
                )
        );

        message.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        emptyPanel.add(message);

        JButton menuButton =
                new JButton(
                        "EXPLORE MENU 🍕"
                );

        menuButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        menuButton.setForeground(
                Color.WHITE
        );

        menuButton.setBackground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        menuButton.setFocusPainted(false);

        menuButton.setBorderPainted(false);

        menuButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        menuButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        menuButton.addActionListener(e -> {

            dispose();

            new MenuFrame("Pizza");
        });

        emptyPanel.add(
                Box.createVerticalStrut(20)
        );

        emptyPanel.add(menuButton);

        cartPanel.add(emptyPanel);
    }

    // =============================================================
    // CREATE CART ITEM
    // =============================================================

    private JPanel createCartItem(
            Items item
    ) {

        JPanel card =
                new JPanel(
                        new BorderLayout(
                                20,
                                10
                        )
                );

        card.setOpaque(true);

        card.setBackground(
                new Color(
                        35,
                        10,
                        20,
                        240
                )
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        150,
                                        60,
                                        90
                                ),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                18,
                                22,
                                18,
                                22
                        )
                )
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        125
                )
        );

        // =============================================================
        // ICON
        // =============================================================

        JLabel iconLabel =
                new JLabel(
                        item.getIcon()
                );

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        48
                )
        );

        iconLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        iconLabel.setPreferredSize(
                new Dimension(
                        75,
                        75
                )
        );

        card.add(
                iconLabel,
                BorderLayout.WEST
        );

        // =============================================================
        // INFORMATION
        // =============================================================

        JPanel infoPanel =
                new JPanel();

        infoPanel.setOpaque(false);

        infoPanel.setLayout(
                new BoxLayout(
                        infoPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel nameLabel =
                new JLabel(
                        item.getName()
                );

        nameLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        21
                )
        );

        nameLabel.setForeground(
                Color.WHITE
        );

        JLabel categoryLabel =
                new JLabel(
                        item.getCategory()
                );

        categoryLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        categoryLabel.setForeground(
                new Color(
                        220,
                        170,
                        185
                )
        );

        JLabel priceLabel =
                new JLabel(
                        "₹"
                                + item.getPriceAsInt()
                                + " each"
                );

        priceLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        14
                )
        );

        priceLabel.setForeground(
                new Color(
                        255,
                        205,
                        125
                )
        );

        infoPanel.add(nameLabel);

        infoPanel.add(
                Box.createVerticalStrut(5)
        );

        infoPanel.add(categoryLabel);

        infoPanel.add(
                Box.createVerticalStrut(6)
        );

        infoPanel.add(priceLabel);

        card.add(
                infoPanel,
                BorderLayout.CENTER
        );

        // =============================================================
        // ACTION PANEL
        // =============================================================

        JPanel actionPanel =
                new JPanel();

        actionPanel.setOpaque(false);

        actionPanel.setLayout(
                new BoxLayout(
                        actionPanel,
                        BoxLayout.Y_AXIS
                )
        );

        // -------------------------------------------------------------
        // QUANTITY
        // -------------------------------------------------------------

        JPanel quantityPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                5,
                                0
                        )
                );

        quantityPanel.setOpaque(false);

        JButton minusButton =
                createSmallButton("-");

        JButton plusButton =
                createSmallButton("+");

        JLabel quantityLabel =
                new JLabel(
                        String.valueOf(
                                item.getQuantity()
                        )
                );

        quantityLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );

        quantityLabel.setForeground(
                Color.WHITE
        );

        quantityLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        quantityLabel.setPreferredSize(
                new Dimension(
                        35,
                        30
                )
        );

        quantityPanel.add(
                minusButton
        );

        quantityPanel.add(
                quantityLabel
        );

        quantityPanel.add(
                plusButton
        );

        actionPanel.add(
                quantityPanel
        );

        // -------------------------------------------------------------
        // TOTAL FOR ITEM
        // -------------------------------------------------------------

        JLabel itemTotal =
                new JLabel(
                        "₹"
                                + item.getTotalPrice()
                );

        itemTotal.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        18
                )
        );

        itemTotal.setForeground(
                new Color(
                        255,
                        190,
                        210
                )
        );

        itemTotal.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        actionPanel.add(
                Box.createVerticalStrut(5)
        );

        actionPanel.add(itemTotal);

        // -------------------------------------------------------------
        // REMOVE
        // -------------------------------------------------------------

        JButton removeButton =
                new JButton(
                        "Remove"
                );

        removeButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        removeButton.setForeground(
                new Color(
                        255,
                        180,
                        195
                )
        );

        removeButton.setOpaque(false);

        removeButton.setContentAreaFilled(false);

        removeButton.setBorderPainted(false);

        removeButton.setFocusPainted(false);

        removeButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        removeButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        actionPanel.add(
                removeButton
        );

        card.add(
                actionPanel,
                BorderLayout.EAST
        );

        // =============================================================
        // QUANTITY ACTIONS
        // =============================================================

        minusButton.addActionListener(e -> {

            Manager.decreaseItem(
                    item.getName()
            );

            loadCart();
        });

        plusButton.addActionListener(e -> {

            Manager.increaseItem(
                    item.getName()
            );

            loadCart();
        });

        // =============================================================
        // REMOVE ACTION
        // =============================================================

        removeButton.addActionListener(e -> {

            int result =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Remove "
                                    + item.getName()
                                    + " from your basket?",
                            "Remove Item",
                            JOptionPane.YES_NO_OPTION
                    );

            if (result ==
                    JOptionPane.YES_OPTION) {

                Manager.removeItem(
                        item.getName()
                );

                loadCart();
            }
        });

        return card;
    }

    // =============================================================
    // SMALL BUTTON
    // =============================================================

    private JButton createSmallButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        15
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                new Color(
                        150,
                        45,
                        75
                )
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setPreferredSize(
                new Dimension(
                        35,
                        30
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =============================================================
    // NAV BUTTON
    // =============================================================

    private JButton createNavButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        11
                )
        );

        button.setForeground(
                new Color(
                        255,
                        210,
                        220
                )
        );

        button.setBackground(
                new Color(
                        35,
                        10,
                        20
                )
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        12,
                        10,
                        12
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                CartFrame::new
        );
    }
}