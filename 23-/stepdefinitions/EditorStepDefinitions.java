package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import pages.EditorPage;
import utilities.Driver;

import java.security.Key;

public class EditorStepDefinitions {

    EditorPage editorPage=new EditorPage();

    @When("kullanici editor anasayfaya gider")
    public void kullaniciHttpsWwwEditorDatatablesNetAdresineGider() {
        Driver.getDriver().get("https://editor.datatables.net/");
    }

    @Then("new butonuna basar")
    public void new_butonuna_basar() {
    editorPage.newButonu.click();
    }

    @Then("firstname olarak {string} yazar")
    public void firstname_olarak_yazar(String firstname) {
    editorPage.firstNameBox.sendKeys(firstname);
    }

    @Then("lastname olarak {string} yazar")
    public void lastname_olarak_yazar(String lastname) {
        editorPage.lastNameBox.sendKeys(lastname);
    }

    @Then("Position olarak {string} yazar")
    public void position_olarak_yazar(String position) {
    editorPage.possitionBox.sendKeys(position);
    }

    @Then("Office olarak {string} yazar")
    public void office_olarak_yazar(String office) {
        editorPage.officeBox.sendKeys(office);

    }

    @Then("Extension olarak {string} yazar")
    public void extension_olarak_yazar(String extension) {
    editorPage.extensionBox.sendKeys(extension);
    }

    @Then("Start date olarak {string} yazar")
    public void start_olarak_yazar(String startDate) {
        editorPage.dateBox.sendKeys(startDate+Keys.TAB);
    }

    @Then("Salary olarak {string} yazar")
    public void salary_olarak_yazar(String salary) {
    editorPage.salary.sendKeys(salary);
    }

    @Then("Create tusuna basar")
    public void create_tusuna_basar() {
    editorPage.createButonElement.click();
    }

    @When("kullanici {string} ile arama yapar")
    public void kullanici_ile_arama_yapar(String firstname) {
    editorPage.searchBoxElement.sendKeys(firstname);
    }

    @Then("isim bolumunde {string} oldugunu dogrular")
    public void isim_bolumunde_oldugunu_dogrular(String firstname) {
    String sonucStr=editorPage.aramasonucuElement.getText();
        Assert.assertTrue(sonucStr.contains(firstname));
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int sure) {
        try {
            Thread.sleep(sure*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
