package productManager;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	
	// Container to Hold the list of the Products 
	private List<Products> productList;
	
	public ProductList() {
		// initilize Product List in Constructor
		productList = new ArrayList<>();
	}
	
	// add product Funtion
	public void AddProduct(Products products) {
		if(productList != null)
		productList.add(products);
		
	}
	
	// return Product size function
	public int CountProductsSize() {
		return productList.size();
	}
	
	// Get Product Index
	public Products getProduct(int index) {
		
		if(index < 0 || index > CountProductsSize()) {
			return null;
		}
		
		return productList.get(index);
	}
	
}
