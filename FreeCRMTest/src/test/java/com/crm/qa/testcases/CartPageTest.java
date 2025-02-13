/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CartPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CartPage cartpage;
	
	String sheetName = "contacts";
	
	   
	public CartPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		cartpage = new CartPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		cartpage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(cartpage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		cartpage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		cartpage.selectContactsByName("test2 test2");
		cartpage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		homePage.clickOncartLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		cartpage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
