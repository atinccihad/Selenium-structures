package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q_05 extends TestBase {

    @Test
    public void alert1() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        // 1- "http://webdriveruniversity.com/Popup-Alerts/index.html"  adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Thread.sleep(2000);

        // 2- CLICK ME of JavaScript Alert e tiklayin
        driver.findElement(By.xpath("(//p[text()='CLICK ME!'])[1]")).click();
        Thread.sleep(2000);

        // 3- pop up text i alin
        String message=driver.switchTo().alert().getText();
        Thread.sleep(2000);

        // 4- Mesajin "I am an alert box!"  oldugunu dogrulayin.
        String expectedMessage="I am an alert box!";
        softAssert.assertTrue(message.equals(expectedMessage));
        Thread.sleep(2000);

        // 5- pop up i kabul edin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        softAssert.assertAll();
    }

    // Yine ayni class da baska bir test methodu olusturun
    @Test(dependsOnMethods = "alert1")
    public void alert2() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();

        // 1- "http://webdriveruniversity.com/Popup-Alerts/index.html"  adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Thread.sleep(2000);

        // 2- CLICK ME of JavaScript Confirm Box i TIKLAYIN
        driver.findElement(By.xpath("//span[@id='button4']")).click();
        Thread.sleep(2000);

        // 3- pop up text i alin
        // Alert alert=driver.switchTo().alert(); //==> Alert alert=...  diye baslamasak da olur   driver.switchTo().alert();  seklinde de.
        String message=driver.switchTo().alert().getText();
        Thread.sleep(2000);

        // 4- Mesajin "Press a button!" oldugunu dogrulayin
        String expMessage="Press a button!";
        softAssert.assertTrue(message.equals(expMessage));
        Thread.sleep(2000);

        // 5- Acilir pencereyi kapat,pop up i iptal edin,
        // alert.dismiss();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        // 6- "You pressed Cancel!"  yazisinin goruntulendigini dogrulayin
        softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-alert-text']")).isDisplayed());
        Thread.sleep(2000);
        softAssert.assertAll();
        // 7- alert1'e gore dependsOnMethods kullanin

        /*
        Alert alert=driver.switchTo().alert();  ==> bu sekilde de kullanimi mevcuttur
        alert variable ile methodlara ulasilabilir
        alert.dismiss();
        alert.getText();
        alert.accept();   vb
        bu kullanim sayesinde switchto() yazmamiza gerek kalmaz
         */
    }
}
