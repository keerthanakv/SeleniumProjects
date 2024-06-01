package com.example;



import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Billing {

private WebDriver driver;

@BeforeTest()
    public void test0() throws Exception 
    
    {

        System.setProperty("webdriver.chrome.driver", "D:\\Users\\NEW\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://esightsolutions.in/billing/demo4/index.php");

        WebElement nameElement = driver.findElement(By.id("user_email"));
       nameElement.sendKeys("admin");
        WebElement Password = driver.findElement(By.id("password-field"));
        Password.sendKeys("admin");
        WebElement login = driver.findElement(By.id("submit"));
        login.click();
        // WebElement cElement =driver.findElement(By.cssSelector("#dashboard > div.sidemenu > div.sidemenuLink > ul > li:nth-child(2)"));
        // cElement.click();


// WebElement elementToHover = driver.findElement(By.xpath("/html/body/main/section/div[1]/div[4]"));
// Actions actions = new Actions(driver);

// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// wait.until(ExpectedConditions.elementToBeClickable(elementToHover));

// actions.moveToElement(elementToHover).perform();


        // WebElement sidemenu =driver.findElement(By.id("dashboard"));
        // Actions actions = new Actions(driver);
        // actions.moveToElement(sidemenu).build().perform();
}

 @Test(dataProvider = "customerData")
    public void customerc(String customername,String popname,String popgst,String Branch,
    String cnumber,String mail,String cpin,String clocation,String caddress){
       System.setProperty("webdriver.chrome.driver", "D:\\Users\\NEW\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://esightsolutions.in/billing/demo4/admin/add-customer.php");

        WebElement customer_name = driver.findElement(By.cssSelector("#product_forms > div > div:nth-child(1) > div > input"));
        customer_name.click();
        customer_name.sendKeys(customername);
        WebElement popupcname = driver.findElement(By.id("customer_num_val"));
        popupcname.sendKeys(popname);
        WebElement popoupgst = driver.findElement(By.id("gst_num_val"));
        popoupgst.sendKeys(popgst);
        driver.findElement(By.cssSelector("body > main > div.addFormPopup > div > form > div.formFooter > button")).click();
        WebElement branch = driver.findElement(By.cssSelector("#product_forms > div > div.templateListBox.customeInputArea > div:nth-child(1) > input"));
        branch.sendKeys(Branch);

        WebElement Phone = driver.findElement(By.cssSelector("#product_forms > div > div.templateListBox.customeInputArea > div:nth-child(2) > input"));
        Phone.sendKeys(cnumber);

        WebElement email = driver.findElement(By.cssSelector("#product_forms > div > div.templateListBox.customeInputArea > div:nth-child(3) > input"));
        email.sendKeys(mail);

        WebElement pin = driver.findElement(By.cssSelector("#product_forms > div > div.templateListBox.customeInputArea > div:nth-child(4) > input"));
        pin.sendKeys(cpin);

        WebElement location = driver.findElement(By.cssSelector("#product_forms > div > div.templateListBox.customeInputArea > div:nth-child(5) > input"));
        location.sendKeys(clocation);

        WebElement address = driver.findElement(By.cssSelector("#product_forms > div > div.templateListBox.customeInputArea > div.formGroupTextarea > textarea"));
        address.sendKeys(caddress);

        driver.findElement(By.id("add_product_btn")).click();

        // WebElement view = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[4]/div/a[2]/span"));
        // Actions actions = new Actions(driver);    
        // actions.moveToElement(view).click().build().perform();
        
}


// @DataProvider(name = "LoginData")
//     public Object[][] LoginData() {
//         return new Object[][] {
//             {"admin","123"},
//             {"admin","admin"},
//         };
//     }

@DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][] {
            {"zv","admin","123456123789457","Kannur","8136971272","select@mail.com","123456","Kerala","Test Address"},
            
        };
    }

}