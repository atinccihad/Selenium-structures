package tests.i20;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.BestBuyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class Q01_testBestBuy{

    @Test
    public void testBestBuy() throws IOException {
        // https://www.bestbuy.com/  adresine gidiniz
        BestBuyPage bestBuyPage = new BestBuyPage();
        Driver.getDriver().get(bestBuyPage.bestbuyUrl);

        // UnitedStates butonuna basiniz
        bestBuyPage.bestBuyUnitedStatesButton.click();

        // searchBox'a  "computer"  yazip aratiniz
        bestBuyPage.bestBuySearchBox.sendKeys("computer");
        bestBuyPage.bestBuySearchButton.click();

        // searchBox islemini yaparken feedback ekrani acilirsa  "No,Thanks" butonuna tiklayip gecin
        try {
            if (bestBuyPage.bestBuyFeedbackButton.isDisplayed()) {
                bestBuyPage.bestBuyFeedbackButton.click();
                System.out.println("bestBuyFeedbackButton handle edildi..");
            }
        } catch (NoSuchElementException e) {
            System.out.println("bestBuyFeedbackButton gorunmedi.");
        }
        // laptop secenegini tiklayin
        Actions actions = new Actions(Driver.getDriver());
        WebElement laptops = Driver.getDriver().findElement(By.xpath("//img[@alt=\"Laptops\"]"));
        ReusableMethods.jsExecutorScrool(laptops);
        ReusableMethods.jsExecutorClick(laptops);

        // marka secimini yapiniz
        ReusableMethods.jsExecutorScrool(bestBuyPage.bestBuyAppleButton);
        ReusableMethods.jsExecutorClick(bestBuyPage.bestBuyAppleButton);

        // 2.sayfaya geciniz
        ReusableMethods.jsExecutorScrool(bestBuyPage.bestBuySayfaGecisMenusu);
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).perform();
        ReusableMethods.jsExecutorClick(Driver.getDriver().findElement(By.xpath("//li[@class=\"page-item\"]")));
        ReusableMethods.jsExecutorClick(Driver.getDriver().findElement(By.xpath("//a[@aria-label=\"Results Page 2\"]")));

        // Ilk urune tiklayiniz
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        Driver.getDriver().findElement(By.xpath("(//img[@class=\"product-image \"])[1]")).click();

        // Acilan sayfanin screenshotunu alip sayfayi kapatiniz
        String dosyaYolu = "target/screenShot/tumsayfa.png";
        ReusableMethods.getScreenshot(dosyaYolu);

        // tum sayfa screenshot icin 4 adim gerekli
        // 1- TakeScreenshot objesi olusturma
        TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();
        Faker faker = new Faker();
        // 2- Kaydedecegimiz dosyayi olusturalim
        File tumSayfaSS = new File("target/screenShot/tumsayfa" + (faker.idNumber()) + ".png");

        // 3- bir dosya daha olusturup screenshot objesi ile screenshot'i alalim
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici resmi kaydetmek istedigimiz asil dosyaya copy yapalim
        FileUtils.copyFile(geciciResim, tumSayfaSS);

        Driver.closeDriver();

    }
}
