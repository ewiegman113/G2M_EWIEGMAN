import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class MyMeetingsPage, which defines the objects found on the
 * My Meetings page and additionally may include helper methods.
 */
public class MyMeetingsPage {

    /**
     * The 'edit meeting profile' link.
     */
    @FindBy(id = "citrix-icon-edit")
    WebElement editProfile;

    /**
     * The 'schedule later' button.
     */
    @FindBy(id = "schedule-later")
    WebElement scheduleLater;

    /**
     * The 'join meeting [now]' button.
     */
    @FindBy(id = "join-meeting-text")
    WebElement joinMeeting;

    /**
     * The meeting URL.
     */
    @FindBy(id = "url")
    WebElement meetingUrl;

    /**
     * The 'start meeting' button.
     */
    @FindBy(id = "start-gotomeeting")
    WebElement startMeeting;

    /**
     * The 'share meeting' button.
     */
    @FindBy(id = "share-gotomeeting")
    WebElement shareMeeting;

    //Note: the rest of the 'My Meetings' code will be handled dynamically,
    //not as Page Elements

 /*   	
        Plan for retrieving information from the various divs and spans ...
       
        Non-Recurring
        --------------
    	//span[contains(text(),'N')]/../../../div[1]/div[1]/span[1]	   Mon, Jun 1
    	//span[contains(text(),'N')]/../../../div[1]/div[2]	           9:00 AM
    	//span[contains(text(),'N')]/../../../div[2]/div[2]	           9:00 AM - 9:30 AM Pacific Daylight Time
    	//span[contains(text(),'N')]/../../../div[2]/div[3]	           Organizers: Eric Wiegman
    	//span[contains(text(),'N')]/../../../div[3]/div/span/a[1]	   Start (button/link)
    	//span[contains(text(),'N')]/../../../div[3]/div/span/a[2]	   Share (button/link)
    	//span[contains(text(),'N')]/../../../div[3]/div/span/i[1]	   Edit (tooltip)
    	//span[contains(text(),'N')]/../../../div[3]/div/span/i[2]	   Delete (tooltip)

    	Recurring
    	---------
    	//span[contains(text(),'N')]/../../../div[1]/div	              Recurring
    	//span[contains(text(),'N')]/../../../div[2]/div[2]	          Organizers: Eric Wiegman
    	//span[contains(text(),'N')]/../../../div[3]/div/span/a[1]	      Start (button/link)
    	//span[contains(text(),'N')]/../../../div[3]/div/span/a[2]	      Share (button/link)
    	//span[contains(text(),'N')]/../../../div[3]/div/span/i[1]	      Edit (tooltip)
    	//span[contains(text(),'N')]/../../../div[3]/div/span/i[2]	      Delete (tooltip)

    	1.	Substitute passed in parameter of the unique meeting name N for the
    	      [contains(text(),'N')]
    	2.	Very likely a lot of extraneous white space ... do a trim(), as well.
    	3.	Also, consider replacing newline with space?
    	
    	If xpath "//span[contains(text(),'N')]/../../../div[1]/div" is 'Recurring' 
    	 use xpaths for recurring, otherwise use xpaths for non-recurring
    	*/

    /**
     * Initializes the WebElements on the 'My Meetings' page.
     *
     * @param driver the Selenium WebDriver
     */
    MyMeetingsPage(WebDriver driver) {
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}


