package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomeFrame extends JFrame {

    private GifBackground backgroundPanel;

    public HomeFrame() {

        setTitle("CraveBite ❤️ - Home");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Open maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(
                new Dimension(1000, 650)
        );

        // =========================================================
        // ROMANTIC BACKGROUND
        // =========================================================

        backgroundPanel = new GifBackground();

        backgroundPanel.setLayout(
                new BorderLayout()
        );

        setContentPane(
                backgroundPanel
        );

        // =========================================================
        // TOP NAVIGATION BAR
        // =========================================================

        JPanel topBar = new JPanel(
                new BorderLayout()
        );

        topBar.setOpaque(false);

        topBar.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 35, 10, 35
                )
        );

        // Logo
        JLabel logo = new JLabel(
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
                new Color(255, 220, 150)
        );

        topBar.add(
                logo,
                BorderLayout.WEST
        );

        // Navigation buttons
        JPanel navPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        12,
                        0
                )
        );

        navPanel.setOpaque(false);

        JButton homeButton =
                createNavButton("HOME");

        JButton ordersButton =
                createNavButton("MY ORDERS");

        JButton cartButton =
                createNavButton("CART 🛒");

        JButton profileButton =
                createNavButton("PROFILE");

        navPanel.add(homeButton);
        navPanel.add(ordersButton);
        navPanel.add(cartButton);
        navPanel.add(profileButton);

        topBar.add(
                navPanel,
                BorderLayout.EAST
        );

        backgroundPanel.add(
                topBar,
                BorderLayout.NORTH
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        JPanel mainContent = new JPanel();

        mainContent.setOpaque(false);

        mainContent.setLayout(
                new BoxLayout(
                        mainContent,
                        BoxLayout.Y_AXIS
                )
        );

        mainContent.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 60, 40, 60
                )
        );

        // =========================================================
        // WELCOME SECTION
        // =========================================================

        JLabel welcome = new JLabel(
                "Good Evening, Love ❤️"
        );

        welcome.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        38
                )
        );

        welcome.setForeground(Color.WHITE);

        welcome.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(welcome);

        mainContent.add(
                Box.createVerticalStrut(8)
        );

        JLabel subtitle = new JLabel(
                "What are you craving tonight?"
        );

        subtitle.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        21
                )
        );

        subtitle.setForeground(
                new Color(255, 210, 220)
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(subtitle);

        mainContent.add(
                Box.createVerticalStrut(30)
        );

        // =========================================================
        // MOOD SECTION
        // =========================================================

        JLabel moodTitle = new JLabel(
                "Choose your mood"
        );

        moodTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        20
                )
        );

        moodTitle.setForeground(
                new Color(255, 220, 150)
        );

        moodTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(moodTitle);

        mainContent.add(
                Box.createVerticalStrut(15)
        );

        JPanel moodPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        15,
                        5
                )
        );

        moodPanel.setOpaque(false);

        JButton romanticButton =
                createMoodButton(
                        "🌹 Romantic"
                );

        JButton fancyButton =
                createMoodButton(
                        "✨ Fancy"
                );

        JButton casualButton =
                createMoodButton(
                        "😊 Cute & Casual"
                );

        JButton nightButton =
                createMoodButton(
                        "🌙 Late Night"
                );

        moodPanel.add(
                romanticButton
        );

        moodPanel.add(
                fancyButton
        );

        moodPanel.add(
                casualButton
        );

        moodPanel.add(
                nightButton
        );

        mainContent.add(
                moodPanel
        );

        mainContent.add(
                Box.createVerticalStrut(30)
        );

        // =========================================================
        // CATEGORY SECTION
        // =========================================================

        JLabel categoryTitle =
                new JLabel(
                        "Explore by category"
                );

        categoryTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        20
                )
        );

        categoryTitle.setForeground(
                Color.WHITE
        );

        categoryTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(
                categoryTitle
        );

        mainContent.add(
                Box.createVerticalStrut(15)
        );

        JPanel categoryPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                15,
                                5
                        )
                );

        categoryPanel.setOpaque(false);

        JButton pizzaButton =
                createCategoryButton(
                        "🍕",
                        "Pizza"
                );

        JButton burgerButton =
                createCategoryButton(
                        "🍔",
                        "Burgers"
                );

        JButton pastaButton =
                createCategoryButton(
                        "🍝",
                        "Pasta"
                );

        JButton dessertButton =
                createCategoryButton(
                        "🍰",
                        "Desserts"
                );

        JButton drinksButton =
                createCategoryButton(
                        "🥤",
                        "Drinks"
                );

        categoryPanel.add(
                pizzaButton
        );

        categoryPanel.add(
                burgerButton
        );

        categoryPanel.add(
                pastaButton
        );

        categoryPanel.add(
                dessertButton
        );

        categoryPanel.add(
                drinksButton
        );

        mainContent.add(
                categoryPanel
        );

        mainContent.add(
                Box.createVerticalStrut(35)
        );

        // =========================================================
        // FEATURED SECTION
        // =========================================================

        JLabel featuredTitle =
                new JLabel(
                        "Tonight's Special ❤️"
                );

        featuredTitle.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        24
                )
        );

        featuredTitle.setForeground(
                new Color(255, 220, 150)
        );

        featuredTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(
                featuredTitle
        );

        mainContent.add(
                Box.createVerticalStrut(15)
        );

        // Featured card
        JPanel featuredCard =
                new JPanel(
                        new BorderLayout()
                );

        featuredCard.setPreferredSize(
                new Dimension(
                        650,
                        130
                )
        );

        featuredCard.setMaximumSize(
                new Dimension(
                        750,
                        130
                )
        );

        featuredCard.setBackground(
                new Color(
                        35,
                        10,
                        20,
                        245
                )
        );

        featuredCard.setBorder(
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
                                15,
                                20,
                                15,
                                20
                        )
                )
        );

        // Food emoji
        JLabel foodIcon =
                new JLabel("🍝");

        foodIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        55
                )
        );

        foodIcon.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        featuredCard.add(
                foodIcon,
                BorderLayout.WEST
        );

        // Food information
        JPanel foodInfo =
                new JPanel();

        foodInfo.setOpaque(false);

        foodInfo.setLayout(
                new BoxLayout(
                        foodInfo,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel foodName =
                new JLabel(
                        "Creamy Alfredo Pasta"
                );

        foodName.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        22
                )
        );

        foodName.setForeground(
                Color.WHITE
        );

        JLabel foodDescription =
                new JLabel(
                        "Perfect for a cozy dinner for two ❤️"
                );

        foodDescription.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        13
                )
        );

        foodDescription.setForeground(
                new Color(
                        210,
                        175,
                        185
                )
        );

        JLabel price =
                new JLabel(
                        "₹299"
                );

        price.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );

        price.setForeground(
                new Color(
                        255,
                        190,
                        110
                )
        );

        foodInfo.add(
                foodName
        );

        foodInfo.add(
                Box.createVerticalStrut(7)
        );

        foodInfo.add(
                foodDescription
        );

        foodInfo.add(
                Box.createVerticalStrut(7)
        );

        foodInfo.add(
                price
        );

        featuredCard.add(
                foodInfo,
                BorderLayout.CENTER
        );

        // Order button
        JButton orderButton =
                new JButton(
                        "ADD TO CART  ♥"
                );

        orderButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        orderButton.setForeground(
                Color.WHITE
        );

        orderButton.setBackground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        orderButton.setFocusPainted(false);

        orderButton.setBorderPainted(false);

        orderButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        orderButton.setPreferredSize(
                new Dimension(
                        135,
                        42
                )
        );

        featuredCard.add(
                orderButton,
                BorderLayout.EAST
        );

        mainContent.add(
                featuredCard
        );

        // =========================================================
        // ROMANTIC MESSAGE
        // =========================================================

        mainContent.add(
                Box.createVerticalStrut(25)
        );

        JLabel bottomMessage =
                new JLabel(
                        "Because every great love story deserves a great meal. ❤️"
                );

        bottomMessage.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        15
                )
        );

        bottomMessage.setForeground(
                new Color(
                        220,
                        180,
                        190
                )
        );

        bottomMessage.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(
                bottomMessage
        );

        // =========================================================
        // SCROLL PANEL
        // =========================================================

        JScrollPane scrollPane =
                new JScrollPane(
                        mainContent
                );

        scrollPane.setOpaque(false);

        scrollPane.getViewport()
                .setOpaque(false);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        backgroundPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =========================================================
        // BUTTON ACTIONS
        // =========================================================

        romanticButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "🌹 Romantic mood selected!\n\n"
                            + "Let's find something perfect for a date night. ❤️",
                    "CraveBite Mood",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        fancyButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "✨ Fancy mood selected!\n\n"
                            + "Something elegant is waiting for you.",
                    "CraveBite Mood",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        casualButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "😊 Cute & Casual selected!\n\n"
                            + "Let's keep it delicious and relaxed.",
                    "CraveBite Mood",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        nightButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "🌙 Late Night selected!\n\n"
                            + "Because cravings don't follow a clock. ❤️",
                    "CraveBite Mood",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        pizzaButton.addActionListener(e -> {
            dispose();
            new MenuFrame("Pizza").setVisible(true);
        });

        burgerButton.addActionListener(e -> {
            dispose();
            new MenuFrame("Burgers").setVisible(true);
        });

        pastaButton.addActionListener(e -> {
            dispose();
            new MenuFrame("Pasta").setVisible(true);
        });

        dessertButton.addActionListener(e -> {
            dispose();
            new MenuFrame("Desserts").setVisible(true);
        });

        drinksButton.addActionListener(e -> {
            dispose();
            new MenuFrame("Drinks").setVisible(true);
        });

        orderButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Creamy Alfredo Pasta added to your cart! ❤️",
                    "Added to Cart",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =========================================================
        // NAVIGATION
        // =========================================================

        homeButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "You're already home ❤️",
                    "CraveBite",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        ordersButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your orders will appear here.\n\n"
                            + "Order history will be connected to MySQL later.",
                    "My Orders",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        cartButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your cart is currently empty 🛒\n\n"
                            + "Cart functionality will be built next.",
                    "Your Cart",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        profileButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your CraveBite profile ❤️\n\n"
                            + "Profile functionality will be connected later.",
                    "Profile",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =========================================================
        // SHOW WINDOW
        // =========================================================

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =============================================================
    // NAVIGATION BUTTON
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
                        20,
                        220
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

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        button.setForeground(
                                new Color(
                                        255,
                                        220,
                                        150
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        button.setForeground(
                                new Color(
                                        255,
                                        210,
                                        220
                                )
                        );
                    }
                }
        );

        return button;
    }

    // =============================================================
    // MOOD BUTTON
    // =============================================================

    private JButton createMoodButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(
                Color.WHITE
        );

        button.setBackground(
                new Color(
                        55,
                        20,
                        35,
                        235
                )
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        120,
                                        50,
                                        75
                                )
                        ),

                        BorderFactory.createEmptyBorder(
                                12,
                                18,
                                12,
                                18
                        )
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        120,
                                        35,
                                        60
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        55,
                                        20,
                                        35,
                                        235
                                )
                        );
                    }
                }
        );

        return button;
    }

    // =============================================================
    // CATEGORY BUTTON
    // =============================================================

    private JButton createCategoryButton(
            String icon,
            String text
    ) {

        JButton button =
                new JButton(
                        "<html><center>"
                                + "<font size='6'>"
                                + icon
                                + "</font><br>"
                                + text
                                + "</center></html>"
                );

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(
                new Color(
                        255,
                        220,
                        230
                )
        );

        button.setBackground(
                new Color(
                        35,
                        10,
                        20,
                        235
                )
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        120,
                                        50,
                                        75
                                )
                        ),

                        BorderFactory.createEmptyBorder(
                                10,
                                20,
                                10,
                                20
                        )
                )
        );

        button.setPreferredSize(
                new Dimension(
                        120,
                        90
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        90,
                                        30,
                                        50
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        button.setBackground(
                                new Color(
                                        35,
                                        10,
                                        20,
                                        235
                                )
                        );
                    }
                }
        );

        return button;
    }

    // =============================================================
    // CATEGORY MESSAGE
    // =============================================================

    private void showCategory(
            String category
    ) {

        JOptionPane.showMessageDialog(
                this,
                category
                        + " menu will be displayed here. ❤️\n\n"
                        + "We will build the real food menu next!",
                category,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =============================================================
    // MAIN
    // =============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                HomeFrame::new
        );
    }
}