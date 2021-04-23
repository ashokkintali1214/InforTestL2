package com.poml.infor.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.poml.infor.base.BaseTest;

public class GoogleSearchPage extends BaseTest {

	public GoogleSearchPage(String browserProperties) {
		super(browserProperties);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a h3")
	public List<WebElement> searchResults;	

	public String getGoogleSearchPageTitle(){
		return driver.getTitle();
	}
}
