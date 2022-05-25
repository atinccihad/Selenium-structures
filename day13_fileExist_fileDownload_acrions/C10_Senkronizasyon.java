package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C10_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
        */
        /*
        driver.get("https://www.youtube.com/");
        */
        /*
        driver.get("https://www.techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        */

        // https://the-internet.herokuapp.com/dynamic_controls  sayfasina gidin
        // disable butonuna basin
        // disabled yazisinin ciktigini test edin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        //Thread.sleep(3000);

        WebElement itsDisabledYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsDisabledYaziElementi.isDisplayed(), "yaziElementiGorunmuyor!!");

        // Thread.sleep(5000);
    }
}
