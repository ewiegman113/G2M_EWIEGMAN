
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiaVideoAddPage {

    // ************************  CONSTANTS *********************** //

    /**
     * The constant NAME_OF_VID_INPUT_ELEMENT, used to ensure the page is
     * loaded.
     */
    public static final String NAME_OF_VID_INPUT_ELEMENT = "wpWikiaVideoAddUrl";


    // *************  WEBELEMENTS AND INITIALISATION ************* //

    /**
     * This is the input field where you type in the URL of the video to be
     * added. For instance: "http://www.youtube.com/watch?v=h9tRIZyTXTI"
     */
    @FindBy(id = NAME_OF_VID_INPUT_ELEMENT)
    WebElement nameOfVideoToAdd;

    /**
     * This is an input of type "submit" with value (text of) "Add". In other
     * words, the 'Add' button.
     */
    @FindBy(xpath = "//*[@class ='submits']/input")
    WebElement addButton;

    /**
     * Initializes the WebElements on the 'Wikia Add Video' page.
     *
     * @param driver the Selenium WebDriver
     */
    public WikiaVideoAddPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // ******************** WAIT METHODS  *********************** //

    /**
     * Wait for a specific input element.
     *
     * @param driver the driver
     */
    public void waitForAddVideoInputElement(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Const.HALF_MINUTE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id
                (NAME_OF_VID_INPUT_ELEMENT)));
    }
}
