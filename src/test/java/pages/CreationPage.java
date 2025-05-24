package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Constants;
import utils.WaitUtil;

import java.util.List;

public class CreationPage extends BaseTest {

    WebDriver driver;

    // Locators
    private final By contactListLocator = By.xpath("//section[@data-qa='block-category-contact_info']//ul[@data-qa='block-category-list']/li");
   // private final By choiceListLocator = By.xpath("//section[@data-qa='block-category-choice']//ul[@data-qa='block-category-list']/li");
    private final By choiceListLocator = By.xpath("//section[@data-qa='block-category-choice']//ul[@data-qa='block-category-list']/li");
    private final By rateRankListLocator = By.xpath("//section[@data-qa='block-category-rating_and_ranking']//ul[@data-qa='block-category-list']/li");
    private final By textListLocator = By.xpath("//section[@data-qa='block-category-text']//ul[@data-qa='block-category-list']/li");
    private final By otherListLocator = By.xpath("//section[@data-qa='block-category-other']//ul[@data-qa='block-category-other-misc']/li");
    private final By questionFieldLocator = By.xpath("//div[contains(@data-placeholder, 'Your question here')]");
   // private final By mcqChoiceListLocator = By.xpath("//ul[contains(@class,'sc-')]/li[@role='button']");
   // private final By mcqChoiceListLocator = By.xpath("//ul[contains(@class,'sc-')]/li[@role='button']");
    
    @FindBy(xpath = "//button[@data-qa='add-content-button']")
    WebElement addButton;
    
    @FindBy(xpath = "//button[contains(text(),'Add choice')]")
    WebElement addChoiceButton;
    
    @FindBy(xpath = "//textarea")
    WebElement textareaDropdown;
    
    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    WebElement saveChoiceDD;
    
    @FindBy(xpath = "//li[@data-qa='add-choice-btn']")
    WebElement addPicButton;
    
    @FindBy(xpath = "//li[@data-qa='choice']")
    WebElement addPic;
    
    @FindBy(xpath = "//button[@id='image']")
    WebElement picImage;
    
    @FindBy(xpath = "//img[contains(@alt, 'rocky landscape')]")
    WebElement image1;
    
    @FindBy(xpath = "//img[contains(@alt, 'Sunrise')]")
    WebElement image2;
    
    @FindBy(xpath = "//button[@aria-label=\"Close\" and contains(@data-qa, 'draggable-modal-header-close-button')]")
    WebElement close;
    
    @FindBy(xpath = "//p[contains(text(), 'Checkbox')]")
    WebElement checkboxDes;
    
