package tests.i23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_DataProvider extends TestBaseRapor {
    AmazonPage amazonPage;

    @Test
    public void test01() {
        ReusableMethods.waitFor(3);
        amazonPage = new AmazonPage();
        //Amazon sayfasına gidelim
        extentTest = extentReports.createTest("Amazon Testi", "Amazon Testi dogrulandi");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella için arama yapalım
        extentTest.info("Nutella aramasi yapildi.");
        amazonPage.amazonSearchBox.sendKeys("Nutella", Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        extentTest.info("sonuclarin nutella icerdigi dogrulandi.");
        String expectedKelime = "Nutella";
        String actualKelime = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        extentTest.pass("actualKelime.contains(expectedKelime) testi PASS");
    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        ReusableMethods.waitFor(3);
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test(dataProvider = "aranacakKelimeler")
    public void test02(String kelimeler) {
        ReusableMethods.waitFor(3);
        amazonPage = new AmazonPage();
        //amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.amazonSearchBox.sendKeys(kelimeler, Keys.ENTER);
        //sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        Driver.quitDriver();
    }
}
