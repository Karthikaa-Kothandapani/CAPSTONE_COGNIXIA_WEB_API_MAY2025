package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class AlertUtil {

    private static final int TIMEOUT = Constants.defaultWaitTime;

    // Accept alert with log
    public static void acceptAlert(WebDriver driver, Logger log, ExtentTest extentTest ) {
        try {
            Alert alert = waitForAlert(driver);
            log.info(Constants.alertAppeared + alert.getText());
            extentTest.info(Constants.alertAppeared + alert.getText());
            alert.accept();
            log.info(Constants.alertAccepted);
            extentTest.info(Constants.alertAccepted);
        } catch (Exception e) {
            log.warn(Constants.noAlert + e.getMessage());
            extentTest.info(Constants.noAlert + e.getMessage());
        }
    }

    // Dismiss alert with log
    public static void dismissAlert(WebDriver driver, Logger log, ExtentTest extentTest) {
        try {
            Alert alert = waitForAlert(driver);
            log.info(Constants.alertAppeared + alert.getText());
            extentTest.info(Constants.alertAppeared + alert.getText());
            alert.dismiss();
            log.info(Constants.alertDismissed);
            extentTest.info(Constants.alertDismissed);
        } catch (Exception e) {
        	log.warn(Constants.noAlert + e.getMessage());
            extentTest.info(Constants.noAlert + e.getMessage());
        }
    }

    // Send input to prompt alert
    public static void enterTextInAlert(WebDriver driver, String inputText, Logger log, ExtentTest extentTest) {
        try {
            Alert alert = waitForAlert(driver);
            log.info(Constants.alertAppeared + alert.getText());
            extentTest.info(Constants.alertAppeared + alert.getText());
            alert.sendKeys(inputText);
            alert.accept();
            log.info(Constants.promptAlertAccept + inputText);
        } catch (Exception e) {
        	log.warn(Constants.noAlert + e.getMessage());
            extentTest.info(Constants.noAlert + e.getMessage());
        }
    }
    
    // Get Alert Text
    public static String getAlertText(WebDriver driver, Logger log, ExtentTest extentTest) {
    		Alert alert = waitForAlert(driver);
            log.info(Constants.alertAppeared + alert.getText());
            extentTest.info(Constants.alertAppeared + alert.getText());
            return alert.getText();
    }

    // Utility: wait for alert
    private static Alert waitForAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
