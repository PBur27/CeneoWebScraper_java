package pl.PBur27.ceneoWebScraper.app;

import pl.PBur27.ceneoWebScraper.product.Product;

import java.util.ArrayList;

public class DataStorage {
    ArrayList<Product> products;

    public void addProduct(String urlText){
        products.add(new Product(urlText));
    }
}
