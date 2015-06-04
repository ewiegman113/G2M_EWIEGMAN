

import org.testng.annotations.DataProvider;

/**
 * The Class WikiaDataProviderPage, separating data from code.
 */
public class WikiaDataProviderPage {

    /**
     * DataProvider for the coding homework.
     *
     * @return the object[][], which represents the data to be used in the Test.
     */
    @DataProvider
    public static Object[][] HomeWork_LoginData() {
        return new Object[][]{
                /*
                rememberMe
                */
                { false }
        };
    }

    /**
     * DataProvider for the coding homework.
     *
     * @return the object[][], which represents the data to be used in the Test.
     */
    @DataProvider
    public static Object[][] HomeWork_VideoAddedData() {
        return new Object[][]{
                /*
                rememberMe, videoURL, expectedVideoTitle
                */
                {
                        false,
                        "http://www.youtube.com/watch?v=h9tRIZyTXTI",
                        "The Best Classical Music In The World"}
                };
         }

}