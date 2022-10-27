package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class AmazonStepDefinition {

    AmazonPage amazonPage = new AmazonPage();
    Set<String> windowHandles;
    String windowHandleAmazon;

    @Given("kullanici amazon anasayfasina gider")
    public void kullanici_amazon_anasayfasinda() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @Then("kullanici Nutella icin arama yapar")
    public void kullanici_nutella_icin_arama_yapar() {
        amazonPage.amazonSearchBox.sendKeys("Nutella" + Keys.ENTER);
    }

    @Then("kullanici sonuclarin Nutella icerdigini test eder")
    public void kullanici_sonuclarin_nutella_icerdigini_test_eder() {
        String arananKelime = "Nutella";
        String actualAramaSonucStr = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucStr.contains(arananKelime));
    }


    @Then("kullanici Selenium icin arama yapar")
    public void kullaniciSeleniumIcinAramaYapar() {
        amazonPage.amazonSearchBox.sendKeys("Selenium" + Keys.ENTER);
    }

    @And("kullanici sonuclarin Selenium icerdigini test eder")
    public void kullaniciSonuclarinSeleniumIcerdiginiTestEder() {
        String arananKelime = "Selenium";
        String actualAramaSonucStr = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucStr.contains(arananKelime));
    }

    @Then("kullanici iphone aramasi yapar")
    public void kullaniciIphoneAramaYapar() {
        amazonPage.amazonSearchBox.sendKeys("iphone" + Keys.ENTER);
    }

    @And("kullanici sonuclarin iphone icerdigini test eder")
    public void kullaniciSonuclarinIphoneIcerdiginiTestEder() {
        String arananKelime = "iphone";
        String actualAramaSonucStr = amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucStr.contains(arananKelime));
    }

    @Then("kullanici {string} icin arama yapar")
    public void kullanici_icin_arama_yapar(String arananKelime) {
        amazonPage.amazonSearchBox.sendKeys(arananKelime+Keys.ENTER);
    }

    @Then("kullanici sonuclarin {string} icerdigini test eder")
    public void kullanici_sonuclarin_icerdigini_test_eder(String arananKelime) {
       String sonucYazisiStr = amazonPage.aramaSonucElementi.getText();
       Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
    }

    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String istenenUrl) {
        ConfigReader.getProperty(istenenUrl);
        Driver.getDriver().get(istenenUrl);
        windowHandles=Driver.getDriver().getWindowHandles();
        windowHandleAmazon = Driver.getDriver().getWindowHandle();
        System.out.println(windowHandles);

    }

    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.closeDriver();
    }


    @Given("kullanici {string} anasayfasina gider")
    public void kullaniciAnasayfasinaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));

    }

    @When("Url'in {string} icerdigini test edelim")
    public void urlInIcerdiginiTestEdelim(String istenenUrl) {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenUrl));
    }

    @Then("kullanici {int} sn bekler")
    public void kullaniciSnBekler(int sure) {
        ReusableMethods.waitFor(sure);
    }
}
