package bard;

import bard.util.MolSpreadsheetHelper;
import bard.util.SearchResultsTab;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import pages.MolSpreadsheetPage;
import pages.SearchPage;
import pages.SearchResultsPage;
import pages.ShowExperimentDetailsPage;

import java.util.List;

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

    @Test
    public void testShowExperimentalDetails() {
        String cid = "11057";
        ShowExperimentDetailsPage showExperimentDetailsPage = new ShowExperimentDetailsPage(getDriver(), cid);
    }

    @Test
    public void testMolSpreadsheetForCidsActiveInManyExperiments() throws Exception {

        final Binding binding = new Binding();
        binding.setVariable("Parameters", "");
        gse.run("MolSpreadsheetScript.groovy", binding);

    }
}
