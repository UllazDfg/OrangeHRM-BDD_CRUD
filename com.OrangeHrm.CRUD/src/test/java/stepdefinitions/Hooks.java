package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverFactory;

public class Hooks {

    @Before
    public void setup() {

        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {

        DriverFactory.driver.quit();
        System.out.println("Browser closed");
    }
}

