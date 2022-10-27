package tests.i19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class H01 {

    @Test
    public  void test01() throws InterruptedException {
        HepsiburadaPage hepsiburadaPage = new HepsiburadaPage();
        // https://www.hepsiburada.com/  adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        // Basligin "Turkiye'nin En Buyuk Alisveris Sitesi"  icerdigini dogrulayin
        System.out.println("title: "+Driver.getDriver().getTitle());
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigReader.getProperty("hepsiburadaActualTitle")),"Basligin 'Turkiye'nin En Buyuk Alisveris Sitesi'  icermiyor!");

        Thread.sleep(1000);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.DOWN).perform();

        // SearchBox a "araba" yazip aratin
        hepsiburadaPage.hepsiburadaSearchBox.sendKeys("araba", Keys.ENTER);
        // Bulunan sonuc sayisini yazdirin
        System.out.println("Sonuc yazisi: " + hepsiburadaPage.hepsiburadaAramaSonucYazisi.getText());
        // Sonuc yazisinin "araba" icerdigini dogrulayin
        Assert.assertTrue(hepsiburadaPage.hepsiburadaAramaSonucYazisi.getText().contains("araba"), "Sonuc yazisi 'araba' icermiyor!");
        // Sonuc yazisinin "oto" icermedigini dogrulayin
        Assert.assertFalse(hepsiburadaPage.hepsiburadaAramaSonucYazisi.getText().contains("oto"), "Sonuc yazisi 'oto' iceriyor!");
    }
}
