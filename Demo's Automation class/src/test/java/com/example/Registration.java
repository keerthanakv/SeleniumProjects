package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration {
   @Test(dataProvider = "registrationData")
   
    public void testclass( String firstName, String lastName, String address,String email,String phone,Boolean male,Boolean female,Boolean cricket, Boolean movie,Boolean hockey,String language){
    System.setProperty("webdriver.chrome.driver", "D:\\Users\\NEW\\Downloads\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Register.html");
        // WebElement drop = driver.findElement(By.xpath("/html/body/header/nav/div/div[2]/ul/li[4]/a"));
        // drop.click();   
        // WebElement option = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[3]/a"));
	    // option.click();
       

        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"));
        WebElement lastNameElement = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input"));
        WebElement addressElement = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));
        WebElement emailAddress = driver.findElement(By.id("eid"));
        WebElement phoneNumber = driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(4) > div"));
        WebElement maleElement = driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1)"));
            if (!maleElement.isSelected()) {
                maleElement.click();
            }
        WebElement femaleElement = driver.findElement(By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(2)"));
            if (!femaleElement.isSelected()) {
                 femaleElement.click();
            }
        WebElement cricketElement = driver.findElement(By.id("checkbox1"));
        if (!cricketElement.isSelected()) {
                 cricketElement.click();
            }
        WebElement movieElement = driver.findElement(By.id("checkbox2"));
         if (!movieElement.isSelected()) {
                 movieElement.click();
            }
        WebElement hockeyElement = driver.findElement(By.id("checkbox3"));
        if (!hockeyElement.isSelected()) {
                 hockeyElement.click();
            }

        WebElement languageElement = driver.findElement(By.cssSelector("#msdd"));


        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        addressElement.sendKeys(address);
        emailAddress.sendKeys(email);
        phoneNumber.sendKeys(phone);
        languageElement.click();
        languageElement.sendKeys(language);

    }
    // 
    
    
}
