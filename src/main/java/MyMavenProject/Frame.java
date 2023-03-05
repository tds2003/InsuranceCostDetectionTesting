package MyMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Frame {
	WebDriver driver;
	public Frame(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void switchToFrame() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='streamlitApp']")));
	}		
}
