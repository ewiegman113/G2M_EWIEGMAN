import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MyWebinarsPage, which defines the objects found on the
 * My Webinars page and additionally may include helper methods.
 */
public class MyWebinarsPage {

    /**
     * The Constant XPATH_PREFIX_WEBINAR_SUMMARY.
     */
    private static final String XPATH_PREFIX_WEBINAR_SUMMARY =
            "//span[contains(text(),'";
    /**
     * The Constant XPATH_SUFFIX_WEBINAR_SUMMARY.
     */
    private static final String XPATH_SUFFIX_WEBINAR_SUMMARY =
            "')]/../../../../ul/";
    /**
     * The 'schedule webinar' button.
     */
    @FindBy(id = "scheduleWebinar")
    WebElement scheduleWebinarButton;

    /**
     * The popup control to bring up the listing of filters for showing
     * scheduled webinars (by relateive date, such as 'Next 7 Days')
     */
    @FindBy(xpath = "//*[@id='upcomingWebinar-webinarSearchDateRangePicker_trig']/span[2]")
    WebElement upcomingWebinarPicker;

    /**
     * The filter item for only showing the scheduled webinars for the next 7 days
     */
    @FindBy(xpath = "//*[@id='upcomingWebinar-webinarSearchDateRangePicker__menu']/ul/li[3]")
    WebElement next7DaysFilter;

    /**
     * Initializes the WebElements on the 'My Webinars' page.
     *
     * @param driver the Selenium WebDriver
     */
    MyWebinarsPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects the filter for only showing the Webinars scheduled for next 7 days
     */
    public void filterForNext7Days() {
        upcomingWebinarPicker.click();
        next7DaysFilter.click();
    }

    /**
     * Gets the listed Webinar name in the scheduled webinars list.
     *
     * @param webinarName  the webinar name
     * @param myTestDriver the test driver
     * @return the listed Webinar name in the scheduled webinars list
     */
    public String getWebinarNameFromListing(
            String webinarName,
            WebDriver myTestDriver
    ) {

        String listedWebinarName = "<&>";
        // if above is returned, this method has a major problem

        WebElement wListedWebinar = myTestDriver.findElement(By
                .xpath((XPATH_PREFIX_WEBINAR_SUMMARY + webinarName
                        + XPATH_SUFFIX_WEBINAR_SUMMARY + "li[3]/a/span")));

        listedWebinarName = wListedWebinar.getText();

        return listedWebinarName;
    }

    /**
     * Gets the registration date.
     *
     * @param webinarName  the webinar name
     * @param myTestDriver the test driver
     * @return the registration date
     */
    public String getRegistrationDate(
            String webinarName,
            WebDriver myTestDriver
    ) {
        String registrationDate = "Wed, Feb 31";
        // if above is returned, this method has a major problem

        WebElement wRegistrationDate = myTestDriver.findElement(By
                .xpath((XPATH_PREFIX_WEBINAR_SUMMARY + webinarName
                        + XPATH_SUFFIX_WEBINAR_SUMMARY + "li[2]")));
        registrationDate = wRegistrationDate.getText();
        return registrationDate;
    }

    /**
     * Gets the registrant count.
     *
     * @param webinarName  the webinar name
     * @param myTestDriver the test driver
     * @return the registrant count
     */
    public int getRegistrantCount(
            String webinarName,
            WebDriver myTestDriver
    ) {
        int registrantCount = -1;
        // if above is returned, this method has a major problem

        WebElement wRegistrantCount = myTestDriver.findElement(By
                .xpath((XPATH_PREFIX_WEBINAR_SUMMARY + webinarName
                        + XPATH_SUFFIX_WEBINAR_SUMMARY + "li[4]/span[2]")));
        registrantCount = Integer.parseInt(wRegistrantCount.getText());
        return registrantCount;
    }

    /**
     * Gets the registration time.
     *
     * @param webinarName  the webinar name
     * @param myTestDriver the test driver
     * @return the registration time
     */
    public String getRegistrationTime(
            String webinarName,
            WebDriver myTestDriver
    ) {
        String registrationTime = "25:00 PM - 25:30 PM PDT";
        // if above is returned, this method has a major problem

        WebElement wRegistrationTime = myTestDriver.findElement(By
                .xpath((XPATH_PREFIX_WEBINAR_SUMMARY + webinarName
                        + XPATH_SUFFIX_WEBINAR_SUMMARY + "div/li[2]/span")));
        registrationTime = wRegistrationTime.getText();
        return registrationTime;
    }

    /**
     * Gets the registration id.
     *
     * @param webinarName  the webinar name
     * @param myTestDriver the test driver
     * @return the registration id
     */
    public String getRegistrationID(
            String webinarName,
            WebDriver myTestDriver
    ) {
        String registrationID = "Webinar ID: XXX-XXX-XXX";
        // if above is returned, this method has a major problem

        WebElement wRegistrationID = myTestDriver.findElement(By
                .xpath((XPATH_PREFIX_WEBINAR_SUMMARY + webinarName
                        + XPATH_SUFFIX_WEBINAR_SUMMARY + "div/li[3]/span")));
        registrationID = wRegistrationID.getText();
        return registrationID;
    }

}
