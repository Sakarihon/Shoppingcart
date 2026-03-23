import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShoppingCartAppTest {

    @Test
    void testItemTotal() {
        double result = ShoppingCartApp.calculateItemTotal(10, 2);
        assertEquals(20, result);
    }

    @Test
    void testZeroQuantity() {
        double result = ShoppingCartApp.calculateItemTotal(10, 0);
        assertEquals(0, result);
    }

    @Test
    void testDecimalPrice() {
        double result = ShoppingCartApp.calculateItemTotal(2.5, 4);
        assertEquals(10.0, result);
    }

    @Test
    void testCartTotal() {
        double[] items = {10.0, 20.0, 5.0};
        double result = ShoppingCartApp.calculateCartTotal(items);
        assertEquals(35.0, result);
    }

    @Test
    void testEmptyCart() {
        double[] items = {};
        double result = ShoppingCartApp.calculateCartTotal(items);
        assertEquals(0.0, result);
    }
}