package ecommerce.fawry;
import java.util.List;
import java.util.Map;
public class ShippingService {
	public static void shipItems(Map<Shipping, Integer> itemsToShip) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (Map.Entry<Shipping, Integer> entry : itemsToShip.entrySet()) {
            Shipping item = entry.getKey();
            int quantity = entry.getValue();
            double itemWeight = item.getWeight() * quantity;
            totalWeight += itemWeight;

            System.out.printf("%dx %-12s %.0fg%n", quantity, item.getName(), itemWeight * 1000); // grams
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}
 // "%dx %-12s %.0fg%n" to follow the output format