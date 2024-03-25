package pl.PBur27.ceneoWebScraper.product;

import org.junit.jupiter.api.Test;


public class UrlTest {

    @Test
    void establishesWorkingConnection(){
        Url test = new Url("https://www.ceneo.pl/47885380#tab=reviews");
        try {
            test.checkConnection();
            assert true;
        }
        catch (Throwable e){
            assert false;
        }
    }

    @Test
    void detectsRedirect(){
        Url test = new Url("https://www.ceneo.pl/47885380/opinie-2");
        try {
            test.checkConnection();
            assert false;
        }
        catch (UrlRedirectException e){
            assert true;
        }
        catch (UrlErrorException e){
            assert false;
        }
    }

    @Test
    void detectsError(){
        Url test = new Url("https://www.cexneo.pl/47885380#tab=reviews");
        try {
            test.checkConnection();
            assert true;
        }
        catch (UrlRedirectException e){
            assert false;
        }
        catch (Throwable e){
            assert true;
        }
    }

}
