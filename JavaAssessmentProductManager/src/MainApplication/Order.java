package MainApplication;

import console.Output;
import console.Printout;
import input.Input;
import input.InputSelection;
import productFactory.ProductFactory;
import productFactory.ProductListFactory;
import productManager.ProductList;
import summary.Bill;
import summary.PrintBill;

import java.util.Scanner;

public class Order {

	private ProductFactory productFactory;
	private Input input;
	private Output output;
	private Bill bill;
	
	Order(ProductList procductList, Scanner scanner) {

		productFactory = new ProductListFactory(procductList, scanner);
		input = new InputSelection(procductList, scanner);
		output = new Printout(procductList, scanner);
		bill = new PrintBill(procductList, input);

		productFactory.DefaultProduct();
	}

	// handle menu input casses
	public void ConsoleStart() {
		while(true) {
			
			switch(Menu()) {
			case 0:
				System.exit(0);
				break;
			case 1:
				Createproduct();
				break;
			case 2:
				showAllProducts();
				break;
			case 3:
				SelectProduct();
				break;
			case 4:
				outPutbill();
				break;
				
				default:
					System.out.println("no Valid Selection");
			}
		}
	}

	private int Menu() {
		return output.Menu();
	}

	// print out the final bill
	private void outPutbill() {
		bill.outputBill();
	}

	// select product from product list or -1 to exit
	private void SelectProduct() {
		showAllProducts();
		input.Select();
	}

	// print the list of existing products 
	private void showAllProducts() {
		output.Stock();
	}

	private void Createproduct() {
		productFactory.CustomProduct();
	}

}
