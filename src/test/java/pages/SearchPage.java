package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchPage extends ScaffoldPage {
    private static final String URL = BASEURL + "/bardWebInterface/index";

    private final WebDriver driver;

    private final String title;

    private final WebElement searchBox;
    private final WebElement searchButton;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);

        this.title = driver.getTitle();
        this.searchBox = driver.findElement(By.id("searchString"));
        this.searchButton = driver.findElement(By.id("searchButton"));

        if(!atSearchPage()){
            throw new IllegalStateException("Did not arrive at search page");
        }

    }

    public SearchResultsPage search(String searchString){
        searchBox.sendKeys(searchString);
        searchButton.click();

        return new SearchResultsPage(driver);
    }

    public boolean atSearchPage() {
        return (title.equals("BioAssay Research Database") && searchBox.isDisplayed());
    }

    public static String getUrl() {
        return URL;
    }
}
