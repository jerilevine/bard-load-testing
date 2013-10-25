package bard;

import org.junit.Test;
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
    public void testMolSpreadsheet(){
        SearchPage searchPage = new SearchPage(this.driver);
        SearchResultsPage searchResultsPage = searchPage.search("protein methylation");

    }

}
