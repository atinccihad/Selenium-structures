package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.AutomationPracticePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class AutomationStedefinition {
    AutomationPracticePage automationPracticePage = new AutomationPracticePage();


    @Given("Tarayıcıyı başlatarak {string} url'sine gidin")
    public void tarayıcıyı_başlatarak_url_sine_gidin(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
    }

    @Then("Ana sayfanın başarıyla görünür olduğunu doğrulayın")
    public void ana_sayfanın_başarıyla_görünür_olduğunu_doğrulayın() {
        String homeUrl = "https://automationexercise.com/";
        Assert.assertEquals("home url esit degil!", homeUrl, Driver.getDriver().getCurrentUrl());
    }

    @Then("Test Case buttonu na tıklayın")
    public void test_case_buttonu_na_tıklayın() {
        automationPracticePage.testCasesButton.click();
    }

    @Then("Kullanıcının test case sayfasına başarıyla yönlendirildiğini doğrulayın")
    public void kullanıcının_test_case_sayfasına_başarıyla_yönlendirildiğini_doğrulayın() {
        Assert.assertTrue("Kullanıcının test case sayfasına yönlendirildiği dogrulanamadi!", automationPracticePage.testCasesYazisi.isDisplayed());

    }

    @Then("İlgili sayfanın ekran görüntüsünü alın")
    public void i̇lgili_sayfanın_ekran_görüntüsünü_alın() {
        try {
            ReusableMethods.getScreenshot("TestCase07 Page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
