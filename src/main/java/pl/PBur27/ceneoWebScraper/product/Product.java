package pl.PBur27.ceneoWebScraper.product;

import pl.PBur27.ceneoWebScraper.app.NoMoreReviewPagesException;
import pl.PBur27.ceneoWebScraper.app.Scraper;

import java.util.ArrayList;

public class Product {
    String name;
    Url productPageUrl;
    ArrayList<Page>  reviewPages = new ArrayList<>();

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
        this.name = Scraper.getTitle(productPageUrl);
    }

    void addReviewPages(){
        this.reviewPages.add(new Page(productPageUrl));

        boolean morePagesAvailable = true;
        Url nextPageUrl = productPageUrl;

        while (morePagesAvailable){
            try {
                nextPageUrl = Scraper.getNextUrl(nextPageUrl);
                this.reviewPages.add(new Page(nextPageUrl));

            } catch (NoMoreReviewPagesException e) {
                morePagesAvailable = false;
            }
        }

    }




}
