import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;


/**
 * The Class SharedLoginPage, which defines the objects found on the Login page
 * for GoToMeeting and for GoToWebinar. Additionally, it may include helper
 * methods.
 */
public class SharedLoginPage {

    /**
     * The Constant ABOUT_US.
     */
    public static final int ABOUT_US = 1;

    // All WebElements are identified by @FindBy annotation, where possible.
    /**
     * The Constant TERMS_OF_SERVICE.
     */
    public static final int TERMS_OF_SERVICE = 2;
    /**
     * The Constant PRIVACY_POLICY.
     */
    public static final int PRIVACY_POLICY = 3;
    /**
     * The Constant SUPPORT.
     */
    public static final int SUPPORT = 4;
    /**
     * The logger.
     */
    private static Logger theLogger =
            Logger.getLogger(SharedLoginPage.class.getName());
    /**
     * The email address.
     */
    @FindBy(id = "emailAddress")
    WebElement emailAddress;

    /**
     * The password.
     */
    @FindBy(id = "password")
    WebElement password;

    /**
     * The 'Sign In' button.
     */
    @FindBy(id = "submit")
    WebElement signIn;

    /**
     * The 'Remember Me' Check Box.
     */
    @FindBy(id = "rememberMeCheckbox")
    WebElement rememberMe;

    /**
     * The 'I forgot my password'  link.
     */
    @FindBy(id = "forgotPassword")
    WebElement forgotPassword;

    /**
     * The 'Use My Company ID' link.
     */
    @FindBy(className = "teamIDLink")
    WebElement useMyCompanyID;

    /**
     * The 'Go to Help Page' link.
     */
    @FindBy(className = "fa-question-circle")
    WebElement goToHelpLink;

    /**
     * The 'About Us' footer link.
     */
    @FindBy(xpath = "//div[@id='footer']/a[ABOUT_US]")
    WebElement aboutUsLink;

    /**
     * The 'Terms of Service' footer link.
     */
    @FindBy(xpath = "//div[@id='footer']/a[TERMS_OF_SERVICE]")
    WebElement termsOfServiceLink;

    /**
     * The 'Privacy Policy' footer link.
     */
    @FindBy(xpath = "//div[@id='footer']/a[PRIVACY_POLICY]")
    WebElement privacyPolicyLink;

    /**
     * The '24x7 Support' footer link.
     */
    @FindBy(xpath = "//div[@id='footer']/a[SUPPORT]")
    WebElement support24_7Link;

    /**
     * Login, with option to 'remember me' accommodated.
     *
     * @param userName   the username (in this case, email)
     * @param passcode   the password
     * @param rememberMe the remember me
     */
    void login(String userName, String passcode, boolean rememberMe) {
        emailAddress.sendKeys(userName);
        password.sendKeys(passcode);
        if (rememberMe) {
            this.rememberMe.click();
        }
        signIn.click();
    }

}