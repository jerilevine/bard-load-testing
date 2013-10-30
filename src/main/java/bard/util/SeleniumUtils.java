package bard.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

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
        } else {   // default to phantomJs
            driver = new PhantomJSDriver(getDesiredCapabilities(PHANTOMJS));
        }
        driver.manage().window().setSize(new Dimension(1024, 768));
        return driver;
    }

    public static DesiredCapabilities getDesiredCapabilities(String browserName) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("takesScreenshot", true);
        if (PHANTOMJS == browserName) {
            desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{
                    "--web-security=false",
                    "--ssl-protocol=any",
                    "--ignore-ssl-errors=true",
                    "--webdriver-loglevel=INFO"});
            desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getPhantomJsExecutablePath());
        }
        return desiredCapabilities;
    }

    public static String getPhantomJsExecutablePath() {
        if (StringUtils.isNotBlank(System.getProperty("PHANTOM_JS_EXECUTABLE_PATH"))) {
            return System.getProperty("PHANTOM_JS_EXECUTABLE_PATH");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            return "driver_executables/phantomjs-1.9.2-windows/phantomjs.exe";
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            return "driver_executables/phantomjs-1.9.2-macosx/bin/phantomjs";
        } else if (SystemUtils.IS_OS_LINUX) {
            return "driver_executables/phantomjs-1.9.2-linux-x86_64/bin/phantomjs";
        } else {
            throw new RuntimeException("Unsure of OS, so couldn't pick an executable for phantomjs");
        }
    }

    public static void takesScreenshot(WebDriver driver) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(getDstDir(), driver.getTitle() + "_" + Thread.currentThread().getName() + ".png"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static File getDstDir() {
        final File dstDir = new File("build/screenshots");
        dstDir.mkdirs();
        return dstDir;
    }
}
