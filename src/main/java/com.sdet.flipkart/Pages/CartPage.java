package com.sdet.flipkart,Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sdet.flipkart.Utilities.Base;

public class CartPage extends Base{

    WebElement itemInCart = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']"));

    public static void verifyItem(String item) {
		Assert.assertTrue(getValue(itemInCart).contains(item), "Item added to cart is available");
	}

    
}