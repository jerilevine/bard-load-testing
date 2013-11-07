package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedHierarchyVisualizationPage extends ScaffoldPage {
    private final String URL;

    private final WebDriver driver;

    private final String title;

    public LinkedHierarchyVisualizationPage(WebDriver driver, String cid) {
        this.URL = buildUrl(cid);

        this.driver = driver;
        driver.get(this.URL);

        this.title = driver.getTitle();

        if(!atLHVPage()){
            throw new IllegalStateException("Did not arrive at Linked Hierarchy Visualization page");
        }
    }

    private String buildUrl(String cid) {
        StringBuilder sb = new StringBuilder(BASEURL);
        sb.append("/bardWebInterface/bigSunburst/");
        sb.append(cid);
        return sb.toString();
    }

    public boolean atLHVPage() {
        return (title.contains("Linked Hierarchy Visualization"));
    }
}
