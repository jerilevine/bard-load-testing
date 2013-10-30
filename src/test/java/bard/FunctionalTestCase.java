package bard;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static bard.util.SeleniumUtils.FIREFOX;
import static bard.util.SeleniumUtils.PHANTOMJS;
import static bard.util.SeleniumUtils.getDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
abstract public class FunctionalTestCase {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup(){
        driver = getDriver(System.getProperty("browser"));
    }

    @AfterClass
    public static void teardown() {
        if(driver != null) { driver.quit(); }
    }
}
