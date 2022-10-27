package i11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v102.page.model.WindowOpen;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBaseBeforeAfter;

public class H04 extends TestBaseBeforeAfter {


    @Test()
    public void test04() {
        // Test04
        // 1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com/");

        // 2- dropdown’dan bebek bölümünu secin
        driver.findElement(By.xpath("//option[text()='Baby']")).click();

        // 3- bebek pusset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek pusset" + Keys.ENTER);
        WebElement bebekPussetSonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String bebekPussetSonucYazisiStr = bebekPussetSonucYazisiElementi.getText();
        String[] bebekPussetSonucYazisiArr = bebekPussetSonucYazisiStr.split(" ");
        int sonucSayisi = Integer.parseInt(bebekPussetSonucYazisiArr[0]);
        System.out.println("sonucSayisi = " + sonucSayisi);

        // 4- sonuç yazısının pusset içerdiğini test edin
        Assert.assertTrue("Sonuc yazisi pusset icermiyor!", bebekPussetSonucYazisiStr.contains("pusset"));

        // 5- üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[3]")).click();

        // 6- title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement title1 = driver.findElement(By.xpath("//span[@id='productTitle']"));

        WebElement fiyatBilgileri1 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']"));

        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    }


}
