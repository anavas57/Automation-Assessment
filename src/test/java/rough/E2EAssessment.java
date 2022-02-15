package rough;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static testDataHelpers.Constants.CHROME_DRIVER_PATH;
import static testDataHelpers.Constants.JSON_DATA_FOLDER;

public class E2EAssessment {
    private static WebDriver driver;

    public static void main(String[] args) {
        /**
         * Step 1: Retrieve the list of devices via API
         */
        System.out.println("\n" + "Step 1: Retrieve the list of devices via API");

        String baseURL = "http://localhost:3000";

        // Create a Request pointing to the Service Endpoint
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given().log().all();

        request.header("Accept", "application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Host", "localhost:3000")
                .header("If-None-Match","574-PHvIb7vC49rJfxo89DW9CU6Y53I")
                .header("Origin","http://localhost:3001");

        Response devicesResponse = request.get("/devices");

        // Validate the Response
        int devicesResponseStatusCode = devicesResponse.getStatusCode();
        Assert.assertEquals(devicesResponseStatusCode, 200);

        // Convert the response into the string representation
        String devicesJsonString = devicesResponse.asPrettyString();

        // Print Response to the Console
        System.out.println("\n" + "Step 1: List of Devices:");
        System.out.println(devicesJsonString);

        // Extracting IDs from the API Response
        List<String> apiIds = devicesResponse.jsonPath().getList("id");
        System.out.println(apiIds);

        // Extracting System Names from the API Response
        List<String> apiSystemNames = devicesResponse.jsonPath().getList("system_name");
        System.out.println(apiSystemNames);

        // Extracting Types from the API Response
        List<String> apiTypes = devicesResponse.jsonPath().getList("type");
        System.out.println(apiTypes);

        // Extracting H DD Capacities from the API Response
        List<String> apiHddCapacities = devicesResponse.jsonPath().getList("hdd_capacity");
        System.out.println(apiHddCapacities);

        /**
         * Step 2: Save the API response to a JSON file
         */
        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + JSON_DATA_FOLDER + "devicesAPI.json");
            file.write(devicesResponse.asPrettyString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Step 3: Retrieve the list of devices from the UI (Page Source)
         */
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + CHROME_DRIVER_PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3001/");

        driver.navigate().to("http://localhost:3001/");

        String pageSource = driver.getPageSource();
        //System.out.println("\n" + "Devices in Page Source = " + "\n" + pageSource);

        /**
         * Step 4: Save the UI's Page Source to a Text file
         */
        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + JSON_DATA_FOLDER + "devicesPageSource.txt");
            file.write(pageSource);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Step 5: Verify the list of devices in the Page Source matches the list returned by the API
        */
        System.out.println("\n" +"Verifying the devices returned in the API are found in the Page Source" + "\n");

        for(int i=0; i < apiIds.size(); i++) {
            // Assert Ids returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiIds.get(i)));
            System.out.println("id = " + apiIds.get(i) + " was found in the Page Source");

            // Assert System Names returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiSystemNames.get(i)));
            System.out.println("System Name = " + apiSystemNames.get(i) + " was found in the Page Source");

            // Assert Types returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiTypes.get(i)));
            System.out.println("Type = " + apiTypes.get(i) + " was found in the Page Source");

            // Assert HDD Capacities returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiHddCapacities.get(i)));
            System.out.println("HDD Capacity = " + apiHddCapacities.get(i) + " was found in the Page Source" + "\n");
        }

        /**
         * Step 6: Retrieve the list of devices from the UI
         */
        List<WebElement> devicesUI = driver.findElements(By.xpath("//*[@class='list-devices']"));
        System.out.println("\n" + "Devices in the UI = ");
        for(int i = 0; i < devicesUI.size(); i++) {
            System.out.println(devicesUI.get(i).getText() + "\n");
        }

        /**
         * Step 7: Save the devices in the UI to a Text file
         */
        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + JSON_DATA_FOLDER + "devicesUI.txt");
            for(int i = 0; i < devicesUI.size(); i++) {
                file.write(String.valueOf(devicesUI.get(i).getText()));
            }
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       driver.quit();
    }
}