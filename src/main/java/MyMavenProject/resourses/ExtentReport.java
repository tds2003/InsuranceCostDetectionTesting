package MyMavenProject.resourses;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester-1", "20ITA37-Saravanan");
		extent.setSystemInfo("Tester-2", "20ITA31-Muthu Vishal Kannan");
		extent.setSystemInfo("Tester-3", "20ITA34-Praveen");
		return extent;
	}

}
