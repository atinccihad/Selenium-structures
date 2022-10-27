package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BlueRentACarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class BlueRentACarStepDefinition {

    BlueRentACarPage blueRentACarPage = new BlueRentACarPage();

    @Given("kullanici bluerentacar ana sayfasinda")
    public void kullaniciBluerentacarAnaSayfasinda() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentAcarUrl"));
    }

    @Then("Login yazisina tiklar")
    public void loginYazisinaTiklar() {
        blueRentACarPage.breLoginButton.click();
    }

    @And("gecersiz username girer")
    public void gecersizUsernameGirer() {
        blueRentACarPage.breEmailBox.sendKeys("asd@sds.com");
    }

    @And("gecersiz password girer")
    public void gecersizPasswordGirer() {
        blueRentACarPage.brePasswordBox.sendKeys("asdsd2");
    }

    @And("Login butonuna basar")
    public void loginButonunaBasar() {
        blueRentACarPage.getBreLoginButton2.click();
    }

    @Then("sayfaya giris yapilamadigini kontrol eder")
    public void sayfayaGirisYapilamadiginiKontrolEder() {
        String expectedUrl = "https://www.bluerentalcars.com/login";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @And("kulllanici sayfayi kapatir")
    public void kulllaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
}
