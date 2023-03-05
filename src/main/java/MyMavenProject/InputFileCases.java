package MyMavenProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class InputFileCases {
	WebDriver driver;
	public InputFileCases(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[aria-label='Age']")
	WebElement Age;
	
	@FindBy(xpath="//div[@aria-label='Gender']//label[1]")
	WebElement Gender;
	
	@FindBy(xpath="//input[@aria-label='Height (in Cm) ']")
	WebElement Height;
	
	@FindBy(xpath="//input[@aria-label='Weight (in Kg) ']")
	WebElement Weight;
	
	@FindBy(xpath="//input[@aria-label='Number Of Children']")
	WebElement noOfChildren;
	
	@FindBy(xpath="//div[contains(@aria-label,'Are you a Smoker ?')]//label[2]")
	WebElement smokingState;
	
	@FindBy(xpath="//div[@aria-label='Region (In US)']//label[1]//div[2]")
	WebElement Region;
	
	@FindBy(xpath="(//button[@class='css-6kekos edgvbvh9'])[1]")
	WebElement Submit;
	
	
	public void ageProvider(String age) throws InterruptedException {
		Age.sendKeys(age);
		String enteredAge = Age.getText();
		if(enteredAge == null) {
			System.out.println("Age field is null");
		}
	}
	public void genderProvider() {
		Gender.click();
	}
	public void heightProvider(String height) {
		Height.sendKeys(height);
		String enteredHeight = Height.getText();
		if(enteredHeight == null) {
			System.out.println("Height field is null");
		}
	}
	public void weightProvider(String weight) {
		Weight.sendKeys(weight);
		String enteredWeight = Weight.getText();
		if(enteredWeight == null) {
			System.out.println("Weight field is null");
	    }
    }
	public void noOfChildrenProvider(String childCount) {
		noOfChildren.sendKeys(childCount);
		String enteredChildren = noOfChildren.getText();
		if(enteredChildren == null) {
			System.out.println("childTextBox is null");
	    }
	}
	public void smokeTestProvider() {
		smokingState.click();
	}
	public void regionTestProvider() {
		Region.click();
	}
	public void submitTestProvider() {
	     Submit.click();
	}
}