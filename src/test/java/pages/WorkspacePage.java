package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class WorkspacePage extends BaseTest {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(), 'Create a new form')]")
	WebElement createFormButton;
	
	public WorkspacePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	// Click Create a New Form Button
	public void clickCreateFormButton() {
		WebElement element = WaitUtil.waitForClickable(driver, createFormButton);
        WaitUtil.scrollIntoView(driver, element);
        element.click();
	}

}
