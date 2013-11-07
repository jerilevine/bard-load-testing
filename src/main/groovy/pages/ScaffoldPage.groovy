package pages;

import bard.util.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 11:36 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class ScaffoldPage {
    final static String BASEURL = "https://bard-dev.broadinstitute.org/BARD";
    final static int DEFAULT_TIMEOUT_IN_SECONDS = 10;

    public WebElement waitForElement(WebDriver driver, Integer timeoutInSeconds, String cssSelector){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public WebElement waitForElement(WebDriver driver, String cssSelector){
        return waitForElement(driver, DEFAULT_TIMEOUT_IN_SECONDS, cssSelector);
    }

    public void waitForTextToChange(WebDriver driver, String cssSelector, String beforeText) throws InterruptedException {
        for(int i = 0; i < DEFAULT_TIMEOUT_IN_SECONDS; i++) {
            final WebElement afterElement = driver.findElement(By.cssSelector(cssSelector));
            final String afterText = afterElement.getText();
            if(!afterText.equals(beforeText)){
                break;
            }
            else if (i == DEFAULT_TIMEOUT_IN_SECONDS - 1){
                SeleniumUtils.takesScreenshot(driver);
                throw new RuntimeException("Cart text did not change in " + DEFAULT_TIMEOUT_IN_SECONDS + " seconds");
            }
            Thread.sleep(1000);
        }
    }

    public boolean waitForText(WebDriver driver, Integer timeoutInSeconds, String cssSelector, String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector(cssSelector), expectedText));
    }
}
