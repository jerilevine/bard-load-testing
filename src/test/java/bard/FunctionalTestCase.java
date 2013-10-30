package bard;

import bard.util.SeleniumUtils;
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
public class FunctionalTestCase {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return SeleniumUtils.getDriver(System.getProperty("browser"));
        }
    };

    @BeforeClass
    public static void setup() {
        driverThreadLocal.get();
    }

    @AfterClass
    public static void teardown() {
        final WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
        }
        driverThreadLocal.remove();
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
