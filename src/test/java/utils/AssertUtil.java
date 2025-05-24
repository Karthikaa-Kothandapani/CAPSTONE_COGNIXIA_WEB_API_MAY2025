package utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class AssertUtil {

    public static void assertTrueWithLogAndExtent(SoftAssert softAssert,
                                                  boolean condition,
                                                  String checkMessage,
                                                  Logger log,
                                                  ExtentTest extentTest) {

    	String methodName = "UnknownMethod";

    	for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
    	    if (element.getClassName().contains("Test")) { // Adjust class name as needed
    	        methodName = element.getMethodName();
    	        break;
    	    }
    	}

        if (!condition) {
            log.warn("[" + methodName + "] " + checkMessage + " " + Constants.assertFailMessage);
            if (extentTest != null) {
                extentTest.fail("WARNING: " + "[" + methodName + "] " + checkMessage + " " + Constants.assertFailMessage);
            }
        } else {
            log.info("[" + methodName + "] " + checkMessage + " " + Constants.assertPassMessage);
            if (extentTest != null) {
                extentTest.pass("[" + methodName + "] " + checkMessage + " " + Constants.assertPassMessage);
            }
        }

        softAssert.assertTrue(condition, Constants.assertFailMessage);
    }
}
