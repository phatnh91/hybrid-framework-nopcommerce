package takeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir")+ File.separator + "screenShotImg" + File.separator;
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Object testClass = result.getInstance();
		driver = ((TakeScreenshotTestFailed) testClass).getWebDriver();
		//Convert WebDriver object to TakeScreenshot
				TakesScreenshot scrShot = ((TakesScreenshot)driver);
				//Call getScreenshotAs method to create image file 
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				//Move image file to new destination
				File DestFile = new File(projectLocation + result.getName() + ".png");
				//Copy file at destination
				try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
