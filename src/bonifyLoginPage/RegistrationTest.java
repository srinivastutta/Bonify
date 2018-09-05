package bonifyLoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

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
	public void Register() throws InterruptedException{
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div[2]/div/form/div[4]/div[2]/a/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Tomas12342@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Tomas1234@");
		driver.findElement(By.xpath("//button[@class='btn-flat-cta btn-flat-cta-alert']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='gender']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Tommy");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Michel");
		driver.findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys("02.05.1987");
		driver.findElement(By.xpath("//input[@name='street']")).sendKeys("Gutleut Str");
		driver.findElement(By.xpath("//input[@name='houseNumber']")).sendKeys("199");
		driver.findElement(By.xpath("//input[@name='zipCode']")).sendKeys("23456");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Frankfurt");
		driver.findElement(By.xpath(".//*[@id='step-{{$index}}']/div/div/form/div[10]/button[2]")).click();
		
	}
	@AfterClass
	public void TearDown(){
		driver.quit();
				
	}	
}
