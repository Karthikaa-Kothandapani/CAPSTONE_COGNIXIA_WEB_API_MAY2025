package utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	// URL
	public static final String URL = "https://admin.typeform.com/login";
	
	// Test Case
	public static final String tcId = "Test Case ID: ";
		
	// Test Types
	public static final String positiveTestCase = "Test Type: Positive Test Cases";
	public static final String negativeTestCase = "Test Type: Negative Test Case";
	
	// Wait Timer
	public static final int defaultWaitTime = 50;
		
	// Extent Report Test
	public static final String test1 = "Test Login with Invalid Email";
	public static final String test2 = "Test Login with Invalid Password";
	public static final String test3 = "Test Login with Valid Credentials";
	public static final String test4 = "Test Form Creation Functionality with All form Elements";
	public static final String test5 = "Test Form preview Functionality";
	public static final String test6 = "Test View Mode Filter Defects";
	public static final String test7 = "Test Grid Mode Filter Defects";
	
	// Logs
	public static final String logStartTest = "The Test has Started!";
	public static final String logEndTest = "The Test has Ended!";
	
	// Alert
	public static final String alertAppeared = "Alert appeared";
	public static final String noAlert = "No Alert is present";
	public static final String alertAccepted = "Alert accepted";
	public static final String alertDismissed = "Alert Dismissed";
	public static final String promptAlertAccept = "Alert input entered and accepted: ";
	
	// Display and Enable
	public static final String display = "Display";
	public static final String enable = "Enable";
	
	// Fields
	public static final String button = "Button";
	public static final String input = "Input";
	public static final String text = "Text";
	public static final String buttonText = "Button Text";
	public static final String elementText = "Element Text";
	public static final String textExpected = "Expected Text";
	public static final String textActual = "Actual Text";
	public static final String emailInput = "Email Input";
	public static final String passwordInput = "Password Input";
	public static final String searchbox = "Search Box";
	
	// Login Functionality User Credentials
	public static final String validUserEmail = "qetestascend@gmail.com";
	public static final String validUserPassword = "TypeForm@18";
	public static final String invalidUserEmail = "karthikaa@gmail.com";
	public static final String invalidUserPassword = "Skhueduekshkfr";
	
	// Login Functionality Dummies
	public static final String loginPageExpectedTitle = "Typeform";
	public static final String workspacePageExpectedTitle = "Workspaces";
	public static final String assertPassMessage = "Passed";
	public static final String assertFailMessage = "Failed";
	public static final String emailContinueButtonText = "Continue with email";
	public static final String loginButtonText = "Log into Typeform";
	public static final String dashboardExpectedText = "My workspace";
	public static final String alertInvalidPassword = "Your login info is not right.";
	public static final String alertInvalidEmail = "Please check your email again";
	
	// Create Form Functionality Dummies
	public static final String[] mcqMonths = {"May", "December", "August", "March" };
	public static final String dropdownCity = "Paris\r\n"
			+ "Santorini\r\n"
			+ "Doha\r\n"
			+ "London";
	public static final String checkboxDesText = "I Accept the Terms and Conditions";
	public static final String[] choiceLabels = {"Music Concert", "Movie Night", "Holy Party", "Standup Comedy"};
	public static final List<String> matrixRowLabels = Arrays.asList("Revathy", "Meha", "Gopa", "Chandar");
	public static final List<String> matrixColLabels = Arrays.asList("Good Communication", "Good Hospitality", "Attentive", "On Time");
	public static final String oldName = "My new form";
	public static final String newName = "SampleFormTest";

	
	// Assert Messages
	public static final String titleVerification = "Expected Page Title Match";
	public static final String alertTextVerification = "Expected Alert!";
	public static final String listContentVerification = "The List should not be Empty";
	public static final String allQuestionsPresent = "All the Expected Questions should be Added!";
	public static final String nameChangeVerification = "The Name should be Changed";
	public static final String rightQuestion = "The Expected Question should be Displayed";
	public static final String questionPageHasValue = "The Question Page should not be Empty";
	public static final String previewQuestionFields = "All the input Elements in the Question Preview should be accessible";
	public static final String exitedPreview = "Exit from Preview";
	
	// Defects
	public static final String filterCreated = "Date created";
	public static final String tabCreated = "Created";
	public static final String expectedFilterContent = "Expected Filter Result";
	public static final String gridViewCheck = "The Workspace should be in Grid View";
	public static final String listViewCheck = "The Workspace should be in List View";
	
	// Pages
	public static final String emailPage = "Email Page";
	public static final String passwordPage = "Password Page";
	
	// Excel
	public static final String EXCEL_PATH = "C:\\Users\\karthikaa.k\\eclipse-workspace\\Capstone_Typeform_Website\\test-data\\CapstoneTypeFormTestData.xlsx";
}