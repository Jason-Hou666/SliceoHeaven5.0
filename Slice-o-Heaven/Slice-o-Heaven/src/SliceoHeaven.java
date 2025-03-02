
public class SliceoHeaven {

   
    public static void processCardPayment(String cardNumber, String expiryDate, int cvv) {
      
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));

        String blacklistedNumber = "66666666666666";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }

        
        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardLength - 4));

      
        StringBuilder masked = new StringBuilder();
        masked.append(cardNumber.charAt(0));
        for (int i = 1; i < cardLength - 4; i++) {
            masked.append('*');
        }
        masked.append(cardNumber.substring(cardLength - 4));
        String cardNumberToDisplay = masked.toString();

        System.out.println("First digit of the card: " + firstCardDigit);
        System.out.println("Last four digits of the card: " + lastFourDigits);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

 
    public static void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        StringBuilder specialDetails = new StringBuilder();
        specialDetails.append("Pizza of the day: ").append(pizzaOfTheDay);
        specialDetails.append("\nSide of the day: ").append(sideOfTheDay);
        specialDetails.append("\nSpecial price: ").append(specialPrice);
        System.out.println(specialDetails.toString());
    }
}