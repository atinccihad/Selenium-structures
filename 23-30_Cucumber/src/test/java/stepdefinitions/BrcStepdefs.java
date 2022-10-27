package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BlueRentACarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class BrcStepdefs {
    BlueRentACarPage blueRentACarPage = new BlueRentACarPage();

    @And("{string} username girer")
    public void usernameGirer(String username) {
      blueRentACarPage.breEmailBox.sendKeys(username);
    }

    @And("{string} password girer")
    public void passwordGirer(String sifre) {
        blueRentACarPage.brePasswordBox.sendKeys(sifre);
    }

    @And("brc Login butonuna basar")
    public void brcLoginButonunaBasar() {
        blueRentACarPage.breLoginButton.click();
    }

    @Then("brc sayfasina giris yapilamadigini kontrol eder")
    public void brcSayfasinaGirisYapilamadiginiKontrolEder() {
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {

    }
}
