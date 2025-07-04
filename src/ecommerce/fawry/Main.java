package ecommerce.fawry;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 	Scanner input = new Scanner(System.in);

	        // User Input
	        System.out.print("Enter your name: ");
	        String name = input.nextLine();

	        System.out.print("Enter your balance: ");
	        double balance = input.nextDouble();

	        Customer customer = new Customer(name, balance);
	        Cart cart = customer.getCart();
		 
		 	//Create Products
		 	ExpirableProducts cheese = new ExpirableProducts("Cheese", 100, 10, LocalDate.of(2025, 7, 10));
	        ExpirableProducts biscuits = new ExpirableProducts("Biscuits", 150, 5, LocalDate.of(2025, 7, 6));
	        NonExpirableProducts tv = new NonExpirableProducts("TV", 3000, 3);
	        NonExpirableProducts scratchCard = new NonExpirableProducts("Scratch Card", 50, 20);
	        Product cheeseShippable = new ShippableProductWrapper(cheese, 0.2);
	        Product biscuitsShippable = new ShippableProductWrapper(biscuits, 0.7);
	        Product tvShippable = new ShippableProductWrapper(tv, 5.0);
	       
	        // Menu
	        Map<String, Product> menu = new HashMap<>();
	        menu.put("1", cheeseShippable);
	        menu.put("2", biscuitsShippable);
	        menu.put("3", tvShippable);
	        menu.put("4", scratchCard);

	        boolean adding = true;
	        while (adding) {
	            System.out.println("\nAvailable Products:");
	            System.out.println("1 - Cheese (100 EGP)");
	            System.out.println("2 - Biscuits (150 EGP)");
	            System.out.println("3 - TV (3000 EGP)");
	            System.out.println("4 - Scratch Card (50 EGP)");
	            System.out.print("Enter product number to add to cart (or 0 to checkout): ");
	            String choice = input.nextLine();

	            if (choice.equals("0")) {
	                adding = false;
	                break;
	            }

	            Product selected = menu.get(choice);
	            if (selected == null) {
	                System.out.println("Invalid choice.");
	                continue;
	            }

	            System.out.print("Enter quantity: ");
	            int qty = input.nextInt();
	            input.nextLine(); 

	            cart.add(selected, qty);
	            System.out.println(qty + "x " + selected.getName() + " added to cart.");
	        }

	        //checkout
	        checkout(customer);

	        input.close();
		
	 }
	
	
	 public static void checkout(Customer customer) {
	        Cart cart = customer.getCart();

	        if (cart.isEmpty()) {
	            System.out.println("Cannot checkout: Cart is empty.");
	            return;
	        }
	        
	        double subtotal = 0;
	        double shippingFee = 0;
	        Map<Shipping, Integer> itemsToShip = new HashMap<>();
	        
	        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
	            Product product = entry.getKey();
	            int quantity = entry.getValue();
	            
	            if (product.isExpired()) {
	                System.out.println("Cannot checkout: Product " + product.getName() + " is expired.");
	                return;
	            }

	            if (product.getQuantity() < quantity) {
	                System.out.println("Cannot checkout: Not enough stock for " + product.getName());
	                return;
	            }
	            
	            double price = product.getPrice() * quantity;
	            subtotal += price;

	            if (product instanceof Shipping) {
	                itemsToShip.put((Shipping) product, quantity);
	                
	            }
	        }
	        
	        if (!itemsToShip.isEmpty()) {
	            shippingFee = 30; 
	        }
	        double total = subtotal + shippingFee;

	        
	        if (customer.getBalance() < total) {
	            System.out.println("Cannot checkout: Insufficient balance.");
	            return;
	        }
	        
	        
	        
	        
	        //Balance and Stock
	        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
	            entry.getKey().setQuantity(entry.getValue());
	        }
	        customer.newBalance(total);
	        
	        //Shipping and receipts
	        if (!itemsToShip.isEmpty()) {
	            ShippingService.shipItems(itemsToShip);
	        }
	        
	        
	        
	        System.out.println("\n** Checkout receipt **");
	        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
	            Product p = entry.getKey();
	            int q = entry.getValue();
	            System.out.printf("%dx %-12s %.0f%n", q, p.getName(), p.getPrice() * q);
	        }

	        System.out.println("----------------------");
	        System.out.println("Subtotal         " + subtotal);
	        System.out.println("Shipping         " + shippingFee);
	        System.out.println("Amount           " + total);
	        System.out.println("Remaining Balance: " + customer.getBalance());

	        cart.clear();
	    }
	        
	        
	        
	        
	        
	        
	        
	        
	        
	     

}
