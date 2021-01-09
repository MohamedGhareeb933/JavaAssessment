package console;

import productManager.ProductList;
import productManager.Products;

import java.util.Scanner;

public class Printout implements Output {

    private ProductList productList;
    Scanner scanner;

    public Printout(ProductList productList, Scanner scanner) {
        this.productList = productList;
        this.scanner = scanner;
    }

    @Override
    public void Stock() {

        System.out.println(" Products: ");
        System.out.println("ID \t" + "Name \t" +  "Price \t \n");

        for (int i = 0; i != productList.CountProductsSize(); i++) {
            Products p = productList.getProduct(i);
            System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getPrice() );
        }
    }

    @Override
    public int Menu() {
        System.out.println("PLEASE ORDER A PRODUCT FROM OUR MENU");
        System.out.println("1. add Product");
        System.out.println("2. Show Products");
        System.out.println("3. Select Product");
        System.out.println("4. Print bill");

        System.out.println("0. Press0 to Exit");

        // handle casses
        int order = parseInt(0, 4);

        return order;
    }

    // read the input and handle cases
    public int parseInt(int min, int max) {
        int order;

        while(true) {
            try {
                order = Integer.parseInt(scanner.nextLine());
                if(order >= min && order <= max) {
                    break;
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return order;
    }
}
