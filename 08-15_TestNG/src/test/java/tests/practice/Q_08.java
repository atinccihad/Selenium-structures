package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

/*
@DataProvider bir TestNG annotation'idir
Dolayisiyla sadece TestNG ile kullanilir.
Veri saglamak icin kullanilir.
DDT(Data Driven Test) yapilir
Cucumber'daki Scenario Outline ile ayni isleve sahiptir
 */
public class Q_08 extends TestBase {
    // http://amazon.com adresine gidiniz
    // araba, ev, anahtarlik, ayakkabi, gomlek kelimelerini arayiniz

    @Test(dataProvider = "urunler")
    public void amazonTest(String kelime) {
        driver.get("http://amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(kelime + Keys.ENTER);
    }

    @DataProvider(name = "urunler")
    public Object[][] getUrunler() {
        Object[][] urunler = {{"araba"}, {"ev"}, {"anahtarlik"}, {"ayakkabi"}, {"gomlek"}};
        // Object tum data tiplerini kapsadigi icin Object kullandik
        return urunler;
    }

    // https://www.gittigidiyor.com/ adresine gidiniz
    // java, javascript ve python kelimelerini arayiniz
    @Test(dataProvider = "aranacakKelimeler")
    public void gittigidiyorTest(String aranacakKelimeler) {
        driver.get("https://www.gittigidiyor.com/");
        driver.findElement(By.xpath("//input[@placeholder='Keşfetmeye Bak']")).sendKeys(aranacakKelimeler + Keys.ENTER);
    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        String data[][] = {{"java"}, {"javascript"}, {"python"}};

        return data;
    }

}
