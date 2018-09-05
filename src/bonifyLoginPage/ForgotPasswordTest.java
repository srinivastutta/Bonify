package bonifyLoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest {


WebDriver driver;
	
	@BeforeClass
	public void SetUp() {
		driver=new FirefoxDriver();
		driver.get("https://my.bonify.de");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void ForgetPass(){
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("srinivas.tutta@gmail.com");
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div[2]/div/form/div[3]/a/span")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("srinivas.tutta@gmail.com");
		driver.findElement(By.xpath("//button[@class='btn-flat-cta btn-flat-cta-default']")).click();
	}
	
	@AfterClass
	public void TearDown(){
		driver.quit();
	}	
}