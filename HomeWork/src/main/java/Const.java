/**
 * The Interface Constants.
 */
public abstract class Const {

    /** The Constant URL, used when invoking the browser first time. */
    public static final String TEMPLATE__URL = "http://qm-homework.wikia.com";

    /**
     * The constant PROPERTY_FILE.
     */
    public static final String PROPERTY_FILE = "config.properties";

    /**
     * The Constant EMPTY, to minimize accidentally confusing SPACE (" ") with
     * the EMPTY String ("").
     */
    public static final String EMPTY = "";

    /**
     * The Constant SPACE, to minimize accidentally confusing the EMPTY String
     * ("") with SPACE (" ").
     */
    public static final String SPACE = " ";

    /** The Constant TAB -- to aid in readability. */
    public static final String TAB = "\t";

    /** The Constant NEWLINE -- to aid in readability. */
    public static final String NEWLINE = "\n";

    /** The Constant QUOTE -- to aid in readability. */
    public static final String QUOTE = "'";

    /** The Constant DQUOTE -- to aid in readability. */
    public static final String DQUOTE = "\"";

    /** The Constant QUARTER_MINUTE, or 15 seconds. */
    public static final int QUARTER_MINUTE = 15;

    /** The Constant HALF_MINUTE, or 30 seconds. */
    public static final int HALF_MINUTE = 30;

    /** The Constant MINUTE, or 60 seconds. */
    public static final int MINUTE = 60;

    // or, better to use Calendar to get today's date and use simple date format
    // to return YYYY
    /** The Constant CURRENT_YEAR. */
    public static final String CURRENT_YEAR = "2015";
    // similar to above, but increment date by +365 to get next year's date
    /** The Constant NEXT_YEAR. */
    public static final String NEXT_YEAR = "2016";
}
