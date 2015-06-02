import org.testng.annotations.DataProvider;

/**
 * The Class WebinarDataProvider, separating data from code.
 */
public class WebinarDataProvider {

    /**
     * DataProvider for Webinar Challenge.
     *
     * @return the object[][], which represents the data to be used in the Test.
     */
    @DataProvider
    public static Object[][] webinarChallengeData() {
        return new Object[][]{
                /*
                remember, webinar_name, _descr,_start, _end, _daysFromNow, _timezone, _language
                */
                { false, "myWebinar_Cat", "my descriptive text", "10:00 PM", "11:30 PM", 3,
                        "(GMT-07:00) Pacific Time (US and Canada);Tijuana", "English"}};
    }

}