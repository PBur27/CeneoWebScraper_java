package pl.PBur27.ceneoWebScraper.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.PBur27.ceneoWebScraper.product.Url;
import pl.PBur27.ceneoWebScraper.product.UrlErrorException;
import pl.PBur27.ceneoWebScraper.product.UrlRedirectException;

public class ScraperTest {

    @Test
    void returnsPageReviews(){
        Url u = new Url("https://www.ceneo.pl/115107321/opinie-10");
        try {
            u.checkConnection();
        } catch (UrlErrorException | UrlRedirectException e) {
            assert  false;
        }

    }
}
