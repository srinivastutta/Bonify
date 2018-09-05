package bonifyLoginPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTest_With_Multiple_Users {
	WebDriver driver;
	
	@BeforeClass
	public void SetUp() {
		driver=new FirefoxDriver();
		driver.get("https://my.bonify.de");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		//To Access Data From Excel Sheet(DataDriven Approach)
		
	}
	@Test
	public void SignIn() throws BiffException, IOException, InterruptedException{
		//To access log in test data from Excel File 
		File fi=new File("D:\\bonifytestdata.xls");
		Workbook wb=Workbook.getWorkbook(fi);
		Sheet ws=wb.getSheet(0);
		Actions act=new Actions(driver);
		
		//for loop for valid and invalid users
		for (int i = 1; i <=ws.getRows(); i++)
		{
				driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ws.getCell(0,i).getContents());
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ws.getCell(1,i).getContents());
				driver.findElement(By.xpath("//button[@class='btn-flat-cta btn-flat-cta-default']")).click();
				Thread.sleep(3000);
				
				//Validation after login
				try{
					
					boolean Image=driver.findElement(By.xpath(".//*[@id='dashboard']/section[1]/div[1]/div/div[1]/img")).isDisplayed();
				
				if (Image==true)
				{ 
					WebElement Signout1=driver.findElement(By.xpath(".//*[@id='main-header']/div[1]/div/div[2]/button"));
			    	WebElement Signout2=driver.findElement(By.xpath(".//*[@id='main-body']/ul[1]/li[4]/button"));
				
					act.moveToElement(Signout1).click().build().perform();
					Thread.sleep(500);
					act.moveToElement(Signout2).click().build().perform();
					System.out.println("Valid Credentials --- Login Successful ");
					
				}} catch (Exception e)
				{
					System.out.println("Invalid Credentials --- Login Unsuccessful");
					driver.navigate().refresh();
					driver.get("https://my.bonify.de");
				}
			}
		wb.close();	
	}
	
	@AfterClass
	public void TearDown(){
		driver.quit();
				
	}}
