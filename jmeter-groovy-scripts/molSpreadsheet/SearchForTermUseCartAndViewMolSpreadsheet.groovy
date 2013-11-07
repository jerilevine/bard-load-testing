import bard.util.SearchResultsTab
import pages.MolSpreadsheetPage
import pages.SearchPage
import pages.SearchResultsPage

import static  bard.util.SeleniumUtils.*

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 11/7/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */


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