package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.nodes.Element;
import pl.PBur27.ceneoWebScraper.app.Scraper;

public class Page {

    Url url;
    Element content;
    public Page(Url productPageUrl) {
        this.url = productPageUrl;
        content = Scraper.getContent(productPageUrl);

    }
}
