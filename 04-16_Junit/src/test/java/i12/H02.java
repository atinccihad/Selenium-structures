package i12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;


import java.time.Duration;

public class H02 extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        /*
        H02
       "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
       "Our Products" butonuna basin
       "Cameras product"i tiklayin
       Popup mesajini yazdirin
       "close" butonuna basin
       "WebdriverUniversity.com (IFrame)" linkini tiklayin
       "http://webdriveruniversity.com/index.html" adresine gittigini test edin
         */
        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //"Our Products" butonuna basin
        WebElement ourProductsFrame = driver.findElement(By.cssSelector("#frame"));
        driver.switchTo().frame(ourProductsFrame);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        //"Cameras product"i tiklayin
        driver.findElement(By.xpath("(//p)[2]")).click();

        //Popup mesajini yazdirin
        WebElement popUp = driver.findElement(By.xpath("//*[@class='modal-body']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-body']")));
        System.out.println("popUp.getText() = " + popUp.getText());

        //"close" butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedURL, actualURL);
    }
}
