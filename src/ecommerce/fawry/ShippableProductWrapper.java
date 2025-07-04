package ecommerce.fawry;

public class ShippableProductWrapper extends Product implements Shipping{

    private Product originalProduct;
    private double weight; 

    public ShippableProductWrapper(Product originalProduct, double weight) {
        super(originalProduct.getName(), originalProduct.getPrice(), originalProduct.getQuantity());
        this.originalProduct = originalProduct;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return originalProduct.isExpired();
    }

    public void setQuantity1(int amount) {
        originalProduct.setQuantity(amount);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return originalProduct.getName();
    }

    @Override
    public int getQuantity() {
        return originalProduct.getQuantity();
    }

    @Override
    public double getPrice() {
        return originalProduct.getPrice();
    }

    @Override
    public void setQuantity(int quantity) {
        originalProduct.setQuantity(quantity);
    }











}
