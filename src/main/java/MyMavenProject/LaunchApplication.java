package MyMavenProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LaunchApplication {
	WebDriver driver;
	public LaunchApplication(WebDriver driver) {
		this.driver=  driver;
		PageFactory.initElements(driver, this);
	}
	
	public void hitApplication() {
		driver.get("https://health-insurance-cost-predictor-k19.streamlit.app/");
	}
	

}
