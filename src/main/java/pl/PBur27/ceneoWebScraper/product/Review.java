package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.nodes.Element;

import java.time.LocalDate;
import java.util.ArrayList;

public class Review {

    public Element reviewElement;
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


    public Review(Element rE) {
        this.reviewElement = rE;
    }
}
