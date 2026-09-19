package org.example.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MenuFrame extends JFrame {

    private GifBackground backgroundPanel;
    private JPanel foodPanel;
    private JTextField searchField;

    private final List<FoodItem> foodItems = new ArrayList<>();

    // Current category
    private String currentCategory;

    // =============================================================
    // CONSTRUCTOR
    // =============================================================

    public MenuFrame(String category) {

        currentCategory = category;

        setTitle("CraveBite ❤️ - " + category);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(new Dimension(1000, 650));

        // =========================================================
        // GIF BACKGROUND
        // =========================================================

        backgroundPanel = new GifBackground();

        backgroundPanel.setLayout(new BorderLayout());

        setContentPane(backgroundPanel);

        // =========================================================
        // FOOD DATA
        // =========================================================

        loadFoodItems();

        // =========================================================
        // TOP NAVIGATION
        // =========================================================

        createTopNavigation();

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
                new EmptyBorder(
                        20,
                        50,
                        50,
                        50
                )
        );

        // =========================================================
        // TITLE
        // =========================================================

        JLabel title = new JLabel(
                getCategoryTitle(category)
        );

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        38
                )
        );

        title.setForeground(Color.WHITE);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(title);

        mainContent.add(
                Box.createVerticalStrut(7)
        );

        // =========================================================
        // SUBTITLE
        // =========================================================

        JLabel subtitle = new JLabel(
                getCategorySubtitle(category)
        );

        subtitle.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        18
                )
        );

        subtitle.setForeground(
                new Color(
                        255,
                        210,
                        220
                )
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(subtitle);

        mainContent.add(
                Box.createVerticalStrut(25)
        );

        // =========================================================
        // SEARCH BAR
        // =========================================================

        JPanel searchPanel = new JPanel(
                new BorderLayout(
                        10,
                        0
                )
        );

        searchPanel.setOpaque(false);

        searchPanel.setMaximumSize(
                new Dimension(
                        700,
                        48
                )
        );

        searchField = new JTextField();

        searchField.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        16
                )
        );

        searchField.setForeground(Color.WHITE);

        searchField.setCaretColor(Color.WHITE);

        searchField.setBackground(
                new Color(
                        35,
                        10,
                        20
                )
        );

        searchField.setBorder(
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
                                8,
                                15,
                                8,
                                15
                        )
                )
        );

        searchField.setToolTipText(
                "Search in " + category + "..."
        );

        JButton searchButton =
                new JButton(
                        "SEARCH 🔍"
                );

        searchButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        searchButton.setForeground(Color.WHITE);

        searchButton.setBackground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        searchButton.setFocusPainted(false);

        searchButton.setBorderPainted(false);

        searchButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        searchPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        searchPanel.add(
                searchButton,
                BorderLayout.EAST
        );

        mainContent.add(searchPanel);

        mainContent.add(
                Box.createVerticalStrut(30)
        );

        // =========================================================
        // CATEGORY HEADING
        // =========================================================

        JLabel categoryHeading = new JLabel(
                category + " Menu ❤️"
        );

        categoryHeading.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        26
                )
        );

        categoryHeading.setForeground(
                new Color(
                        255,
                        220,
                        150
                )
        );

        categoryHeading.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        mainContent.add(categoryHeading);

        mainContent.add(
                Box.createVerticalStrut(18)
        );

        // =========================================================
        // FOOD PANEL
        // =========================================================

        foodPanel = new JPanel(
                new GridLayout(
                        0,
                        3,
                        20,
                        20
                )
        );

        foodPanel.setOpaque(false);

        foodPanel.setBorder(
                new EmptyBorder(
                        5,
                        20,
                        20,
                        20
                )
        );

        // Display ONLY selected category
        displayCategory(category);

        mainContent.add(foodPanel);

        // =========================================================
        // SCROLL
        // =========================================================

        JScrollPane scrollPane =
                new JScrollPane(
                        mainContent
                );

        scrollPane.setOpaque(false);

        scrollPane.getViewport().setOpaque(false);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        backgroundPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =========================================================
        // SEARCH ACTION
        // =========================================================

        searchButton.addActionListener(
                e -> searchFood()
        );

        searchField.addActionListener(
                e -> searchFood()
        );

        // =========================================================
        // SHOW WINDOW
        // =========================================================

        setLocationRelativeTo(null);

        setVisible(true);
    }

    // =============================================================
    // TOP NAVIGATION
    // =============================================================

    private void createTopNavigation() {

        JPanel topBar = new JPanel(
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

        // =========================================================
        // LOGO
        // =========================================================

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

        // =========================================================
        // NAVIGATION
        // =========================================================

        JPanel navPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        10,
                        0
                )
        );

        navPanel.setOpaque(false);

        JButton homeButton =
                createNavButton("HOME");

        JButton ordersButton =
                createNavButton("MY ORDERS");

        JButton cartButton =
                createNavButton("CART");

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
        // HOME
        // =========================================================

        homeButton.addActionListener(e -> {

            dispose();

            new HomeFrame().setVisible(true);
        });

        // =========================================================
        // MY ORDERS
        // =========================================================

        ordersButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your orders will appear here ❤️\n\n"
                            + "MySQL order history will be connected later.",
                    "My Orders",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =========================================================
        // CART
        // =========================================================

        cartButton.addActionListener(e -> {

            dispose();

            new CartFrame();
        });

        // =========================================================
        // PROFILE
        // =========================================================

        profileButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Your CraveBite profile ❤️\n\n"
                            + "Profile functionality will be connected later.",
                    "Profile",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
    }

    // =============================================================
    // FOOD DATA
    // =============================================================

    private void loadFoodItems() {

        // =========================================================
        // PIZZAS
        // =========================================================

        foodItems.add(
                new FoodItem(
                        "Margherita Pizza",
                        "Pizza",
                        "Classic tomato, mozzarella and fresh basil.",
                        "₹249",
                        "⭐ 4.8",
                        "🍕"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Pepperoni Pizza",
                        "Pizza",
                        "Loaded with delicious pepperoni and cheese.",
                        "₹329",
                        "⭐ 4.7",
                        "🍕"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Farmhouse Pizza",
                        "Pizza",
                        "Fresh vegetables, cheese and herbs.",
                        "₹299",
                        "⭐ 4.7",
                        "🍕"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Cheese Burst Pizza",
                        "Pizza",
                        "Extra cheesy pizza with a creamy cheese center.",
                        "₹349",
                        "⭐ 4.9",
                        "🍕"
                )
        );

        // =========================================================
        // BURGERS
        // =========================================================

        foodItems.add(
                new FoodItem(
                        "Classic Cheese Burger",
                        "Burgers",
                        "Juicy burger with melted cheese.",
                        "₹199",
                        "⭐ 4.6",
                        "🍔"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Double Decker Burger",
                        "Burgers",
                        "Two layers of pure deliciousness.",
                        "₹299",
                        "⭐ 4.9",
                        "🍔"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Crispy Chicken Burger",
                        "Burgers",
                        "Crispy chicken with lettuce and special sauce.",
                        "₹249",
                        "⭐ 4.8",
                        "🍔"
                )
        );

        foodItems.add(
                new FoodItem(
                        "BBQ Burger",
                        "Burgers",
                        "Smoky BBQ sauce with a juicy patty.",
                        "₹279",
                        "⭐ 4.7",
                        "🍔"
                )
        );

        // =========================================================
        // PASTA
        // =========================================================

        foodItems.add(
                new FoodItem(
                        "Creamy Alfredo Pasta",
                        "Pasta",
                        "Creamy Alfredo sauce with herbs and parmesan.",
                        "₹299",
                        "⭐ 4.9",
                        "🍝"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Arrabbiata Pasta",
                        "Pasta",
                        "Spicy tomato pasta with herbs.",
                        "₹259",
                        "⭐ 4.6",
                        "🍝"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Cheesy Macaroni",
                        "Pasta",
                        "Creamy macaroni loaded with cheese.",
                        "₹229",
                        "⭐ 4.7",
                        "🍝"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Pesto Pasta",
                        "Pasta",
                        "Fresh basil pesto with parmesan.",
                        "₹289",
                        "⭐ 4.8",
                        "🍝"
                )
        );

        // =========================================================
        // DESSERTS
        // =========================================================

        foodItems.add(
                new FoodItem(
                        "Chocolate Lava Cake",
                        "Desserts",
                        "Warm chocolate cake with a gooey center.",
                        "₹179",
                        "⭐ 4.9",
                        "🍰"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Strawberry Cheesecake",
                        "Desserts",
                        "Creamy cheesecake with fresh strawberries.",
                        "₹229",
                        "⭐ 4.8",
                        "🍰"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Chocolate Brownie",
                        "Desserts",
                        "Rich and soft chocolate brownie.",
                        "₹159",
                        "⭐ 4.7",
                        "🍫"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Ice Cream Sundae",
                        "Desserts",
                        "Vanilla ice cream with chocolate topping.",
                        "₹149",
                        "⭐ 4.6",
                        "🍨"
                )
        );

        // =========================================================
        // DRINKS
        // =========================================================

        foodItems.add(
                new FoodItem(
                        "Cold Coffee",
                        "Drinks",
                        "Creamy chilled coffee.",
                        "₹129",
                        "⭐ 4.5",
                        "🥤"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Strawberry Shake",
                        "Drinks",
                        "Sweet strawberry milkshake.",
                        "₹149",
                        "⭐ 4.7",
                        "🥤"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Chocolate Shake",
                        "Drinks",
                        "Rich chocolate milkshake.",
                        "₹159",
                        "⭐ 4.8",
                        "🥤"
                )
        );

        foodItems.add(
                new FoodItem(
                        "Fresh Lime Soda",
                        "Drinks",
                        "Refreshing lime soda.",
                        "₹99",
                        "⭐ 4.5",
                        "🥤"
                )
        );
    }

    // =============================================================
    // DISPLAY CATEGORY
    // =============================================================

    private void displayCategory(String category) {

        List<FoodItem> results =
                new ArrayList<>();

        for (FoodItem item : foodItems) {

            if (item.category.equalsIgnoreCase(category)) {

                results.add(item);
            }
        }

        displayFoodItems(results);
    }

    // =============================================================
    // DISPLAY FOOD ITEMS
    // =============================================================

    private void displayFoodItems(
            List<FoodItem> items
    ) {

        foodPanel.removeAll();

        if (items.isEmpty()) {

            JLabel emptyLabel =
                    new JLabel(
                            "No items found ❤️"
                    );

            emptyLabel.setFont(
                    new Font(
                            "Serif",
                            Font.BOLD,
                            22
                    )
            );

            emptyLabel.setForeground(Color.WHITE);

            emptyLabel.setHorizontalAlignment(
                    SwingConstants.CENTER
            );

            foodPanel.add(emptyLabel);
        }

        for (FoodItem item : items) {

            foodPanel.add(
                    createFoodCard(item)
            );
        }

        foodPanel.revalidate();

        foodPanel.repaint();
    }

    // =============================================================
    // FOOD CARD
    // =============================================================

    private JPanel createFoodCard(
            FoodItem item
    ) {

        JPanel card = new JPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBackground(
                new Color(
                        30,
                        10,
                        20
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
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        // =========================================================
        // ICON
        // =========================================================

        JLabel icon = new JLabel(
                item.icon
        );

        icon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        55
                )
        );

        icon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(icon);

        card.add(
                Box.createVerticalStrut(8)
        );

        // =========================================================
        // NAME
        // =========================================================

        JLabel name = new JLabel(
                item.name
        );

        name.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        20
                )
        );

        name.setForeground(Color.WHITE);

        name.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(name);

        card.add(
                Box.createVerticalStrut(6)
        );

        // =========================================================
        // DESCRIPTION
        // =========================================================

        JLabel description =
                new JLabel(
                        "<html><center>"
                                + item.description
                                + "</center></html>"
                );

        description.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        12
                )
        );

        description.setForeground(
                new Color(
                        205,
                        175,
                        185
                )
        );

        description.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        card.add(description);

        card.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // RATING + PRICE
        // =========================================================

        JPanel infoPanel =
                new JPanel(
                        new BorderLayout()
                );

        infoPanel.setOpaque(false);

        JLabel rating =
                new JLabel(
                        item.rating
                );

        rating.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        rating.setForeground(
                new Color(
                        255,
                        210,
                        120
                )
        );

        JLabel price =
                new JLabel(
                        item.price
                );

        price.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        17
                )
        );

        price.setForeground(
                new Color(
                        255,
                        190,
                        110
                )
        );

        infoPanel.add(
                rating,
                BorderLayout.WEST
        );

        infoPanel.add(
                price,
                BorderLayout.EAST
        );

        infoPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        30
                )
        );

        card.add(infoPanel);

        card.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // ADD TO CART BUTTON
        // =========================================================

        JButton addButton =
                new JButton(
                        "ADD TO CART  ♥"
                );

        addButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        addButton.setForeground(Color.WHITE);

        addButton.setBackground(
                new Color(
                        200,
                        55,
                        90
                )
        );

        addButton.setFocusPainted(false);

        addButton.setBorderPainted(false);

        addButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        addButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        addButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        card.add(addButton);

        // =========================================================
        // ADD TO CART ACTION
        // =========================================================

        addButton.addActionListener(e -> {

            Manager.addItem(
                    item.name,
                    item.category,
                    item.price,
                    item.icon
            );

            JOptionPane.showMessageDialog(
                    this,
                    item.name
                            + " has been added to your cart! ❤️\n\n"
                            + "Price: "
                            + item.price,
                    "Added to Cart",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =========================================================
        // HOVER EFFECT
        // =========================================================

        addButton.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        addButton.setBackground(
                                new Color(
                                        240,
                                        75,
                                        110
                                )
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        addButton.setBackground(
                                new Color(
                                        200,
                                        55,
                                        90
                                )
                        );
                    }
                }
        );

        return card;
    }

    // =============================================================
    // SEARCH FOOD
    // =============================================================

    private void searchFood() {

        String search =
                searchField
                        .getText()
                        .trim()
                        .toLowerCase();

        // Empty search = show current category
        if (search.isEmpty()) {

            displayCategory(
                    currentCategory
            );

            return;
        }

        List<FoodItem> results =
                new ArrayList<>();

        // Search ONLY inside current category
        for (FoodItem item : foodItems) {

            if (!item.category.equalsIgnoreCase(
                    currentCategory
            )) {

                continue;
            }

            if (
                    item.name
                            .toLowerCase()
                            .contains(search)

                            ||

                            item.description
                                    .toLowerCase()
                                    .contains(search)
            ) {

                results.add(item);
            }
        }

        displayFoodItems(results);

        if (results.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No "
                            + currentCategory
                            + " item found ❤️\n\n"
                            + "Try another search.",
                    "No Food Found",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =============================================================
    // CATEGORY TITLE
    // =============================================================

    private String getCategoryTitle(
            String category
    ) {

        switch (category) {

            case "Pizza":
                return "Pizza Made With Love 🍕❤️";

            case "Burgers":
                return "Juicy Burgers For You 🍔❤️";

            case "Pasta":
                return "Perfect Pasta For Two 🍝❤️";

            case "Desserts":
                return "Sweet Moments 🍰❤️";

            case "Drinks":
                return "Something Refreshing 🥤❤️";

            default:
                return "Choose Something Delicious ❤️";
        }
    }

    // =============================================================
    // CATEGORY SUBTITLE
    // =============================================================

    private String getCategorySubtitle(
            String category
    ) {

        switch (category) {

            case "Pizza":
                return "Hot, cheesy and perfect for sharing.";

            case "Burgers":
                return "Big bites for an unforgettable date.";

            case "Pasta":
                return "Creamy, delicious and made with love.";

            case "Desserts":
                return "Because every date deserves something sweet.";

            case "Drinks":
                return "Sip, relax and enjoy the moment.";

            default:
                return "Because every date deserves a delicious meal.";
        }
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
    // MAIN
    // =============================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                () -> new MenuFrame("Pizza")
        );
    }
}


// =================================================================
// FOOD ITEM CLASS
// =================================================================

class FoodItem {

    String name;
    String category;
    String description;
    String price;
    String rating;
    String icon;

    public FoodItem(
            String name,
            String category,
            String description,
            String price,
            String rating,
            String icon
    ) {

        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.icon = icon;
    }
}