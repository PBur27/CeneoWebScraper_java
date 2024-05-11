package pl.PBur27.ceneoWebScraper.product;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductTest {

    @Test
    void assignsProductName(){
        Product test = new Product("https://www.ceneo.pl/47885380#tab=reviews");

        if (test.name.equals("Długopis Parker Jotter Stainless Steel GT 1953182")){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    void addsPages(){

        Product test = new Product("https://www.ceneo.pl/157746229#tab=reviews");


        Assertions.assertThat(!test.pages.isEmpty());
    }
}
