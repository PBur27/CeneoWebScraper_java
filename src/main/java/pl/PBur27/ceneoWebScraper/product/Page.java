package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.select.Elements;
import pl.PBur27.ceneoWebScraper.app.Scraper;

import java.io.Serializable;
import java.util.ArrayList;


public class Page implements Serializable {

    Url url;
    ArrayList<Review> reviews;
    // to be scrapped
    public Page(Url pageUrl) {
        this.url = pageUrl;
        this.reviews = Scraper.getReviews(this.url);
    }

}
