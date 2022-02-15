package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JsonDataReader;

/**
 * FileReaderManager: Manages all the File Readers.
 *                    Client has to use the getInstance() method to access other public methods of the FileReaderManager.
 *                    Example: FileReaderManager.getInstance().getConfigReader()
 */
public class FileReaderManager {
    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonDataReader jsonDataReader;

    /**
     * FileReaderManager() - Private constructor to restrict instantiation of the class from other classes..
     */
    private FileReaderManager() {
    }

    /**
     * getInstance() - Public static method that returns the instance of the class.
     *                 This is the global access point for outer world to get the instance of the singleton class.
     * @return
     */
    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    /**
     * getConfigReader(): Returns the Configuration File Reader Object.
     * @return
     */
    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    /**
     * getJsonReader(): Returns the JsonDataReader Object.
     * @return
     */
    public JsonDataReader getJsonDataReader(){
        return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
    }
}
