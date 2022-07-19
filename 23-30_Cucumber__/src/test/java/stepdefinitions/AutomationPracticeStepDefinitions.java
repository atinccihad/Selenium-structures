package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AutomationPracticePage;
import utilities.ConfigReader;

public class AutomationPracticeStepDefinitions {
    AutomationPracticePage automationPracticePage=new AutomationPracticePage();

    @Given("user sign in linkine tiklar")
    public void user_sign_in_linkine_tiklar() {
      automationPracticePage.signInLinki.click();
    }
    @Given("email kutusuna @isareti olmayan email adres yazar ve enter'a tiklar")
    public void email_kutusuna_isareti_olmayan_email_adres_yazar_ve_enter_a_tiklar() {
       automationPracticePage.emailKutusuTextBox.sendKeys(ConfigReader.getProperty("AutomationPracticeYanlisEmail")+ Keys.ENTER);
    }
    @Then("error mesajinin {string} oldugunu dogrulayin")
    public void error_mesajinin_oldugunu_dogrulayin(String string) {
       String actualHataYazisi=automationPracticePage.invalidEmailYazisiElementi.getText();
       String expectedHataYazisi=ConfigReader.getProperty("AutomationPracticeHataYazisi");

        Assert.assertNotEquals(expectedHataYazisi,actualHataYazisi);
    }
}
