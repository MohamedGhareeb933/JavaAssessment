package summary;

import input.Input;
import offer.OfferSale;
import productManager.ProductList;
import offer.Sale;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintBill implements Bill {

    ProductList procductList;
    Input input;
    Sale sale;

    public PrintBill(ProductList procductList, Input input) {
        this.procductList = procductList;
        this.input = input;
        sale = new OfferSale(procductList);
    }

    private List<Integer> getCart() {
        return input.returnSelect();
    }

    @Override
    public float countBill() {
        float totalbill = 0.f;

        System.out.println("Items in the Cart");
        for (Integer i : getCart()) {
            totalbill += procductList.getProduct(i).getPrice();
            System.out.println(procductList.getProduct(i).getName() + " ");
        }

        return totalbill - Discount();
    }

    @Override
    public void outputBill() {
        System.out.println("Debug line - Discount" + Discount());
        float total = 0;
        float taxes = 9.7f;
        float totalbill = countBill();

        System.out.println("Subtotal: $" + totalbill);
        System.out.println("Taxes: $" + taxes);
        //System.out.println("Discounts: \n" + Discounts);

        total = totalbill + taxes;

        System.out.println("Total: $" + total);
    }

    @Override
    public Map<Integer, Integer> CountCart() {

        Map<Integer, Integer> isExist = new TreeMap<>();

        for (Integer i : getCart()) {
            if (!isExist.containsKey(i)) {
                isExist.put(i, 1);
            } else {
                isExist.computeIfPresent(i, (Key, Val) -> Val + 1);
            }
        }

        return isExist;
    }

    public float Discount() {
        float discount = 0;

        if (CountCart().containsKey(0))
            if (CountCart().get(0) > 1)
                discount += sale.jacketDiscount();


        if (CountCart().containsKey(3))
            discount += sale.shoeDiscount();


        return discount;
    }

}