package ecommerce.fawry;

public class Customer {
	private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
	
    }
	
   //Getters and Setters
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }
    
    public void newBalance(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient!");
        }
        balance -= amount;
    }

    public void addBalance(double amount) {
        balance += amount;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
