import java.time.LocalDate;
import java.util.Scanner;

public class SliceoHeavenOrder {
    private String orderID;
    private double orderTotal;
    private String pizzaIngredients;
    private String sides;
    private String drinks;
    private double pizzaSizePrice;

    public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;

    public SliceoHeavenOrder() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public SliceoHeavenOrder(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String ingredients = scanner.nextLine();
        String[] pizzaIngredientList = ingredients.split(" ");
        pizzaIngredients = String.join(", ", pizzaIngredientList);

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.nextLine();
        pizzaSizePrice = pizzaSize.equalsIgnoreCase("Small") ? 10.00
                : pizzaSize.equalsIgnoreCase("Medium") ? 15.00
                        : pizzaSize.equalsIgnoreCase("Large") ? 20.00 : 0.00;

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();
        System.out.println("your choice is"+extraCheese);

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        sides = scanner.nextLine();

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        drinks = scanner.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();

        orderTotal = pizzaSizePrice;
        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment(scanner);
        }
        scanner.close();
    }

    private void isItYourBirthday() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter your birthdate (YYYY-MM-DD):");
            String dateInput = scanner.nextLine();

            String[] parts = dateInput.split("-");
            if (parts.length != 3) {
                System.out.println("False!You will need to convert this to a date.");
                return;
            }

            try {
                int year = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int day = Integer.parseInt(parts[2]);

                LocalDate birthdate = LocalDate.of(year, month, day);
                LocalDate today = LocalDate.now();

                int age = today.getYear() - birthdate.getYear();
                if (birthdate.getDayOfYear() > today.getDayOfYear()) {
                    age--;
                }

                if (age < 18 && today.getDayOfYear() == birthdate.getDayOfYear()) {
                    orderTotal /= 2;
                    System.out.println("Congratulations! You pay only half the price for your order");
                } else {
                    System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                }
            } catch (Exception e) {
                System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
            }
        }
    }

    private void makeCardPayment(Scanner scanner) {
        System.out.println("Please give me your card number:");
        long cardNumber = Long.parseLong(scanner.nextLine());

        System.out.println("Please give me your card's expiry date（MM/YYYY）:");
        String expiryDate = scanner.nextLine();

        System.out.println("Please give me your card's CVV:");
        int cvv = Integer.parseInt(scanner.nextLine());

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        String cardNumberStr = Long.toString(cardNumber);

        if (cardNumberStr.length() == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }

        int firstCardDigit = Integer.parseInt(String.valueOf(cardNumberStr.charAt(0)));
        long blacklistedNumber = 12345678901234L;

        if (cardNumber == blacklistedNumber) {
            System.out.println("Card is blacklisted. Please use another\n" + 
                    "card");
            return;
        }

        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));
        String cardNumberToDisplay = firstCardDigit
                + new String(new char[cardNumberStr.length() - 5]).replace("\0", "*") + lastFourDigits;

        System.out.println("First Card Digit: " + firstCardDigit);
        System.out.println("Last Four Digits: " + lastFourDigits);
        System.out.println("Card Number to display: " + cardNumberToDisplay);

        printReceipt();
    }

    private void printReceipt() {
        System.out.println("********RECEIPT*******");
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Details: " + "pizzaIngredients: " + pizzaIngredients + ", sides : " + sides
                + ", drinks: " + drinks);
        System.out.println("Order Total: " + orderTotal);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        System.out.println("Today's Special: Pizza of the Day: " + pizzaOfTheDay +
                ", Side of the Day: " + sideOfTheDay +
                ", Special Price: " + specialPrice);
    }
}