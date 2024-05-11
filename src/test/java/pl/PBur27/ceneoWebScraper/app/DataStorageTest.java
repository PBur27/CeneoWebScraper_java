package pl.PBur27.ceneoWebScraper.app;

import org.junit.jupiter.api.Test;
import pl.PBur27.ceneoWebScraper.product.Product;

import java.io.IOException;

public class DataStorageTest {

    @Test
    void serializationTest() throws IOException {

        Product test = new Product("https://www.ceneo.pl/115107321/opinie-10");

        DataStorage.serializeProduct(test);


    }

}
