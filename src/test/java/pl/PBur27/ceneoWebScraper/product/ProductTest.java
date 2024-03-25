package pl.PBur27.ceneoWebScraper.product;


import org.junit.jupiter.api.Test;


public class ProductTest {

    @Test
    void assignsProductName(){
        Product test = new Product("https://www.ceneo.pl/47885380#tab=reviews");

        if (test.name.equals("Długopis Parker Jotter Stainless Steel GT 1953182 - Ceny i opinie - Ceneo.pl")){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    void addsPages(){

        Product test = new Product("https://www.ceneo.pl/157746229#tab=reviews");


        String productNameInBody1 = test
                .pages
                .get(0)
                .reviews
                .select("h1.product-top-section__product-name")
                .text();

        String productNameInBody2 = test
                .pages
                .get(1)
                .reviews
                .select("h1.product-top-section__product-name")
                .text();

        if (productNameInBody1.equals("Motorola Moto G54 5G 8/256GB Czarny")
                &&
                productNameInBody2.equals("Motorola Moto G54 5G 8/256GB Czarny")
                &&
                test.pages.size() == 5){
            assert true;
        }
        else {
            assert false;
        }
    }
}
