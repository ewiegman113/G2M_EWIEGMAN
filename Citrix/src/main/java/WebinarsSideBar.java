import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebinarsSideBar {

    /**
     * The Constant MY_WEBINARS.
     */
    private static final int MY_WEBINARS = 1;

    /**
     * The Constant REPORTS.
     */
    private static final int REPORTS = 2;

    /**
     * The Constant HISTORY.
     */
    private static final int HISTORY = 3;

    /**
     * The Constant MY_RECORDINGS.
     */
    private static final int MY_RECORDINGS = 4;

    /**
     * The Constant SCHEDULE_WEBINAR.
     */
    private static final int SCHEDULE_WEBINAR = 5;

    /**
     * The Constant SETTINGS.
     */
    private static final int SETTINGS = 6;

    /**
     * The 'my webinars' link.
     */
    @FindBy(xpath = "//ul[@class='sidebar-nav']/li[" + MY_WEBINARS + "]")
    WebElement myWebinarsLink;

    /**
     * The 'schedule webinar' link.
     */
    @FindBy(xpath = "//ul[@class='sidebar-nav']/li[" + SCHEDULE_WEBINAR + "]")
    WebElement scheduleWebinarLink;

    /**
     * The 'schedule webinar' button.
     */
    @FindBy(id = "scheduleWebinar")
    WebElement scheduleWebinarButton;

    /**
     * The 'my recordings' link.
     */
    @FindBy(xpath = "//ul[@class='sidebar-nav']/li[" + MY_RECORDINGS + "]")
    WebElement myRecordings;

    /**
     * The 'webinars history' link.
     */
    @FindBy(xpath = "//ul[@class='sidebar-nav']/li[" + HISTORY + "]")
    WebElement webinarsHistory;

    /**
     * The 'generate reports' link.
     */
    @FindBy(xpath = "//ul[@class='sidebar-nav']/li[" + REPORTS + "]")
    WebElement generateReports;

    /**
     * The 'settings' link.
     */
    @FindBy(xpath = "//ul[@class='sidebar-nav']/li[" + SETTINGS + "]")
    WebElement settings;

    /**
     * Initializes the WebElements on the common Webinars side-bar 'page'.
     *
     * @param driver the Selenium WebDriver
     */
    WebinarsSideBar(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
}
