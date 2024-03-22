package pl.PBur27.ceneoWebScraper.product;

import org.assertj.core.api.Assertions;

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
    void assignsFirstReviewPage(){

        Product test = new Product("https://www.ceneo.pl/47885380#tab=reviews");

        test.setName();
        test.addFirstReviewPage();
        System.out.println();

        String productNameInBody = test
                .reviewPages
                .getFirst()
                .content
                .select("#body > div.no-banner > div > div > article > div > div.product-top__product > div.product-top__product-info > div.product-top__product-info__name-container > div.product-top__title > h1")
                .text();

        if (productNameInBody.equals("Długopis Parker Jotter Stainless Steel GT 1953182")){
            assert true;
        }
        else {
            assert false;
        }
    }
}
