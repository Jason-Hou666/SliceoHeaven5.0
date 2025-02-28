public class SliceoHeaven {
     public String storeName;
     public String storeAddress;
     public String storeMenu;
     public long storePhoneNumber;
     public String storeEmail;
     public String pizzaPrice;
     public String sides;
     public String drinks;

     private String orderID;
     private String orderDetails;

     private double orderTotal;

     public void takeOrder(String id, String details, double total) {
          orderID = id;
          orderDetails = details;
          orderTotal = total;

          
          System.out.println("Order accepted!");

          System.out.println("Order is being prepared");

          try {
               Thread.sleep(5000);
          } catch (InterruptedException e) {
               System.out.println("Order is ready for pickup!");
          }

          System.out.println("Your order is ready!");
          makePizza();

          printReceipt();

     }
     private void makePizza() {
          System.out.println("Making the pizza...");
          System.out.println("Your Pizza is made!");
     }
     private void printReceipt() {
          System.out.println("********RECEIPT********");

          System.out.println("Order ID: " + orderID);
          System.out.println("Order Details: " + orderDetails);
          System.out.println("Order Total: " + orderTotal);
}
}