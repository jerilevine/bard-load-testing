package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowExperimentDetailsPage extends ScaffoldPage {
    private final String URL;

    private final WebDriver driver;

    private final String title;

    public ShowExperimentDetailsPage(WebDriver driver, String cid) {
        this.URL = buildUrl(cid);

        this.driver = driver;
        driver.get(this.URL);

        this.title = driver.getTitle();

        if(!atShowExperimentDetailsPage()){
            throw new IllegalStateException("Did not arrive at Experiment Details page");
        }
    }

    private String buildUrl(String cid) {
        StringBuilder sb = new StringBuilder(BASEURL);
        sb.append("/molSpreadSheet/showExperimentDetails?cid=");
        sb.append(cid);
        sb.append("&transpose=true");
        return sb.toString();
    }

    public boolean atShowExperimentDetailsPage() {
        return (title.contains("Molecular Spreadsheet"));
    }
}
