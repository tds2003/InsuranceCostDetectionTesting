package MyMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsuranceBruteTesting{
	@Test()
	public void case1() throws InterruptedException{
	ChromeOptions options = new ChromeOptions();
	options.setAcceptInsecureCerts(true);
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	LaunchApplication LA = new LaunchApplication(driver);
	LA.hitApplication();
	Thread.sleep(9000);
	Frame F = new Frame(driver);
	F.switchToFrame();
	InputFileCases IFC = new InputFileCases(driver);
	//IFC.inputProvider();
	Thread.sleep(3000);
	String Range = driver.findElement(By.cssSelector("div[class='stAlert'] div div div div p")).getText();
	System.out.println(Range);
	String childTextBox = driver.findElement(By.xpath("//input[@aria-label='Number Of Children']")).getText();
	
	if(childTextBox.isBlank()) {
		System.out.println("childTextBox is null");
	}
	if(Range.contains("Invalid")) {
		Assert.assertTrue(false);
	}
	
	}
}