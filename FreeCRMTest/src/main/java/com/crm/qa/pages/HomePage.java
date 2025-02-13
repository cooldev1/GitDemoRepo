package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@class='dropdown dropdown-user welcome-admin']//child::h4")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//div[@class='middel-section hidden-xs']//child::span")
	WebElement homepagename;
	
	@FindBy(xpath = "//span[contains(text(),'Organize')]")
	WebElement  OrganizeLink;
	

	@FindBy(xpath = "//body/app-root[1]/app-top-navigation[1]/nav[1]/div[2]/ul[7]/li[1]/ul[1]/li[1]/a[1]")
	WebElement MasterLink;

	@FindBy(xpath = "//body/app-root[1]/app-top-navigation[1]/nav[1]/div[2]/ul[7]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
	WebElement financeLink;

	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	WebElement CartLink;
	
	

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	
	public CartPage clickOncartLink() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(OrganizeLink).build().perform();
		Thread.sleep(1000);
		action.moveToElement(MasterLink).build().perform();
		Thread.sleep(1000);
		action.moveToElement(financeLink).build().perform();
		Thread.sleep(1000);
		CartLink.click();
		driver.findElement(By.xpath("//*[@class='slider round']")).click();
	
	
	
	return new CartPage();
	
	
	}

	public CartPage clickOnContactsLink() {
		// TODO Auto-generated method stub
		
		return null;
	}
}
