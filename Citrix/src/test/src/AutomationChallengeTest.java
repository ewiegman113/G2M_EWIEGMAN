import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

/**
 * The Class AutomationChallengeTest.
 */
public class AutomationChallengeTest {

    /**
     * The Constant STARTING_URL.
     */
    final static String STARTING_URL =
            "https://global.gotowebinar.com/webinars.tmpl";
    /**
     * The Selenium WebDriver, used to give a handle to current browser.
     */
    final WebDriver driver = new FirefoxDriver();
    /**
     * The webinar login page.
     */
    final WebinarLoginPage webinarLoginPage = new WebinarLoginPage(driver);
    /**
     * The webinar common side-bar 'page'.
     */
    final WebinarsSideBar webinarsSideBar = new WebinarsSideBar(driver);
    /**
     * The 'my webinars' page.
     */
    final MyWebinarsPage myWebinarsPage = new MyWebinarsPage(driver);
    /**
     * The 'webinar scheduling' page.
     */
    final WebinarSchedulingPage webinarSchedulingPage =
            new WebinarSchedulingPage(driver);

    /**
     * Setup routine, run before the Test. <BR>
     * It launches the browser with the starting URL.
     */
    @BeforeTest()
    public void setup() {
        driver.get(STARTING_URL);
    }

    /**
     * Verify upcoming webinar is listed correctly. <BR> That is, the webinar appears
     * in the upcoming webinars list and is scheduled for the right date and time.
     *
     * @param rememberMe          the 'Remember me' checkbox is checked, if set to true ... else, it remains unchecked
     * @param webinarName         the webinar name
     * @param webinarDesc         the webinar description (optional information that is user supplied)
     * @param webinarStart        the webinar start date (12 hour format, with AM or PM)
     * @param webinarEnd          the webinar end date (12 hour format, with AM or PM)
     * @param webinarDaysInFuture the days in future in which the webinar is scheduled
     * @param webinarTimezone     the webinar's timezone
     * @param webinarLanguage     the webinar's language (such as Deutch, English, etc)
     *
     * @throws IOException        Exception thrown if config.properties (defining login credentials) is not in classpath
     */
    @Test(dataProvider = "webinarChallengeData", dataProviderClass = WebinarDataProvider.class)
    public void testUpcomingWebinarListedCorrectly(
            boolean rememberMe,
            String webinarName,
            String webinarDesc,
            String webinarStart,
            String webinarEnd,
            int webinarDaysInFuture,
            String webinarTimezone,
            String webinarLanguage
    ) throws IOException {

        String result = "";

        String propFileName = "config.properties";
        Properties prop = getPropertiesFromClasspath(propFileName);

        String username = prop.getProperty("email");
        String password = prop.getProperty("password");

           webinarLoginPage.login(
                username,
                password,
                rememberMe
        );

        myWebinarsPage.scheduleWebinarButton.click();

        webinarSchedulingPage.setWebinarInfo(
                webinarName,
                webinarDesc
        );

        //FIXME: Won't work on last day of month as product already shows tomorrow (next Month) and the automation does a next and now I am in Month after next!
        int dateNum = webinarSchedulingPage.getDayNumFromDatePicker(
                webinarDaysInFuture
        );

        WebElement wMonthDay = driver.findElement(By.xpath("//td[.= '" + dateNum + "']/a"));
        wMonthDay.click();

        String currentDateInDatePicker = webinarSchedulingPage.currentDateLabelData.getAttribute("value");

        webinarSchedulingPage.setWebinarTime(
                webinarStart,
                webinarSchedulingPage.webinarStartTime,
                webinarSchedulingPage.amPmListArrow1,
                webinarSchedulingPage.amItem1,
                webinarSchedulingPage.pmItem1
        );

        webinarSchedulingPage.setWebinarTime(
                webinarEnd,
                webinarSchedulingPage.webinarEndTime,
                webinarSchedulingPage.amPmListArrow2,
                webinarSchedulingPage.amItem2,
                webinarSchedulingPage.pmItem2
        );

        webinarSchedulingPage.setWebinarTimezone(webinarTimezone);

        webinarSchedulingPage.setWebinarLanguage(webinarLanguage);

        webinarSchedulingPage.schedule();

        webinarsSideBar.myWebinarsLink.click();

        String actualWebinarName = myWebinarsPage.getWebinarNameFromListing(
                webinarName,
                driver
        );
        String actualWebinarDate = myWebinarsPage.getRegistrationDate(
                webinarName,
                driver
        );
        String actualWebinarTime = myWebinarsPage.getRegistrationTime(
                webinarName,
                driver
        );

        Assert.assertEquals(
                actualWebinarName,
                webinarName,
                "The 'My Webinars' listing for the meeting name doesn't match "
                        + "the expected value --"
        );

        String tzDateShortCode = getWebinarShortTimezone(webinarTimezone);

        Assert.assertEquals(
                actualWebinarTime,
                webinarStart + " - " + webinarEnd + " " + tzDateShortCode,
                "The 'My Webinars' listing for the meeting times doesn't match "
                        + "the expected value --"
        );

        int lastCommaSpaceInDatePickerDate = currentDateInDatePicker.lastIndexOf(", ");
        String modifiedCurrentDateInDatePicker = currentDateInDatePicker.substring(0, lastCommaSpaceInDatePickerDate);

        Assert.assertEquals(
                actualWebinarDate,
                modifiedCurrentDateInDatePicker,
                "The 'My Webinars' listing for the meeting date doesn't match "
                        + "the expected value --"
        );
    }

    /**
     * Returns the old fashioned timezone (such as 'PDT' or 'PST' for input)
     *
     * @param webinarTimezone the webinar's timezone (such as
     *                        '(GMT-07:00) Pacific Time (US and Canada);Tijuana)')
     *
     * @return the timezone formatted portion of the date (such as 'GMT' or 'PDT')
     */
    private String getWebinarShortTimezone(String webinarTimezone) {

        String serverTimeShortTZ = "XXX";
        // if above is returned, this method has a major problem

        int webinarTimezoneFirstSpaceIndex = webinarTimezone.indexOf(" ");
        String parseTheCode = webinarTimezone.substring(0, webinarTimezoneFirstSpaceIndex);

        final TimeZone tz = TimeZone.getTimeZone(parseTheCode);
        final Calendar cal = Calendar.getInstance(tz);
        cal.setTime(new Date());
        Date serverTime = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("z");
        serverTimeShortTZ = format.format(serverTime);

        //RETURNS the short old-fashioned code such as "PDT"
        return serverTimeShortTZ;
    }

    private Properties getPropertiesFromClasspath(String propFileName) throws IOException {
        Properties props = new Properties();
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName
                    + "' not found in the classpath");
        }

        props.load(inputStream);

        return props;
    }


}
