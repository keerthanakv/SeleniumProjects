package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class salesinvoice {

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

}

 @Test(dataProvider ="InvoiceDetailsData")
    public void invoicecClass(String VechicleNo,String Qty,String amount){
       System.setProperty("webdriver.chrome.driver", "D:\\Users\\NEW\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver.get("https://esightsolutions.in/billing/demo4/admin/add-bill.php");

        WebElement customer_form = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/div/div/i"));
        customer_form.click();
          WebElement customer_namec = driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div[1]/div/input"));
         customer_namec.click();

        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div[1]/div/div/ul/li[4]"));
        dropdownElement.click();
        driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div[1]/div/div/ul/li[2]")).click();
        WebElement branch = driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div[2]/div/input"));
        branch.click();
        driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div[2]/div/div")).click();
        WebElement vec_no = driver.findElement(By.id("vec_no"));
        vec_no.sendKeys(VechicleNo);
        driver.findElement(By.xpath("//*[@id=\"customer_details_save_btn\"]")).click();
        WebElement deliveryElement = driver.findElement(By.id("delivery_note_check"));
        deliveryElement.click();
        WebElement deliveryaddress = driver.findElement(By.id("same_customer_check"));
        deliveryaddress.click();

        WebElement Add_Product =driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[2]/div/div[3]/div[1]/div/div[4]/div[1]/div/div[2]"));
        Add_Product.click();
        WebElement Product =driver.findElement(By.xpath("//*[@id=\"product_form\"]/div[1]/div[1]/div/input"));
        Product.click();
        WebElement Prodct_List=driver.findElement(By.xpath("//*[@id=\"product_form\"]/div[1]/div[1]/div/div/ul/li[1]"));
        Prodct_List.click();
        WebElement Batch=driver.findElement(By.xpath("//*[@id=\"product_form\"]/div[1]/div[2]/div/input"));
        Batch.click();
        WebElement Batch_List=driver.findElement(By.xpath("//*[@id=\"product_form\"]/div[1]/div[2]/div/div"));
        Batch_List.click();
        WebElement quantity = driver.findElement(By.xpath("//*[@id=\"product_form\"]/div[1]/div[8]/input[1]"));
        quantity.sendKeys(Qty);
        WebElement Product_Save = driver.findElement(By.xpath("//*[@id=\"product_form\"]/div[2]/button"));
        Product_Save.click();
        WebElement SalesOrder = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[2]/div/div[3]/div[1]/div/div[4]/div[1]/div/div[1]/div[1]"));
        SalesOrder.click();
        WebElement add_payment = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[2]/div/div[3]/div[1]/div/div[5]/div[1]/div/div[2]"));
        add_payment.click();
        WebElement Mode_Of_Payment=driver.findElement(By.xpath("//*[@id=\"add_payment\"]/div[1]/div[1]/div[1]/select"));
        Mode_Of_Payment.click();
        Select select = new Select(Mode_Of_Payment);
        //select.selectByVisibleText("Cash");
        select.selectByIndex(2);
        WebElement Amount = driver.findElement(By.xpath("//*[@id=\"add_payment\"]/div[1]/div[1]/div[2]/input"));
        Amount.sendKeys(amount);

        WebElement MOP_Save = driver.findElement(By.id("payment_save_btn"));
        MOP_Save.click();

        WebElement Preview = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[2]/div/div[3]/div[1]/div/div[6]/div"));
        Preview.click();

        WebElement Preview_Close = driver.findElement(By.className("closeCanvasFormPreview"));
        Preview_Close.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement saveButton = driver.findElement(By.className("formSaveBtn"));

js.executeScript("arguments[0].click();", saveButton);      

        // WebElement Generate = driver.findElement(By.className("formSaveBtn"));
        // Generate.click();
        
}


@DataProvider(name = "InvoiceDetailsData")
    public Object[][] InvoiceDetailsData() {
        return new Object[][] {
            {"KL08BB7856","1","203"},
            {"KL08BB7856","2","406"},
            {"KL08BB7856","3","611"},
            
        };
    }

}