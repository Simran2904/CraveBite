package org.example.ui;

public class Items {

    private String name;
    private String category;
    private String price;
    private String icon;
    private int quantity;

    public Items(
            String name,
            String category,
            String price,
            String icon
    ) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.icon = icon;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getIcon() {
        return icon;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {
        if (quantity > 1) {
            quantity--;
        }
    }

    public int getPriceAsInt() {

        return Integer.parseInt(
                price.replace("₹", "").trim()
        );
    }

    public int getTotalPrice() {

        return getPriceAsInt() * quantity;
    }
}