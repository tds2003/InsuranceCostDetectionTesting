package MyMavenProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MyMavenProject.pageobjects.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InsuranceBruteTesting2 extends BaseTest{
	WebDriver driver;
	
	
	@Test(priority=1)
	public void hittingBrowser() throws IOException {
		driver = initializeDriver();
		hitInBrowser();
		
	}
	@Test(priority=2)
	public void enterIntoFrame() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		Thread.sleep(2000);

	}
	@Test(priority=3)
	public void ageFieldTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.ageProvider("19");
		Thread.sleep(2000);
	
		
	}
	@Test(priority=4)
	public void genderFieldTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.genderProvider();
		Thread.sleep(2000);
		
	}
	@Test(priority=5)
	public void heightFieldTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.heightProvider("159");
		Thread.sleep(2000);
		
	}
	@Test(priority=6)
	public void weightFieldTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.weightProvider("59");
		Thread.sleep(2000);
		
	}
	@Test(priority=7)
	public void numberOfChildrenFieldTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.noOfChildrenProvider("0");
		Thread.sleep(2000);
		
	}
	@Test(priority=8)
	public void smokerTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.smokeTestProvider();
		Thread.sleep(2000);
		

	}
	@Test(priority=9)
	public void regionTest() throws InterruptedException, IOException {
    	driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.regionTestProvider();
		Thread.sleep(2000);
		
	}
	@Test(priority=10)
	public void brokenLinkTest() throws InterruptedException, IOException {
		driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		String url = driver.findElement(By.cssSelector("a[href='https://fake-news-detector-k19.streamlit.app/']")).getAttribute("href");
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		Thread.sleep(2000);
		conn.setRequestMethod("HEAD");
		conn.connect();
		int responseCode = conn.getResponseCode();
		System.out.println(responseCode);
	}	
}