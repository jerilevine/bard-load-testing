package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchResultsPage extends ScaffoldPage {
    private static final String URL = BASEURL + "/bardWebInterface/searchResults";

    private final WebDriver driver;
    private final String title;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.title = driver.getTitle();

        if(!atSearchResultsPage()){
            throw new IllegalStateException("Did not arrive at search results page");
        }
    }

    public boolean atSearchResultsPage() {
        return (title.equals("BARD: Search"));
    }

    public static String getUrl() {
        return URL;
    }
}
