package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utitlity.WebDriverUtility;

	public class EmployeePage {
		
		 WebDriver driver;
		    WebDriverWait wait;
		    JavascriptExecutor js;

	            public EmployeePage(WebDriver driver) {
	            	 this.driver = driver;
	                 this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	                 JavascriptExecutor js;
	                
	            }

	

	    By pimMenu = By.xpath("//span[text()='PIM']");
	    By addBtn = By.xpath("//a[text()='Add Employee']");

	    By firstName = By.name("firstName");
	    By lastName = By.name("lastName");

	    By saveBtn = By.xpath("//button[@type='submit']");
	    By accountName = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
	    
	    By empList = By.xpath("//a[contains(text(),'Employee List')]");
	    By empNameTxt = By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	    By seachBtn = By.xpath("//button[@type='submit']");
	    
	    By empNameFromList = By.xpath("//div[@class='oxd-table-card'][1]//div[3]/div");
	    By empLName = By.xpath("//div[@class='oxd-table-card'][1]//div[4]/div");

	    By editButton = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
	    By editFistName = By.name("firstName");
	    By editLastName = By.name("lastName");
	    By saveUpdateBtn = By.xpath("(//button[normalize-space()='Save'])[1]");
	    By personalDetail = By.xpath("//div[@class='orangehrm-tabs-wrapper'][1]");
	    By personalAccName = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
	    
	    By deleteButton = By.xpath("(//i[@class='oxd-icon bi-trash'])[1]");
	    By deletConfirmationBtn = By.xpath("//button[contains(@class,'label-danger orangehrm-button-margin')]");
	    
	    public void clickPIM() {
	    	
	        driver.findElement(pimMenu).click();
	       
	    }

	    public void addEmployee(String fname,String lname) {

	        driver.findElement(addBtn).click();

	        driver.findElement(firstName).sendKeys(fname);
	        driver.findElement(lastName).sendKeys(lname);

	        driver.findElement(saveBtn).click();
	    }
	    public String getAccountName() {
	    	  
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(accountName));

		        return driver.findElement(accountName).getText();

	}
	    public void searchEmployee(String empName) {
	    	
	        
	    	driver.findElement(empList).click();
	    	System.out.println("clicked employee list");
	    	driver.findElement(empNameTxt).sendKeys(empName);
	    	System.out.println("entered empoyee name to search");
	    	driver.findElement(seachBtn).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    	System.out.println("clicked search button");
	    	System.out.println("Searched Employee name");
	    }
	    public String getEmployeeName() {

	        wait.until(ExpectedConditions.visibilityOfElementLocated(empNameFromList));

	        return driver.findElement(empNameFromList).getText();
	        
	    }
	    public void updateLastName (String lName) {
	    	

	    	    WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(editButton));
	    	    editBtn.click();

	    	    System.out.println("Clicked edit button");

	    	    WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(editLastName));

	    	    lastNameField.clear();
	    	    lastNameField.sendKeys(lName);

	    	    System.out.println("Entered Name");

	    	    WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveUpdateBtn));
	    	    
	            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);

	    js.executeScript("arguments[0].click();", saveButton);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    	    
	    	    System.out.println("Clicked save button");
	    	
	    
	}
	    public void deleteEmployee() {

	    	
	        WebElement deleteBtn = wait.until(
	                ExpectedConditions.elementToBeClickable(deleteButton)
	        );

	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", deleteBtn);

	        js.executeScript("arguments[0].click();", deleteBtn);

	        System.out.println("Clicked delete button");

	        WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(deletConfirmationBtn));

	        confirmBtn.click();

	        System.out.println("Employee deleted");
	    
	    	}
	    public void clickEmpList(String fname , String lstName) {
	    	
	    	driver.findElement(empList).click();
	    	System.out.println("clicked employee list");
	    	driver.findElement(empNameTxt).sendKeys(fname);
	    	System.out.println("entered empoyee name to search");
	    	driver.findElement(seachBtn).click();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    	System.out.println("clicked search button");
	    	System.out.println("Searched Employee name");

	}
	    public String getEmployeeUpdatedName() {

	        String fName = driver.findElement(empNameFromList).getText();
	        String lName = driver.findElement(empLName).getText();

	        return fName + " " + lName;
	    
	    }
	    	
	    }
	
