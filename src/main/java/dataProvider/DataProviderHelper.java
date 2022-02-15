package dataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static testDataHelpers.Constants.*;

public class DataProviderHelper {
    /**
     * getDataFilePath() - Returns data file path.
     * @param fileName
     * @return
     */
    public static String getDataFilePath(final String fileName) {
        String filePath = DATA_FOLDER + fileName;

        final boolean existsInRoot = new File(filePath).exists();
        if (existsInRoot) {
            System.out.println("Using data file from root data folder: " + filePath);
            // Use data file from the root
        } else {
            System.out
                    .println("Data file does not exist in root folder");
            filePath = null;
        }

        return filePath;
    }

    /**
     * getJsonDataFilePath() - Returns JSON file path.
     * @param fileName
     * @return
     */
    public static String getJsonDataFilePath(final String fileName) {
        String filePath = JSON_DATA_FOLDER + fileName;
        final boolean existsInRoot = new File(filePath).exists();
        if (existsInRoot) {
            System.out
                    .println("Using data file from json data folder: " + filePath);
            // Use data file from the json folder
        } else {
            System.out
                    .println("jSON data file does not exist in json data folder");
            filePath = null;
        }

        return filePath;
    }

    /**
     * getXmlDataFilePath() - Returns XML file path.
     * @param fileName
     * @return
     */
    public static String getXmlDataFilePath(final String fileName) {
        String filePath = XML_DATA_FOLDER + fileName;
        final boolean existsInRoot = new File(filePath).exists();
        if (existsInRoot) {
            System.out
                    .println("Using data file from xml data folder: " + filePath);
            // Use data file from the xml folder
        } else {
            System.out
                    .println("XML data file does not exist in xml data folder");
            filePath = null;
        }

        return filePath;
    }

    /**
     * readFileAsString() - Reads file and converts it to String.
     * @param filePath
     * @throws IOException
     */
    public static String readFileAsString(String filePath) throws IOException {
        System.out.println(filePath);
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }
}
