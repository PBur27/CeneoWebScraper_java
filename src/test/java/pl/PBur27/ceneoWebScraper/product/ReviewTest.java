package pl.PBur27.ceneoWebScraper.product;

import org.junit.jupiter.api.Test;

public class ReviewTest {

    @Test
    void checkReviewContent(){
        Url u = new Url("https://www.ceneo.pl/115107321/opinie-10");
        try {
            u.checkConnection();
            Page test = new Page(u);
            System.out.println(test.reviews.getFirst().reviewElement.toString());
            System.out.println(test.reviews.getFirst().opinionId);
            System.out.println(test.reviews.getFirst().author);
            System.out.println(test.reviews.getFirst().recommendation);
            System.out.println(test.reviews.getFirst().score);
            System.out.println(test.reviews.getFirst().publishDate);
            System.out.println(test.reviews.getFirst().purchaseDate);
        } catch (UrlRedirectException | UrlErrorException e) {
            assert false;
        }
    }
}
