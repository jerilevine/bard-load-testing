package bard;

import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
    @Test
    public void testFoo() {
        WebDriver driver = getDriver(PHANTOMJS);
        // Load page
        driver.get("http://youruseragent.info/what-is-my-user-agent");
        // Read values from page
        String myUA = driver.findElement(By.cssSelector("#ua-string span")).getText();
        String myIP = driver.findElement(By.cssSelector("#ip-address span")).getText();

        assertTrue(StringUtils.isNotBlank(myUA));
        assertTrue(StringUtils.isNotBlank(myIP));
        driver.quit();
    }

    @Test
    public void testBar() throws Exception {
        WebDriver driver = getDriver(PHANTOMJS);
        driver.get("http://www.google.com");

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(getDstDir(), "${driver.getTitle()}.png"));

        assertTrue(StringUtils.isNotBlank(driver.getTitle()));
        driver.quit();

    }

    @Test
    public void testBard() throws Exception {
        WebDriver driver = getDriver(FIREFOX);
        driver.get("http://bard-qa.broadinstitute.org");

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(getDstDir(), "${driver.getTitle()}.png"));

        assertTrue(StringUtils.isNotBlank(driver.getTitle()));
        driver.quit();
    }

    private File getDstDir() {
        final File dstDir = new File("build/screenshots");
        dstDir.mkdirs();
        return dstDir;
    }
}
