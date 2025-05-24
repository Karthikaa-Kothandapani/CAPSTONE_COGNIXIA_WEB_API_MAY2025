package pages;

import base.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class PreviewFormPage extends BaseTest{
	
	WebDriver driver;
	
	@FindBy(xpath = "(//div[@data-qa='question-wrapper'])[2]")
	WebElement form;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[2]")
	WebElement ques1;
	
	@FindBy(xpath = "//div[@data-qa='preview-form-toolbar']//button[1]")
	WebElement close;
	
	
	public PreviewFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	// Question Page Content Verification
	public String quesPage() {
		WaitUtil.waitForPageToLoad(driver);
		System.out.println(WaitUtil.waitForVisible(driver, form).getText());
		return WaitUtil.waitForVisible(driver, form).getText();
	}
	
	// Questions
	public boolean ques1() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("1");
	}

	// Close
	public void closePreview() {
		WaitUtil.waitForPageToLoad(driver);
		WaitUtil.waitForClickable(driver, close).click();
	}
}
