package test.java.Integration.FunctionalRest;

import test.java.Integration.FunctionalRest.LogOut;


import main.java.com.util.pages.Dashboard;
import main.java.com.util.pages.Login;
import main.java.com.util.pages.Media;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class LoginTestCase {
	
   WebDriver driver;
	
   private String baseUrl;
     Dashboard dashboard;
	 Media media; 
	  @BeforeMethod
	@BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	   // driver = new FirefoxDriver();
	    baseUrl = "http://localhost:85/WordPress/wp-login.php?";
	  }
  
  @Test(dataProvider = "dp")
  public void login(String n, String s) throws InterruptedException, AWTException {
	
	 // driver.get(baseUrl);
	 
	 // driver.manage().window().maximize();
	  Assert.assertEquals(driver.getTitle(), "Persistent_QE ‹ Log In");
	  Login login=new Login(driver);
	  login.loginToWordPress(n, s);
	  LogOut logout = new LogOut(driver);
	  logout.clickLogOutLink();
	 // System.out.println("Working on this first");
  }

  @Test(dependsOnMethods =("login") , dataProvider = "dp")
  public void dashboard(String n, String s) throws InterruptedException, AWTException{
	 // driver.get(baseUrl);
	 // driver.manage().window().maximize();
	  Assert.assertEquals(driver.getTitle(), "Persistent_QE ‹ Log In");
	  System.out.println("Over here");
	  Login login=new Login(driver);
	  login.loginToWordPress(n, s);
	  dashboard= new Dashboard(driver);
boolean presence = 	IsElementPresent(By.tagName("h1"));
System.out.println("Presence is : "+presence);
if(presence == false){
	Assert.fail();
}	
else {
	  //System.out.println("Hi manpreet");
	  //System.out.println(driver.getTitle());
	  dashboard.quickDraft("hello there", "QE");
	 List<WebElement> listofwebe= driver.findElements(By.tagName("li"));
	 System.out.println("No of Elements are" +listofwebe.size());
}
LogOut logout = new LogOut(driver);
logout.clickLogOutLink();
Thread.sleep(3000);
  }
  
  private boolean IsElementPresent(By by) {
try {
	driver.findElement(by);
return true;
}
catch(Exception e){
	System.out.println("Element not found");
	return false;
}
	  
	  
	  
	  // TODO Auto-generated method stub
	
}
/*
@Test(dependsOnMethods = ("dashboard") ,dataProvider = "dp")
  public void media(String n, String s) throws IOException, InterruptedException, AWTException{
	  boolean flag = false;
	 //driver.get(baseUrl);
	 // driver.manage().window().maximize();
	  Assert.assertEquals(driver.getTitle(), "Persistent_QE ‹ Log In");
	  Login login=new Login(driver);
	  login.loginToWordPress(n, s);
	
	
	
	
	
	
	
	
	 
	 // Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/h1")).getText(), "Media Library Add New");
	  ReadFile readfile = new ReadFile();
	List<List<Cell>> mediadata = readfile.readingfile("input_data\\Xlsx\\", "WordPress.xls", "MediaSheet");
	List<List<Cell>> logindata = readfile.readingfile("input_data\\Xlsx\\", "WordPress.xls", "Login");
	
	//C:\FunctionalRest\input_data\Xlsx\WordPress.xlsx
	for (List<Cell> user :logindata){
		if(user.get(0).getStringCellValue().equals(n)){
			if(user.get(3).getStringCellValue().equals("Yes"))
			flag = true;
			break;
		}
	}
	
	
	if(flag == true){
		 
		  media = new Media(driver);
		  System.out.println("Baade size is over here :"+mediadata.size());
	for(int i =1;i<mediadata.size();i++){
		driver.findElement(By.linkText("Media")).click();
		//List<Cell> listcell = mediadata.get(i).get(1);
		//System.out.println("Type of file :" +listcell.get(0));
		//media.addNewMedia(listcell.get(1).getStringCellValue());
		System.out.println("****************");
	System.out.println(mediadata.get(i).get(1));
	media.addNewMedia(mediadata.get(i).get(1).getStringCellValue());
	}
	}
	  LogOut logout = new LogOut(driver);
	  logout.clickLogOutLink();
  }
  */
  @DataProvider
  public Object[][] dp() {
 	
    	 ReadFile r = new ReadFile();
    	
    	 List<List<Cell>> datalist=new ArrayList();
    	 
    	 datalist=r.readingfile("input_data\\Xlsx\\","WordPress.xls","Login");
    	System.out.println(datalist);
    	  
 	
    		System.out.println(datalist.get(1).get(2));
    	    System.out.println(datalist.get(0).get(1));
    	    System.out.println(datalist.get(2).get(0));
    	 	System.out.println(datalist.get(3).get(0));
    	  	System.out.println(datalist.get(4).get(0));
    	  
    	 	Object[][] data=new Object[4][2];
    		
    		//row1
    		data[0][0]=datalist.get(1).get(0).getStringCellValue();
    		data[0][1] = datalist.get(1).get(1).getStringCellValue();
    		data[1][0]=datalist.get(2).get(0).getStringCellValue();
    		data[1][1]=datalist.get(2).get(1).getStringCellValue();
    	    data[2][0]=datalist.get(3).get(0).getStringCellValue();
    		data[2][1]=datalist.get(3).get(1).getStringCellValue();
    		data[3][0]=datalist.get(4).get(0).getStringCellValue();
    		data[3][1]=datalist.get(4).get(1).getStringCellValue();
    		System.out.println("Value of password for qe_batch is :"+data[3][1] );
    		return data;
    	
        
}
  
  
  
  @Test(dependsOnMethods = ("login") ,dataProvider ="dp")
  public void accessibility (String n, String s) throws InterruptedException, AWTException{
	  
	 // driver.get(baseUrl);
	  //driver.manage().window().maximize();
	  Assert.assertEquals(driver.getTitle(), "Persistent_QE ‹ Log In");
	  Login login=new Login(driver);
	  login.loginToWordPress(n, s);
	  boolean success= false ;
	  
	  String checkfrominputfile = null;
	  
//driver.findElement(By.cssSelector("div.wp-menu-name"));
ReadFile readfile = new ReadFile ();	  

success = false;
String stepstobefollowed =null;
//=inputlistiterator.next().get(2).getStringCellValue();  
	  


	WebDriverWait wait = new WebDriverWait(driver,10);
	
		Actions builder = new Actions(driver);
		
		List<List<Cell>> logindata = readfile.readingfile("input_data\\Xlsx\\", "WordPress.xls", "Login");
		List<WebElement> dropdownlist =null;
		
		for (List<Cell> user :logindata){
			
			if(user.get(0).getStringCellValue().equals(n)){
				if(user.get(4).getStringCellValue().equals("Class")){
					
					stepstobefollowed = user.get(2).getStringCellValue();
					String arrstepstobefollowed[] = stepstobefollowed.split(":");
					builder.moveToElement(driver.findElement(By.linkText(arrstepstobefollowed[0]))).build().perform();
					checkfrominputfile=arrstepstobefollowed[2];
					dropdownlist = driver.findElements(By.className(user.get(5).getStringCellValue()));
				break;
			}
			
					if(user.get(4).getStringCellValue().equals("linkText")){
						
						 stepstobefollowed = user.get(2).getStringCellValue();
						 String arrstepstobefollowed[] = stepstobefollowed.split(":");
						 builder.moveToElement(driver.findElement(By.linkText(arrstepstobefollowed[0]))).build().perform();
						 checkfrominputfile=arrstepstobefollowed[2];
							dropdownlist = driver.findElements(By.linkText(user.get(5).getStringCellValue()));
					break;
				}
				
		}
		}
			
		
		//builder.moveToElement(driver.findElement(By.linkText(arrstepstobefollowed[0]))).build().perform();
		
		Iterator<WebElement> dropdowniterator = dropdownlist.iterator();
	    while(dropdowniterator.hasNext()){
	    	String checkwith = dropdowniterator.next().getText();
	    	System.out.println("The value over here is :"+checkwith);
	    	if(checkwith.equals(checkfrominputfile)){
	  success = true ;
	  System.out.println("------qwerty-----");
	    		break;
	    	}
	    	
	    	System.out.println("Value of success"+success);
	    	
	    }
	    System.out.println("After break :"+success);
		System.out.println("Size of drop down is :" +dropdownlist.size());
		if(success==false){
			Assert.fail();
		}
				
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(checkfrominputfile)));
		builder.moveToElement(driver.findElement(By.linkText(checkfrominputfile))).build().perform();
	
	
	 LogOut logout = new LogOut(driver);
	 logout.clickLogOutLink();
		}
	
			

  
  
 
  //@Parameters("browser")
  @BeforeTest
  // public void launchbrowser(String browser) throws MalformedURLException 
  public void launchbrowser() throws MalformedURLException  
  {
               String baseUrl = "http://localhost:85/WordPress/wp-login.php?";
               //if (browser.equalsIgnoreCase("firefox"))
               Random t = new Random();
               int num=t.nextInt(10);
               System.out.println("num is : "+num);
               if(num %2==0) {
              System.out.println(" Executing on FireFox");
                      DesiredCapabilities cap = DesiredCapabilities.firefox();
                       cap.setBrowserName("firefox");
                       driver = new RemoteWebDriver(new java.net.URL("http://10.222.40.147:4444/wd/hub"), cap);
                       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    
                    	   
                                  // Launch website
                       driver.navigate().to(baseUrl);
                       driver.manage().window().maximize();
              }
               else //if (browser.equalsIgnoreCase("chrome"))*/
               {
                    System.out.println(" Executing on CHROME");
                    //System.setProperty(key, value)
                    System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
                    DesiredCapabilities cap = DesiredCapabilities.chrome();
                     cap.setBrowserName("chrome");
                     driver = new RemoteWebDriver(new java.net.URL("http://10.222.40.147:4444/wd/hub"), cap);
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                     
                    

                     // Launch website
                     driver.navigate().to(baseUrl);
                     driver.manage().window().maximize();
                }
  }
                          
  @BeforeMethod
  public void waitforPage(){
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
}
