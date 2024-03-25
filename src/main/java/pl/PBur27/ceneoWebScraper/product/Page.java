package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.select.Elements;
import pl.PBur27.ceneoWebScraper.app.Scraper;

import java.util.ArrayList;


public class Page {

    Url url;
    ArrayList<Review> reviews;
    // to be scrapped
    public Page(Url pageUrl) {
        this.url = pageUrl;
        this.getReviews();
    }

    public void getReviews(){
        this.reviews = Scraper.getReviews(this.url);
    }
}
