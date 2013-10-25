package bard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import pages.SearchResultsPage;

import static bard.util.SeleniumUtils.FIREFOX;
import static bard.util.SeleniumUtils.PHANTOMJS;
import static bard.util.SeleniumUtils.getDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MolSpreadsheetTestCase {
    private static WebDriver driver = getDriver(FIREFOX);

    @Test
    public void testMolSpreadsheet(){
        SearchPage searchPage = new SearchPage(this.driver);
        SearchResultsPage searchResultsPage = searchPage.search("protein methylation");

    }

    @After
    public void teardown() {
        if(this.driver != null) { driver.quit(); }
    }
}
