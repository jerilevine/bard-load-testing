package bard.util;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/25/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumUtils {

    public static final String FIREFOX = "firefox";
    public static final String PHANTOMJS = "phantomjs";

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        if (FIREFOX.equals(browserName)) {

            driver = new FirefoxDriver(getDesiredCapabilities(browserName));
        } else if (PHANTOMJS.equals(browserName)) {

            driver = new PhantomJSDriver(getDesiredCapabilities(browserName));
        } else {
            throw new RuntimeException("need driver name");
        }
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

    public static DesiredCapabilities getDesiredCapabilities(String browserName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("takesScreenshot", true);
        if (PHANTOMJS == browserName) {
            desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
                    "--web-security=false",
                    "--ssl-protocol=any",
                    "--ignore-ssl-errors=true",
                    "--webdriver-loglevel=INFO"  });
            desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getPhantomJsExecutablePath());
        }
        return desiredCapabilities;
    }

    public static String getPhantomJsExecutablePath() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return "driver_executables/phantomjs-1.9.2-windows/phantomjs.exe";
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            return "driver_executables/phantomjs-1.9.2-macosx/bin/phantomjs";
        } else if (SystemUtils.IS_OS_LINUX) {
            return "driver_executables/phantomjs-1.9.2-linux-x86_64/bin/phantomjs";
        }
        else {
            throw new RuntimeException("Unsure of OS, so couldn't pick an executable for phantomjs");
        }
    }
}
