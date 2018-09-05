package bonifyLoginPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task3_LoginPageValidation {
	
WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		driver=new FirefoxDriver();
		driver.get("https://my.bonify.de");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
}
	//To Validate Registration Page
	@Test
	public void RegistrationPgValidation() throws InterruptedException{
		
		driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div/form/div[4]/div[2]/a/button/div")).click();
		Thread.sleep(3000);
		String RegTitle=driver.getTitle();
		System.out.println(RegTitle);
		Assert.assertEquals(RegTitle,"bonify");
		
}
	//To validate Forget Page
	@Test
	public void ForgetPassValidation() throws InterruptedException{
	
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/div[2]/div/form/div[3]/a/span")).click();
		Thread.sleep(3000);
		String actual=driver.findElement(By.xpath(".//*[@id='step-{{$index}}']/div/form/h1")).getText();
		Assert.assertEquals(actual,"Email senden");
		
	}
	@AfterMethod
	public void TearDown(){
		
		driver.close();

	}
}

