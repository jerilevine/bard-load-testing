package bard;

import org.junit.Test;
import pages.CompoundBioActivitySummaryPage;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompoundBioActivitySummaryTestCase extends FunctionalTestCase {
    @Test
    public void testCompoundBioActivitySummary(){
        CompoundBioActivitySummaryPage compoundBioActivitySummaryPage = new CompoundBioActivitySummaryPage(getDriver(), "2259");
    }
}
