package com.sdet.flipkart.Utilities;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;

    public static void setDriver(){

    System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(2000);
            
            
    }

           //Open URL
        public static void openUrl(String url){
        driver.get(url);
        }

        //Close
           public static void browserClose(){
            driver.quit();
           }

           //Click
           public static void click(WebElement elementToBeClicked){
            elementToBeClicked.click();
           }

           //Search
           public static void searchText(WebElement elementToBeSearched){
            elementToBeSearched.sendKeys("Macbook air m2");
           }

           //Get Text
           public static String getValue(WebElement elememtToBeGet){
            return elememtToBeGet.getText();
           }

           //get Attribute
           public static String getAttributeValue(WebElement elementAtribute){
            return elementAtribute.getAtrtibute("title");
           }

           //Switch tab
           public static void switchTab(){
            String currentTab = driver.getWindowHandles();
            for(Sting tab : driver.getWindowHandles){
                if(!tab.equals(currentTab)){
                    driver.switchTo.window(tab);
                }
            }
           }

        
       
        
}
