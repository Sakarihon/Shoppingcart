import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCartApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Select a language");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");

        int choice = input.nextInt();

        Locale locale;

        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            default:
                locale = new Locale("en", "US");
        }

        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);

        System.out.println(rb.getString("items"));
        int itemCount = input.nextInt();

        double[] itemTotals = new double[itemCount];

        for (int i = 0; i < itemCount; i++) {

            System.out.println(rb.getString("price") + " " + (i + 1) + ":");
            double price = input.nextDouble();

            System.out.println(rb.getString("quantity") + " " + (i + 1) + ":");
            int quantity = input.nextInt();

            double itemTotal = calculateItemTotal(price, quantity);

            System.out.println(rb.getString("itemTotal") + " " + itemTotal);

            itemTotals[i] = itemTotal;
        }

        double totalCartCost = calculateCartTotal(itemTotals);

        System.out.println(rb.getString("total") + " " + totalCartCost);
    }

    public static double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    public static double calculateCartTotal(double[] itemTotals) {
        double sum = 0;
        for (double item : itemTotals) {
            sum += item;
        }
        return sum;
    }
}