package bard;

import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static bard.util.SeleniumUtils.FIREFOX;
import static bard.util.SeleniumUtils.PHANTOMJS;
import static bard.util.SeleniumUtils.getDriver;

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/25/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchPageTestCase {
    final private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return getDriver(PHANTOMJS);
        }
    };



    @Test
    public void testFoo() {
        final WebDriver driver = driverThreadLocal.get();

        // Load page
        driver.get("http://youruseragent.info/what-is-my-user-agent");
        // Read values from page
        String myUA = driver.findElement(By.cssSelector("#ua-string span")).getText();
        String myIP = driver.findElement(By.cssSelector("#ip-address span")).getText();

        assertTrue(StringUtils.isNotBlank(myUA));
        assertTrue(StringUtils.isNotBlank(myIP));
    }

    @Test
    public void testBar() throws Exception {
        final WebDriver driver = driverThreadLocal.get();
        driver.get("http://www.google.com");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(getDstDir(), driver.getTitle() + "_" + Thread.currentThread().getName() + ".png"));

        assertTrue(StringUtils.isNotBlank(driver.getTitle()));
    }

    @Test
    public void testBard() throws Exception {
        final WebDriver driver = driverThreadLocal.get();
        driver.get("https://bard-qa.broadinstitute.org/BARD");

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(getDstDir(), driver.getTitle() + "_" + Thread.currentThread().getName() + ".png"));

        assertEquals("BioAssay Research Database", driver.getTitle());
    }

//    public void oneTimeTearDown(){
//       quitWebDriver();
//    }

    public void quitWebDriver() {
        System.out.println("quitting webDriver");
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }

    private File getDstDir() {
        final File dstDir = new File("build/screenshots");
        dstDir.mkdirs();
        return dstDir;
    }
}
