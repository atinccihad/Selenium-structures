package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EditorPage;
import utilities.ConfigReader;
import utilities.Driver;

public class EditorStepDefinitions {

    EditorPage editorPage = new EditorPage();

    @When("kullanici  {string} adresine gider")
    public void kullaniciAdresineGider(String url) {
       // Driver.getDriver().get("https://editor.datatables.net");
       // url = "https://editor.datatables.net";
        Driver.getDriver().get(url);

    }

    @Then("new butonuna basar")
    public void newButonunaBasar() {
        editorPage.editorNewButton.click();
    }

    @And("firstname olarak {string} yazar")
    public void firstnameOlarakYazar(String firstname) {


    }

    @And("lastname olarak {string} yazar")
    public void lastnameOlarakYazar(String lastname) {

    }

    @And("position olarak {string} yazar")
    public void positionOlarakYazar(String position) {
    }
}
