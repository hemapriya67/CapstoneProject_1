package com.sdet.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sdet.flipkart.Utilities.Base;

public class ItemDetails extends Base{

    ////*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span
    WebElement itemName = driver.findElement(By.xpath("//*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/h1/span"));

    ////*[@id="container"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button
    WebElement addToCartButton = driver.findElement(By.xpath("//*[@id="container"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));

    ////*[@id="container"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a
    WebElement cartIcon= driver.findElement(By.xpath("//a[@class='_3SkBxJ']"));

    public static verifyItem(String item){
        Assert.assertTrue(getValue(itemName).contains(item), "Item name is displaying correctly");
    }

    public static void clickAddToCart(){
        click(addToCartButton);
    }
 
    public static void clickCartIcon(){
        click(cartIcon);
    }
    
}