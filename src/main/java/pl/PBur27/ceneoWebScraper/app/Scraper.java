package pl.PBur27.ceneoWebScraper.app;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.PBur27.ceneoWebScraper.product.Review;
import pl.PBur27.ceneoWebScraper.product.Url;
import pl.PBur27.ceneoWebScraper.product.UrlErrorException;
import pl.PBur27.ceneoWebScraper.product.UrlRedirectException;

import java.time.LocalDate;
import java.util.ArrayList;


public class Scraper {

    public static Url getNextUrl(Url oldUrl) throws NoMoreReviewPagesException {
        if (oldUrl.url.endsWith("#tab=reviews")){
            Url newUrl = new Url(oldUrl.url.replaceAll("#tab=reviews", "/opinie-2"));
            try {
                newUrl.checkConnection();
                return newUrl;
            } catch (UrlRedirectException e) {
                throw new NoMoreReviewPagesException();
            } catch (UrlErrorException e) {
                System.out.println("Error");
            }
        } else if (oldUrl.url.matches(".+opinie-\\d+")) {
            int newPageNumber = oldUrl.getPageNumber() + 1;
            Url newUrl = new Url(oldUrl.url.replaceAll("\\d+$", String.valueOf(newPageNumber)));
            try {
                newUrl.checkConnection();
                return newUrl;
            } catch (UrlRedirectException e) {
                throw new NoMoreReviewPagesException();
            } catch (UrlErrorException e) {
                System.out.println("Error");
            }
        }
        return oldUrl;
    }

    public static String getTitle(Url u) {
        return u.response.title();
    }

    public static ArrayList<Review> getReviews(Url u) {

        ArrayList<Review> reviews = new ArrayList<>();
        Elements reviewElements = u
                .response
                .select("#reviews > div > div.review-box-items-list.white.js_product-reviews.js_product-reviews-container > *");

        for (Element reviewElement : reviewElements) {

            reviews.add(new Review(reviewElement));

        }

        return reviews;

    }
    /*
    int opinionId;
    String author;
    boolean recommendation;
    int score;
    LocalDate publishDate;
    LocalDate purchaseDate;
    int thumbsUp;
    int thumbsDown;
    String content;
    ArrayList<String> pros;
    ArrayList<String> cons;
    */

    public static int getOpinionId(Element rE){
        return Integer.parseInt(rE.select("div.js_review.review-box-item").attr("data-entry-id"));
    }

    public static String getAuthor(Element rE){
        return rE.select("span.js_review-user-name").text();
    }

    public static boolean getRecommendation(Element rE){
        return rE.select("span.uppercase.green-text").text().equals("Polecam");
    }

    public static int getScore(Element rE){
        return rE.select("span.score__meter").text().charAt(0);
    }

    public static LocalDate getPublishDate(Element rE){
        return LocalDate.parse(rE.select("span.m-font-small > time").first().attr("datetime").split(" ",2)[0]);
    }

    public static LocalDate getPurchaseDate(Element rE){
        return LocalDate.parse(rE.select("span.m-font-small > time").last().attr("datetime").split(" ",2)[0]);
    }

}