    @FindBy(xpath = "//div[@id='BaseStyleRoot']/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement sideBar;
    
    @FindBy(xpath = "//*[@id=\"chief-header\"]/div/div[1]/div/nav/ol/li[2]/button")
    WebElement formNameLocator;
    
    @FindBy(xpath = "//span[contains(text()='form')]")
    WebElement oldNameLocator;
    
    @FindBy(xpath = "//span[text()='SampleFormTest']")
    WebElement newNameLocator;
    
    @FindBy(xpath = "//input[@aria-labelledby=\"form-title-input-label\"]")
    WebElement oldName;
    
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement nameSaveButton;
    
    @FindBy(xpath = "//button[@data-qa='modal-cross-icon-close-btn']")
    WebElement addElementPageClose;
    
    @FindBy(xpath = "//button[@data-qa='preview-form-button']")
    WebElement previewButton;
    
    @FindBy(xpath = "//div[text()='My workspace']")
    WebElement workspace;

    public CreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // Open Preview
    public void openPreview() {
    	WaitUtil.waitForClickable(driver, previewButton).click();
    }
    
    // Close Add Element Page
    public void closeAddElementPage() {
    	WaitUtil.waitForClickable(driver, addElementPageClose).click();
    }
    
    // Check if exited from Preview
    public boolean checkIfExitedPreview() {
    	return WaitUtil.waitForVisible(driver, workspace).isDisplayed();
    }
    
    
    // Go To workspace
    public void goToWorkspace () {
    	WaitUtil.waitForClickable(driver, workspace).click();
    }
  
    // Change the Form Name
    public void changeName(String newName) {
        WaitUtil.waitForClickable(driver, formNameLocator);
        formNameLocator.click();  // Click the container span/div

        WaitUtil.waitForVisible(driver, oldName); // Ensure it's visible and ready
        oldName.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
        oldName.sendKeys(Keys.BACK_SPACE);               // Clear all
        oldName.sendKeys(newName);                       // Enter new name
        WaitUtil.waitForVisible(driver, nameSaveButton).click();
        log.info("Form renamed to: " + newName);
    }
    
    // Helper Method to Choose Image
     public void chooseImage(WebElement add, WebElement img) throws InterruptedException { 
    	WaitUtil.waitForClickable(driver, add).click();
    	WaitUtil.waitForClickable(driver, picImage).click();
    	WaitUtil.waitForClickable(driver, img).click();
    	Thread.sleep(3000);
    	WaitUtil.waitForClickable(driver, close).click();
    	
    	Thread.sleep(1000);
    }

    // Helper Method to Create Matrix for Rating Element
    public void createMatrixForm(List<String> rows, List<String> cols) {
        // Add required columns
        for (int i = 1; i < cols.size(); i++) {
            WaitUtil.waitForClickableBy(driver, By.xpath("//button[contains(text(),'Add column')]")).click();
        }

        // Add required rows
        for (int i = 1; i < rows.size(); i++) {
            WaitUtil.waitForClickableBy(driver, By.xpath("//button[contains(text(),'Add row')]")).click();
        }

        // Wait for all inputs to be present (use appropriate locator)
        List<WebElement> rowInputs = WaitUtil.waitForPresenceOfAll(
            driver,
            By.xpath("//div[@data-placeholder='Row 1' or starts-with(@data-placeholder,'Row')]")
        );

        for (int i = 0; i < rows.size() && i < rowInputs.size(); i++) {
            WebElement input = rowInputs.get(i);
            WaitUtil.scrollIntoView(driver, input);
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].innerText = arguments[1];", input, rows.get(i)
            );
            log.info("Set row " + i + " as: " + rows.get(i));
        }

        // Column header editing
        List<WebElement> colInputs = WaitUtil.waitForPresenceOfAll(
            driver,
            By.xpath("//div[@data-placeholder='Col 1' or starts-with(@data-placeholder,'Col')]")
        );

