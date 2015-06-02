import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MeetingSchedulingPage, which defines the objects found on the
 * Schedule Meeting page and additionally may include helper methods.
 */
public class MeetingSchedulingPage {

    /**
     * The Constant AUDIO_TAB.
     */
    private static final int AUDIO_TAB = 1;

    /**
     * The Constant CO_ORGANIZERS_TAB.
     */
    private static final int CO_ORGANIZERS_TAB = 2;

    /**
     * The Constant PASSWORD_TAB.
     */
    private static final int PASSWORD_TAB = 3;

    /**
     * The meeting ID, as seen when editing existing meetings.
     */
    @FindBy(xpath = "//div[@class='meeting-id']")
    WebElement meetingID; //NOTE: Needs "Meeting ID:" and "Share" stripped.

    /**
     * The Share link.
     */
    @FindBy(xpath = "//div[@class='meeting-id']/a")
    WebElement shareLink; //applies when editing existing meeting

    /**
     * The meeting name that user defines.
     */
    @FindBy(id = "meeting-subject-input")
    WebElement meetingName;

    /**
     * The dropdown for recurring status list.
     */
    @FindBy(id = "meeting-occurrence-select")
    WebElement dropdownForRecurringStatusList;

    /**
     * The start time.
     */
    @FindBy(id = "meeting-starttime-input")
    WebElement startTime;

    /**
     * The dropdown for AM/PM list.
     */
    @FindBy(id = "meeting-startperiod-select")
    WebElement dropdownForAmPmList;

    /**
     * The dropdown for the meeting length list.
     */
    @FindBy(id = "meeting-endtime-input")
    WebElement dropdownForMeetingLengthList;

    /**
     * The 'invalid time' error.
     */
    @FindBy(id = "invalid-time-error")
    WebElement invalidTimeError;

    /**
     * The 'past time' error.
     */
    @FindBy(id = "past-time-error")
    WebElement pastTimeError;

    /**
     * The 'invalid duration' error.
     */
    @FindBy(id = "invalid-duration-error")
    WebElement invalidDurationError;

    /**
     * The 'meeting overlap' warning.
     */
    @FindBy(id = "meeting-overlap-warning")
    WebElement meetingOverlapWarning;

    /**
     * The 'meeting timezone' label.
     */
    @FindBy(id = "meeting-timezone-label")
    WebElement meetingTimezoneLabel;

    /**
     * The current month on calendar.
     */
    @FindBy(id = "ui-datepicker-month")
    WebElement currentMonthOnCalendar;

    /**
     * The current year on calendar.
     */
    @FindBy(id = "ui-datepicker-year")
    WebElement currentYearOnCalendar;

    /**
     * The current date dropdown control.
     * Note: This is useful to validate that the current date is as one expects.
     * <br>
     * The Selenium code can get the ID attribute (such as 'dp1433010837369' and
     * then the numeric portion converted from 'UNIX time' to a normal date.
     */
    @FindBy(className = "hasDatepicker")
    WebElement currentDateDropdownControl;

    //Note: the rest of the datepicker code will be handled dynamically,
    // not as Page Elements ...
    //See potentially reusable code in WebinarSchedulingPage class.

    /**
     * The 'Audio' tab.
     */
    @FindBy(xpath = "//div[3]/ul[@class='nav nav-tabs']/li[" + AUDIO_TAB + "]")
    WebElement audioTab;

    /**
     * The 'Co-organizers' tab.
     */
    @FindBy(xpath = "//div[3]/ul[@class='nav nav-tabs']/li["
            + CO_ORGANIZERS_TAB + "]")
    WebElement coOrganizersTab;

    /**
     * The 'Password' tab.
     */
    @FindBy(xpath = "//div[3]/ul[@class='nav nav-tabs']/li[" + PASSWORD_TAB
            + "]")
    WebElement passwordTab;

    /**
     * The 'Use Built-in Audio' radio button.
     */
    @FindBy(id = "built-in")
    WebElement useBuiltInAudio;

    /**
     * The 'Use VOIP' checkbox.
     */
    @FindBy(id = "voip")
    WebElement useVoip;

    /**
     * The 'Use Long Distance Settings' checkbox.
     */
    @FindBy(id = "long-distance")
    WebElement useLongDistanceSettings;

    /**
     * The 'Add Countries to Meeting' Link.
     */
    @FindBy(id = "edit-tollcountries-link")
    WebElement addCountriesToMeeting;

    /**
     * The 'Use Own Conference Service' radio button.
     */
    @FindBy(id = "conference-service")
    WebElement useOwnConferenceService;

    /**
     * The user-defined message regarding 'Own Conference Service'.
     */
    @FindBy(id = "private-message")
    WebElement messageRegardingConferenceService;

    /**
     * The "Password is Required' checkbox.
     */
    @FindBy(id = "password-required")
    WebElement passwordIsRequired;


    /**
     * Initializes the WebElements on the 'Schedule Meetings' page.
     *
     * @param driver the Selenium WebDriver
     */
    MeetingSchedulingPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}

