package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.DatatablesPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DatatablesStepDefinitions {
    DatatablesPage datatablesPage = new DatatablesPage();
    Actions actions;


    @When("kullanici {string} adresine gider")
    public void kullaniciAdresineGider(String url) {
        Driver.getDriver().get(url);

    }

    @And("isim bolumune {string} girer")
    public void isimBolumuneGirer(String firstname) {
        datatablesPage.firstname.sendKeys(firstname);
    }


    @And("soyisim bolumune {string} girer")
    public void soyisimBolumuneGirer(String lastname) {
        actions.sendKeys(Keys.TAB).sendKeys(lastname).perform();
    }

    @And("position bolumune{string} girer")
    public void positionBolumuneGirer(String position) {
        actions.sendKeys(Keys.TAB).sendKeys(position).perform();
    }

    @And("ofis bolumune {string} girer")
    public void ofisBolumuneGirer(String ofis) {
        actions.sendKeys(Keys.TAB).sendKeys(ofis).perform();
    }

    @And("extension bolumune {string} girer")
    public void extensionBolumuneGirer(String extension) {
        actions.sendKeys(Keys.TAB).sendKeys(extension).perform();
    }

    @And("startdate bolumune{string}  girer")
    public void startdateBolumuneGirer(String startDate) {
        actions.sendKeys(Keys.TAB).sendKeys(startDate).perform();
    }

    @And("salary bolumune {string} girer")
    public void salaryBolumuneGirer(String salary) {
        actions.sendKeys(Keys.TAB).sendKeys(salary).perform();
    }

    @And("Create tusuna basar")
    public void createTusunaBasar() {
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
    }

    @When("kullanici {string} ile arama yapar")
    public void kullaniciIleAramaYapar(String firstname) {
        datatablesPage.search.sendKeys(firstname);
    }

    @Then("isim bolumunde {string} oldugunu dogrular")
    public void isimBolumundeOldugunuDogrular(String isim) {
        Assert.assertTrue(datatablesPage.isimVar.getText().contains(isim));
    }


}
