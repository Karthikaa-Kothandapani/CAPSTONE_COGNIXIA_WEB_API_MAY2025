package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;
import utils.WaitUtil;

public class WorkspacePage extends BaseTest {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(text(), 'Create a new form')]")
	WebElement createFormButton;
	
	@FindBy(xpath = "(//div[@rows='1'])[2]")
	WebElement tab;
	
	@FindBy(xpath = "//button[@data-qa='rebrand-workspace-sort-dropdown']")
	WebElement filter;
	
	@FindBy(xpath = "(//a[@data-qa='form-card-image']/following-sibling::div)[1]")
	WebElement card;
	
	@FindBy(xpath = "//button[@data-qa='rebrand-view-mode-toggle-grid-view']")
	WebElement grid;
	
	@FindBy(xpath = "//button[@data-qa='rebrand-view-mode-toggle-list-view']")
	WebElement list;
	
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
	
	// Tab text
	public String tabText() {
		System.out.println(WaitUtil.waitForVisible(driver, tab).getText());
		return WaitUtil.waitForVisible(driver, tab).getText();
	}
	
	// Check if in List View
	public boolean isInListView() {
		return !list.isEnabled();
	}
	
	// Switch to List View
	public void listview() {
		WaitUtil.waitForClickable(driver, list).click();
	}
	
	// Tab Verification
	public boolean listViewDateCreatedVerification() {
		return WaitUtil.waitForVisible(driver, filter).getText().contains(Constants.filterCreated) &&
			   WaitUtil.waitForVisible(driver, tab).getText().contains(Constants.tabCreated);
	}
	
	// Switch to Grid view
	public void gridview() {
		WaitUtil.waitForClickable(driver, grid).click();
	}
	
	// Check if in Grid View
	public boolean isInGridView() {
		return !WaitUtil.waitForClickable(driver, grid).isEnabled();
	}
	
	// Grid Card
	public boolean gridFormDetailsVerification() {
		WaitUtil.waitForPageToLoad(driver);
		System.out.println(WaitUtil.waitForVisible(driver, card).getText());
		return WaitUtil.waitForVisible(driver, card).getText().contains(Constants.tabCreated);
	}

}
