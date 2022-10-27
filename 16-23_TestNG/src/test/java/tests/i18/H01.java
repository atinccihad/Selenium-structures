package tests.i18;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class H01 {
    // https://www.amazon.com/  adresine gidin
    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test01() throws InterruptedException {
        // Amazon anasayfaya gittiginizi test edin
        Driver.getDriver().get(amazonPage.amazonUrl);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), amazonPage.amazonUrl, "Amazon anasayfa testi failed!");
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "test01")
    public void test02() throws InterruptedException {
        // test01 basarili ise searchBox'i kullanarak "Nutella" icin arama yapin ve aramanin gerceklestigini test edin
        amazonPage.amazonSearchBox.sendKeys("Nutella", Keys.ENTER);
        Assert.assertTrue(amazonPage.aramaSonucElementi.isDisplayed());
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "test02")
    public void test03() throws InterruptedException {
        amazonPage.aramaSonucundakiIlkUrun.click();
        // "Nutella" icin arama yapildiysa ilk urunu tiklayin ve fiyatinin "$16.83"  olmadigini test edin ve guncel fiyati yazdirin
        WebElement guncelFiyatElementiWE = Driver.getDriver().findElement(By.xpath("//div[@class=\"a-section a-spacing-micro\"]"));
        String guncelFiyatElementi = guncelFiyatElementiWE.getText();
        String expectedFiyatElementi = "$16.83";
        Assert.assertNotEquals(guncelFiyatElementi,expectedFiyatElementi,"guncelFiyatElementi, expectedFiyatElementi beklenenden farkli olarak esit!");
        Thread.sleep(2000);
        // Driver.closeDriver();
        Driver.closeDriver();
    }



}
