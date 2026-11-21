
# CraveBite ❤️

CraveBite is a desktop-based food ordering application developed using Java Swing and MySQL. It provides users with an interactive and visually appealing platform to explore food items, browse different categories, add products to their cart, and place food orders.

The application features a romantic-themed user interface with animated backgrounds, attractive food menus, user registration, cart management, and order confirmation.

## Features

### 1. User Authentication
- User registration with name, email, phone number, and password.
- Login interface for existing users.
- Password confirmation during registration.
- Basic form validation.
- Terms and conditions acceptance during registration.
- User registration details stored in MySQL.

### 2. Home Page
- Attractive and interactive home screen.
- Romantic-themed animated background.
- Food mood selection options.
- Navigation to different food categories.
- Easy access to menu and shopping cart.

### 3. Food Menu
- Multiple food categories:
  - Pizza
  - Burgers
  - Pasta
  - Desserts
  - Drinks
- Food item cards with names, prices, and icons.
- Search functionality to find food items.
- Add-to-cart functionality.

### 4. Shopping Cart
- View selected food items.
- Increase or decrease item quantities.
- Remove items from the cart.
- Automatic total price calculation.
- Display total number of items.
- Empty cart message and menu navigation.

### 5. Checkout
- Customer name input.
- Phone number input.
- Delivery address input.
- Payment method selection.
- Automatic order total calculation.
- Save order details and purchased items in MySQL.
- Database transaction handling.
- Order confirmation with generated order ID.

### 6. Order Confirmation
- Dedicated order success screen.
- Order confirmation message.
- Confirmation displayed after successful database insertion.

### 7. UI and Design
- Java Swing graphical user interface.
- Romantic dark and pink color theme.
- Animated heart background.
- GIF-based background animations.
- Interactive buttons and navigation.
- Custom-designed application screens.

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 21 | Core programming language |
| Java Swing | Desktop graphical user interface |
| Java AWT | GUI components and graphics |
| MySQL | Database management |
| JDBC | Database connectivity |
| MySQL Connector/J 9.6.0 | MySQL database driver |
| Maven | Project and dependency management |

## Project Structure

```text
CraveBite-main/
│
├── pom.xml
│
└── src/
    └── main/
        ├── java/
        │   └── org/example/
        │       │
        │       ├── Main.java
        │       │
        │       ├── database/
        │       │   ├── DBConnection.java
        │       │   ├── DatabaseTest.java
        │       │   └── UserDAO.java
        │       │
        │       └── ui/
        │           ├── HomeFrame.java
        │           ├── LoginFrame.java
        │           ├── RegisterFrame.java
        │           ├── MenuFrame.java
        │           ├── CartFrame.java
        │           ├── CheckoutFrame.java
        │           ├── OrderSuccessFrame.java
        │           ├── Items.java
        │           ├── Manager.java
        │           ├── GifBackground.java
        │           └── RomanticBackground.java
        │
        └── resources/
            └── images/
                ├── Screenshot 2026-09-15 234401.png
                ├── romantic_dinner.gif
                ├── romantic_dinner_3_5_seconds.gif
                └── romantic_dinner_5_seconds.gif
```

## Requirements

Before running the project, make sure you have installed:

- JDK 21
- Apache Maven
- MySQL Server
- IntelliJ IDEA or Eclipse (recommended)

## Installation and Setup

### 1. Clone the Repository

```bash
git clone <repository-url>
```

Navigate to the project directory:

```bash
cd CraveBite-main
```

### 2. Create the MySQL Database

Open MySQL and execute:

```sql
CREATE DATABASE cravebite;
```

### 3. Configure Database Connection

Open:

`src/main/java/org/example/database/DBConnection.java`

Update the database credentials according to your local MySQL configuration:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/cravebite";

private static final String USER =
        "YOUR_USERNAME";

private static final String PASSWORD =
        "YOUR_PASSWORD";
```

### 4. Create Required Database Tables

The application uses the following database tables:

**Users Table**

The registration module inserts records into the `users` table with these columns:

- name
- email
- phone
- password

**Orders Table**

The checkout module uses these columns:

- user_id
- total_amount
- status

**Order Items Table**

The checkout module uses these columns:

- order_id
- item_name
- category
- price
- quantity
- item_total

Create the tables in MySQL with suitable data types, primary keys, and relationships before running the application.

Note: The supplied project does not include a SQL schema or database initialization script.

### 5. Build the Project

Open a terminal in the project directory and execute:

```bash
mvn clean install
```

This command downloads the required dependencies and builds the project.

## Running the Application

The supplied `Main.java` currently launches a simple welcome window.

To launch the login interface directly, run:

`org.example.ui.LoginFrame`

Alternatively, you can update the main method in `Main.java` to launch the login screen:

```java
import javax.swing.SwingUtilities;
import org.example.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
```

After launching the login screen:

1. Register a new account.
2. Open the login screen.
3. Enter your email and password.
4. Explore the home page.
5. Select a food category.
6. Add food items to your cart.
7. Proceed to checkout.
8. Place your order and view the confirmation screen.

## Database Connectivity

CraveBite uses JDBC to connect to the MySQL database.

The `DBConnection.java` class manages database connections, while `UserDAO.java` handles user registration.

The checkout module uses JDBC prepared statements and database transactions to save orders and their associated food items.

## Future Enhancements

- Implement database-based user authentication.
- Add secure password hashing.
- Connect the logged-in user ID with placed orders.
- Store customer delivery details and selected payment method in the order database.
- Add order history and order tracking.
- Add an admin dashboard for managing food items and orders.
- Implement online payment gateway integration.
- Improve input validation and error handling.
- Add automated testing.

## Important Notes

- The login screen currently validates that the email and password fields are not empty. It does not verify credentials against the MySQL database.
- Registration details are saved in MySQL, but passwords are currently stored as plain text.
- The checkout module currently inserts `NULL` for the order's `user_id`.
- Customer name, phone number, address, and selected payment method are collected during checkout but are not included in the current order insertion SQL statements.
- The project requires the MySQL tables to be created manually.
- The `Main.java` entry point currently opens a basic welcome window rather than the complete application flow.

## License

No separate LICENSE file is included in the supplied project archive. Add a license if you intend to publish or distribute this project.
