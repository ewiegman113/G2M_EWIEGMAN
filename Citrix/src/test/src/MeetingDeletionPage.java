import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MeetingDeletionPage, which defines the objects found on the
 * Delete Meeting page and additionally may include helper methods.
 */
public class MeetingDeletionPage {


    /**
     * The 'No, don't Delete the Meeting' button (essentially, 'Cancel').
     */
    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    WebElement DoNotDelete;

    /**
     * The default 'Delete' button.
     */
    @FindBy(xpath = "//div[@class='modal-footer']/button[2]")
    WebElement Delete;


    /**
     * Initializes the WebElements on the 'Delete Meeting' page.
     *
     * @param driver the Selenium WebDriver
     */
    MeetingDeletionPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


}
