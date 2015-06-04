import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * The Class AutomationChallengeTest.
 */
public class InterviewHomeworkTests {

    // ******************** INITIALISATION *********************** //

    // initializing the utility methods
    Utilities utils = new Utilities();

    /**
     * The Selenium WebDriver, used to give a handle to current browser.
     */
    WebDriver driver = utils.setDriver();

    // initializing the pages used in this set of tests
    WikiaHomePage wikiaHomePage = new WikiaHomePage(driver);
    WikiaVideoAddPage wikiaVideoAddPage = new WikiaVideoAddPage(driver);
    VideosOnThisWikiPage videosOnThisWikiPage = new
         VideosOnThisWikiPage (driver);
    BestClassicalMusicPage bestClassicalMusicPage = new
        BestClassicalMusicPage(driver);

    /**
     * Setup routine, run before the Test. <BR>
     * It launches the browser with the starting URL.
     */
    @BeforeTest()
    public void setup() {
        driver.get(Const.TEMPLATE__URL);
    }

    // ******************** TESTCASE SCENARIOS *********************** //

    /**
     * Verify login has occurred and the Avatar has changed from anonymous to
     * your avatar.
     *
     * @param rememberMe
     *  the 'Remember me' checkbox is checked, if set to true ... else, it
     *  remains unchecked
     *
     * @throws IOException
     *  Exception thrown if config.properties (defining login credentials, etc.)
     *  is not in classpath
     */
    @Test(
            dataProvider = "HomeWork_LoginData",
            dataProviderClass = WikiaDataProviderPage.class
    )
    public void testWikiaLogin(
            boolean rememberMe
    ) throws IOException {

        String user = commonLogin(rememberMe);

        wikiaHomePage.waitForUserAvatar(driver);

        String avatarTitle = wikiaHomePage.usernameText.getAttribute("title");
        Assert.assertEquals(
                avatarTitle,
                user + " - My page",
                "User isn't logged in - 'Log in' label displays instead of username.");
    }

    /**
     * Verify login has occurred and the Avatar has changed from anonymous to
     * your avatar.
     *
     * @param rememberMe
     *  the 'Remember me' checkbox is checked, if set to true ... else, it
     *  remains unchecked
     *
     * @param videoURL
     *  the text to type in the input field to specify the video to download and
     *  put on the wiki page
     *
     * @param videoTitle
     *  the title associated with the downloaded video
     *
     * @throws IOException
     *  Exception thrown if config.properties (defining login credentials, etc.)
     *  is not in classpath
     */
    @Test(
            dataProvider = "HomeWork_VideoAddedData",
            dataProviderClass = WikiaDataProviderPage.class
    )
    public void testWikiaVideoAdd(
            boolean rememberMe,
            String videoURL,
            String videoTitle
    ) throws IOException {

        commonLogin(rememberMe);

        wikiaHomePage.waitForUserAvatar(driver);
        wikiaHomePage.contributeButton.click();
        wikiaHomePage.addVideoMenuItem.click();

        wikiaVideoAddPage.waitForAddVideoInputElement(driver);
        wikiaVideoAddPage.nameOfVideoToAdd.sendKeys(videoURL);
        wikiaVideoAddPage.addButton.click();

        videosOnThisWikiPage.linkToAddedVideo.click();

        Assert.assertEquals(
                bestClassicalMusicPage.bestMusicHeader.getText(),
                videoTitle,
                "The Header text on the page doesn't match the Video's Title."
        );


    }


    // ************** Reusable code  ************** //


    private String commonLogin (boolean rememberMe) throws IOException {
        String propFileName = Const.PROPERTY_FILE;
        Properties prop = utils.getPropertiesFromClasspath(propFileName);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        // Loading of advertising, etc seems to pull the focus from the login
        // pop-up, so this code keeps trying many times to ensure a stable
        // pop-up is achieved.

        int tries = 0;

        while (tries < 4) {
            try {
                wikiaHomePage.invokeLoginPage(driver);

                wikiaHomePage.login(
                        username,
                        password,
                        rememberMe
                );
                break;
            } catch (ElementNotVisibleException enve) {
                //enve.printStackTrace();
            }

            tries++;
        }

        return username;

    }
}
