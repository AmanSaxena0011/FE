package com.qa.shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.shop.base.BasePage;
import com.qa.shop.utils.ElementUtil;

public class HomePage extends BasePage {

	public static String act;
	private WebDriver driver;
	ElementUtil elementutil;

//	By Locators
	By laptop = By.xpath("(//a[@class='list-group-item'])[3]");
	By Sony = By.linkText("Sony vaio i5");
	By Dell = By.linkText("Dell i7 8gb");
	By AddtoCard = By.cssSelector("a.btn.btn-success.btn-lg");
	By cart = By.cssSelector("a#cartur.nav-link");
	By delete = By.xpath("//td[text()= 'Dell i7 8gb']//following-sibling::td//following-sibling::td/a");
	By placeOrder = By.cssSelector("button.btn.btn-success");
	By home = By.xpath("//li[@class='nav-item active']/a");

	By name = By.id("name");
	By country = By.id("country");
	By city = By.id("city");
	By card = By.id("card");
	By month = By.id("month");
	By year = By.id("year");
	By purchase = By.xpath("//button[@class='btn btn-primary' and @onclick ='purchaseOrder()']");

	By amounttext = By.cssSelector("div.sweet-alert.showSweetAlert.visible");
	By okbutton = By.cssSelector("button.confirm.btn.btn-lg.btn-primary");

//Constructor of page
	public HomePage(WebDriver driver) {
		elementutil = new ElementUtil(driver);
		this.driver = driver;

	}

	
//Page Actions/Methods
	public void ProductAdd() throws InterruptedException {

		elementutil.clickWhenReady(10, laptop);
		elementutil.clickWhenReady(10, Sony);
		elementutil.clickWhenReady(10, AddtoCard);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		elementutil.clickWhenReady(10, home);
		elementutil.clickWhenReady(10, laptop);
		elementutil.clickWhenReady(10, Dell);
		elementutil.clickWhenReady(10, AddtoCard);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		elementutil.clickWhenReady(10, cart);
		Thread.sleep(5000);
		elementutil.clickWhenReady(10, delete);
		Thread.sleep(5000);
		elementutil.clickWhenReady(10, placeOrder);

		elementutil.doSendKeys(name, "Aman");
		elementutil.doSendKeys(country, "India");
		elementutil.doSendKeys(city, "Delhi");
		elementutil.doSendKeys(card, "12345678");
		elementutil.doSendKeys(month, "Oct");
		elementutil.doSendKeys(year, "2020");
		elementutil.clickWhenReady(10, purchase);
		Thread.sleep(5000);

		String amt = elementutil.doGetText(amounttext);

		act = amt.substring(amt.indexOf("Amount: "), amt.indexOf("\nCard"));

		System.out.println(act);

		elementutil.clickWhenReady(10, okbutton);

	}
}
