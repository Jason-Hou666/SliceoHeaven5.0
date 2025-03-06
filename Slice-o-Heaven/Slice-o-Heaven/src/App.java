

public class App {
    public static void main(String[] args) throws Exception {
        SliceoHeavenOrder sliceoheavenorder1 = new SliceoHeavenOrder();
        System.out.println("Default Order ID: " + sliceoheavenorder1.getOrderID());
        System.out.println("Default Pizza Ingredients: " + sliceoheavenorder1.getPizzaIngredients());
        System.out.println("Default Order Total : " + String.format("%.2f", sliceoheavenorder1.getOrderTotal()));

        SliceoHeavenOrder sliceoheavenorder2 = new SliceoHeavenOrder("1234", "Cheese", 20.00);
        System.out.println("Custom Order ID: " + sliceoheavenorder2.getOrderID());
        System.out.println("Custom Pizza Ingredients: " + sliceoheavenorder2.getPizzaIngredients());
        System.out.println("Custom Order Total : " + String.format("%.2f", sliceoheavenorder2.getOrderTotal()));

        sliceoheavenorder2.takeOrder();

        System.out.println("Final Order Total : " + String.format("%.2f", sliceoheavenorder2.getOrderTotal()));
        sliceoheavenorder2.specialOfTheDay("Pizza1", "Side1", "RMB15.00");
    }
}