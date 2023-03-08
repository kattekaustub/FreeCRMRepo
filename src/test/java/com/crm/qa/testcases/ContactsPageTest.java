package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public ContactsPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization ();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Tester QA");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Tester QA");
		contactsPage.selectContactsByName("abc tester");
	}
	
	
	@DataProvider
	public void getTestData() {
		
	}
	
	@Test(priority = 4)
	public void validateCreateNewContactTest() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Tom", "n Jerry", "Google");
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
