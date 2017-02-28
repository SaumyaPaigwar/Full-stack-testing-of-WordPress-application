package main.java.com.util.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class PostMobile {
	 static AppiumDriver driver;
	 Dimension size;
	 By wordpress=By.id("org.wordpress.android:id/tab_icon");
	 By postedit=By.id("org.wordpress.android:id/fab_button");
     By title=By.id("org.wordpress.android:id/format_bar_button_media");
  
	 By publish=By.id("org.wordpress.android:id/menu_save_post");
	 By html=By.id("org.wordpress.android:id/format_bar_button_html");
	 By multiselect=By.name("Multi-select with the new picker");
	 By gallery=By.id("org.wordpress.android:id/format_bar_button_media");
	 By deviceimages=By.id("Device Images");
	 
	 By image=By.id("org.wordpress.android:id/image_view_background");
	 public PostMobile(AppiumDriver driver){

	        this.driver = driver;

	   }
	 public void BlogPost() throws InterruptedException{
		 driver.findElement(wordpress).click();
		  WebElement chk=driver.findElement(By.id("org.wordpress.android:id/my_site_title_label"));
			Boolean iselementpresent = driver.findElementsById("org.wordpress.android:id/my_site_title_label").size()!=0;
			  //iselementpresent will be true so assertion will pass and so test method will pass too.
			Assert.assertTrue(iselementpresent,"Targeted element App is not present on screen");
			
			driver.findElement(postedit).click();
			
			
			Thread.sleep(5000);
			driver.findElement(html).click();
			driver.findElement(html).click();
			driver.findElement(gallery).click();
			driver.findElement(multiselect).click();
		//	driver.findElement(deviceimages).click();
			
			//Thread.sleep(5000);
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
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			  driver.swipe(startx, starty, startx, endy, 3000);
			//driver.findElement(title).click();
			Thread.sleep(5000);
		//	driver.findElement(publish).click();
			
			//checking it is on first tab
			driver.findElement(image).click();
				
			
	 }
}
