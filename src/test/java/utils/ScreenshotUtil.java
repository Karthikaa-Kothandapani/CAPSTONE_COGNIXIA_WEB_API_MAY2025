package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtil {

    private static final Logger log = Logger.getLogger(ScreenshotUtil.class);

    public static void captureScreenshot(WebDriver driver, String fileName) {
        try {
            File screenshotDir = new File("./screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                log.info("Created screenshots directory");
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotDir, fileName + ".png");
            FileUtils.copyFile(src, dest);

            if (dest.exists()) {
                log.info("Screenshot captured: " + dest.getAbsolutePath());
            } else {
                log.warn("Screenshot not saved correctly at: " + dest.getAbsolutePath());
            }

        } catch (Exception e) {
            log.error("Exception while capturing screenshot: " + e.getMessage(), e);
        }
    }
}
