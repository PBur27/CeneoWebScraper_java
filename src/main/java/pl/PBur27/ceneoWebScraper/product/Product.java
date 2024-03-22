package pl.PBur27.ceneoWebScraper.product;

import pl.PBur27.ceneoWebScraper.app.Url;
import pl.PBur27.ceneoWebScraper.app.UrlErrorException;
import pl.PBur27.ceneoWebScraper.app.UrlRedirectException;

import java.util.ArrayList;

public class Product {
    String name;
    Url productPageUrl;
    ArrayList<Page>  reviewPages = new ArrayList<Page>();

    Product(String text) {
        this.productPageUrl = new Url(text);
        try {
            this.productPageUrl.checkConnection();
        } catch (UrlRedirectException | UrlErrorException e) {
            System.out.println("Error adding product");
            //add exception??
        }
    }

    void setName(){

        this.name = productPageUrl.getTitle();

    }

    void addFirstReviewPage(){
        reviewPages.add(new Page(this.productPageUrl));
    }


}
