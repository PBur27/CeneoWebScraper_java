package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
public class Page {

    Document content;

    public Page(String url) throws IOException {
        this.content = Jsoup.connect(url).timeout(5000).get();
    }
}