package i16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

// Yeni bir class olusturun : ScroolInto
public class H01_ScroolInto extends TestBaseBeforeAfter {

    @Test
    public void actions() {
        // hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com");
        // 2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        WebElement rooms = driver.findElement(By.xpath("(//a[text()='Rooms'])[1]"));
        Actions actions = new Actions(driver);
        actions.click(rooms).perform();
        // istediginiz oda inceleme sayfasi acildigini test  edin
        String expectedUrl = "https://www.hotelmycamp.com/rooms";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Istenilen oda inceleme sayfasi acilmadi!",expectedUrl,actualUrl);

        WebElement MY = driver.findElement(By.xpath("(//a[@href='/RoomDetail/347'])[2]"));
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        Assert.assertTrue("MY is not Displayed!",MY.isDisplayed());
        MY.click();
    }

    @Test
    public void jsexecutor() {
        // hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com");
        // 2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        WebElement rooms = driver.findElement(By.xpath("(//a[text()='Rooms'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",rooms);
        // istediginiz oda inceleme sayfasi acildigini test  edin
        String expectedUrl = "https://www.hotelmycamp.com/rooms";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Istenilen oda inceleme sayfasi acilmadi!",expectedUrl,actualUrl);

        WebElement goldnerGroup = driver.findElement(By.xpath("(//a[@class='btn-custom'])[150]"));

        js.executeScript("arguments[0].scrollIntoView(true);",goldnerGroup);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).perform();
        js.executeScript("arguments[0].click();",goldnerGroup);
        Assert.assertEquals("https://www.hotelmycamp.com/RoomDetail/277",driver.getCurrentUrl());
    }


}
