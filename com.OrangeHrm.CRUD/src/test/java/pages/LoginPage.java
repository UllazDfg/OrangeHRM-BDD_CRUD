package pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

import Utitlity.WebDriverUtility;

	public class LoginPage {

	    WebDriver driver;

	    public LoginPage(WebDriver driver){
	        this.driver = driver;
	    }

	    By userame = By.name("username");
	    By password = By.name("password");
	    By loginBtn = By.xpath("//button[@type='submit']");

	    public void login(String user,String pass){
	    	
	    	//wDUtils.waitForVisibility(userame).sendKeys(user);

	    	 driver.findElement(userame).sendKeys(user);
	        System.out.println("entered Username");
	        driver.findElement(password).sendKeys(pass);
	        System.out.println("entered Password");
	        driver.findElement(loginBtn).click();
	        System.out.println("Clicked Button");
	    }
	}

