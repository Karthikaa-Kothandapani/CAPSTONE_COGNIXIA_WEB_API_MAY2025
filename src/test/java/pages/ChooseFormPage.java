package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class ChooseFormPage extends BaseTest{
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(), 'Start from scratch')]")
	WebElement fromScratch;
	
	public ChooseFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	// Click Create a Form from Scratch Button
	public void clickCreateFromScratch() {
		WebElement element = WaitUtil.waitForClickable(driver, fromScratch);
        WaitUtil.scrollIntoView(driver, element);
        element.click();
	}
	
	// Check if Create Form from scratch is Displayed
	public boolean isCreateFromStrachPresent() {
		return WaitUtil.waitForVisible(driver, fromScratch).isDisplayed();
	}

}
