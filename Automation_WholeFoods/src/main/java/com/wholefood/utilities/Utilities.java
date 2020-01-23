package com.wholefood.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {

    static WebDriver driver=null;

    public static void main(String arg[]){
        initializeChromeDriver("https://www.wholefoodsmarket.com/recipes/lentil-and-quinoa-salad-cashews");
    }

    public static void initializeChromeDriver(String url){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get(url);
    }

    public static void  initializeIE(){
        System.setProperty("webdriver.IE.driver", "");
        driver=new ChromeDriver();

    }


    public static void closeDriver(){
        driver.close();
    }

    public static void quitDriver(){
        driver.quit();
    }


    public static void clickElement(By xpath){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            element.click();
        }
    }

    public static void setText(By xpath,String key){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            element.sendKeys(new CharSequence[]{key});
        }
    }

    public static String getText(By xpath){
        if(isPresent(xpath)==true) {
            WebElement element = driver.findElement(xpath);
            String text = element.getText();
            return text;
        }
        return "";
    }

    public static Boolean isPresent(By xpath){
        try{
            WebElement element = driver.findElement(xpath);
            return element.isDisplayed();
        }catch(Exception var){
            System.out.println("error in finding element"+var);
            return false;
        }
    }

}
