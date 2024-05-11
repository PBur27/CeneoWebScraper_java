package pl.PBur27.ceneoWebScraper.product;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Url implements Serializable {

    public String url;
    public transient Document response;
    public Url(String text) {
        text = text.replaceAll("www.ceneo","m.ceneo");
        this.url = text;
    }


    public void checkConnection() throws UrlErrorException, UrlRedirectException {
        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NEVER).build();
        HttpRequest request = HttpRequest.newBuilder(URI.create(this.url)).GET().build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 301 || response.statusCode() == 302){
                throw new UrlRedirectException();
            }
            else {
                this.response = Jsoup.parse(response.body());
            }
        }
        catch (IOException | InterruptedException e) {
            throw new UrlErrorException();
        }
    }
    public int getPageNumber(){
        if (Character.isDigit(this.url.charAt(this.url.length()-3))){
            return Integer.parseInt(this.url.substring(this.url.length()-3));
        }
        else if (Character.isDigit(this.url.charAt(this.url.length()-2))){
            return Integer.parseInt(this.url.substring(this.url.length()-2));
        }
        else if (Character.isDigit(this.url.charAt(this.url.length()-1))){
            return Integer.parseInt(this.url.substring(this.url.length()-1));
        }
        return 0;
    }
}