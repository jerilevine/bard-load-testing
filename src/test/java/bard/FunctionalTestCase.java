package bard;

import bard.util.SeleniumUtils;
import groovy.util.GroovyScriptEngine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import static bard.util.SeleniumUtils.getDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class FunctionalTestCase {

    private static final String[] GSE_ROOTS = new String[]{"jmeter-groovy-scripts", "jmeter-groovy-scripts/molSpreadsheet"};
    protected static GroovyScriptEngine gse = null;

    @BeforeClass
    public static void setup() throws Exception{
        SeleniumUtils.getDriver();
        gse = new GroovyScriptEngine(GSE_ROOTS);
    }

    @AfterClass
    public static void teardown() {
        SeleniumUtils.quitDrivers();
    }

    public static WebDriver getDriver() {
        return SeleniumUtils.getDriver();
    }

    public static WebDriver getDriver(String browser) {
        return SeleniumUtils.getDriver(browser);
    }
}
