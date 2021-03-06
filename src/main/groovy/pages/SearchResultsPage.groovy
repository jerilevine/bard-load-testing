package pages;

import bard.util.SearchResultsTab;
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

    public SearchResultsPage clearQueryCart() {
        final WebElement queryCart = driver.findElement(By.cssSelector("span.cartContents"));
        queryCart.click();

        final WebElement clearAllButton = waitForElement(driver, "a.removeAllFromCart.btn");
        clearAllButton.click();

        waitForText(driver, DEFAULT_TIMEOUT_IN_SECONDS, "span.cartContents", "Empty");

        return this;
    }

    public SearchResultsPage addAllToCart(SearchResultsTab tabName) throws InterruptedException {
        // Check the cart before starting
        final WebElement beforeCartLabel = driver.findElement(By.cssSelector("span.cartContents"));
        final String beforeCartText = beforeCartLabel.getText();

        clickTab(tabName);

        final WebElement addAllButton = driver.findElement(By.id("addAllItemsToCart"));
        addAllButton.click();

        // Check the cart to make sure the items made it over
        waitForTextToChange(driver, "span.cartContents", beforeCartText);

        return this;
    }

    public SearchResultsPage addItemToCart(String id) throws InterruptedException {
        // Check the cart before starting
        final WebElement beforeCartLabel = driver.findElement(By.cssSelector("span.cartContents"));
        final String beforeCartText = beforeCartLabel.getText();

        // Add item to cart
        final WebElement item = waitForElement(driver,"input[data-cart-id=\"" + id + "\"]");
        item.click();

        // Check the cart to make sure the item made it over
        waitForTextToChange(driver, "span.cartContents", beforeCartText);

        return this;
    }

    public SearchResultsPage clickTab(SearchResultsTab tabName){
        final WebElement tab = driver.findElement(By.id(tabName.getTabName() + "Tab"));
        tab.click();

        return this;
    }

    public boolean atSearchResultsPage() {
        return (title.equals("BARD: Search"));
    }

    public static String getUrl() {
        return URL;
    }
}
