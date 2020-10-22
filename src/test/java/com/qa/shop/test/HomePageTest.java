package com.qa.shop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.shop.base.BaseTest;
import com.qa.shop.pages.HomePage;
import com.qa.shop.utils.Constants;

public class HomePageTest extends BaseTest {

	HomePage homepage;

	@Test(priority = 1)
	public void verifyOrder() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.ProductAdd();

		String actual = HomePage.act;

		Assert.assertEquals(actual, Constants.ExpPurAmt);
	}

}
