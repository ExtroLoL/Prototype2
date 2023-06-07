package cafe;

import java.util.HashMap;
import java.util.Map;

public class MenuItems {

    // List of menu items
    private static Map<String, Double> menuItems;

    static {
        menuItems = new HashMap<>();
        menuItems.put("Coffee", 5.50);
        menuItems.put("Tea", 3.00);
        menuItems.put("Juice", 6.00);
        menuItems.put("Sandwich", 8.50);
        menuItems.put("Cake", 12.00);
        menuItems.put("Salad", 10.00);
    }

    public static double getPrice(String itemName) {
        return menuItems.getOrDefault(itemName, 0.00);
    }
}
