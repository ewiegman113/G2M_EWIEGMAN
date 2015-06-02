import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MeetingLoginPage, which defines the objects found on the
 * Login page and additionally may include helper methods.
 */
public class WebinarLoginPage extends SharedLoginPage {

    /**
     * The 'Learn about Go To Webinar and start free trial' link.
     */
    @FindBy(id = "freeTrial")
    WebElement learnAboutGoToWebinarAndStartFreeTrial;

    /**
     * Initializes the WebElements on the 'Login' page.
     *
     * @param driver the Selenium WebDriver
     */
    WebinarLoginPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}