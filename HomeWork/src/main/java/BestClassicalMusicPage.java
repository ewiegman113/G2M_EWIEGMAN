
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class for the special "Best Classical Music" page.
 */
public class BestClassicalMusicPage {

    // *************  WEBELEMENTS AND INITIALISATION ************* //

    /**
     * This is the header: The Best Classical Music In The World"
     */
    @FindBy(xpath = "//div[@class='header-column header-title']/h1")
    WebElement bestMusicHeader;

    /**
     * This is the link that identifies the video provider ("Youtube")
     */
    @FindBy(xpath = "//p[@class='video-provider']/a")
    WebElement videoProvider;

    /**
     * Initializes the WebElements on the 'Best Classical Music Page'.
     *
     * @param driver the Selenium WebDriver
     */
    public BestClassicalMusicPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}
