package android.example.foodo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Cart {

    private static List<String> checkoutCart = new LinkedList<String>();

    public static void addItemToCart(String itemName, int quantity) {
        System.out.println("[Cart] Adding item : "+itemName+" - quantity : "+quantity);
        String item = itemName+"-"+quantity;
        checkoutCart.add(item);
        System.out.println("[Cart] Added items");
    }

    public static List<String> getCart() {
        System.out.println("[Cart] Getting items");
        return checkoutCart;
    }

    public static void emptyCart()
    {
        checkoutCart.clear();

    }
}
