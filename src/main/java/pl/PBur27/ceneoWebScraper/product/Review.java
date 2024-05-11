package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.nodes.Element;
import pl.PBur27.ceneoWebScraper.app.Scraper;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Review implements Serializable {

    int opinionId;
    String author;
    boolean recommendation;
    int score;
    LocalDate publishDate;
    LocalDate purchaseDate;
    int thumbsUp;
    int thumbsDown;
    String content;
    ArrayList<String> pros;
    ArrayList<String> cons;


    public Review(Element reviewElement) {

    this.opinionId = Scraper.getOpinionId(reviewElement);
    this.author = Scraper.getAuthor(reviewElement);
    this.recommendation = Scraper.getRecommendation(reviewElement);
    this.score = Scraper.getScore(reviewElement);
    this.publishDate = Scraper.getPublishDate(reviewElement);
    this.purchaseDate = Scraper.getPurchaseDate(reviewElement);
    this.thumbsUp = Scraper.getThumbsUp(reviewElement);
    this.thumbsDown = Scraper.getThumbsDown(reviewElement);
    this.content = Scraper.getContent(reviewElement);
    this.pros = Scraper.getPros(reviewElement);
    this.cons = Scraper.getCons(reviewElement);

    }
}
