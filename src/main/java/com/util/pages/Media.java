package main.java.com.util.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.PageFactory;

//import test.java.Integration.FunctionalRest.GridInfoExtractor;

public class Media {

	WebDriver driver ;
	
	public Media(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public void addNewMedia(String mediapath) throws IOException, InterruptedException{
driver.findElement(By.className("page-title-action")).click();
driver.findElement(By.linkText("Select Files")).click();
//SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
// String nodeHost = GridInfoExtractor.getHostNameAndPort("localhost", 4444, sessionId)[0];
// System.out.println("------------------------------------------"+nodeHost);
//String path = "C:\\Users\\Administrator\\Downloads\\psexec.exe \\\\%s -u %s -p %s -i C:\\abcd.exe "+mediapath;
//Process p = Runtime.getRuntime().exec(String.format(path,"10.222.40.147","administrator","P@ssw0rd"));
//Process p = Runtime.getRuntime().exec("C:\\Users\\Administrator\\Downloads\\psexec.exe \\10.222.40.144 -u administrator -p P@ssw0rd -i C:\\abcd.exe "+mediapath);
//p.waitFor();
Runtime.getRuntime().exec("C:\\abcd.exe"+" "+mediapath);
Thread.sleep(10000);   
}	
	
	
	
	
	
}
