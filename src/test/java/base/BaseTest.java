package base;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.WorkspacePage;
import pages.ChooseFormPage;
import pages.CreationPage;
import pages.PreviewFormPage;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    protected LoginPage login;
    protected WorkspacePage workspace;
    protected ChooseFormPage chooseForm;
    protected CreationPage form;
    protected PreviewFormPage view;
    public Logger log = Logger.getLogger("Capstone");

    @BeforeClass
    public void setup() {
        ConfigReader.loadConfig();
        PropertyConfigurator.configure("src/test/resources/log4j.properties");

        String browser = ConfigReader.get("browser").toLowerCase();
        String headless = ConfigReader.get("headless").toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless.equals("true")) {
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                log.info("Chrome started in " + (headless.equals("true") ? "headless" : "headed") + " mode.");
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless.equals("true")) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                log.info("Firefox started in " + (headless.equals("true") ? "headless" : "headed") + " mode.");
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless.equals("true")) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                log.info("Edge started in " + (headless.equals("true") ? "headless" : "headed") + " mode.");
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        log.info("Navigating to URL: " + ConfigReader.get("url"));
        driver.get(ConfigReader.get("url"));
        
        
        // Create a page objects
     	login = new LoginPage(driver);
     	workspace = new WorkspacePage(driver);
     	chooseForm = new ChooseFormPage(driver);
     	form = new CreationPage(driver);
     	view = new PreviewFormPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed.");
        }
    }
}
