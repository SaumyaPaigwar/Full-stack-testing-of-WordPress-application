package main.java.com.util.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
public class Dashboard {

	
WebDriver driver;
String title,message;
	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void setTitle(String title) {
	WebElement webe = driver.findElement(By.cssSelector("input#title"));
        webe.click();
        webe.sendKeys(title);
		
	}



	public void setMessage(String message) {
	driver.findElement(By.cssSelector("textarea#content")).sendKeys(message);
	}


	public void quickDraft(String message ,String title ){
setTitle(title);
setMessage(message);
driver.findElement(By.id("save-post")).click();
	
	}


	public void gotoMediaPage(){
	driver.findElement(By.linkText("Media")).click();	
	}
	
	
	
	
	
	
	
	
	
	
}
