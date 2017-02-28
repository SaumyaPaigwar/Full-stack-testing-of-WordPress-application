package main.java.com.util.pages;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MediaMobile {

	 static AppiumDriver driver;
	 Dimension size;
	 By wordpress=By.id("org.wordpress.android:id/tab_icon");
	 By username = By.id("org.wordpress.android:id/my_site_subtitle_label");
	 By media=By.name("Media");
	 By plusbutton=By.id("org.wordpress.android:id/menu_new_media");
	 By select=By.name("Select a photo from gallery");
	 
	 By gallery=By.name("Gallery");
	 By video=By.name("Video files");
	 By album=By.name("Albums");
	 By folder=By.name("WhatsApp Images");
	 By img=By.id("com.miui.gallery:id/pick_num_indicator");
	 By back=By.className("android.widget.ImageButton");
	 
	 By videogallery=By.name("Select a video from gallery");
	 By videoname=By.name("VID_20161123_101712.mp4");
	 By ok=By.name("OK");
	 
	 
	 
	 By capture=By.name("Capture photo");
	 By camera=By.name("Camera");
	
	 By capturebutton=By.id("com.android.camera:id/v6_shutter_button_internal");
	 By tick=By.id("com.android.camera:id/v6_btn_done");
	 
	// By img=By.id("com.miui.gallery:id/indicator_container");
	 public MediaMobile(AppiumDriver driver){

	        this.driver = driver;

	   }
	 
	  public void Mediauploadimage() throws InterruptedException{
		  
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(wordpress).click();
		 //Assertion to check if logged in or not 
		  WebElement chk=driver.findElement(By.id("org.wordpress.android:id/my_site_title_label"));
			Boolean iselementpresent = driver.findElementsById("org.wordpress.android:id/my_site_title_label").size()!=0;
			  //iselementpresent will be true so assertion will pass and so test method will pass too.
			Assert.assertTrue(iselementpresent,"Targeted element App is not present on screen");
		 
		  Thread.sleep(3000);
		  driver.findElement(media).click();
		  Thread.sleep(3000);
		  driver.findElement(plusbutton).click();
		  Thread.sleep(3000);
		  
		  
		 
		    driver.findElement(select).click();
		  
		  driver.findElement(gallery).click();
		
		  driver.findElement(album).click();
		  System.out.println("-------------------------------");
		 /* WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/a"));
		  Thread.sleep(3000);

		  Actions moveSlider = new Actions(driver);
		 // Action action = moveSlider.dragAndDropBy(slider, 0, 30).build();
		  Action action = moveSlider.dragAndDropBy(slider, 10, 100).build();

		  action.perform();*/
		 Thread.sleep(3000);
		//Get the size of screen.
		//Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.80);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		  //Swipe from Bottom to Top.
		  driver.swipe(startx, starty, startx, endy, 3000);
		  driver.swipe(startx, starty, startx, endy, 3000);
		  driver.swipe(startx, starty, startx, endy, 3000);
		  Thread.sleep(2000);
		  //Swipe from Top to Bottom.
		//  driver.swipe(startx, endy, startx, starty, 3000);
	//	  Thread.sleep(2000);
		  driver.findElement(folder).click();
		  driver.findElement(img).click();
		  Thread.sleep(8000);
		  /******************************CAPTURING PHOTO**********************************************/
		  driver.findElement(plusbutton).click();
		  Thread.sleep(3000);
		  Thread.sleep(3000);
		  driver.findElement(capture).click();
		  driver.findElement(camera).click();
		  Thread.sleep(3000);
		  driver.findElement(capturebutton).click();
		  Thread.sleep(3000);
		  driver.findElement(tick).click();
		  Thread.sleep(3000);
		  
		  /**********************************SELECTING VIDEO FROM GALLERY***********************************************/
		  driver.findElement(plusbutton).click();
		  Thread.sleep(3000);
		  driver.findElement(videogallery).click();
		  driver.findElement(video).click();
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty1 = (int) (size.height * 0.80);
		  //Find endy point which is at top side of screen.
		  int endy1 = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx1 = size.width / 2;
		  System.out.println("starty1 = " + starty1 + " ,endy1 = " + endy1 + " , startx1 = " + startx1);

		  //Swipe from Bottom to Top.
		  driver.swipe(startx1, starty1, startx1, endy1, 3000);
		  driver.swipe(startx1, starty1, startx1, endy1, 3000);
		  driver.swipe(startx1, starty1, startx1, endy1, 3000);
		  driver.swipe(startx1, starty1, startx1, endy1, 3000);
		  driver.swipe(startx1, starty1, startx1, endy1, 3000);
		
		  Thread.sleep(1000);
		  
		  driver.findElement(videoname).click();
		  driver.findElement(ok).click();
		  /**********************************************************************************************/
		  Thread.sleep(5000);
	      driver.findElement(back).click();
		  
		  
	  }
			  

	
}
