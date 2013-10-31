package bard;

import bard.util.SeleniumUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SearchPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ddurkin
 * Date: 10/25/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchPageTestCase extends FunctionalTestCase {

    @Test
    public void testLoadingHomePage() throws Exception {

        SearchPage searchPage = new SearchPage(getDriver());

        assertTrue(searchPage.atSearchPage());
    }


}
