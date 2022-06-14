package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;
// 1- C05_JsExecutorScrollIntoView
public class C05_JsExecutorScrollIntoView extends TestBase {
    // 2- hotelmycamp anasayfasina gidin
    // 3- 2 farkli methodu olusturarak actions class i ve Js Executor kullanarak
    //    asagidaki oda turlerinden ust sira
    // 4- istediginiz oda inceleme sayfasi acildigini test edin

    @Test
    public void scroolAction() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
        Thread.sleep(3000);
    }

    @Test
    public void scroolJsExecutor() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        driver.navigate().refresh();

        // 1. adim JsExecutor objesi olustur ve driver'i cast et
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        // 2. adim calisacagimiz webelementi locate edelim
        WebElement odaInceleLinki=driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        // 3. adim ilgili script ve argument ile jse.executeScript()  calistir
        jse.executeScript("arguments[0].scrollIntoView(true);",odaInceleLinki);
        Thread.sleep(4000);
        jse.executeScript("arguments[0].click();",odaInceleLinki);
        Thread.sleep(4000);
    }

}
