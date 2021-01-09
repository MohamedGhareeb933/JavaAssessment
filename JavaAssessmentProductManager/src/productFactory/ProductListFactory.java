package productFactory;

import productManager.ProductList;
import productManager.Products;

import java.util.Scanner;

public class ProductListFactory implements ProductFactory {
	
	ProductList procductList;
	int index = 0;
	Scanner scanner;

	public ProductListFactory(ProductList procductList, Scanner scanner) {
		this.procductList = procductList;
		this.scanner = scanner;
	}

	@Override
	public void DefaultProduct() {

		procductList.AddProduct(new Products(index++, "T-shirt", 10.99f));
		procductList.AddProduct(new Products(index++, "Pants", 14.99f));
		procductList.AddProduct(new Products(index++, "Jacket ", 19.99f));
		procductList.AddProduct(new Products(index++, "shoes ", 24.99f));
	}

	@Override
	public void CustomProduct() {

		System.out.println("Enter Product Name: \n");
		String name = scanner.nextLine();
		System.out.println("Enter Product Price: \n");
		float Price = readPrice();

		procductList.AddProduct(new Products(index++, name, Price));
	}



	// enter custom price for Custom added product
	private float readPrice() {
		float Price;
		while(true) {
			try {
				Price = Float.parseFloat(scanner.nextLine());
				if(Price > 0 && Price <= Float.MAX_VALUE) {
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Price;
	}
}
