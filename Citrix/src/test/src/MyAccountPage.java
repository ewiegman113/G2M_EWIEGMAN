import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MyAccountPage, which defines the objects found on the Accounts page and
 * additionally may include helper methods.
 */
public class MyAccountPage {

    /**
     * The 'Add alternate email' link.
     */
    @FindBy(xpath = "//*[@id='password-recovery-email-banner']/div/p/a")
    WebElement addAlternateEmailLink;

    /**
     * The 'Subscribe after trial' link.
     */
    @FindBy(xpath = "//*[@id='renewLink_GoToMeeting']/div/span")
    WebElement subscribeAfterTrial;

    /**
     * The link to navigate to 'Go To Meetings' page.
     */
    @FindBy(id = "homePageLink_GoToMeeting")
    WebElement navToGoToMeetings;

    /**
     * The link to navigate to the 'Administrative Center' page.
     */
    @FindBy(id = "adminLink_GoToMeeting")
    WebElement navToAdminCenter;

    /**
     * TThe link to navigate to the 'Cloud Workspace Support' page.
     */
    @FindBy(id = "supportLink_CWC")
    WebElement navToCloudWorkspaceSupport;

    /**
     * The 'change login info' link.
     */
    @FindBy(id = "//*[@id='changeLoginLink']/div/span")
    WebElement changeLoginInfo;

    /**
     * The 'change personal info' link.
     */
    @FindBy(id = "//*[@id='changePersonInfoLink']/div/span")
    WebElement changePersonalInfo;


    /**
     * Initializes the WebElements on the 'My Account' page.
     *
     * @param driver the Selenium WebDriver
     */
    MyAccountPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to go to meeting page.
     */
    private void navigateToGoToMeetingPage() {
        navToGoToMeetings.click();
    }

}
