package bard;

import bard.util.SearchResultsTab;
import org.junit.Test;
import pages.MolSpreadsheetPage;
import pages.SearchPage;
import pages.SearchResultsPage;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MolSpreadsheetTestCase extends FunctionalTestCase {

    @Test
    public void testMolSpreadsheet() throws InterruptedException {
        // 1. Perform search
        SearchPage searchPage = new SearchPage(getDriver());
        SearchResultsPage searchResultsPage = searchPage.search("protein methylation");

        // 2. Choose assay definitions
        searchResultsPage.addItemToCart("4658");

        // 3. Choose compounds
        searchResultsPage.clickTab(SearchResultsTab.COMPOUNDS);
        searchResultsPage.addItemToCart("4055");

        // 4. Visualize molecular spreadsheet
        MolSpreadsheetPage molSpreadsheetPage = new MolSpreadsheetPage(getDriver());
    }
}
