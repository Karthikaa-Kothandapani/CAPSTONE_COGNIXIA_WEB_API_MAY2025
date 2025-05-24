package pages;

import base.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class PreviewFormPage extends BaseTest{
	
	WebDriver driver;
	
	@FindBy(xpath = "(//div[@data-qa='question-wrapper'])[2]")
	WebElement form;
	
	// Q
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[2]")
	WebElement ques1;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[3]")
	WebElement ques2;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[4]")
	WebElement ques3;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[5]")
	WebElement ques4;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[6]")
	WebElement ques5;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[7]")
	WebElement ques6;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[8]")
	WebElement ques7;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[9]")
	WebElement ques8;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[10]")
	WebElement ques9;
	
	@FindBy(xpath = "(//span[@data-qa='question-header-counter']//span)[11]")
	WebElement ques10;
	
	@FindBy(xpath = "//input[@name='given-name']")
	WebElement givenName;

	@FindBy(xpath = "//input[@name='family-name']")
	WebElement famName;
	
	@FindBy(xpath = "//input[@name='tel']")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@aria-label='Enter your email address']")
	WebElement email;
	
	// Q4
	@FindBy(xpath = "//input[@autocomplete='address-line1']")
	WebElement address1;
	
	@FindBy(xpath = "//input[@autocomplete='address-line2']")
	WebElement address2;
	
	@FindBy(xpath = "//input[@autocomplete='address-level2']")
	WebElement address3;
	
	@FindBy(xpath = "//input[@autocomplete='address-level1']")
	WebElement address4;
	
	@FindBy(xpath = "//input[@autocomplete='postal-code']")
	WebElement address5;
	
	@FindBy(xpath = "//input[@autocomplete='country']")
	WebElement address6;
	
	// Q5
	@FindBy(xpath = "//input[@type='url']")
	WebElement url;
	
	
	
	
	public PreviewFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	// Move to Next Question
	public void moveToNextQuestion() throws InterruptedException {
		WaitUtil.waitForPageToLoad(driver);
		WaitUtil.waitForVisible(driver, form);
		Thread.sleep(3000);
		// Press ENTER after page load
	    Actions actions = new Actions(driver);
	    actions.sendKeys(Keys.ENTER).perform();
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
	public boolean ques2() {
		return WaitUtil.waitForVisible(driver, ques2).getText().contains("2");
	}
	public boolean ques3() {
		return WaitUtil.waitForVisible(driver, ques3).getText().contains("3");
	}
	public boolean ques4() {
		return WaitUtil.waitForVisible(driver, ques4).getText().contains("4");
	}
	public boolean ques5() {
		return WaitUtil.waitForVisible(driver, ques5).getText().contains("5");
	}
	public boolean ques6() {
		return WaitUtil.waitForVisible(driver, ques6).getText().contains("6");
	}
	public boolean ques7() {
		return WaitUtil.waitForVisible(driver, ques7).getText().contains("7");
	}
	public boolean ques8() {
		return WaitUtil.waitForVisible(driver, ques8).getText().contains("8");
	}
	public boolean ques9() {
		return WaitUtil.waitForVisible(driver, ques9).getText().contains("9");
	}
	public boolean ques10() {
		return WaitUtil.waitForVisible(driver, ques10).getText().contains("10");
	}
	public boolean ques11() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("11");
	}
	public boolean ques12() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("12");
	}
	public boolean ques13() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("13");
	}
	public boolean ques14() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("14");
	}
	public boolean ques15() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("15");
	}
	public boolean ques16() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("16");
	}
	public boolean ques17() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("17");
	}
	public boolean ques18() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("18");
	}
	public boolean ques19() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("19");
	}
	public boolean ques20() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("20");
	}
	public boolean ques21() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("21");
	}
	public boolean ques22() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("22");
	}
	public boolean ques23() {
		return WaitUtil.waitForVisible(driver, ques1).getText().contains("23");
	}
	
	
	
	// Question Elements
	public boolean ques1Verification() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Scroll each element into view before visibility check
		    js.executeScript("arguments[0].scrollIntoView(true);", form);
		    WebElement formElement = WaitUtil.waitForVisible(driver, form);

		    js.executeScript("arguments[0].scrollIntoView(true);", givenName);
		    WebElement givenNameElement = WaitUtil.waitForVisible(driver, givenName);

		    js.executeScript("arguments[0].scrollIntoView(true);", famName);
		    WebElement famNameElement = WaitUtil.waitForVisible(driver, famName);

		    js.executeScript("arguments[0].scrollIntoView(true);", telephone);
		    WebElement telephoneElement = WaitUtil.waitForVisible(driver, telephone);

		    js.executeScript("arguments[0].scrollIntoView(true);", email);
		    WebElement emailElement = WaitUtil.waitForVisible(driver, email);

		    // Final visibility and content check
		    return formElement.getText() != null &&
		           givenNameElement.isDisplayed() &&
		           famNameElement.isDisplayed() &&
		           telephoneElement.isDisplayed() &&
		           emailElement.isDisplayed();
		}
	
	public boolean ques2Verification() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll each element into view before visibility check
	    js.executeScript("arguments[0].scrollIntoView(true);", form);
	    WebElement formElement = WaitUtil.waitForVisible(driver, form);

	    js.executeScript("arguments[0].scrollIntoView(true);", email);
	    WebElement emailElement = WaitUtil.waitForVisible(driver, email);


	    // Final visibility and content check
	    return formElement.getText() != null &&
	           emailElement.isDisplayed();
	}
	
	public boolean ques3Verification() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll each element into view before visibility check
	    js.executeScript("arguments[0].scrollIntoView(true);", form);
	    WebElement formElement = WaitUtil.waitForVisible(driver, form);

	    js.executeScript("arguments[0].scrollIntoView(true);", telephone);
	    WebElement phoneElement = WaitUtil.waitForVisible(driver, telephone);


	    // Final visibility and content check
	    return formElement.getText() != null &&
	           phoneElement.isDisplayed();
	}

	public boolean ques4Verification() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll each element into view before visibility check
	    js.executeScript("arguments[0].scrollIntoView(true);", form);
	    WebElement formElement = WaitUtil.waitForVisible(driver, form);

	    js.executeScript("arguments[0].scrollIntoView(true);", address1);
	    WebElement address1NameElement = WaitUtil.waitForVisible(driver, address1);
	    
	    js.executeScript("arguments[0].scrollIntoView(true);", address2);
	    WebElement address2NameElement = WaitUtil.waitForVisible(driver, address2);
	    
	    js.executeScript("arguments[0].scrollIntoView(true);", address3);
	    WebElement address3NameElement = WaitUtil.waitForVisible(driver, address3);

	    js.executeScript("arguments[0].scrollIntoView(true);", address4);
	    WebElement address4NameElement = WaitUtil.waitForVisible(driver, address4);
	    
	    js.executeScript("arguments[0].scrollIntoView(true);", address5);
	    WebElement address5NameElement = WaitUtil.waitForVisible(driver, address5);
	    
	    js.executeScript("arguments[0].scrollIntoView(true);", address6);
	    WebElement address6NameElement = WaitUtil.waitForVisible(driver, address6);

	    // Final visibility and content check
	    return formElement.getText() != null &&
	    		address1NameElement.isDisplayed() &&
	    		address2NameElement.isDisplayed() &&
	    		address3NameElement.isDisplayed() &&
	    		address4NameElement.isDisplayed() &&
	    		address5NameElement.isDisplayed() &&
	    		address6NameElement.isDisplayed();
	}

	public boolean ques5Verification() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll each element into view before visibility check
	    js.executeScript("arguments[0].scrollIntoView(true);", form);
	    WebElement formElement = WaitUtil.waitForVisible(driver, form);

	    js.executeScript("arguments[0].scrollIntoView(true);", url);
	    WebElement urlElement = WaitUtil.waitForVisible(driver, url);


	    // Final visibility and content check
	    return formElement.getText() != null &&
	           urlElement.isDisplayed();
	}
}
