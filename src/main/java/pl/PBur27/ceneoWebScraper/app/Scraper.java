package pl.PBur27.ceneoWebScraper.app;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import pl.PBur27.ceneoWebScraper.product.*;

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

    public static ArrayList<Page> getPages(Url u){
        ArrayList<Page> pagesArrayList= new ArrayList<>();
        pagesArrayList.add(new Page(u));

        boolean morePagesAvailable = true;
        Url nextPageUrl = u;

        while (morePagesAvailable){
            try {
                nextPageUrl = Scraper.getNextUrl(nextPageUrl);
                pagesArrayList.add(new Page(nextPageUrl));

            } catch (NoMoreReviewPagesException e) {
                return pagesArrayList;
            }
        }

        return pagesArrayList;
    }

    public static ArrayList<Review> getReviews(Url u) {

        ArrayList<Review> reviews = new ArrayList<>();
        Elements reviewElements = u
                .response
                .select("div.review-box-items-list > *");

        for (Element reviewElement : reviewElements) {

            reviews.add(new Review(reviewElement));

        }

        return reviews;

    }


    public static int getOpinionId(Element rE){
        return Integer.parseInt(rE.select("div.js_review.review-box-item").attr("data-entry-id"));
    }

    public static String getAuthor(Element rE){
        return rE.selectFirst("span.js_review-user-name").text();
    }

    public static boolean getRecommendation(Element rE){
        return rE.select("span.uppercase.green-text").text().equals("Polecam");
    }

    public static int getScore(Element rE){
        return Character.getNumericValue(rE.select("span.score__meter").text().charAt(0));
    }

    public static LocalDate getPublishDate(Element rE){
        return LocalDate.parse(rE.select("span.m-font-small > time").first().attr("datetime").split(" ",2)[0]);
    }

    public static LocalDate getPurchaseDate(Element rE){
        return LocalDate.parse(rE.select("span.m-font-small > time").last().attr("datetime").split(" ",2)[0]);
    }

    public static int getThumbsUp(Element rE){
        return Integer.parseInt(rE.select("button.vote-yes > span").text());
    }

    public static int getThumbsDown(Element rE){
        return Integer.parseInt(rE.select("button.vote-no > span").text());
    }

    public static String getContent(Element rE){
        return rE.select("div.review-box-text").text().replaceAll("(...) więcej", "");
    }

    public static ArrayList<String> getPros(Element rE) {
        ArrayList<String> pros = new ArrayList<>();
        Element prosDiv;
        try {
            prosDiv = rE.selectFirst("div.product-pros-cons:has(div:containsOwn(ZALETY))");
            Elements prosElements = prosDiv.select("ul > *");
            for (Element pro : prosElements) {
                pros.add(pro.text());
            }
            return pros;
        }
        catch (java.lang.NullPointerException e) {
            return pros;
        }

    }

    public static ArrayList<String> getCons(Element rE) {
        ArrayList<String> cons = new ArrayList<>();
        Element consDiv;
        try {
            consDiv = rE.selectFirst("div.product-pros-cons:has(div:containsOwn(WADY))");
            Elements consElements = consDiv.select("ul > *");
            for (Element pro : consElements) {
                cons.add(pro.text());
            }
            return cons;
        }
        catch (java.lang.NullPointerException e) {
            return cons;
        }

    }
}
