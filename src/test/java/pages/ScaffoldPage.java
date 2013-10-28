package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class ScaffoldPage {
    final static String BASEURL = "https://bard-qa.broadinstitute.org/BARD";
    final static int DEFAULT_TIMEOUT_IN_SECONDS = 10;

    public WebElement waitForCondition(WebDriver driver, Integer timeoutInSeconds, String cssSelector){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public WebElement waitForCondition(WebDriver driver, String cssSelector){
        return waitForCondition(driver, DEFAULT_TIMEOUT_IN_SECONDS, cssSelector);
    }
}
