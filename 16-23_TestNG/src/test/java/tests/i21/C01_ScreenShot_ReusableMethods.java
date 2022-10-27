package tests.i21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.HepsiburadaPage;
import tests.log4J.Log4jTest1;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShot_ReusableMethods {

    private static Logger logger = LogManager.getLogger(C01_ScreenShot_ReusableMethods.class.getName());
    @Test
    public void test01() throws IOException {

        logger.info("hepsiburada sitesine gidilir");
        // https://www.hepsiburada.com  sayfasina gidip screenShot aliniz
        Driver.getDriver().get("https://www.hepsiburada.com");
        // searcBox'a tv yaziniz
        HepsiburadaPage hepsiburadaPage = new HepsiburadaPage();
        hepsiburadaPage.hepsiburadaSearchBox.sendKeys("tv" + Keys.ENTER);
        // sayfanin screenShot'ini aliniz
        logger.info("ekran goruntusu alinir");
        ReusableMethods.getScreenshot("sayfaSS");
        logger.warn("Driver closed");
        // sayfayi kapatiniz
        Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException {
        // Amazon sayfasina gidiniz "Nutella" aratiniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella", Keys.ENTER);
        // Arama sonuc yazisi webelementinin resmini aliniz
        ReusableMethods.getScreenshotWebElement("AramasonucuWE", amazonPage.aramaSonucElementi);

    }
}
