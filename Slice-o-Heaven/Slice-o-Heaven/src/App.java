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

        sliceoheavenorder2.takeOrder("1234", "2 pizza", 20.00);

        System.out.println("Custom Order Total : " + String.format("%.2f", sliceoheavenorder2.getOrderTotal()));

        // 示例：处理卡支付
        sliceoheavenorder2.processCardPayment("12345678901234", "3/3", 666);

        // 示例：特价披萨
        sliceoheavenorder2.specialOfTheDay("Pizza1", "Side1", "RMB15.00");
    }
}