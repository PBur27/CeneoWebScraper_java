package pl.PBur27.ceneoWebScraper.product;

import org.junit.jupiter.api.Test;

public class PageTest {

    @Test
    void checkPageContent(){
        Url u = new Url("https://www.ceneo.pl/115107321#tab=reviews");
        try {
            u.checkConnection();
            Page test = new Page(u);

            test.reviews.forEach(review -> System.out.println(review.toString()));
            System.out.println(test.reviews.getFirst().toString());

            assert true;
        } catch (UrlErrorException | UrlRedirectException e) {
            assert  false;
        }
    }
}
