package test.java.Integration.FunctionalRest;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut {
WebDriver driver ;
	public LogOut(WebDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
		  
	
	public void clickLogOutLink() throws AWTException{
				  WebElement webe=driver.findElement(By.partialLinkText("Howdy"));
				  Actions builder = new Actions(driver);
				  builder.moveToElement(webe).build().perform();
				  WebDriverWait wait = new WebDriverWait(driver, 5);
				  //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='wp-admin-bar-logout']/a")));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Out")));
				 // WebElement required = driver.findElement(By.xpath(".//*[@id='wp-admin-bar-logout']/a"));
				  WebElement required =driver.findElement(By.linkText("Log Out"));
				  builder.moveToElement(required).build().perform();
				  required.click();
				    }
		
		
	

}
