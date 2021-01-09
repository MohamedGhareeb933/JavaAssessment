package offer;

import productManager.ProductList;

public class OfferSale implements Sale{

    ProductList productList;

    public OfferSale(ProductList productList){
        this.productList = productList;
    }

    @Override
    public float shoeDiscount() {
        return productList.getProduct(3).getPrice() * 10 / 100;
    }

    @Override
    public float jacketDiscount() {
        return  productList.getProduct(2).getPrice() * 50 / 100;
    }
}
