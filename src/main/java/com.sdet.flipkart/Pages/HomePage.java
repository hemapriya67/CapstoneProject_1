package com.sdet.flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import com.sdet.flipkart.Utilities.Base;

public class HomePage extends Base{

 
    WebElement logoName = driver.findElement(By.xpath("//img[@class='aqQN50']"));
    WebElement elementToSearch = driver.findElement(By.xpath("//*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/div/input"));
    WebElement elementSearchIcon = driver.findElement(By.xpath("//*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/button"));
    //Logo
    public static void logoDisplay(){
        Assert.assertTrue(getAttributeValue(logoName).equals("Flipkart"),"Flipkart logo is present");

    }


    //Search 
    public static searchElementText(){
     searchText(elementToSearch);
    }
}
