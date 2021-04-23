package com.poml.infor.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.poml.infor.base.BaseTest;

public class GoogleHomePage extends BaseTest{

	public GoogleHomePage(String browserProperties) {
		super(browserProperties);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[aria-label='Search']")
	WebElement searchBox;	
	
	
	public String getGoogleHomePageTitle(){
		return driver.getTitle();
	}
	
	public GoogleHomePage fillSearchBox(String browserProperties) {
		searchBox.sendKeys("birst.com");
		return this;
		
	}
	public void clickEnter() {
		searchBox.sendKeys(Keys.ENTER);
		
	}
}
