package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntellifolowHM {

    @Test()
    public void setup(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("WebDriver.chrome.driver", "D:\\Users\\NEW\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://intelliflow.ai/");

        driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-f1e1099cba5984b32\"]/div[4]/div/section/div/div/div/div/div/div/ul/li[1]/a")).click();

       // driver.findElement(By.cssSelector("#wrapper > section.section-main-container.section.no-padding > div > div > div > div > div > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-22fe1d38.solution-wrapper.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div > div:nth-child(1) > div > div > a")).click();
        //driver.findElement(By.cssSelector("#wrapper > div.homepage-content > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-23279ed.elementor-section-boxed.elementor-section-height-default.lazyloaded > div > div.elementor-column.elementor-col-50.elementor-top-column.elementor-element.elementor-element-9c60c54 > div > div.elementor-element.elementor-element-6d9fe0c.elementor-widget.elementor-widget-text-editor > div > div > p:nth-child(2) > a")).sendKeys(Keys.ENTER);
       // driver.navigate().back();
       //driver.findElement(By.cssSelector("#menu-item-2687 > a")).click();

        //driver.findElement(By.xpath("//*[@id=\"menu-item-4715\"]/a")).click();
    }
}

    

