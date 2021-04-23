package com.poml.infor.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.poml.infor.base.BaseTest;

public class InforHomePage extends BaseTest{

	public InforHomePage(String browserProperties) {
		super(browserProperties);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a.navbar-brand img")
	WebElement inforBrandLogo;
	
	@FindBy(css="div#top-nav a[href='https://www.infor.com/resources']")
	WebElement resourceLink;
	
	public void clickResouceOption() {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", resourceLink);
	//	resourceLink.click();		
		}catch (Exception e) {
			Assert.fail("Unable to click Resource option in home page");
		}
	}

	public boolean isInforLogodisplayed(){
		return inforBrandLogo.isDisplayed();
	}
}
