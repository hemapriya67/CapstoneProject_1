package com.sdet.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sdet.flipkart.Utilities.Base;

public class SearchItem extends Base{
    ////*[@id="container"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span/span
    WebElement searchResult = driver.findElement(By.xpath("//*[@id="container"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span/span"));
    
    ////*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a
    WebElement itemClick = driver.findElement(By.xpath("//*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a"));

    ////*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]
    WebElement itemName = driver.findElement(By.xpath("//*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]"));

    public static void verifyItem(String item){
        Assert.assertTrue(getValue(searchResult).contains(item), "Macbook air m2 results page");
    }

    public static void clickItem(){
        click(itemClick);
    }

    public static String getFirstItem(){
        return getValue(itemName);
    }
}