package bard

import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import spock.lang.Specification

import static bard.util.SeleniumUtils.*

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/23/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
class SearchPageSpec extends Specification {

    void "test foo"() {
        given:
        WebDriver driver = getDriver(PHANTOMJS);

        when:
        // Load page
        driver.get("http://youruseragent.info/what-is-my-user-agent");
        // Read values from page
        String myUA = driver.findElement(By.cssSelector("#ua-string span")).getText();
        String myIP = driver.findElement(By.cssSelector("#ip-address span")).getText();

        // Print
        println("My User-Agent: " + myUA);
        println("My IP: " + myIP);

        then:
        myUA
        myIP

        driver.quit()
    }

    void "test bar"() {
        given:
        WebDriver driver = getDriver(PHANTOMJS);

        when:
        // Load page
        driver.get("http://www.google.com");
        // Read values from page
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
        FileUtils.copyFile(file, new File(getDstDir(), "${driver.getTitle()}.png"))

        then:
        driver.getTitle()
        driver.quit()

    }

    void "test bard"() {
        given:
        WebDriver driver = getDriver(FIREFOX);

        when:
        // Load page
        driver.get("http://bard-qa.broadinstitute.org");
        // Read values from page
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE)
        FileUtils.copyFile(srcFile, new File(getDstDir(), "${driver.getTitle()}.png"))

        then:
        driver.getTitle()
        driver.quit()
    }

    private File getDstDir() {
        final File dstDir = new File("build/screenshots");
        dstDir.mkdirs();
        return dstDir;
    }
}
