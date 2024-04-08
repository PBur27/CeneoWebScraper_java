package pl.PBur27.ceneoWebScraper.product;

import org.junit.jupiter.api.Test;

public class PageTest {

    @Test
    void checkPageContent(){
        Url u = new Url("https://www.ceneo.pl/115107321/opinie-10");
        try {
            u.checkConnection();
            Page test = new Page(u);

            //test.reviews.forEach(review -> System.out.println(review.reviewElement.toString()));
            System.out.println(test.reviews.getFirst().reviewElement.toString());

            assert true;
        } catch (UrlErrorException | UrlRedirectException e) {
            assert  false;
        }
    }
}
