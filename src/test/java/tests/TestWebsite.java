package tests;

import base.BaseTest;
import utils.AssertUtil;
import utils.Constants;
import utils.ExcelUtil;
import utils.ExtentReportManager;
import utils.WaitUtil;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestWebsite extends BaseTest {
	
	ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test1;
    ExtentTest test2;
    ExtentTest test3;
    ExtentTest test4;
    ExtentTest test5;
    ExtentTest test6;
    ExtentTest test7;

 	
 	// TestCaseID: 01
  	// TestType: NegativeTestCase
  	// TestDescription: Invalid Mail Login Test
  	@Test(priority = 1, enabled = false)
  	public void testInValidEmail() {
  		
  		test1 = extent.createTest(Constants.test1);
  		SoftAssert softAssert = new SoftAssert();		
  		log.info(Constants.tcId + "01\r\n"
  				+ Constants.negativeTestCase + " \r\n"
  				+ "TestDescription: " + Constants.test1);
  		test1.info(Constants.tcId + "01\r\n"
  				+ Constants.negativeTestCase + " \r\n"
  				+ "TestDescription: " + Constants.test1);
  		log.info(Constants.logStartTest);
  		
  		// *** Email Page ***
  		log.info(Constants.emailPage);
  		test1.info(Constants.emailPage);
  		// Checks
  		// Check Page Title
  		boolean emailPageTitlematch = login.getPageTitle().contains(Constants.loginPageExpectedTitle);
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, emailPageTitlematch, Constants.titleVerification , log, test1);
  		
  		// Check if the Email Field is Visible
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailFieldVisible(), Constants.emailInput + Constants.display, log, test1);
  		
  		// Check if the Email Field is Enabled
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailFieldEnabled(), Constants.emailInput + Constants.enable, log, test1);
  		
  		// Check if the Continue Button is Visible
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailContinueButtonDisplayed(), Constants.button + Constants.display, log, test1);
  		
  		// Check if the Continue Button is Enabled
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailContinueButtonEnabled(), Constants.button + Constants.enable, log, test1);
  		
  		// Check if the Button Text Matches
  		boolean emailContinueButtonTextMatch = login.emailContinueButtonText().contains(Constants.emailContinueButtonText);
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, emailContinueButtonTextMatch, Constants.buttonText + Constants.display, log, test1);
  		
  		
  		// Actions	
  		// Enter valid user Email
  		login.enterUserEmail(Constants.invalidUserEmail);
  		
  		// Continue with Email
  		login.emailContinueButtonClick();
  		
  		
  		// Check it shows invalid
  		boolean invalidEmail = login.emailInvalidAlert().contains(Constants.alertInvalidEmail);
  		AssertUtil.assertTrueWithLogAndExtent(softAssert, invalidEmail, Constants.alertTextVerification, log, test1);
  		
  		log.info(Constants.logEndTest);
  		softAssert.assertAll();
  		
  	}
  	
	
    // TestCaseID: 02
 	// TestType: NegativeTestCase
 	// TestDescription: Invalid Password Login Test
 	@Test(priority = 2, enabled = false)
 	public void testInValidLogin() throws InterruptedException {
 		
 		test2 = extent.createTest(Constants.test2);
 		SoftAssert softAssert = new SoftAssert();		
 		log.info(Constants.tcId + "02\r\n"
 				+ Constants.negativeTestCase + " \r\n"
 				+ "TestDescription: " + Constants.test2);
 		test2.info(Constants.tcId + "02\r\n"
 				+ Constants.negativeTestCase + " \r\n"
 				+ "TestDescription: " + Constants.test2);
 		log.info(Constants.logStartTest);
 		
 		// *** Email Page ***
 		log.info(Constants.emailPage);
 		test2.info(Constants.emailPage);
 		// Checks
 		// Check Page Title
 		boolean emailPageTitlematch = login.getPageTitle().contains(Constants.loginPageExpectedTitle);
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, emailPageTitlematch, Constants.titleVerification , log, test2);
 		
 		// Check if the Email Field is Visible
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailFieldVisible(), Constants.emailInput + Constants.display, log, test2);
 		
 		// Check if the Email Field is Enabled
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailFieldEnabled(), Constants.emailInput + Constants.enable, log, test2);
 		
 		// Check if the Continue Button is Visible
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailContinueButtonDisplayed(), Constants.button + Constants.display, log, test2);
 		
 		// Check if the Continue Button is Enabled
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailContinueButtonEnabled(), Constants.button + Constants.enable, log, test2);
 		
 		// Check if the Button Text Matches
 		boolean emailContinueButtonTextMatch = login.emailContinueButtonText().contains(Constants.emailContinueButtonText);
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, emailContinueButtonTextMatch, Constants.buttonText + Constants.display, log, test2);
 		
 		
 		// Actions	
 		// Enter valid user Email
 		login.enterUserEmail(Constants.validUserEmail);
 		
 		// Continue with Email
 		login.emailContinueButtonClick();
 		
 		
 		
 		// *** Password Page ***
 		// *** Email Page ***
 	 	log.info(Constants.passwordPage);
 	 	test2.info(Constants.passwordPage);
 		
 		// Checks
 		// Check Page Title
 		boolean passwordPageTitlematch = login.getPageTitle().contains(Constants.loginPageExpectedTitle);
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, passwordPageTitlematch, Constants.titleVerification, log, test2);	

 		// Check if the Password Field is Visible
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isPasswordFieldVisible(), Constants.passwordInput + Constants.display, log, test2);
 		
 		// Check if the Password Field is Enabled
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isPasswordFieldEnabled(), Constants.passwordInput + Constants.enable, log, test2);
 		
 		// Check if the Login Button is Visible
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isLoginContinueButtonDisplayed(), Constants.button + Constants.display, log, test2);
 		
 		// Check if the Login Button is Enabled
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isLoginContinueButtonEnabled(), Constants.button + Constants.enable, log, test2);
 		
 		// Check if the Button Text Matches
 		boolean loginButtonTextMatch = login.loginContinueButtonText().contains(Constants.loginButtonText);
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, loginButtonTextMatch, Constants.buttonText + Constants.buttonText, log, test2);
 		
 		
 		
 		// Actions
 		// Enter valid user Password
 		login.enterUserPassword(Constants.invalidUserPassword);
 		
 		// Continue with Login Passwords
 		login.loginContinueButtonClick();
 		
 		// Check it shows invalid
 		boolean invalidPassword = login.emailInvalidAlert().contains(Constants.alertInvalidPassword);
 		AssertUtil.assertTrueWithLogAndExtent(softAssert, invalidPassword, Constants.alertTextVerification, log, test2);
 		
 		log.info(Constants.logEndTest);
 		softAssert.assertAll();
 		
 		
 	}
    
    
	// TestCaseID: 03
	// TestType: PositiveTestCase
	// TestDescription: Valid Credentials Login Test
	@Test(priority = 3, enabled = true)
	public void testValidLogin() throws InterruptedException {
		
		test3 = extent.createTest(Constants.test3);
		SoftAssert softAssert = new SoftAssert();		
		log.info(Constants.tcId + "03\r\n"
				+ Constants.positiveTestCase + " \r\n"
				+ "TestDescription: " + Constants.test3);
		test3.info(Constants.tcId + "03\r\n"
				+ Constants.positiveTestCase + " \r\n"
				+ "TestDescription: " + Constants.test3);
		log.info(Constants.logStartTest);
		

 		driver.get(Constants.URL);
		
		// *** Email Page ***
		log.info(Constants.emailPage);
		test3.info(Constants.emailPage);
		// Checks
		// Check Page Title
		boolean emailPageTitlematch = login.getPageTitle().contains(Constants.loginPageExpectedTitle);
		AssertUtil.assertTrueWithLogAndExtent(softAssert, emailPageTitlematch, Constants.titleVerification , log, test3);
		
		// Check if the Email Field is Visible
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailFieldVisible(), Constants.emailInput + Constants.display, log, test3);
		
		// Check if the Email Field is Enabled
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailFieldEnabled(), Constants.emailInput + Constants.enable, log, test3);
		
		// Check if the Continue Button is Visible
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailContinueButtonDisplayed(), Constants.button + Constants.display, log, test3);
		
		// Check if the Continue Button is Enabled
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isEmailContinueButtonEnabled(), Constants.button + Constants.enable, log, test3);
		
		// Check if the Button Text Matches
		boolean emailContinueButtonTextMatch = login.emailContinueButtonText().contains(Constants.emailContinueButtonText);
		AssertUtil.assertTrueWithLogAndExtent(softAssert, emailContinueButtonTextMatch, Constants.buttonText + Constants.display, log, test3);
		
		
		// Actions	
		// Enter valid user Email
		login.enterUserEmail(Constants.validUserEmail);
		
		// Continue with Email
		login.emailContinueButtonClick();
		
		
		
		// *** Password Page ***
		log.info(Constants.passwordPage);
 	 	test3.info(Constants.passwordPage);
		
		// Checks
		// Check Page Title
		boolean passwordPageTitlematch = login.getPageTitle().contains(Constants.loginPageExpectedTitle);
		AssertUtil.assertTrueWithLogAndExtent(softAssert, passwordPageTitlematch, Constants.titleVerification, log, test3);	

		// Check if the Password Field is Visible
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isPasswordFieldVisible(), Constants.passwordInput + Constants.display, log, test3);
		
		// Check if the Password Field is Enabled
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isPasswordFieldEnabled(), Constants.passwordInput + Constants.enable, log, test3);
		
		// Check if the Login Button is Visible
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isLoginContinueButtonDisplayed(), Constants.button + Constants.display, log, test3);
		
		// Check if the Login Button is Enabled
		AssertUtil.assertTrueWithLogAndExtent(softAssert, login.isLoginContinueButtonEnabled(), Constants.button + Constants.enable, log, test3);
		
		// Check if the Button Text Matches
		boolean loginButtonTextMatch = login.loginContinueButtonText().contains(Constants.loginButtonText);
		AssertUtil.assertTrueWithLogAndExtent(softAssert, loginButtonTextMatch, Constants.buttonText + Constants.buttonText, log, test3);
		
		
		
		// Actions
		// Enter valid user Password
		login.enterUserPassword(Constants.validUserPassword);
		
		// Continue with Login Passwords
		login.loginContinueButtonClick();
		
		/*Handling unknown errors
		if (login.passwordInvalidAlertPresent()==true) {
			login.clearText();
			login.enterUserPassword(Constants.validUserPassword);
			login.loginContinueButtonClick();
		} */
		
		// Check Page Title
		boolean workspaceText = login.dashboardOpen().contains(Constants.dashboardExpectedText);
		AssertUtil.assertTrueWithLogAndExtent(softAssert, workspaceText, Constants.titleVerification, log, test3);
		
		log.info(Constants.logEndTest);
		softAssert.assertAll();
		
	}
	
	
	
	// TestCaseID: 04
	// TestType: PositiveTestCase
	// TestDescription: Test Form Creation Functionality
	@Test(priority = 4, enabled = true)
	public void testFormCreation() {
	    test4 = extent.createTest(Constants.test4);
	    log.info(Constants.tcId + "04\r\n" +
	             Constants.positiveTestCase + "\r\n" +
	             "TestDescription: " + Constants.test4);
	    test4.info(Constants.tcId + "04\r\n" +
	               Constants.positiveTestCase + "\r\n" +
	               "TestDescription: " + Constants.test4);
	    log.info(Constants.logStartTest);
	    SoftAssert softAssert = new SoftAssert();

	    // Step 1: Click Create New Form
	    workspace.clickCreateFormButton();
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, chooseForm.isCreateFromStrachPresent(), Constants.textExpected + Constants.display, log, test4);

	    // Step 2: Click "Create From Scratch"
	    chooseForm.clickCreateFromScratch();
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isFormNamePresent(), Constants.textExpected + Constants.display, log, test4);

	    // Step 3: Load Excel questions
	    List<String> questions1 = ExcelUtil.getColumnAsList(Constants.EXCEL_PATH, "Sheet1", 0);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, questions1 != null, Constants.listContentVerification, log, test4);
	    
	    List<String> questions2 = ExcelUtil.getColumnAsList(Constants.EXCEL_PATH, "Sheet1", 1);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, questions2 != null, Constants.listContentVerification, log, test4);
	    
	    List<String> questions3 = ExcelUtil.getColumnAsList(Constants.EXCEL_PATH, "Sheet1", 2);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, questions3 != null, Constants.listContentVerification, log, test4);
	    
	    List<String> questions4 = ExcelUtil.getColumnAsList(Constants.EXCEL_PATH, "Sheet1", 3);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, questions4 != null, Constants.listContentVerification, log, test4);
	    
	    List<String> questions5 = ExcelUtil.getColumnAsList(Constants.EXCEL_PATH, "Sheet1", 4);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, questions5 != null, Constants.listContentVerification, log, test4);

	    // Step 4: Create elements
	    form.createFormElementsContactInfo(questions1);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isContactInfoElementsCreated(questions1), Constants.allQuestionsPresent, log, test4);
	    
	    form.createFormElementsChoice(questions2);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isContactInfoElementsCreated(questions2), Constants.allQuestionsPresent, log, test4);
	    
	    form.createFormElementsRatingRanking(questions3);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isContactInfoElementsCreated(questions3), Constants.allQuestionsPresent, log, test4);
	    
	    form.createFormElementsText(questions4);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isContactInfoElementsCreated(questions4), Constants.allQuestionsPresent, log, test4);
	    
	    form.createFormElementsOther(questions5);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isContactInfoElementsCreated(questions5), Constants.allQuestionsPresent, log, test4);
	    
	    // Step 5: Change Form Name
	    form.closeAddElementPage();
	    form.changeName(Constants.newName);
	   // AssertUtil.assertTrueWithLogAndExtent(softAssert, form.isNameChanged(Constants.newName), Constants.nameChangeVerification, log, test4);

	    softAssert.assertAll();
	    log.info(Constants.logEndTest);
	}

	
	
	// TestCaseTD: 06
	// TestType: PositiveTestCase
	// TestDescription: Test Form Preview Functionality
	@Test(priority = 5, enabled = true)
	public void testFormPreview() {
	    test5 = extent.createTest(Constants.test5);
	    log.info(Constants.tcId + "05\r\n" +
	             Constants.positiveTestCase + "\r\n" +
	             "TestDescription: " + Constants.test5);
	    test5.info(Constants.tcId + "05\r\n" +
	               Constants.positiveTestCase + "\r\n" +
	               "TestDescription: " + Constants.test5);
	    log.info(Constants.logStartTest);
	    SoftAssert softAssert = new SoftAssert();
	    
	    // Open preview
	    form.openPreview();
	    
	    // Question
	    view.quesPage();
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, view.ques1(), Constants.rightQuestion, log, test5);
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, view.quesPage()!=null, Constants.questionPageHasValue, log, test5);
	    
	    // Close
	    view.closePreview();
	    AssertUtil.assertTrueWithLogAndExtent(softAssert, form.checkIfExitedPreview(), Constants.exitedPreview, log, test5);
	    
	    // Go to Workspace
	    form.goToWorkspace();
	    // Check Page Title
	 	boolean workspaceText = login.dashboardOpen().contains(Constants.dashboardExpectedText);
	 	AssertUtil.assertTrueWithLogAndExtent(softAssert, workspaceText, Constants.titleVerification, log, test5); 
	 	
	 	softAssert.assertAll();
	 	log.info(Constants.logEndTest);
	}

	
		// TestCaseTD: 06
		// TestType: PositiveTestCase
		// TestDescription: Test List View Filter
		@Test(priority = 6, enabled = false)
		public void listFilter() {
		    test6 = extent.createTest(Constants.test6);
		    log.info(Constants.tcId + "06\r\n" +
		             Constants.positiveTestCase + "\r\n" +
		             "TestDescription: " + Constants.test6);
		    test6.info(Constants.tcId + "06\r\n" +
		               Constants.positiveTestCase + "\r\n" +
		               "TestDescription: " + Constants.test6);
		    log.info(Constants.logStartTest);
		    SoftAssert softAssert = new SoftAssert();
		    
		   // Get Tab Elements
		   workspace.tabText();
		  // AssertUtil.assertTrueWithLogAndExtent(softAssert, workspace.isInListView(), Constants.listViewCheck, log, test6);
		   
		   // Verify Filter
		   AssertUtil.assertTrueWithLogAndExtent(softAssert, workspace.listViewDateCreatedVerification(), Constants.expectedFilterContent, log, test6);
		   
		   log.info(Constants.logEndTest);
		   softAssert.assertAll();
		}
		
		// TestCaseTD: 07
		// TestType: PositiveTestCase
		// TestDescription: Test Grid View Filter
		@Test(priority = 7, enabled = false)
		public void gridFilter() {
			test7 = extent.createTest(Constants.test7);
			log.info(Constants.tcId + "07\r\n" +
				     Constants.positiveTestCase + "\r\n" +
				     "TestDescription: " + Constants.test7);
			test7.info(Constants.tcId + "07\r\n" +
				      Constants.positiveTestCase + "\r\n" +
				      "TestDescription: " + Constants.test7);
			log.info(Constants.logStartTest);
			SoftAssert softAssert = new SoftAssert();
				    
			// Switch to Grid View
			workspace.gridview();
			//AssertUtil.assertTrueWithLogAndExtent(softAssert, workspace.isInGridView(), Constants.gridViewCheck, log, test7);
				   
			// Verify Filter
			AssertUtil.assertTrueWithLogAndExtent(softAssert, workspace.gridFormDetailsVerification(), Constants.expectedFilterContent, log, test7);
			
			// Back to List View
			workspace.listview();
			WaitUtil.waitForPageToLoad(driver);
				   
			log.info(Constants.logEndTest);
			softAssert.assertAll();
		}
}