        for (int i = 0; i < cols.size() && i < colInputs.size(); i++) {
            WebElement input = colInputs.get(i);
            WaitUtil.scrollIntoView(driver, input);
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].innerText = arguments[1];", input, cols.get(i)
            );
            log.info("Set column " + i + " as: " + cols.get(i));
        }
    }
   
    // Contact Info List Elements Creation
    public void createFormElementsContactInfo(List<String> questions) {
        for (int i = 0; i < questions.size(); i++) {
            try {
                // Re-locate contact list fresh each time (avoids stale)
                List<WebElement> contactList = WaitUtil.waitForPresenceOfAll(driver, contactListLocator);

                if (i >= contactList.size()) {
                    log.warn("Not enough form elements on screen for question index: " + i);
                    break;
                }

                WebElement element = contactList.get(i);
                WaitUtil.scrollIntoView(driver, element);
                element.click();
                log.info("Clicked form element: " + i);

                // Enter the question text
                String question = questions.get(i);
                if (question != null && !question.trim().isEmpty()) {
                    WebElement field = WaitUtil.waitForVisibleBy(driver, questionFieldLocator);
                    WaitUtil.scrollIntoView(driver, field);
                    field.clear();
                    field.sendKeys(question);
                    log.info("Entered question: " + question);
                } else {
                    log.warn("Skipped empty question at index: " + i);
                    continue;
                }

                // Click "Add Element" button
                WaitUtil.waitForPageToLoad(driver);
                WaitUtil.scrollIntoView(driver, addButton);
                addButton.click();
                log.info("Clicked Add Element");

                // Optional wait for DOM to refresh
                Thread.sleep(1000);

            } catch (Exception e) {
                log.warn("Error on element index " + i + ": " + e.getMessage());
            }
        }
    }

    // Choice List Elements Creation
    public void createFormElementsChoice(List<String> questions) {
        for (int i = 0; i < questions.size(); i++) {
            try {
                // Re-locate choice list each time to avoid stale elements
                List<WebElement> choiceList = WaitUtil.waitForPresenceOfAll(driver, choiceListLocator);

                if (i >= choiceList.size()) {
                    log.warn("Not enough form elements on screen for question index: " + i);
                    break;
                }

                WebElement element = choiceList.get(i);
                WaitUtil.scrollIntoView(driver, element);
                element.click();
                log.info("Clicked form element: " + i);

                // Enter question
                String question = questions.get(i);
                if (question != null && !question.trim().isEmpty()) {
                    WebElement field = WaitUtil.waitForVisibleBy(driver, questionFieldLocator);
                    WaitUtil.scrollIntoView(driver, field);
                    field.clear();
                    field.sendKeys(question);
                    log.info("Entered question: " + question);
                } else {
                    log.warn("Skipped empty question at index: " + i);
                    continue;
                }

                // Perform extra operation based on index (e.g. MCQ input)
                try {
                    switch (i) {
                        case 0:
                            log.info("Adding choices for MCQ");

                            // Click "Add choice" button 4 times
                            for (int j = 0; j < 4; j++) {
                                WaitUtil.waitForClickable(driver, addChoiceButton).click();
                            }

                            // Re-fetch choice inputs (editable fields)
                            List<WebElement> choiceInputs = driver.findElements(
                                    By.xpath("//div[@data-qa='choice']//div[contains(@class,'Spacer-sc')]")
                            );

                            for (int j = 0; j < Constants.mcqMonths.length && j < choiceInputs.size(); j++) {
                                WebElement input = choiceInputs.get(j);
                                WaitUtil.scrollIntoView(driver, input);

                                // Double click or JavaScript interaction may be needed if regular sendKeys fails
                                ((JavascriptExecutor) driver).executeScript(
                                    "arguments[0].innerText = arguments[1];", input, Constants.mcqMonths[j]
                                );
                                log.info("Added MCQ Option: " + Constants.mcqMonths[j]);
                            }

                            break;

                        case 1:
                            log.info("Adding Choices for DropDown");
                            WaitUtil.waitForClickable(driver, addChoiceButton).click();
                            
                            WaitUtil.waitForPageToLoad(driver);
                            WaitUtil.waitForVisible(driver, textareaDropdown).sendKeys(Constants.dropdownCity);
                            WaitUtil.waitForClickable(driver, saveChoiceDD).click();          
                            log.info("Added MCQ Option: " + Constants.dropdownCity);
                            break;

                        case 2:
                            log.info("Adding Pictures for Choose");
                            chooseImage(addPic, image1);
                            chooseImage(addPicButton, image2);
                            log.info("Images Added");
                            break;
                            
                        case 3:
                        	break;
                        	
                        case 4:
                        	break;
                        	
                        case 5:
                        	log.info("Adding Checkbox Description");
                        	WaitUtil.waitForVisible(driver, checkboxDes);
                        	WaitUtil.scrollIntoView(driver, checkboxDes);

                            // Double click or JavaScript interaction may be needed if regular sendKeys fails
                            ((JavascriptExecutor) driver).executeScript(
                                "arguments[0].innerText = arguments[1];", checkboxDes, Constants.checkboxDesText);
                            log.info("Added Description" + Constants.checkboxDesText);
                        	break;

                        default:
                            log.info("No extra click action for index " + i);
                            break;
                    }
                } catch (Exception e) {
                    log.warn("Failed extra operation for index " + i + ": " + e.getMessage());
                }

                // Finalize element
                WaitUtil.waitForPageToLoad(driver);
                WaitUtil.scrollIntoView(driver, addButton);
                addButton.click();
                log.info("Clicked Add Element");

                Thread.sleep(1000);

            } catch (Exception e) {
                log.warn("Error on element index " + i + ": " + e.getMessage());
            }
        }
    }

    // Rating and Ranking List Elements Creation
 // Contact Info List Elements Creation
    public void createFormElementsRatingRanking(List<String> questions) {
        for (int i = 0; i < questions.size(); i++) {
            try {
                // Re-locate contact list fresh each time (avoids stale)
                List<WebElement> rateRankList = WaitUtil.waitForPresenceOfAll(driver, rateRankListLocator);

                if (i >= rateRankList.size()) {
                    log.warn("Not enough form elements on screen for question index: " + i);
                    break;
                }

                WebElement element = rateRankList.get(i);
                WaitUtil.scrollIntoView(driver, element);
                element.click();
                log.info("Clicked form element: " + i);

                // Enter the question text
                String question = questions.get(i);
                if (question != null && !question.trim().isEmpty()) {
                    WebElement field = WaitUtil.waitForVisibleBy(driver, questionFieldLocator);
                    WaitUtil.scrollIntoView(driver, field);
                    field.clear();
                    field.sendKeys(question);
                    log.info("Entered question: " + question);
                } else {
                    log.warn("Skipped empty question at index: " + i);
                    continue;
                }
                
             // Perform extra operation based on index 
                try {
                    switch (i) {
                        case 0:
                            break;

                        case 1:
                            break;

                        case 2:
                            break;
                            
                        case 3:
                        	log.info("Adding Event Raniking List");
                        	// Click "Add choice" button 4 times
                        	for (int j = 0; j < 4; j++) {
                        	    WaitUtil.waitForClickable(driver, addChoiceButton).click();
                        	}

                        	// Wait for the editable divs to appear
                        	List<WebElement> choiceInputs = driver.findElements(
                        	    By.xpath("//div[@data-qa='quill-choice-editor']//div[contains(@class, 'ql-editor')]")
                        	);

                        	for (int j = 0; j < Constants.choiceLabels.length && j < choiceInputs.size(); j++) {
                        	    WebElement editableDiv = choiceInputs.get(j);
                        	    WaitUtil.scrollIntoView(driver, editableDiv);

                        	    // Use JavaScript to insert text in the Quill editor 
                        	    ((JavascriptExecutor) driver).executeScript(
                        	        "arguments[0].innerText = arguments[1];",
                        	        editableDiv, Constants.choiceLabels[j]
                        	    );

                        	    log.info("Event Ranking List Added " + Constants.choiceLabels[j]);
                        	}
                        	break;
                        	
                        case 4:
                        	createMatrixForm(Constants.matrixRowLabels, Constants.matrixColLabels);
                        	break;
                        	
                        default:
                            log.info("No extra click action for index " + i);
                            break;
                    }
                } catch (Exception e) {
                    log.warn("Failed extra operation for index " + i + ": " + e.getMessage());
                }
                

                // Click "Add Element" button
                WaitUtil.waitForPageToLoad(driver);
                WaitUtil.scrollIntoView(driver, addButton);
                addButton.click();
                log.info("Clicked Add Element");

                // Optional wait for DOM to refresh
                Thread.sleep(1000);

            } catch (Exception e) {
                log.warn("Error on element index " + i + ": " + e.getMessage());
            }
            
            
        }
    }
  
    // Text List Elements Creation
    public void createFormElementsText(List<String> questions) {
        for (int i = 0; i < questions.size(); i++) {
        	
            try {
                // Re-locate contact list fresh each time (avoids stale)
                List<WebElement> textList = WaitUtil.waitForPresenceOfAll(driver, textListLocator);

                if (i >= textList.size()-1) {
                    log.warn("Not enough form elements on screen for question index: " + i);
                    break;
                }

                WebElement element = textList.get(i);
                WaitUtil.scrollIntoView(driver, element);
                element.click();
                log.info("Clicked form element: " + i);

                // Enter the question text
                String question = questions.get(i);
                if (question != null && !question.trim().isEmpty()) {
                    WebElement field = WaitUtil.waitForVisibleBy(driver, questionFieldLocator);
                    WaitUtil.scrollIntoView(driver, field);
                    field.clear();
                    field.sendKeys(question);
                    log.info("Entered question: " + question);
                } else {
                    log.warn("Skipped empty question at index: " + i);
                    continue;
                }

                // Click "Add Element" button
                WaitUtil.waitForPageToLoad(driver);
                WaitUtil.scrollIntoView(driver, addButton);
                addButton.click();
                log.info("Clicked Add Element");

                Thread.sleep(1000);

            } catch (Exception e) {
                log.warn("Error on element index " + i + ": " + e.getMessage());
            }
        }
    }
    
    // Other List Elements Creation
    public void createFormElementsOther(List<String> questions) {
        for (int i = 0; i < questions.size(); i++) {
        	
            try {
                // Re-locate contact list fresh each time (avoids stale)
                List<WebElement> otherList = WaitUtil.waitForPresenceOfAll(driver, otherListLocator);

                if (i >= otherList.size()-2) {
                    log.warn("Not enough form elements on screen for question index: " + i);
                    break;
                }

                WebElement element = otherList.get(i);
                WaitUtil.scrollIntoView(driver, element);
                element.click();
                log.info("Clicked form element: " + i);

                // Enter the question text
                String question = questions.get(i);
                if (question != null && !question.trim().isEmpty()) {
                    WebElement field = WaitUtil.waitForVisibleBy(driver, questionFieldLocator);
                    WaitUtil.scrollIntoView(driver, field);
                    field.clear();
                    field.sendKeys(question);
                    log.info("Entered question: " + question);
                } else {
                    log.warn("Skipped empty question at index: " + i);
                    continue;
                }

                // Click "Add Element" button
                WaitUtil.waitForPageToLoad(driver);
                WaitUtil.scrollIntoView(driver, addButton);
                addButton.click();
                log.info("Clicked Add Element");

                Thread.sleep(1000);

            } catch (Exception e) {
                log.warn("Error on element index " + i + ": " + e.getMessage());
            }
        }
    }

    
    
    // Helper for Asserts
    public boolean isFormNamePresent() {
    	 WaitUtil.waitForVisible(driver, formNameLocator);
    	 return formNameLocator.getText().contains(Constants.oldName);
    }
    
    public boolean isContactInfoElementsCreated(List<String> questions) {
        WaitUtil.waitForVisible(driver, sideBar);
        String sidebarText = sideBar.getText();

        // Check if all questions are present
        for (String question : questions) {
            if (!sidebarText.contains(question)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isChoiceListElementsCreated(List<String> questions) {
        WaitUtil.waitForVisible(driver, sideBar);
        String sidebarText = sideBar.getText();

        // Check if all questions are present
        for (String question : questions) {
            if (!sidebarText.contains(question)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isRatingRankingElementsCreated(List<String> questions) {
        WaitUtil.waitForVisible(driver, sideBar);
        String sidebarText = sideBar.getText();

        // Check if all questions are present
        for (String question : questions) {
            if (!sidebarText.contains(question)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isTextElementsCreated(List<String> questions) {
        WaitUtil.waitForVisible(driver, sideBar);
        String sidebarText = sideBar.getText();

        // Check if all questions are present
        for (String question : questions) {
            if (!sidebarText.contains(question)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isOtherElementsCreated(List<String> questions) {
        WaitUtil.waitForVisible(driver, sideBar);
        String sidebarText = sideBar.getText();

        // Check if all questions are present
        for (String question : questions) {
            if (!sidebarText.contains(question)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isNameChanged(String newName) {
    	WaitUtil.waitForPageToLoad(driver);
    	WaitUtil.waitForVisible(driver, formNameLocator);
    	System.out.println(formNameLocator.getText());
    	return formNameLocator.getText().contains(newName);
    }
}
