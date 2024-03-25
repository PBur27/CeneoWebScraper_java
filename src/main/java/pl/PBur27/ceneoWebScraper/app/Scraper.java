package pl.PBur27.ceneoWebScraper.app;


import org.jsoup.nodes.Element;
import pl.PBur27.ceneoWebScraper.product.Url;
import pl.PBur27.ceneoWebScraper.product.UrlErrorException;
import pl.PBur27.ceneoWebScraper.product.UrlRedirectException;


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

    public static Element getContent(Url u) {
        return u.response.body();
    }
}
