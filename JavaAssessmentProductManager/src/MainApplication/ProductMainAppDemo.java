package MainApplication;

import productManager.ProductList;

import java.awt.*;
import java.util.Scanner;

public class ProductMainAppDemo {

	
	public static void main(String[] args ) {

		ProductList productList = new ProductList();
		Scanner scanner = new Scanner(System.in);

		Order order = new Order(productList, scanner);

		order.ConsoleStart();
		
		// Run Program in Main Java Application To test the output in the Console
	}

}
