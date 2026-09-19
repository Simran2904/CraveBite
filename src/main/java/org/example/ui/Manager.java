package org.example.ui;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    // =============================================================
    // CART ITEMS
    // =============================================================

    private static final List<Items> items = new ArrayList<>();


    // =============================================================
    // ADD ITEM
    // =============================================================

    public static void addItem(
            String name,
            String category,
            String price,
            String icon
    ) {

        // Check if item already exists
        for (Items item : items) {

            if (item.getName().equalsIgnoreCase(name)) {

                item.increaseQuantity();

                return;
            }
        }

        // If item doesn't exist, create new item
        Items newItem = new Items(
                name,
                category,
                price,
                icon
        );

        items.add(newItem);
    }


    // =============================================================
    // GET ALL ITEMS
    // =============================================================

    public static List<Items> getItems() {

        return new ArrayList<>(items);
    }


    // =============================================================
    // INCREASE QUANTITY
    // =============================================================

    public static void increaseItem(
            String name
    ) {

        for (Items item : items) {

            if (item.getName().equalsIgnoreCase(name)) {

                item.increaseQuantity();

                return;
            }
        }
    }


    // =============================================================
    // DECREASE QUANTITY
    // =============================================================

    public static void decreaseItem(
            String name
    ) {

        for (Items item : items) {

            if (item.getName().equalsIgnoreCase(name)) {

                item.decreaseQuantity();

                return;
            }
        }
    }


    // =============================================================
    // REMOVE ITEM
    // =============================================================

    public static void removeItem(
            String name
    ) {

        items.removeIf(
                item -> item.getName()
                        .equalsIgnoreCase(name)
        );
    }


    // =============================================================
    // CLEAR CART
    // =============================================================

    public static void clearItems() {

        items.clear();
    }


    // =============================================================
    // TOTAL ITEMS
    // =============================================================

    public static int getTotalItems() {

        int total = 0;

        for (Items item : items) {

            total += item.getQuantity();
        }

        return total;
    }


    // =============================================================
    // TOTAL PRICE
    // =============================================================

    public static int getTotalPrice() {

        int total = 0;

        for (Items item : items) {

            total += item.getTotalPrice();
        }

        return total;
    }


    // =============================================================
    // CHECK IF EMPTY
    // =============================================================

    public static boolean isEmpty() {

        return items.isEmpty();
    }
}