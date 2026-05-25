package Utitlity;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	 //private WebDriver driver;
	    private WebDriverWait wait;
	    private WebDriver driver;
	   

	    public WebDriverUtility(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	 public void click(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	        
}
	 public void enterText(WebElement element, String value) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.clear();
	        element.sendKeys(value);
	    }
	 public WebElement waitForVisibility(By locator) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    return wait.until(
		        ExpectedConditions.visibilityOfElementLocated(locator));
		
	 }
	 public void click(By locator) {
	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(
	                ExpectedConditions.elementToBeClickable(locator))
	                .click();
	 }
}
