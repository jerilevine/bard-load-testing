package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class CompoundBioActivitySummaryPage extends ScaffoldPage {
    private final String URL;

    private final WebDriver driver;

    private final String title;

    public CompoundBioActivitySummaryPage(WebDriver driver, String cid) {
        this.URL = buildUrl(cid);

        this.driver = driver;
        driver.get(this.URL);

        this.title = driver.getTitle();

        if(!atCBASPage()){
            throw new IllegalStateException("Did not arrive at CBAS page");
        }
    }

    private String buildUrl(String cid) {
        StringBuilder sb = new StringBuilder(BASEURL);
        sb.append("/bardWebInterface/showCompoundBioActivitySummary/");
        sb.append(cid);
        return sb.toString();
    }

    public boolean atCBASPage() {
        return (title.contains("Compound Bio-Activity Summary"));
    }
}
