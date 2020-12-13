package test.qa;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class AppTest {
	
	 
	@Test
	
	public void createEvent() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","/Users/Mahmed/Downloads/chromedriver_mac64" );
		WebDriver driver = new ChromeDriver();
	   //WebDriver driver = new SafariDriver();
	    driver.get("https://portal-staging.parent.cloud/login");
	    driver.manage().window().maximize();
	    
//login to the portal 
	    WebElement username= driver.findElement(By.xpath("//*[@id=\"txtEmail\"]"));      //locate the user email field 
	    WebElement password= driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));   //locate the password field 
	    WebElement login= driver.findElement(By.id("submitBtn"));                        //locate the login button
	     
	    username.sendKeys("demo@parent.eu"); //send the user name 
	    password.sendKeys("12345678"); //send the password
	    login.click(); //click on the login button
	    
	    Thread.sleep(9000);
	    //click on the kinds place institute
	    WebElement kidsplace= driver.findElement(By.cssSelector("body > app-root > app-main-layout > main > app-institution > div > div.institutions.col-md > div > div.institution-details__content > div:nth-child(1) > div.data-cell.title-cell.list__item-row > div > div > div.institution__name"));
	    kidsplace.click();
	    //allow the notification pop-up
	    WebElement allow= driver.findElement(By.id("onesignal-slidedown-allow-button"));
	    allow.click();
	    Thread.sleep(9000);
	    
	    //click on the calender 
	    WebElement calender= driver.findElement(By.xpath("//*[@id=\"calendarTab\"]/i"));
	    calender.click();
	    Thread.sleep(5000);
	    //click on create event
	    WebElement createEvent= driver.findElement(By.xpath("//*[@id=\"createEventBtn\"]/span[2]"));
	    createEvent.click();
	    Thread.sleep(5000);
	    
	    //send the event title
	    WebElement Eventtitle= driver.findElement(By.xpath("//*[@id=\"eventTitle\"]"));
	    Eventtitle.sendKeys("Mahmoud Test");
	    
	    //send the Recipients
	    WebElement Recipients= driver.findElement(By.xpath("//*[@id=\"Recipients\"]/div/span"));
	    Recipients.click();
	    WebElement Recipients1= driver.findElement(By.xpath("//*[@id=\"option_0\"]/div/p"));
	    Recipients1.click();
	   
	 //choose certain date
	  By selectdate = By.cssSelector("body > app-root > app-main-layout > main > app-create-event > div > div.event__content > form > div > div > prt-date-picker > div > div");
	  WebElement choosedate = driver.findElement(selectdate);
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , choosedate);
	  Thread.sleep(5000);
	  By selectday = By.cssSelector("body > bs-datepicker-container > div > div > div > div > bs-days-calendar-view > bs-calendar-layout > div.bs-datepicker-body > table > tbody > tr:nth-child(4) > td:nth-child(3) > span");
	  WebElement day = driver.findElement(selectday);
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , day);
	  
	  //choose certain period 
	  WebElement from= driver.findElement(By.xpath("//*[@id=\"timepickerStartTime\"]"));
	  from.sendKeys("12:00 AM");;
	  Thread.sleep(5000);
	  
	  //scroll down
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("scrollBy"+ "(0,4000)");
      Thread.sleep(5000);
      //create event 
	  By submit = By.cssSelector("#submitCreateEventBtn");
	  WebElement save = driver.findElement(submit);
	  ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , save);
	
	  System.out.println("Calender booked");
	 // String title = driver.getTitle();
	  //Assert.assertEquals(title, "Mahmoud Test");
	  driver.quit();
	   
	   
}
}