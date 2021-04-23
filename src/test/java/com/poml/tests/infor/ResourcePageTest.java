package com.poml.tests.infor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.poml.infor.pages.GoogleHomePage;
import com.poml.infor.pages.GoogleSearchPage;
import com.poml.infor.pages.InforHomePage;
import com.poml.infor.pages.InforResourcePage;

public class ResourcePageTest extends GoogleHomePage {

	String browserProperties = "chrome.properties";

	public ResourcePageTest() {
		super("chrome.properties");
	}

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test
	public void verifyWebinarNameOnResourcePage() {

		GoogleHomePage ghome = new GoogleHomePage(browserProperties);

		Assert.assertTrue(ghome.getGoogleHomePageTitle().equalsIgnoreCase("google"),
				"Google home Page title is not matching");

		ghome.fillSearchBox(browserProperties);
		ghome.clickEnter();

		GoogleSearchPage searchPage = new GoogleSearchPage(browserProperties);
		for (WebElement searchResult : searchPage.searchResults) {
			String title = searchResult.getText();
			if (title.equalsIgnoreCase("Birst | Business intelligence and analytics | Infor")) {
				searchResult.click();
				break;
			}
		}

		InforHomePage inforHomePage = new InforHomePage(browserProperties);
		Assert.assertTrue(inforHomePage.isInforLogodisplayed(), "Infor Logo is not displayed on Pages");
		inforHomePage.clickResouceOption();
		
		InforResourcePage resourcePage = new InforResourcePage(browserProperties);
		sleep(2000);
		resourcePage.selectValueFromAllProducts("Birst");
		resourcePage.selectValueFromAllAssets("Past Webinars");
		
		Assert.assertTrue(resourcePage.verifyCardTitle("Six steps to becoming a data-driven organization"), "Six steps to becoming a data-driven organization is not present in result");
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
