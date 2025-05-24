package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentTestListener implements ITestListener {

    private static final Logger log = Logger.getLogger(ExtentTestListener.class);
    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = testThread.get();
        test.fail(result.getThrowable());

        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;

        if (driver == null) {
            log.error("WebDriver was null at the time of failure!");
            test.warning("Unable to capture screenshot — WebDriver is null");
            return;
        }

        String methodName = result.getName();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = methodName + "_" + timestamp;
        String screenshotPath = "../screenshots/" + screenshotName + ".png";


        ScreenshotUtil.captureScreenshot(driver, screenshotName);

        File screenshotFile = new File(screenshotPath);
        if (screenshotFile.exists()) {
        	test.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
            log.info("Screenshot attached to ExtentReport: " + screenshotFile.getAbsolutePath());
        } else {
            log.warn("Screenshot file was not found at: " + screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().skip("Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
