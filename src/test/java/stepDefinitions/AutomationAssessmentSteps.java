package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestUtils;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static testDataHelpers.Constants.CHROME_DRIVER_PATH;
import static testDataHelpers.Constants.JSON_DATA_FOLDER;

public class AutomationAssessmentSteps {
    private RequestSpecification request;
    private Response devicesResponse;
    private static WebDriver driver;
    private final TestUtils utilities = new TestUtils();
    private List<String> apiIds = Collections.singletonList("");
    private List<String> apiSystemNames = Collections.singletonList("");
    private List<String> apiTypes = Collections.singletonList("");
    private List<String> apiHddCapacities = Collections.singletonList("");
    private String pageSource;

    @Given("the user wants to retrieve the list of devices from the server")
    public void the_user_wants_to_retrieve_the_list_of_devices_from_the_server() {
        utilities.log().info("Given the user wants to retrieve the list of devices from the server");
        String baseURL = "http://localhost:3000";

        /**
         * Create a Request pointing to the Service Endpoint
         */
        RestAssured.baseURI = baseURL;
        request = RestAssured.given().log().all();

        request.header("Accept", "application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "en-US,en;q=0.9")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .header("Host", "localhost:3000")
                .header("If-None-Match","574-PHvIb7vC49rJfxo89DW9CU6Y53I")
                .header("Origin","http://localhost:3001");
    }

    @When("the user requests the list of devices from the server")
    public void the_user_requests_the_list_of_devices_from_the_server() {
        utilities.log().info("When the user requests the list of devices from the server");
        devicesResponse = request.get("/devices");
    }

    @Then("the user gets the list of devices from the server")
    public void the_user_gets_the_list_of_devices_from_the_server() {
        utilities.log().info("Then the user gets the list of devices from the server");

        // Validate the Response
        int devicesResponseStatusCode = devicesResponse.getStatusCode();
        Assert.assertEquals(devicesResponseStatusCode, 200);

        // Convert the response into the string representation
        String devicesJsonString = devicesResponse.asPrettyString();

        // Print Response to the Console
        System.out.println("\n" + "Step 1: List of Devices:");
        System.out.println(devicesJsonString);

        /**
         * Extracting data from the API response:
         *    - Extracting IDs from the API Response
         *    - Extracting System Names from the API Response
         *    - Extracting Types from the API Response
         *    - Extracting H DD Capacities from the API Response
         */
        apiIds = devicesResponse.jsonPath().getList("id");
        System.out.println(apiIds);

        apiSystemNames = devicesResponse.jsonPath().getList("system_name");
        System.out.println(apiSystemNames);

        apiTypes = devicesResponse.jsonPath().getList("type");
        System.out.println(apiTypes);

        apiHddCapacities = devicesResponse.jsonPath().getList("hdd_capacity");
        System.out.println(apiHddCapacities);

        /**
         * Save the API response to a JSON file
         */
        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + JSON_DATA_FOLDER + "devicesAPI.json");
            file.write(devicesResponse.asPrettyString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Given("the user has retrieved the list of devices from the server")
    public void the_user_has_retrieved_the_list_of_devices_from_the_server() {
        utilities.log().info("Given the user has retrieved the list of devices from the server");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + CHROME_DRIVER_PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3001/");

        driver.navigate().to("http://localhost:3001/");

        pageSource = driver.getPageSource();

        /**
         * Save the UI's Page Source to a Text file
         */
        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + JSON_DATA_FOLDER + "devicesPageSource.txt");
            file.write(pageSource);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("the user checks for the devices in the list in the client app")
    public void the_user_checks_for_the_devices_in_the_list_in_the_client_app() {
        utilities.log().info("When the user checks for the devices in the list in the client app");
    }

    @Then("the user can verify the id of each device is displayed in the UI")
    public void the_user_can_verify_the_id_of_each_device_is_displayed_in_the_ui() {
        utilities.log().info("Then the user can verify the id of each device is displayed in the UI");
        for(int i=0; i < apiIds.size(); i++) {
            // Assert Ids returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiIds.get(i)));
            System.out.println("id = " + apiIds.get(i) + " was found in the Page Source");
        }
    }

    @Then("the user can verify the name of each device is displayed in the UI")
    public void the_user_can_verify_the_name_of_each_device_is_displayed_in_the_ui() {
        utilities.log().info("Then the user can verify the name of each device is displayed in the UI");
        for(int i=0; i < apiSystemNames.size(); i++) {
            // Assert System Names returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiSystemNames.get(i)));
            System.out.println("System Name = " + apiSystemNames.get(i) + " was found in the Page Source");
        }
    }

    @Then("the user can verify the type of each device is displayed in the UI")
    public void the_user_can_verify_the_type_of_each_device_is_displayed_in_the_ui() {
        utilities.log().info("Then the user can verify the type of each device is displayed in the UI");
        for(int i=0; i < apiTypes.size(); i++) {
            // Assert Types returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiTypes.get(i)));
            System.out.println("Type = " + apiTypes.get(i) + " was found in the Page Source");
        }
    }

    @Then("the user can verify the capacity of each device is displayed in the UI")
    public void the_user_can_verify_the_capacity_of_each_device_is_displayed_in_the_ui() {
        utilities.log().info("Then the user can verify the capacity of each device is displayed in the UI");
        for(int i=0; i < apiHddCapacities.size(); i++) {
            // Assert HDD Capacities returned by the API can be found in the page source
            Assert.assertTrue(pageSource.contains(apiHddCapacities.get(i)));
            System.out.println("HDD Capacity = " + apiHddCapacities.get(i) + " was found in the Page Source" + "\n");
        }
    }
}
