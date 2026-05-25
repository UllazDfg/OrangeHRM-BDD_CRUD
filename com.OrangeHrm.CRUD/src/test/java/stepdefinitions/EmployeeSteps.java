package stepdefinitions;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.EmployeePage;
import pages.LoginPage;
import utilities.DriverFactory;

//Author = Ullas OU

	public class EmployeeSteps {
		
		
		

	    WebDriver driver;

	    LoginPage loginPage;
	    EmployeePage employeePage;

	    @Given("User launches OrangeHRM")
	    public void launchApplication() throws InterruptedException {

	        driver = DriverFactory.getDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	       
	    }

	    @Given("User login with valid credentials")
	    public void login() throws InterruptedException {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        loginPage = new LoginPage(driver);
	        loginPage.login("Admin", "admin123");
	    }

	    @When("User navigates to PIM module")
	    public void navigateToPIM() {

	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        employeePage = new EmployeePage(driver);
	        employeePage.clickPIM();
	    }

	    @When("User adds employee {string} {string}")
	    public void addEmployee(String fname,String lname) {


	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        employeePage.addEmployee(fname,lname);
	        
	    }

	    @Then("Employee should be created successfully")
	    public void verifyEmployeeCreation() {

	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	        String accountName = employeePage.getAccountName();
	        System.out.println("Account Name: " + accountName);
	        System.out.println("Employee Created Successfully");
	        
	    }
	    
	    @When("User searches employee {string}")
	    public void user_searches_employee(String empName) {

	        employeePage = new EmployeePage(driver);
	        employeePage.clickPIM();
	        employeePage.searchEmployee(empName);
	       
	    }

	    @Then("Employee details should be displayed as {string}")
	    public void employee_details_should_be_displayed_as(String expectedName) {

	    	
	        String actualName = employeePage.getEmployeeName();
	        
	        System.out.println("Actual Name is = " + actualName);
	        System.out.println("Expected Name is = " + expectedName);

	        Assert.assertEquals(actualName, expectedName);
	    }
	    
	    @Then("User updates employee lastname to {string}")
	    public void user_updates_employee_lastname_to(String lastName) {

	        employeePage.updateLastName(lastName);
	        
	        //Thread.sleep(1000);
	    }

	    @Then("Employee should be updated successfully as {string} {string}")
	    public void employee_should_be_updated_successfully_as(String fstName , String lstName) {
	    
	    	  employeePage.clickEmpList(fstName, lstName);

	    	    String actualFullName = employeePage.getEmployeeUpdatedName();

	    	    String expectedFullName = fstName + " " + lstName;

	    	    System.out.println("Actual: " + actualFullName);
	    	    System.out.println("Expected: " + expectedFullName);

	    	    Assert.assertEquals(actualFullName, expectedFullName);

	    	    System.out.println("Employee updated successfully");
	    		    
	    }
	    @When("User deletes employee {string}")
	    public void user_deletes_employee(String empName) {

	        //employeePage.searchEmployee(empName);
	        employeePage.deleteEmployee();
	 
	}

	    @Then("Employee should be removed successfully")
	    public void employee_should_be_removed_successfully() {

	       System.out.println("Successfully removed");
	    	
		    }
	   
	}
	
