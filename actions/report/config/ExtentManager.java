package report.config;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + File.separator +"extentReports"+File.separator+"ExtentReportResults.html", true);
		}
		return extent;
	}
}
