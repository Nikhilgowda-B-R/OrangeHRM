package orange.hRM.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	public static ExtentReports  getReporterObeject() {
		
		String path = System.getProperty("user.dir")+"\\reports\\TestReport("+System.currentTimeMillis()+").html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Orange HRM Test report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikhil gowda B R");
		return extent;
		
	}
}
