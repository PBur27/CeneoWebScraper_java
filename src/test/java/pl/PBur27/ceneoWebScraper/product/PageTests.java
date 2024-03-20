package pl.PBur27.ceneoWebScraper.product;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PageTests {

    @Test
    void itGetsPage() throws IOException {
        String url = "https://www.ceneo.pl/115107321#tab=reviews";

        Page reviews = new Page(url);

        System.out.println(reviews.content);

    }
}
