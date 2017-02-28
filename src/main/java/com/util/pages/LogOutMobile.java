package main.java.com.util.pages;

import java.util.List;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogOutMobile {

	 AppiumDriver driver;
	 By logout=By.name("Log out from WordPress.com");
	 By confirmlogout=By.name("Log out");
	 
	 public  LogOutMobile(AppiumDriver driver){

	        this.driver = driver;

	   }
	 
	 public void Logout() throws InterruptedException{

	       
		 	Thread.sleep(2000);
		     List<WebElement> ele=driver.findElements(By.className("android.support.v7.app.ActionBar$Tab"));
	       
	    	WebElement b=ele.get(2);
		     Thread.sleep(2000);
	    	 b.click();
	     
	    	 //Assertion to check if on log-out page
	    	 WebElement chk=driver.findElement(By.id("org.wordpress.android:id/me_my_profile_text_view"));
				Boolean iselementpresent = driver.findElementsById("org.wordpress.android:id/me_my_profile_text_view").size()!=0;
				  //iselementpresent will be true so assertion will pass and so test method will pass too.
				Assert.assertTrue(iselementpresent,"Targeted element App is not present on screen");
				 Thread.sleep(2000);
				driver.findElement(logout).click();
             driver.findElement(confirmlogout).click();
        	 Thread.sleep(2000);
        	 
        	 //assertion to check if logged in or not
        	 WebElement chk1=driver.findElement(By.id("org.wordpress.android:id/nux_username"));
				Boolean iselementpresent1 = driver.findElementsById("org.wordpress.android:id/nux_username").size()!=0;
				  //iselementpresent will be true so assertion will pass and so test method will pass too.
				Assert.assertTrue(iselementpresent1,"Targeted element App is not present on screen");
				
	    }
	  
}
