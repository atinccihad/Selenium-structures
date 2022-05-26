package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuterClick extends TestBase {
    // amazon.com anasayfaya gidip
    // sell linkine JSExecutor ile tiklayalim
    // ilgili sayfaya gittigimizi test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        // 1. adim JsExecutor objesi olusturalim ve driver'i cast edelim
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        // 2. ilgili webelementi locate edelim
        WebElement sellElementi=driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_4']"));

        // 3. ilgili script ve argument(bizim webelementimiz) ile objemiz uzerinden
        //    executeScript methodunu calistiralim
        jse.executeScript("arguments[0].click();",sellElementi);

        Thread.sleep(5000);

        // 4. ilgili sayfaya gittigimizi test edelim
        WebElement sellOnAmazonElementi=driver.findElement(By.xpath("//h1[@class='heading align-start font-size-xxxlarge color-squid-ink ember font-heavy']"));

        Assert.assertTrue(sellOnAmazonElementi.isDisplayed(),"sellOn.. elementi gorunmuyor.");
    }
}
