package bard;

import org.junit.Test;
import pages.CompoundBioActivitySummaryPage;
import pages.LinkedHierarchyVisualizationPage;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedHierarchyVisualizationTestCase extends FunctionalTestCase {
    @Test
    public void testLinkedHierarchyVisualization(){
        LinkedHierarchyVisualizationPage linkedHierarchyVisualizationPage = new LinkedHierarchyVisualizationPage(this.driver, "5924");
    }
}
