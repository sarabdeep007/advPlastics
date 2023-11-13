package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getExtentReports()
	{
		String extentReportPath = System.getProperty("user.dir")+"/ExtentReports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		
		reporter.config().setReportName("Accenture Test Report");
		reporter.config().setDocumentTitle("Report By DeepSingh");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		return extent;
		
	}

}
