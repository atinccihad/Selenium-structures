package i12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;
import java.util.Set;

// H03
public class H03 extends TestBaseBeforeAfter {
    @Test
    public void test01() {

        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        // 2."Login Portal" a  kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.DOWN).perform();
        // 3."Login Portal" a tiklayin
        String wh1 = driver.getWindowHandle();

        WebElement loginPortal = driver.findElement(By.xpath("//h1[text()=\"LOGIN PORTAL\"]"));
        loginPortal.click();

        // 4.Diger window'a gecin
        Set<String> windowHandles = driver.getWindowHandles();
        String wh2 = "";
        System.out.println(windowHandles);

        for (String each : windowHandles) {
            if (!each.equals(wh1)) {
                wh2 = each;
            }
        }
        System.out.println("wh2 = " + wh2);

        // 5."username" ve  "password" kutularina deger yazdirin
        driver.switchTo().window(wh2);
        System.out.println(driver.switchTo().activeElement().getText());
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("user" + Keys.TAB + "password");

        // 6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String popUpYazi = driver.switchTo().alert().getText();
        String expectedPopupYazi = "validation failed";
        Assert.assertTrue(expectedPopupYazi.equals(popUpYazi));

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        // Ilk sayfaya geri donun
        driver.switchTo().window(wh1);
        // Ilk sayfaya donuldugunu test edin
        String expectedUrl = "http://webdriveruniversity.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
