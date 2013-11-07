package bard

import org.openqa.selenium.WebDriver
import spock.lang.Specification

import bard.util.SeleniumUtils
import bard.util.SeleniumUtils

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 11/7/13
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
abstract class FunctionalUnitSpec extends Specification {

    private static final String[] GSE_ROOTS = ["jmeter-groovy-scripts", "jmeter-groovy-scripts/molSpreadsheet"]

    protected static GroovyScriptEngine gse


    void setupSpec() throws Exception {
        getDriver();
        gse = new GroovyScriptEngine(GSE_ROOTS);
    }


    void cleanupSpec() {
//        SeleniumUtils.quitDrivers();
    }

    public WebDriver getDriver() {
        SeleniumUtils.getDriver()
    }

    public WebDriver getDriver(String browser) {
        SeleniumUtils.getDriver(browser)
    }
}
