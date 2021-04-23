package com.poml.infor.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.poml.infor.base.BaseTest;

public class InforResourcePage extends BaseTest{

	public InforResourcePage(String browserProperties) {
		super(browserProperties);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='row align-items-lg-center justify-content-lg-between'] select")
	List<WebElement> selectTags;
	
	@FindBy(css="div[class='card-body'] a.card-title")
	List<WebElement> cardTitles;
	
	public String getResourcePageTitle(){
		return driver.getTitle();
	}
	
	public void selectValueFromAllProducts(String value) {
		try {
			Select allProductsDropDown = new Select(selectTags.get(1));
			allProductsDropDown.selectByVisibleText(value);
			sleep(2000);
		}catch (Exception e) {
			Assert.fail("Unable to select value from All Products");
		}
	}
	
	public void selectValueFromAllAssets(String value) {
		try {
			Select allAssets = new Select(selectTags.get(2));
			allAssets.selectByVisibleText(value);
			sleep(2000);
		}catch (Exception e) {
			Assert.fail("Unable to select value from All Products");
		}
	}
	
	public boolean verifyCardTitle(String value) {
		boolean flag = false;
		try {
			List<String> allCardsTitles = new ArrayList<String>();
			for(WebElement cardtitle: cardTitles ) {
				allCardsTitles.add(cardtitle.getText());
			}
			
			flag = allCardsTitles.contains(value);
			
		}catch (Exception e) {
			Assert.fail("Unable to select value from All Products");
		}
		return flag;
	}

}
