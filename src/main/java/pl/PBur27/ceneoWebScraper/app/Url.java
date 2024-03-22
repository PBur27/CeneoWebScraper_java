package pl.PBur27.ceneoWebScraper.app;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Url {

    String url;
    Document response;
    public Url(String text) {
        this.url = text;
    }

    public void checkConnection() throws UrlRedirectException, UrlErrorException {
        Connection.Response tryResponse;
        try {
            tryResponse = Jsoup.connect(this.url)
                    .followRedirects(false)
                    .execute();
            if (tryResponse.statusCode() == 301 || tryResponse.statusCode() == 302){
                throw new UrlRedirectException();
            }
            else {
                this.response = tryResponse.parse();
            }
        } catch (IOException e) {
            throw new UrlErrorException();
        }
    }

    public String getTitle() {
        return response.title();
    }

    public Element getContent()  {
        return response.body();
    }
}