package pages;

import base.BaseTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class LoginPage extends BaseTest {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    WebElement userEmailInputField;

    @FindBy(xpath = "//button[@id='email-continue']")
    WebElement emailContinueButton;

    @FindBy(xpath = "//input[@id='password']")
    WebElement userPasswordInputField;

    @FindBy(xpath = "//button[@id='login-password']")
    WebElement loginContinueButton;
    
    @FindBy(xpath = "//span[@role='alert']")
    WebElement emailInvalidAlert;
    
    @FindBy(xpath = "//div[text()='My workspace']")
    WebElement dashboardText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==== Email Field ====
    public boolean isEmailFieldVisible() {
        return WaitUtil.waitForVisible(driver, userEmailInputField).isDisplayed();
    }

    public boolean isEmailFieldEnabled() {
        return WaitUtil.waitForClickable(driver, userEmailInputField).isEnabled();
    }

    public void enterUserEmail(String userEmail) {
        WebElement element = WaitUtil.waitForVisible(driver, userEmailInputField);
        WaitUtil.scrollIntoView(driver, element);
    	element.clear();
    	userEmailInputField.sendKeys(userEmail);
    }

    // ==== Password Field ====
    public boolean isPasswordFieldVisible() {
        return WaitUtil.waitForVisible(driver, userPasswordInputField).isDisplayed();
    }

    public boolean isPasswordFieldEnabled() {
        return WaitUtil.waitForClickable(driver, userPasswordInputField).isEnabled();
    }

    // WaitUtil.waitForClickable(driver, userPasswordInputField);
    public void enterUserPassword(String userPassword) throws InterruptedException {
        WaitUtil.waitForPageToLoad(driver); // 👈 added
        WebElement element = userPasswordInputField;
        WaitUtil.scrollIntoView(driver, element);
        element.sendKeys(userPassword);
        Thread.sleep(1000);
    }

    // ==== Email Continue Button ====
    public boolean isEmailContinueButtonDisplayed() {
        return WaitUtil.waitForVisible(driver, emailContinueButton).isDisplayed();
    }

    public boolean isEmailContinueButtonEnabled() {
        return WaitUtil.waitForClickable(driver, emailContinueButton).isEnabled();
    }

    public void emailContinueButtonClick() {
        WebElement element = WaitUtil.waitForClickable(driver, emailContinueButton);
        WaitUtil.scrollIntoView(driver, element);
        element.click();
    }

    public String emailContinueButtonText() {
        return WaitUtil.waitForVisible(driver, emailContinueButton).getText();
    }

    // ==== Login Continue Button ====
    public boolean isLoginContinueButtonDisplayed() {
        return WaitUtil.waitForVisible(driver, loginContinueButton).isDisplayed();
    }

    public boolean isLoginContinueButtonEnabled() {
        return WaitUtil.waitForClickable(driver, loginContinueButton).isEnabled();
    }

    public void loginContinueButtonClick() {
    	WebElement element = WaitUtil.waitForClickable(driver, loginContinueButton);
        WaitUtil.scrollIntoView(driver, element);
        element.click();
    }

    public String loginContinueButtonText() {
        return WaitUtil.waitForVisible(driver, loginContinueButton).getText();
    }
    
    public String dashboardOpen() {
    	return WaitUtil.waitForVisible(driver, dashboardText).getText();
    }
    

    // ==== Page Title ====
    public String getPageTitle() {
        WaitUtil.waitForPageToLoad(driver);
        return driver.getTitle();
    }
    
    // ==== Alert ====
    public String emailInvalidAlert() {
    	return WaitUtil.waitForVisible(driver, emailInvalidAlert).getText();
    }
    
    public String passwordInvalidAlert() {
    	return WaitUtil.waitForVisible(driver, emailInvalidAlert).getText();
    }
    
    public boolean passwordInvalidAlertPresent() {
    	return WaitUtil.waitForVisible(driver, emailInvalidAlert).isDisplayed();
    }
    
    public void clearText() {
    	userPasswordInputField.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
    	userPasswordInputField.sendKeys(Keys.BACK_SPACE);;    
    	}
}
