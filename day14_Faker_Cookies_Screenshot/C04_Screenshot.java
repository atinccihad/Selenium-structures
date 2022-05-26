package tests.day14;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {

    @Test
    public void screenTest(){
        driver.get("https://www.google.com");

        // tum sayfanin screenshot'ini almak icin

        // 1.adim : screenshot almak icin obje olusturalim ve deger olarak driver'imizi atayalim
        //          deger olarak driver'i kabul etmesi icin casting yapmaliyiz.
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2. adim : tum sayfanin screenshot'ini almak icin bir File olusturalim ve
        // dosya yolunu belirtelim
        File tumSayfaSS=new File("src\\tumSayfa.png");

        // 3. adim : olusturdugumuz file ile takescreenshot objesini iliskilendirelim
        tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);

        // eger spesifik bir webelementin screenshot'ini almak istiyorsaniz
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
        File logoResmi=new File("src/logo.png");
        logoResmi=logoElementi.getScreenshotAs(OutputType.FILE);

    }
}
