package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.TutorialninjaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class TutorialninjaStepDefinition {

    TutorialninjaPage tutorialninjaPage = new TutorialninjaPage();

    @Given("tutorialsninjaUrl sayfasına gidiniz")
    public void tutorialsninjaurlSayfasınaGidiniz() {
        Driver.getDriver().get(ConfigReader.getProperty("tutorialsninjaUrl"));
    }


    @Then("Phones & PDAs'a tıklayınız")
    public void phonesPDAsATıklayınız() {
        tutorialninjaPage.phonesPda.click();
    }

    @Then("Telefonların markalarını alınız")
    public void telefonlarınMarkalarınıAlınız() {
        List<WebElement> telefonlar = tutorialninjaPage.phoneMarkalari;
        int sira = 1;
        for (WebElement each : telefonlar) {
            System.out.println(sira + ". telefon: " + each.getText());
            sira++;
        }
    }

    @When("Tüm öğeleri sepete ekleyiniz")
    public void tümÖğeleriSepeteEkleyiniz() {
        List<WebElement> telefonlar = tutorialninjaPage.telefonlar;

        for (int i = 0; i < telefonlar.size(); i++) {
            telefonlar.get(i).click();
            tutorialninjaPage.addToCartButton.click();
            Driver.getDriver().navigate().back();
        }
    }

    @Then("Sepete tıklayınız")
    public void sepeteTıklayınız() {
        tutorialninjaPage.ilkTelefon.click();
        tutorialninjaPage.sepetButton.click();
    }

    @When("Sepetteki isimleri alınız")
    public void sepettekiIsimleriAlınız() {
        List<WebElement> sepettekiUrunler = tutorialninjaPage.sepettekiUrunler;
        int sira = 1;
        for (WebElement each : sepettekiUrunler) {
            System.out.println("Sepetteki " + sira + ". urun " + each.getText());
            sira++;
        }
    }

    @And("Sepetteki ve sayfadaki ürünlerin doğru olduğunu karşılaştırınız")
    public void sepettekiVeSayfadakiÜrünlerinDoğruOlduğunuKarşılaştırınız() {

        List<WebElement> telefonlar = tutorialninjaPage.telefonlar;
        List<WebElement> sepettekiUrunler = tutorialninjaPage.sepettekiUrunler;
        int count = 0;

        for (int i = 0; i < telefonlar.size(); i++) {
            if (telefonlar.get(i).getText().equals(sepettekiUrunler.get(i).getText())) {
                count++;
            }
        }
        if (count == telefonlar.size()) {
            System.out.println("Sayfadaki ve sepetteki,urun dogrulama testi PASS");
        } else {
            System.out.println("Sayfadaki ve sepetteki,urun dogrulama testi FAIL");
        }


    }


}
