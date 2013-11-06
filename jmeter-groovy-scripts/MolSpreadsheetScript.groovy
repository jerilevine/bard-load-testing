import bard.util.MolSpreadsheetHelper
import bard.util.SearchResultsTab
import static  bard.util.SeleniumUtils.*
import org.apache.commons.lang3.StringUtils
import pages.MolSpreadsheetPage
import pages.SearchPage
import pages.SearchResultsPage


println("Parameters : ${Parameters}" )
def parametersMap = Parameters?  evaluate(Parameters) : [:]

final MolSpreadsheetHelper molSpreadsheetHelper = new MolSpreadsheetHelper();

// 1. Perform search
final SearchPage searchPage = new SearchPage(getDriver());
List<Integer> cids = molSpreadsheetHelper.findCidsWithExperimentCount(parametersMap.experimentCount?:6);
cids = cids.subList(0,parametersMap.cidLimit?:5)
println("cids.size() : ${cids.size()}")
final String searchTerm =   "cid: " + StringUtils.join(cids, " ");
//println(searchTerm);
final SearchResultsPage searchResultsPage = searchPage.search(searchTerm);

// 2. Choose compounds
searchResultsPage.clickTab(SearchResultsTab.COMPOUNDS);
for(Integer cid : cids)           {
    searchResultsPage.addItemToCart(cid.toString());
}

// 4. Visualize molecular spreadsheet
MolSpreadsheetPage molSpreadsheetPage = new MolSpreadsheetPage(getDriver());