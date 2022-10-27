package tests.i23;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.HepsiburadaPage;
import utilities.*;

public class Q_01 extends TestNGBeforeMethodAfterMethod {
    // http://amazon.com adresine gidiniz
    // araba, ev, anahtarlik, ayakkabi, gomlek kelimelerini aratiniz
    AmazonPage amazonPage = new AmazonPage();
    HepsiburadaPage hepsiburadaPage = new HepsiburadaPage();


    @Test(dataProvider = "urunler")
    public void amazonTest(String kelime) {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.amazonSearchBox.sendKeys(kelime + Keys.ENTER);

    }

    @DataProvider(name = "urunler")
    public Object[][] getUrunler() {
        String[][] urunler = {{"araba"}, {"ev"}, {"anahtarlik"}, {"ayakkabi"}, {"gomlek"}};
        return urunler;
    }

    // http://hepsiburada.com adresine gidiniz
    // java, javascript, python kelimelerini aratiniz
    @Test(dataProvider = "aranacakKelimeler")
    public void hepsiburada(String aranacakKelime) {
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));
        hepsiburadaPage.hepsiburadaSearchBox.sendKeys(aranacakKelime + Keys.ENTER);
    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        String[][] data = {{"java"}, {"javascript"}, {"python"}};
        return data;
    }

}
