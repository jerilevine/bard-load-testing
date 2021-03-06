package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: jlev
 * Date: 10/25/13
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class MolSpreadsheetPage extends ScaffoldPage {
    private static final String URL = BASEURL + "/molSpreadSheet/index";

    private final WebDriver driver;
    private final String title;

    public MolSpreadsheetPage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);

        this.title = driver.getTitle();
        // looking for the table header row
        // this is definitely long 3 * 60 seconds
        // but want to see if this returns even if very slow
        waitForElement(driver, 3 * 60, "table.molSpreadSheet");

        if (!atMolSpreadsheetPage()) {
            throw new IllegalStateException("Did not arrive at molecular spreadsheet");
        }
    }

    public boolean atMolSpreadsheetPage() {
        return (title.equals("BARD: Molecular Spreadsheet"));
    }

    public static String getUrl() {
        return URL;
    }
}
