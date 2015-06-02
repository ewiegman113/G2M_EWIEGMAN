import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;

/**
 * The Class WebinarSchedulingPage.
 */
public class WebinarSchedulingPage {

    /**
     * The webinar name.
     */
    @FindBy(id = "name")
    WebElement webinarName;

    /**
     * The webinar description.
     */
    @FindBy(id = "description")
    WebElement webinarDescription; //optional

    /**
     * The current date showing (pops up datepicker control).
     */
    @FindBy(id = "webinarTimesForm.dateTimes_0.baseDate")
    WebElement currentDateLabelData;

    /**
     * The current month showing in datepicker.
     */
    @FindBy(id = "ui-datepicker-month")
    WebElement currentMonth;

    /**
     * The current year showing in datepicker.
     */
    @FindBy(id = "ui-datepicker-year")
    WebElement currentYear;

    /**
     * The previous month control in datepicker.
     */
    @FindBy(className = "ui-icon-circle-triangle-w")
    WebElement prevMonth;

    /**
     * The next month control in datepicker .
     */
    @FindBy(className = "ui-icon-circle-triangle-e")
    WebElement nextMonth;

    /**
     * The webinar start time.
     */
    @FindBy(name = "webinarTimesForm.dateTimes[0].startTime")
    WebElement webinarStartTime;

    /**
     * The start-time AM/PM list arrow (pops up the list).
     */
    @FindBy(xpath = "//*[@id='webinarTimesForm_dateTimes_0_startAmPm_trig']/span[@class='arrow']")
    WebElement amPmListArrow1;

    /**
     * The end-time AM/PM list arrow (pops up the list).
     */
    @FindBy(xpath = "//*[@id='webinarTimesForm_dateTimes_0_endAmPm_trig']/span[@class='arrow']")
    WebElement amPmListArrow2;

    /**
     * The start-time AM menu item.
     */
    @FindBy(xpath = "//*[@id='webinarTimesForm_dateTimes_0_startAmPm__menu']/ul/li[1]")
    WebElement amItem1;

    /**
     * The start-time AM menu item.
     */
    @FindBy(xpath = "//*[@id='webinarTimesForm_dateTimes_0_startAmPm__menu']/ul/li[2]")
    WebElement pmItem1;

    /**
     * The end-time AM menu item
     */
    @FindBy(xpath = "//*[@id='webinarTimesForm_dateTimes_0_endAmPm__menu']/ul/li[1]")
    WebElement amItem2;

    /**
     * The end-time PM menu item.
     */
    @FindBy(xpath = "//*[@id='webinarTimesForm_dateTimes_0_endAmPm__menu']/ul/li[2]")
    WebElement pmItem2;

    /**
     * The webinar end time.
     */
    @FindBy(id = "webinarTimesForm.dateTimes_0.endTime")
    WebElement webinarEndTime;

    /**
     * The end-time AM/PM list arrow (pops up the list).
     */
    @FindBy(id = "webinarTimesForm_dateTimes_0_endAmPm_trig")
    WebElement amPmList2;

    /**
     * The time zone list.
     */
    @FindBy(id = "webinarTimesForm_timeZone__menu")
    WebElement timeZoneList;

    /**
     * The language list.
     */
    @FindBy(id = "language__menu")
    WebElement languageList;

    /**
     * The submit button ("Schedule").
     */
    @FindBy(id = "schedule.submit.button")
    WebElement submit;

    /**
     * Initializes the WebElements on the 'Schedule Webinar' page.
     *
     * @param driver the Selenium WebDriver
     */
    WebinarSchedulingPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    /**
     * Gets the day number (integer) from date picker for current month.
     *
     * @param numberOfDaysFromNow the number of days from now to schedule the webinar
     * @return the day number (integer) from date picker
     */
    int getDayNumFromDatePicker(int numberOfDaysFromNow) {

        Calendar cal = Calendar.getInstance();
        int monthInt1 = cal.get(Calendar.MONTH);
        cal.add(Calendar.DATE, numberOfDaysFromNow);


        int monthInt2 = cal.get(Calendar.MONTH);
        int dayInt2 = cal.get(Calendar.DATE);

        currentDateLabelData.click();

        if (monthInt1 != monthInt2) {
            //date has wrapped to next month in the simplistic case tested for
            nextMonth.click();
        }

        return dayInt2;

    }

    /**
     * Sets the webinar info.
     *
     * @param webinarName the webinar name
     * @param webinarInfo the webinar user-defined additional info
     */
    public void setWebinarInfo(String webinarName, String webinarInfo) {
        this.webinarName.sendKeys(webinarName);
        if (webinarInfo != null) {
            webinarDescription.sendKeys(webinarInfo);
        }
    }

    /**
     * Sets the webinar time.
     *
     * @param time         the time
     * @param webinarTime  the control showing the scheduled time
     * @param webinarArrow the control that pops up the AM/PM list
     * @param amItem       the AM item in the popup list
     * @param pmItem       the PM item in the popup list
     */
    public void setWebinarTime(
            String time,
            WebElement webinarTime,
            WebElement webinarArrow,
            WebElement amItem,
            WebElement pmItem
    ) {

        String[] timeArray = time.split(" ");
        String timeValue = timeArray[0];
        String timeAmPm = timeArray[1].toLowerCase();

        String selectAll = Keys.chord(Keys.CONTROL, "a");
        webinarTime.sendKeys(selectAll);
        webinarTime.sendKeys(Keys.BACK_SPACE);
        webinarTime.sendKeys(timeValue);


        webinarArrow.click();

        if (timeAmPm.toLowerCase().equals("am")) {
            amItem.click();
        } else {
            pmItem.click();
        }
    }

    /**
     * Sets the webinar timezone.
     *
     * @param timezoneString the webinar timezone to be chosen
     */
    public void setWebinarTimezone(String timezoneString) {

        //TODO: Finish this later. Not important to spec, so using default value.

    }


    /**
     * Sets the webinar language.
     *
     * @param webinarLanguage the webinar language to be chosen
     */
    public void setWebinarLanguage(String webinarLanguage) {

        //TODO:  Finish this later. Not important to spec, so using default value.

    }


    /**
     * Schedules the webinar by clicking the Submit button.
     */
    public void schedule() {
        submit.click();
    }

}
