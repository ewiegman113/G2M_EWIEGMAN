
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class "Videos on This Wikia Page".
 */
public class VideosOnThisWikiPage {

    // *************  WEBELEMENTS AND INITIALISATION ************* //

    /**
     * This is the link: File: The Best Classical Music In The World"
     */
    @FindBy(xpath = "//*[@class='msg']/a")
    WebElement linkToAddedVideo;


    /**
     * Initializes the WebElements on the 'Videos On This Wiki' page.
     *
     * @param driver the Selenium WebDriver
     */
    public VideosOnThisWikiPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}
