package com.sdet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sdet.flipkart.Pages.HomePage;
import com.sdet.flipkart.Pages.ItemDetails;
import com.sdet.flipkart.Pages.SearchItem;
import com.sdet.flipkart.Pages.CartPage;
import com.sdet.flipkart.Utilities.Base;

public class AddToCart extends Base {

    HomePage homePage1;
    SearchItem searchItem1;
    CartPage cartPage1;
    ItemDetails itemDetails1;

    @BeforeSuite
    public void setup() {
		setDriver();
		openUrl("https://www.flipkart.com/");
		homepage1.logoDisplay();
	}

    @Test(priority=1)
	public void searchProduct(){
		homePage1.searchElementText();
		searchItem1.verifyItem("Macbook air m2");
		
	}

    @Test(Priority=2)
    public void clickFirstItem(){
		searchItem1.clickItem();
		String item_name = searchItem1.getFirstItem();
		switch_tab();
		itemDetails1.VerifyItem(item_name);
		itemDetails1.clickAddToCart();
		cartPage1.VerifyItem(item_name);
	}

    @AfterSuite
	public void end_test() {
		browserClose();
	}
    
}
