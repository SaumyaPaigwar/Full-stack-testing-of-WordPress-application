package main.java.com.util.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.reporters.jq.TimesPanel;

import io.appium.java_client.AppiumDriver;

public class LoginMobile {

	 static AppiumDriver driver;

	 By username = By.id("org.wordpress.android:id/nux_username");
	 By nextbuttton=By.id("org.wordpress.android:id/nux_sign_in_button");
	 By password=By.id("org.wordpress.android:id/nux_password");
	 By submit=By.id("org.wordpress.android:id/nux_sign_in_button");
	 By iconlogout=By.id("org.wordpress.android:id/tab_icon");
	 By logout=By.linkText("org.wordpress.android:id/me_login_logout_text_view");
			    //driver.findElement(By.xpath("//img[contains(@src,'http://2.gravatar.com/avatar/ecd4cd8d38730d6141a509af3c0c2a74?s=26&d=mm&r=g')]")).click();
	    //driver.findElement(By.linkText("Log Out")).click();
	// driver.findElement(By.id("org.wordpress.android:id/nux_username")).sendKeys("ruc123");
	//  driver.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
	 // driver.findElement(By.id("org.wordpress.android:id/nux_password")).sendKeys("ru12@#chi");
	 // driver.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
	 
	  public LoginMobile(AppiumDriver driver){

	        this.driver = driver;

	   }
	  
	  public void setUserName(String strUserName){

	    	driver.findElement(username).clear();
		    
	        driver.findElement(username).sendKeys(strUserName);
	        driver.findElement(nextbuttton).click();

	    }

	    

	    //Set password in password textbox

	    public void setPassword(String strPassword){
	    	
	    	WebElement ele=driver.findElement(password);
	    	 driver.findElement(password).clear();
	    /*	 WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,5).until(new ExpectedCondition<WebElement>() {
	    		 public WebElement apply(WebDriver d) {
	    		      //  d.get(baseUrl);
	    		        return d.findElement(password);
	    		    }
			} );*/

	    			 //TimeSpan.FromSeconds(maxWaitTimeInSeconds));
	    	 driver.findElement( password).sendKeys(strPassword);

	    }
	    
	  //Click on login button

	    public void clickLogin() throws InterruptedException{

	            driver.findElement(submit).click();
	           // Thread.sleep(5000);

	    }
	    
//Click on logout link
	    
	    public void clickLogOutLink(){
	    	
	    	driver.findElement(iconlogout).click();
	    	driver.findElement(logout).click();
	    }
	    
	    public void loginToWordPress(String strUserName ,String strPasword) throws InterruptedException{

	        //Fill user name
	    	 Thread.sleep(8000);
	        this.setUserName(strUserName);

	        //Fill password
	       
	        this.setPassword(strPasword);

	        //Click Login button

	        this.clickLogin();   
	   	 Thread.sleep(5000);
	   	 WebElement chk=driver.findElement(By.id("org.wordpress.android:id/my_site_title_label"));
			Boolean iselementpresent = driver.findElementsById("org.wordpress.android:id/my_site_title_label").size()!=0;
			  //iselementpresent will be true so assertion will pass and so test method will pass too.
			Assert.assertTrue(iselementpresent,"Targeted element App is not present on screen");
	//        Thread.sleep(5);
	   //     Assert.assertEquals(driver.getTitle(), "Dashboard � CheckMate � WordPress");
	     //   this.clickLogOutLink();
	        

	    }
	    
	    

	    

}
