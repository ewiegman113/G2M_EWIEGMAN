import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MeetingLoginPage, which defines the objects found on the
 * Login page and additionally may include helper methods.
 */
public class MeetingLoginPage extends SharedLoginPage {

    /**
     * The 'Learn about Go To Meeting and start free trial' link.
     */
    @FindBy(id = "freeTrial")
    WebElement learnAboutGoToMeetingAndStartFreeTrial;

    /**
     * Initializes the WebElements on the 'Login' page.
     *
     * @param driver the Selenium WebDriver
     */
    MeetingLoginPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}