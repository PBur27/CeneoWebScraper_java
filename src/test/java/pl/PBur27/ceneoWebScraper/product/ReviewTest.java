package pl.PBur27.ceneoWebScraper.product;

import org.junit.jupiter.api.Test;

public class ReviewTest {

    @Test
    void checkReviewContent(){
        Url u = new Url("https://m.ceneo.pl/115107321#tab=reviews");
        try {
            u.checkConnection();
            Page test = new Page(u);
            System.out.println(test.reviews.getFirst().opinionId);
            System.out.println(test.reviews.getFirst().author);
            System.out.println(test.reviews.getFirst().recommendation);
            System.out.println(test.reviews.getFirst().score);
            System.out.println(test.reviews.getFirst().publishDate);
            System.out.println(test.reviews.getFirst().purchaseDate);
            System.out.println(test.reviews.getFirst().thumbsUp);
            System.out.println(test.reviews.getFirst().thumbsDown);
            System.out.println(test.reviews.getFirst().content);
            System.out.println(test.reviews.getFirst().pros);
            System.out.println(test.reviews.getFirst().cons);
        } catch (UrlRedirectException | UrlErrorException e) {
            assert false;
        }
    }
}
