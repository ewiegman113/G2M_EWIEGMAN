import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The Class for the "Wikia Home Page".
 */
public class WikiaHomePage {

  // ************************  CONSTANTS *********************** //

  /**
   * The Constant LOGIN_ELEMENT_STRING, used to recognize and to wait for the
   * non-logged in (anonymous) avatar.
   */
  public static final String LOGIN_ELEMENT_STRING =
          "account-navigation-first-item";

  /**
   * The Constant USERNAME_TITLE_ELEMENT_STRING, used to recognize and to wait
   * for the item associated with the Title that identifies the avatar as
   * belonging to the username.
   */
  public static final String USERNAME_TITLE_ELEMENT_STRING =
          "//*[@class='account-navigation-first-item']/div/a";


  // *************  WEBELEMENTS AND INITIALISATION ************* //

  /**
   * This is the not-logged-in avatar, which when clicked pops up the login
   * 'page'
   */
  @FindBy(className = LOGIN_ELEMENT_STRING)
  WebElement nonLoggedInAvatar;

  /**
   * The username
   */
  @FindBy(id = "usernameInput")
  WebElement username;

  /**
   * The password
   */
  @FindBy(id = "passwordInput")
  WebElement password;

  /**
   * The 'Remember Me' Check Box.
   */
  @FindBy(name = "keeploggedin")
  WebElement rememberMe;

  /**
   * This is the header: The Best Classical Music In The World"
   */
  @FindBy(className = "forgot-password")
  WebElement forgotPasswordLink;

  /**
   * This is the login 'button'
   */
  @FindBy(className = "login-button" )
  WebElement loginButton;

  /**
   * This is the logged-in avatar, which when clicked pops up a menu of items
   */
  @FindBy(className = "logged-avatar-placeholder")
  WebElement loggedInAvatar;

  /**
   * usernameText.getAttribute("title") will yield the String "{username} -
   * My page" -- where {username} is substituted with the username login
   * credential.
   */
  @FindBy(xpath = USERNAME_TITLE_ELEMENT_STRING)
  WebElement usernameText;

  /**
   * This is the control that, when clicked, brings up an applicable 'menu'
   */
  @FindBy(className = "contribute")
  WebElement contributeButton;

  /**
   * This is the menu item "Add a Video"
   */
  @FindBy(xpath = "//*[@id=\"WikiHeader\"]/div[1]/nav/ul/li[2]/a")
  WebElement addVideoMenuItem;

  /**
   * This is another reference to the menu item "Add a Video". It is <b>not</b>
   * language independent, but might be more robust than the above try.
   */
  @FindBy(xpath = "//a[.='Add a Video']")
  WebElement addVideoMenuItem2;

  /**
   * Initializes the WebElements on the 'Wikia Home' page.
   *
   * @param driver the Selenium WebDriver
   */
  public WikiaHomePage(WebDriver driver) {
    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
  }

  // ******************** WAIT METHODS  *********************** //

  /**
   * Wait for the (non-anonymous) user avatar to exist and be visible.
   *
   * @param driver the driver
     */
  public void waitForUserAvatar (WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Const.HALF_MINUTE);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
            (USERNAME_TITLE_ELEMENT_STRING)));
  }

  /**
   * Wait for the login page to pop up (that is, to exist and be visible).
   *
   * @param driver the driver
     */
  public void invokeLoginPage(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, Const.HALF_MINUTE);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className
            (LOGIN_ELEMENT_STRING)));
    nonLoggedInAvatar.click();
  }

  // ******************** REUSABLE METHODS *********************** //

  /**
   * Login, with option to 'remember me' accommodated.
   *
   * @param userName   the username (in this case, email)
   * @param passcode   the password
   * @param rememberMe the remember me
   */
  public void login(String userName, String passcode, boolean rememberMe) {

    username.sendKeys(userName);
    password.sendKeys(passcode);
    if (rememberMe) {
      this.rememberMe.click();
    }
    loginButton.click();
  }
}

