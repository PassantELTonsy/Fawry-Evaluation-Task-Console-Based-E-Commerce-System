package ecommerce.fawry;

public class NonExpirableProducts extends Product {
	public NonExpirableProducts(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false; 
    }

}
