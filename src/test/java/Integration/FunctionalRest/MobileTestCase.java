package test.java.Integration.FunctionalRest;



import main.java.com.util.pages.LogOutMobile;
import main.java.com.util.pages.LoginMobile;
import main.java.com.util.pages.MediaMobile;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;

import org.testng.annotations.BeforeTest;



//import Pages.Post;

public class MobileTestCase {
	 static DesiredCapabilities cap;
	 static AppiumDriver driver;

	 static AppiumDriverLocalService appiumService;
	    static String appiumServiceUrl;
	    String folder_name;
	    DateFormat df;
	 
	 
	 
	@BeforeTest
	static void setup() throws IOException, InterruptedException{
	
	
        
		 String apkpath = "D:\\WordPress_v6.6_apkpure.com.apk";
		 String prernaredimi="6a94c369";
	//	 String manpreet="BMJ7U4F6MNIJTC7H";
	     cap = new DesiredCapabilities();
	   //  cap.setCapability(CapabilityType.BROWSER_NAME, "");
	//     cap.setCapability(CapabilityType.PLATFORM, "Android");
	     //cap.setCapability("VERSION", "5.1.1 LMY47V");
	     cap.setCapability("deviceName", prernaredimi);
	     cap.setCapability("appium-version","1.4.16.1");
	     //cap.setCapability("platformName","Android");
	     //cap.setCapability("appPackage", "org.wordpress.android-1/base");
	     //cap.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchactivity");
	    // cap.setCapability("app",app.getAbsolutePath());
	   //  driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	     driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	     
	    // driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	    // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	}
	
	
	
	@Test()
	  public void ValidLogin() throws InterruptedException {
		   //description="Enters valid data"
		  Thread.sleep(3000); 
		  LoginMobile login=new LoginMobile(driver);
		  login.loginToWordPress("ruc123", "ru12@#chi");
		  Thread.sleep(3000); 
	 }
	
	@Test()
	public void ValidMedia() throws InterruptedException {
 
	//  Login login=new Login(driver);
	  //login.loginToWordPress("ruc123", "ru12@#chi");
	// Thread.sleep(3000);
	  MediaMobile media=new MediaMobile(driver);
	  media.Mediauploadimage();
	  
	  Thread.sleep(3000);
	  LogOutMobile l=new LogOutMobile(driver);
	  l.Logout();
	  //driver.findElement(By.id("org.wordpress.android:id/nux_username")).sendKeys("ruc123");
 // driver.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
  //driver.findElement(By.id("org.wordpress.android:id/nux_password")).sendKeys("ru12@#chi");
  //driver.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
  
 
  
  }
	
	@Test()
	  public void WrongLogin() throws InterruptedException, IOException {
	      
		  LoginMobile login=new LoginMobile(driver);
		  login.loginToWordPress("prerna", "ru12@#chi");
		  Thread.sleep(5000);
		
	 }

/*	@Test()
	public void d() throws InterruptedException {
      Post post=new Post(driver);
      post.BlogPost();
   
	}*/
	
	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	 
	 // Here will compare if test is failing then only it will enter into if condition
	     if(ITestResult.FAILURE==result.getStatus())
	     {
	           try 
	           {
	                // Create refernce of TakesScreenshot
	                TakesScreenshot ts=(TakesScreenshot)driver;
	 
	               // Call method to capture screenshot
	                File source=ts.getScreenshotAs(OutputType.FILE);
	 
	                // Copy files to specific location here it will save all screenshot in our project home directory and
	                // result.getName() will return name of test case so that screenshot name will be same
	                FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
	 
	                System.out.println("Screenshot taken");
	           } 
	           catch (Exception e)
	           {
	 
	        	   System.out.println("Exception while taking screenshot "+e.getMessage());
	           } 
	 
	 
	 
	     }
	}
	
}