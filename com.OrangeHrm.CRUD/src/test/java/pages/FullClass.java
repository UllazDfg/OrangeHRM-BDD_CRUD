package pages;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullClass {
	
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	System.out.println("Logined");
	
	driver.findElement(By.xpath("//span[text()='PIM']")).click();
	System.out.println("clicked PIM");
	
	Thread.sleep(20000);
	
	driver.quit();
	
}
}