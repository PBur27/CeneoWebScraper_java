package pl.PBur27.ceneoWebScraper.app;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.PBur27.ceneoWebScraper.product.Review;
import pl.PBur27.ceneoWebScraper.product.Url;
import pl.PBur27.ceneoWebScraper.product.UrlErrorException;
import pl.PBur27.ceneoWebScraper.product.UrlRedirectException;

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

        for (int i = 0; i < reviewElements.size(); i++) {

            reviews.add(new Review(reviewElements.get(i)));

        }

        return reviews;

    }

    //public static int getOpinionId(Element reviewElement){
        //return reviewElement.select()
    //}


}
