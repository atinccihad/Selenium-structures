package tests.i16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestNGBeforeClassAfterClass;

// 1) Bir class oluşturun: YoutubeAssertions
public class H01_YoutubeAssertions extends TestNGBeforeClassAfterClass {

    @Test
    public void youtubeAssertions() {
        // 2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        // 3) Aşağıdaki adları kullanarak
        //   test metodu oluşturun ve gerekli testleri yapin
    }

    @Test(dependsOnMethods = "youtubeAssertions")
    public void titleTest() {
        //  ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "actualTitle, expectedTitle'a esit degil!");
    }

    @Test(dependsOnMethods = "titleTest")
    public void imageTest() {
        //  ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed(), "youtubeLogo is not displayed!");
    }

    @Test(dependsOnMethods = "imageTest")
    public void isEnabled() {
        //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled(), "searchBox is not enabled!");
    }

    @Test(dependsOnMethods = "isEnabled")
    public void wrongTitleTest() {
        //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertFalse(actualTitle.equals(expectedTitle), "Sayfa basligi,  youtube !");
    }

}
