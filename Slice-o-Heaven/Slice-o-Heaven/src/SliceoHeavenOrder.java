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
    public static final long BLACKLISTED_NUMBER = 12345678912345L;

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

        int ingChoice1, ingChoice2, ingChoice3;
        do {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun-dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.print("Enter any three choices (1, 2, 3,…) separated by spaces: ");
            String[] choices = scanner.nextLine().split(" ");
            if (choices.length != 3) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                continue;
            }
            try {
                ingChoice1 = Integer.parseInt(choices[0]);
                ingChoice2 = Integer.parseInt(choices[1]);
                ingChoice3 = Integer.parseInt(choices[2]);
                if (ingChoice1 < 1 || ingChoice1 > 5 || ingChoice2 < 1 || ingChoice2 > 5 || ingChoice3 < 1 || ingChoice3 > 5) {
                    System.out.println("Invalid choice(s). Please pick only from the given list:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        } while (true);

        String ing1, ing2, ing3;
        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            default:
                ing1 = "Pineapple";
        }

        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            default:
                ing2 = "Pineapple";
        }

        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            default:
                ing3 = "Pineapple";
        }

        pizzaIngredients = ing1 + ", " + ing2 + ", " + ing3;

        int sizeChoice;
        do {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.print("Enter only one choice (1, 2, or 3): ");
            try {
                sizeChoice = Integer.parseInt(scanner.nextLine());
                if (sizeChoice < 1 || sizeChoice > 3) {
                    System.out.println("Invalid choice. Please pick only from the given list:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        } while (true);

        String pizzaSize;
       
        switch (sizeChoice) {
            case 1:
                pizzaSize = "Large";
                pizzaSizePrice = 15.00;
                break;
            case 2:
                pizzaSize = "Medium";
                pizzaSizePrice = 10.00;
                break;
            default:
                pizzaSize = "Small";
                pizzaSizePrice = 5.00;
        }
        String orderDescription = "Order: " + pizzaSize + " pizza";
        System.out.println(orderDescription);
        System.out.println("Total price: $" + pizzaSizePrice);

        System.out.print("Do you want extra cheese (Y/N): ");
        String extraCheese = scanner.nextLine();
        System.out.println("Your choice is:"+ extraCheese);

        int sideDishChoice;
        do {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.print("What would you like? Pick one (1, 2, 3,…): ");
            try {
                sideDishChoice = Integer.parseInt(scanner.nextLine());
                if (sideDishChoice < 1 || sideDishChoice > 5) {
                    System.out.println("Invalid choice. Please pick only from the given list:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        } while (true);

        String sideDish;
        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish = "Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            default:
                sideDish = "Nothing for me";
        }
        sides = sideDish;

        int drinkChoice;
        do {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.print("Enter your choice: ");
            try {
                drinkChoice = Integer.parseInt(scanner.nextLine());
                if (drinkChoice < 1 || drinkChoice > 4) {
                    System.out.println("Invalid choice. Please pick only from the given list:");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please pick only from the given list:");
            }
        } while (true);

        String drink;
        switch (drinkChoice) {
            case 1:
                drink = "Coca Cola";
                break;
            case 2:
                drink = "Cold coffee";
                break;
            case 3:
                drink = "Cocoa Drink";
                break;
            default:
                drink = "No drinks for me";
        }
        drinks = drink;

        System.out.print("Would you like the chance to pay only half for your order? (Y/N): ");
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
            while (true) {
                System.out.print("Please enter your birthdate (YYYY-MM-DD): ");
                String dateInput = scanner.nextLine();

                String[] parts = dateInput.split("-");
                if (parts.length != 3) {
                    System.out.println("False!You will need to convert this to a date.");
                    continue;
                }

                try {
                    int year = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int day = Integer.parseInt(parts[2]);

                    LocalDate birthdate = LocalDate.of(year, month, day);
                    LocalDate today = LocalDate.now();

                    long age = today.getYear() - birthdate.getYear();
                    if (birthdate.getDayOfYear() > today.getDayOfYear()) {
                        age--;
                    }

                    if (age < 5 || age > 120) {
                        System.out.println("Invalid date. You are either too young or too dead to order.");
                        System.out.println("Please enter a valid date:");
                    } else {
                        if (age < 18 && today.getDayOfYear() == birthdate.getDayOfYear()) {
                            orderTotal /= 2;
                            System.out.println("Congratulations! You pay only half the price for your order");
                        } else {
                            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                        }
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
                }
            }
        }
    }

    private void makeCardPayment(Scanner scanner) {
        System.out.print("Please give me your card number: ");
        long cardNumber = Long.parseLong(scanner.nextLine());

        String expiryDate;
        do {
            System.out.print("Please give me your card's expiry date（MM/YYYY）: ");
            expiryDate = scanner.nextLine();

            String[] parts = expiryDate.split("/");
            if (parts.length != 2) {
                System.out.println("Invalid expiry date. Please enter in MM/YYYY format:");
            } else {
                try {
                    int month = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    LocalDate expiry = LocalDate.of(year, month, 1);
                    LocalDate today = LocalDate.now();
                    if (expiry.isBefore(today)) {
                        System.out.println("Invalid expiry date. Please enter a future date:");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid expiry date. Please enter in MM/YYYY format:");
                }
            }
        } while (true);

        System.out.print("Please give me your card's CVV: ");
        long cvv = Long.parseLong(scanner.nextLine());

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, long cvv) {
        String cardNumberStr = Long.toString(cardNumber);

        while (cardNumberStr.length() != 14 || cardNumber == BLACKLISTED_NUMBER) {
            if (cardNumberStr.length() != 14) {
                System.out.println("Card number must be 14 digits long.");
            } else {
                System.out.println("Card is blacklisted. Please use another card.");
            }
            System.out.print("Please enter a new card number: ");
            cardNumber = Long.parseLong(System.console().readLine());
            cardNumberStr = Long.toString(cardNumber);
        }

        int firstCardDigit = Integer.parseInt(String.valueOf(cardNumberStr.charAt(0)));
        int lastFourDigits = Integer.parseInt(cardNumberStr.substring(cardNumberStr.length() - 4));
        String cardNumberToDisplay = firstCardDigit
                + new String(new char[cardNumberStr.length() - 5]).replace("\0", "*") + lastFourDigits;

        System.out.println("First Card Digit: " + firstCardDigit);
        System.out.println("Last Four Digits: " + lastFourDigits);
        System.out.println("Card Number to display: " + cardNumberToDisplay);

        System.out.println(this.toString());
    }

    
    public String toString() {
        return "\n********RECEIPT*******\n" +
                "Order ID: " + orderID + "\n" +
                "Order Details: pizzaIngredients: " + pizzaIngredients + ", sides : " + sides +
                ", drinks: " + drinks + "\n" +
                "Order Total: " + orderTotal;
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        System.out.println("Today's Special: Pizza of the Day: " + pizzaOfTheDay +
                ", Side of the Day: " + sideOfTheDay +
                ", Special Price: " + specialPrice);
    }
}