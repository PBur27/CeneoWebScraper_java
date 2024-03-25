package pl.PBur27.ceneoWebScraper.product;


import org.junit.jupiter.api.Test;


public class ProductTest {

    @Test
    void assignsProductName(){
        Product test = new Product("https://www.ceneo.pl/47885380#tab=reviews");
        test.setName();

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

        test.setName();
        test.addReviewPages();

        String productNameInBody1 = test
                .reviewPages
                .get(0)
                .content
                .select("h1.product-top-section__product-name")
                .text();

        String productNameInBody2 = test
                .reviewPages
                .get(1)
                .content
                .select("h1.product-top-section__product-name")
                .text();

        if (productNameInBody1.equals("Motorola Moto G54 5G 8/256GB Czarny")
                &&
                productNameInBody2.equals("Motorola Moto G54 5G 8/256GB Czarny")
                &&
                test.reviewPages.size() == 5){
            assert true;
        }
        else {
            assert false;
        }
    }
}
