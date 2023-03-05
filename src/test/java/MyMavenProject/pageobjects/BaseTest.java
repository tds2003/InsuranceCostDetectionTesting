package MyMavenProject.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties() ;
		FileInputStream fis = new FileInputStream("C:\\Users\\sarav\\seleniumTesting\\InsuranceCostDetectionTesting\\src\\main\\java\\MyMavenProject\\resourses\\Test.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			
		}
		else if(browserName.equalsIgnoreCase("edge")){
			
		}
		
		return driver;
		
	}
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file =new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDownTest(){
		driver.quit();
	}
	public void hitInBrowser() {
		driver.get("https://health-insurance-cost-predictor-k19.streamlit.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ChromeOptions options = new ChromeOptions();
    	options.setAcceptInsecureCerts(true);
	}
	

}
