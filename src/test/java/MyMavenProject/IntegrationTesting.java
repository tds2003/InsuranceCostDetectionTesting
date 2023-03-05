package MyMavenProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyMavenProject.Data.DataReader;
import MyMavenProject.pageobjects.BaseTest;

public class IntegrationTesting extends BaseTest{
	
	@Test(dataProvider ="getData")
	public void wholeFormTest(HashMap<String,String> input) throws InterruptedException, IOException {
		driver = initializeDriver();
		hitInBrowser();	
		Thread.sleep(9000);
		Frame F = new Frame(driver);
		F.switchToFrame();
		InputFileCases IFC = new InputFileCases(driver);
		IFC.ageProvider(input.get("age"));
		IFC.genderProvider();
		IFC.heightProvider(input.get("height"));
		IFC.weightProvider(input.get("weight"));
		IFC.noOfChildrenProvider(input.get("noOfChildren"));
		IFC.smokeTestProvider();
		IFC.regionTestProvider();
		IFC.submitTestProvider();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map = new HashMap<String,String>();
//			map.put("age","19");
//			map.put("height","159");
//			map.put("weight","159");
//			map.put("noOfChildren","0");
//			
//			HashMap<String,String> map2 = new HashMap<String,String>();
//			map2.put("age","20");
//			map2.put("height","160");
//			map2.put("weight","100");
//			map2.put("noOfChildren","3");
		DataReader DR = new DataReader();
			List<HashMap<String,String>> data = DR.scanJsonData();
			return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}
