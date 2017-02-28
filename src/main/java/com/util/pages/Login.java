package main.java.com.util.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
	 WebDriver driver;
	 
	 By username = By.id("user_login");
	 By password=By.id("user_pass");
	 By submit=By.id("wp-submit");
	 By logout=By.linkText("Log Out");
			    //driver.findElement(By.xpath("//img[contains(@src,'http://2.gravatar.com/avatar/ecd4cd8d38730d6141a509af3c0c2a74?s=26&d=mm&r=g')]")).click();
	    //driver.findElement(By.linkText("Log Out")).click();

	 
	  public Login(WebDriver driver){

	        this.driver = driver;

	   }
	  
	  public void setUserName(String strUserName){

	    	driver.findElement(username).clear();
		    
	        driver.findElement(username).sendKeys(strUserName);;

	    }

	    

	    //Set password in password textbox

	    public void setPassword(String strPassword){

	    	 driver.findElement(password).clear();
	         driver.findElement( password).sendKeys(strPassword);

	    }
	    
	  //Click on login button

	    public void clickLogin(){

	            driver.findElement(submit).click();

	    }
	    
 //Click on logout link
	    
	 
	    
	    public void loginToWordPress(String strUserName ,String strPasword) throws InterruptedException, AWTException{

	        //Fill user name
	    Thread.sleep(1000);
	        this.setUserName(strUserName);
	        Thread.sleep(1000);
	        //Fill password
	       
	        this.setPassword(strPasword);
	        Thread.sleep(1000);
	        //Click Login button

	        this.clickLogin();   
	      //  Thread.sleep(5);
	   //     Assert.assertEquals(driver.getTitle(), "Dashboard � CheckMate � WordPress");
	       
	        

	    }
   
}
