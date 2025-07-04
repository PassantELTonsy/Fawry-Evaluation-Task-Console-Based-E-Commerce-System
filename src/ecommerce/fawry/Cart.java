package ecommerce.fawry;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Product, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }
    public void add(Product product, int quantity) {
        if (product.isExpired()) {
            System.out.println("Cannot add expired product: " + product.getName());
            return;
        }

        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock for: " + product.getName());
            return;
        }

        int currentQty = items.getOrDefault(product, 0);
        items.put(product, currentQty + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
