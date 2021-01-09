package input;

import productManager.ProductList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputSelection implements Input {

    ProductList productList;
    Scanner scanner;
    List<Integer> cart;

    public InputSelection(ProductList productList, Scanner scanner) {
        this.productList = productList;
        this.scanner = scanner;
        cart = new ArrayList<>();
    }

    @Override
    public void Select() {

        int index = 0;

        System.out.println("please Select our Products or Enter -1 to Exit");

        try {
            while (index != -1 ) {
                index = Integer.parseInt(scanner.nextLine());
                if (index == -1) {
                    return;
                } else if (index >= productList.CountProductsSize()){
                    System.out.println("invalid Input");
                }else{
                    cart.add(Integer.valueOf(index));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Integer> returnSelect() {
        return cart;
    }
}
