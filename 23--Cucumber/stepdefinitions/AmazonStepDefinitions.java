package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class AmazonStepDefinitions {
    @Given("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get("https://www.amazon.com");
    }
    @Given("iPhone icin arama yapar")
    public void i_phone_icin_arama_yapar() {

    }
    @Then("sonuclarin Iphone icerdigini test eder")
    public void sonuclarin_iphone_icerdigini_test_eder() {

    }
    @Given("tea pot icin arama yapar")
    public void tea_pot_icin_arama_yapar() {

    }
    @Then("sonuclarin tea pot icerdigini test eder")
    public void sonuclarin_tea_pot_icerdigini_test_eder() {

    }
    @Given("flower icin arama yapar")
    public void flower_icin_arama_yapar() {

    }
    @Then("sonuclarin flower icerdigini test eder")
    public void sonuclarin_flower_icerdigini_test_eder() {

    }

}
