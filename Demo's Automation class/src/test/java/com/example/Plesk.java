package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Plesk {

    @Test()
    public void settingup(){
    WebDriverManager.edgedriver().clearDriverCache().setup();
    System.setProperty("webdriver.edge.driver", "D:\\Users\\NEW\\Downloads\\edgedriver_win64\\msedgedriver.exe");
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.plesk.com/");
    driver.findElement(By.cssSelector("body > section > div.ch2-container.ch2-theme-overlay.ch2-style-light.ch2-ea.ch2-block > div.ch2-dialog.ch2-dialog-center.ch2-visible > div.ch2-dialog-actions.ch2-dialog-actions-vertical > div:nth-child(1) > button.ch2-btn.ch2-deny-all-btn.ch2-btn-primary")).click();

    // first button
    driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-3904d33.elementor-section-full_width.elementor-section-content-middle.elementor-section-height-default.elementor-section-height-default.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div > div > section > div.elementor-container.elementor-column-gap-default > div.elementor-column.elementor-col-50.elementor-inner-column.elementor-element.elementor-element-774e443 > div > div.elementor-element.elementor-element-2eb05d0.elementor-align-center.elementor-widget.elementor-widget-raven-button > div > div > a")).click();
    driver.navigate().back();

//service provide

        driver.findElement(By.cssSelector("#jet-tabs-control-2271 > div > div")).click();
        driver.findElement(By.cssSelector("#jet-tabs-control-2272 > div > div")).click();
        driver.findElement(By.cssSelector("#jet-tabs-control-2273 > div > div")).click();
        driver.findElement(By.cssSelector("#jet-tabs-control-2274 > div > div")).click();
        driver.findElement(By.cssSelector("#jet-tabs-control-2275 > div > div")).click();
        driver.findElement(By.cssSelector("#jet-tabs-control-2276 > div > div")).click();


// extension

        driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-1d0f73d.elementor-section-height-min-height.elementor-section-boxed.elementor-section-height-default.elementor-section-items-middle.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div.elementor-column.elementor-col-50.elementor-top-column.elementor-element.elementor-element-349ce83 > div > div.elementor-element.elementor-element-cfcf413.elementor-widget.elementor-widget-raven-button > div > div > a > span > span")).click();
         driver.navigate().back();

//pleskWPToolkit

        driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-66be2a9.elementor-section-height-min-height.elementor-section-boxed.elementor-section-height-default.elementor-section-items-middle.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div.elementor-column.elementor-col-50.elementor-top-column.elementor-element.elementor-element-7cd525c > div > div.elementor-element.elementor-element-1ee3584.elementor-widget.elementor-widget-raven-button > div > div > a")).click();
        driver.navigate().back();

//Certified to hyperscale into the cloud

        driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-1006d70.elementor-section-height-min-height.elementor-section-boxed.elementor-section-height-default.elementor-section-items-middle.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div.elementor-column.elementor-col-50.elementor-top-column.elementor-element.elementor-element-9d4e1b6 > div > div.elementor-element.elementor-element-c7780a3.elementor-widget.elementor-widget-raven-button > div > div > a > span > span")).click();
        driver.navigate().back();

//sitejet

        driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-fccc963.elementor-section-height-min-height.elementor-section-boxed.elementor-section-height-default.elementor-section-items-middle.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div > div > section > div.elementor-container.elementor-column-gap-default > div.elementor-column.elementor-col-50.elementor-inner-column.elementor-element.elementor-element-01cab41 > div > div.elementor-element.elementor-element-76ef517.elementor-align-center.elementor-widget.elementor-widget-raven-button > div > div > a > span > span")).click();
        driver.navigate().back();

//Loved by Partners
        driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-76d4f72.elementor-section-height-min-height.elementor-section-items-bottom.elementor-section-content-bottom.elementor-section-boxed.elementor-section-height-default.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div > div > section > div.elementor-container.elementor-column-gap-default > div.elementor-column.elementor-col-50.elementor-inner-column.elementor-element.elementor-element-8b94027 > div > div.elementor-element.elementor-element-44af34f.elementor-widget.elementor-widget-raven-button > div > div > a > span > span")).click();
        driver.navigate().back();

//Start working faster today
        driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-1800b19.elementor-section-height-min-height.elementor-section-items-bottom.elementor-section-content-bottom.elementor-section-boxed.elementor-section-height-default.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div > div > section > div.elementor-container.elementor-column-gap-default > div.elementor-column.elementor-col-50.elementor-inner-column.elementor-element.elementor-element-7197a54 > div > div > div > div > a")).click();
        driver.navigate().back();
}
@AfterTest()
 public void starttrail(){
    WebDriverManager.edgedriver().clearDriverCache().setup();
    System.setProperty("webdriver.edge.driver", "D:\\Users\\NEW\\Downloads\\edgedriver_win64\\msedgedriver.exe");
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.plesk.com/");

    driver.findElement(By.cssSelector("body > section > div.ch2-container.ch2-theme-overlay.ch2-style-light.ch2-ea.ch2-block > div.ch2-dialog.ch2-dialog-center.ch2-visible > div.ch2-dialog-actions.ch2-dialog-actions-vertical > div:nth-child(1) > button.ch2-btn.ch2-deny-all-btn.ch2-btn-primary")).click();
    // first button
    driver.findElement(By.cssSelector("#main > div.elementor.elementor-27874 > section.elementor-section.elementor-top-section.elementor-element.elementor-element-3904d33.elementor-section-full_width.elementor-section-content-middle.elementor-section-height-default.elementor-section-height-default.jet-parallax-section > div.elementor-container.elementor-column-gap-no > div > div > section > div.elementor-container.elementor-column-gap-default > div.elementor-column.elementor-col-50.elementor-inner-column.elementor-element.elementor-element-774e443 > div > div.elementor-element.elementor-element-2eb05d0.elementor-align-center.elementor-widget.elementor-widget-raven-button > div > div > a")).click();
    
    WebElement name = driver.findElement(By.id("input_91_1_3"));
    name.sendKeys("Keerthana");
    WebElement last = driver.findElement(By.id("input_91_1_6"));
    last.sendKeys("KV");
    WebElement mail = driver.findElement(By.id("input_91_2"));
    mail.sendKeys("keerthana.8991@gmail.com");

    // check box
    driver.findElement(By.id("choice_91_19_1")).click();
    //driver.findElement(By.cssSelector("#checkbox")).click();

}
}
