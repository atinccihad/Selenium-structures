package tests.i21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class H02 {
    HepsiburadaPage page;

    Actions actions;

    @Test
    public void hepsiburda() throws IOException, IOException {

        // Hepsiburada sayfasına gidiniz
        // Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        // Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanız resmini alalım
        // Sayfayı kapatalım

        page = new HepsiburadaPage();

        actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("hepsiburadaUrl"));

        ilkIkiTiklama(); // method

        int count = 1;
        for (int i = 0; i < page.kucukAltBasliklar.size(); i++) {

            page.kucukAltBasliklar.get(i).click();

            actions.sendKeys(Keys.PAGE_DOWN).perform();   // sayfayi kaydir
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            ReusableMethods.waitFor(1);

            ReusableMethods.getScreenshot("SS" + count);
            count++;

            //Driver.getDriver().navigate().back(); //sayfa geri
            ReusableMethods.waitFor(2);

            ilkIkiTiklama(); // method
        }

        Driver.closeDriver();
    }


    public void ilkIkiTiklama() { //method

        //Elektronikten Bilgisayar/Tablet sec
        actions.moveToElement(page.elektronics).perform();
        ReusableMethods.waitFor(1);

        actions.moveToElement(page.bilgisayarTablet).perform();
        ReusableMethods.waitFor(1);
    }
}
