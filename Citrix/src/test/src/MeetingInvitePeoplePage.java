import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MeetingInvitePeoplePage, which defines the objects found on the
 * Invite People page and additionally may include helper methods.
 */
public class MeetingInvitePeoplePage {

    /**
     * The 'Skip' button (essentially, a Cancel button).
     */
    @FindBy(className = "btn btn-link skip")
    WebElement skipButton;

    /**
     * The 'Copy' button.
     */
    @FindBy(id = "global-zeroclipboard-html-bridge")
    WebElement copyButton;


    /**
     * Initializes the WebElements on the 'Invite People' page.
     *
     * @param driver the Selenium WebDriver
     */
    MeetingInvitePeoplePage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}
