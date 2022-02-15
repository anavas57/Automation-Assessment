package testDataHelpers;


public final class Constants {

    /** Default Timeouts **/
    public static final String SELENIUM_DEFAULT_TIMEOUT_PROPERTY = "selenium.default_timeout";
    public static final String SELENIUM_ELEMENT_TIMEOUT_PROPERTY = "selenium.element_timeout";
    public static final String SELENIUM_PAGE_TIMEOUT_PROPERTY = "selenium.page_timeout";

    /** The default timeout in seconds, should be a generous default time **/
    public final static long GLOBAL_DRIVER_TIMEOUT = Integer.getInteger(SELENIUM_DEFAULT_TIMEOUT_PROPERTY, 60);

    /** The timeout (seconds) for finding web elements on a page, shouldn't be too long **/
    public final static long ELEMENT_TIMEOUT = Integer.getInteger(SELENIUM_ELEMENT_TIMEOUT_PROPERTY, 10);

    /** The timeout (seconds) for page/DOM/transitions, should also be a generous **/
    public final static long PAGE_TIMEOUT = Integer.getInteger(SELENIUM_PAGE_TIMEOUT_PROPERTY, 60);

    /** Path to Chrome Driver **/
    public static final String CHROME_DRIVER_PATH = "/src/test/resources/drivers/";

    /** Test Data Folder **/
    public static final String DATA_FOLDER      = "/src/test/resources/testDataResources/"; // root data folder
    public static final String JSON_DATA_FOLDER = "/src/test/resources/testDataResources/json/"; // json data folder
    public static final String XML_DATA_FOLDER = "/src/test/resources/testDataResources/xml/"; // xml data folder

    /** Test Data Files **/
    public static String DevicesAPI = "devicesAPI.json";
    public static String DevicesUI = "devicesUI.json";
}
