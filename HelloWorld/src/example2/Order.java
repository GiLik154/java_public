package example2;

public class Order {
	public Product selectedProduct;
	public String optionShot ="";	

	public Order(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Order(Product selectedProduct, String optionShot) {
		this.selectedProduct = selectedProduct;
		this.optionShot = optionShot;
	}
}
