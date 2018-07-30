package testng1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver ffdriver;
	String title;
	@Test
	  public void f() throws InterruptedException {
			ffdriver.findElement(By.xpath("//*[@name='uname']")).sendKeys("admin");
			String elementvalue=ffdriver.findElement(By.xpath("//*[@name='uname']")).getAttribute("value");
			Assert.assertEquals(elementvalue,"admin");
			
			ffdriver.findElement(By.xpath("//*[@name='psw']")).sendKeys("pass");
			ffdriver.findElement(By.xpath("//*[@type='submit']")).click();
			
			title=ffdriver.getTitle();
			System.out.println(title);
		}
			
		  
	  
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			ffdriver=new FirefoxDriver(); 
		 
		  ffdriver.get("http://ec2-18-222-147-65.us-east-2.compute.amazonaws.com:8090/TestWebapp-1.0/");
		  ffdriver.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() {
		  ffdriver.close();
	  }


}
