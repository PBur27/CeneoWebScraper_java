package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.nodes.Element;
import pl.PBur27.ceneoWebScraper.app.Scraper;

import java.time.LocalDate;
import java.util.ArrayList;

public class Review {

    public Element reviewElement;
    //to be deleted - move to constr
    int opinionId;
    String author;
    boolean recommendation;
    int score;
    boolean purchased;
    LocalDate publishDate;
    LocalDate purchaseDate;
    int thumbsUp;
    int thumbsDown;
    String content;
    ArrayList<String> pros;
    ArrayList<String> cons;


    public Review(Element reviewElement) {

    this.reviewElement = reviewElement;

    this.opinionId = Scraper.getOpinionId(reviewElement);
    this.author = Scraper.getAuthor(reviewElement);
    this.recommendation = Scraper.getRecommendation(reviewElement);


    }
}
