package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import pages.MorhipoPage;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;

public class GoogleStepDefinition {

    GooglePage googlePage=new GooglePage();

    @Given("Google'a gidiniz")
    public void kullanici_amazon_anasayfasinda() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }
    @Then("{string} u aratiniz")
    public void uAratiniz(String string) {
        string="trendyol";
        googlePage.searchBox.sendKeys(string,Keys.ENTER);
    }


    @And("trendyol linkini bulup siteye gidiniz")
    public void trendyolLinkiniBulupSiteyeGidiniz() {
        googlePage.trendyolLinki.click();
    }



}
