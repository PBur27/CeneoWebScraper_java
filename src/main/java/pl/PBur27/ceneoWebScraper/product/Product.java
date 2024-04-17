package pl.PBur27.ceneoWebScraper.product;

import pl.PBur27.ceneoWebScraper.app.NoMoreReviewPagesException;
import pl.PBur27.ceneoWebScraper.app.Scraper;

import java.util.ArrayList;

public class Product {
    String name;
    Url productPageUrl;
    ArrayList<Page> pages = new ArrayList<>();

    public Product(String text) {
        this.productPageUrl = new Url(text);
        try {
            this.productPageUrl.checkConnection();
            this.name = Scraper.getTitle(productPageUrl);
            this.pages = Scraper.getPages(productPageUrl);
        } catch (UrlRedirectException | UrlErrorException e) {
            System.out.println("Error adding product");
        }
    }

}
