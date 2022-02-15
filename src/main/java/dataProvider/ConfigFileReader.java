package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigFileReader - Reads data from the configuration properties file.
 */
public class ConfigFileReader {
    private Properties properties;
    private static ConfigFileReader configReader;

    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "configs//configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    /**
     * getInstance( ) - Creates an instance of the Configuration File Reader.
     * @return
     */
    public static ConfigFileReader getInstance( ) {
        if(configReader == null) {
            configReader = new ConfigFileReader();
        }
        return configReader;
    }

    /**
     * getBaseUrl() - Returns the Base URL
     * @return
     */
    public String getBaseUrl() {
        String baseUrl = properties.getProperty("BASE_URL");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("BASE_URL not specified in the Configuration.properties file.");
    }

    /**
     * getPorticoBaseURL() - Returns the Portico Base URL
     * @return
     */
    public String getPorticoBaseUrl() {
        String baseUrl = properties.getProperty("porticoBASE_URL");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("Portico BASE_URL not specified in the Configuration.properties file.");
    }

    /**
     * getMerchantSettingsPath() - Returns retrieveMerchantSettings path to be used in Route
     * @return
     */
    public String getMerchantSettingsPath() {
        String userId = properties.getProperty("retrieveMerchantSettings_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("retrieveMerchantSettings_Path not specified in the Configuration.properties file.");
    }

    /**
     * getProductsPath() - Returns products path to be used in Route
     * @return
     */
    public String getProductsPath() {
        String userId = properties.getProperty("getProducts_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("getProducts_Path not specified in the Configuration.properties file.");
    }

    /**
     * orderProductPath() - Returns orderProduct path to be used in Route
     * @return
     */
    public String orderProductPath() {
        String userId = properties.getProperty("orderProduct_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("orderProduct_Path not specified in the Configuration.properties file.");
    }

    /**
     * getTokenPath() - Returns getToken path to be used in Route
     * @return
     */
    public String getTokenPath() {
        String userId = properties.getProperty("getToken_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("getToken_Path not specified in the Configuration.properties file.");
    }

    /**
     * createTransactionPath() - Returns createTransaction path to be used in Route
     * @return
     */
    public String createTransactionPath() {
        String userId = properties.getProperty("createTransaction_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("createTransaction_Path not specified in the Configuration.properties file.");
    }

    /**
     * getKatanaV5Domain() - Returns Katana V5 Domain path to be used in Route
     * @return
     */
    public String getKatanaV5Domain() {
        String userId = properties.getProperty("katanaV5Domain_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("createTransaction_Path not specified in the Configuration.properties file.");
    }

    /**
     * getOrderingLocations() - Returns Ordering Locations path to be used in Route
     * @return
     */
    public String getOrderingLocations() {
        String userId = properties.getProperty("orderingLocations_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("createTransaction_Path not specified in the Configuration.properties file.");
    }

    /**
     * getOrderingLocations() - Returns Ordering Locations path to be used in Route
     * @return
     */
    public String getOrderingAccounts() {
        String userId = properties.getProperty("orderingAccounts_Path");
        if(userId != null) return userId;
        else throw new RuntimeException("createTransaction_Path not specified in the Configuration.properties file.");
    }

    /**
     * getTestDataResourcePath() - Returns path to test data stored in JSON files
     * @return
     */
    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResource_Path");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }
}
