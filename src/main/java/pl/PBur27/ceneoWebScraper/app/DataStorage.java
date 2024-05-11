package pl.PBur27.ceneoWebScraper.app;

import pl.PBur27.ceneoWebScraper.product.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DataStorage {

    public static void serializeProduct(Product target) throws IOException {

        FileOutputStream fileOut = new FileOutputStream("src/test/java/resources/" + target.name);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(target);
        objectOut.close();
        fileOut.close();

    }

}
