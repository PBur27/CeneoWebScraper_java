package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.nodes.Element;
import pl.PBur27.ceneoWebScraper.app.Url;

import org.jsoup.nodes.Document;

public class Page {

    Element content;
    public Page(Url productPageUrl) {

        content = productPageUrl.getContent();

    }
}
