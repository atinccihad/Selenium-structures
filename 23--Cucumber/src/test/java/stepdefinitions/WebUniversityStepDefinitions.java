package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.WebUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniversityStepDefinitions {

    WebUniversityPage webUniversityPage=new WebUniversityPage();

    @Given("Login Portal'a kadar asagi iner")
    public void login_portal_a_kadar_asagi_iner() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Given("Login Portal'a Tiklar")
    public void login_portal_a_tiklar() {
       webUniversityPage.webUniversityLoginPortal.click();
    }

    @Then("acilan Diger window a gecer")
    public void acilan_diger_window_a_gecer() {
        ReusableMethods.switchToWindow("WebDriver | Login Portal");
    }

    @Then("{string} ve {string} kutularina deger yazar")
    public void veKutularinaDegerYazar(String username, String password) {
       webUniversityPage.webUniversityUsernameBox.sendKeys(username);
       webUniversityPage.webUniversityPasswordBox.sendKeys(password);
    }

    @Then("WebUniversity Login butonuna basar")
    public void web_university_login_butonuna_basar() {
       webUniversityPage.webUniversityLoginButton.click();
    }

    @Then("Popup'ta cikan yazinin {string} oldugunu test eder")
    public void popup_ta_cikan_yazinin_oldugunu_test_eder(String popUpYazi) {
        System.out.println(Driver.getDriver().switchTo().alert().getText());
        String alertYazisi=Driver.getDriver().switchTo().alert().getText();
        System.out.println(alertYazisi);
        Assert.assertEquals(popUpYazi,alertYazisi);
    }

    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
       Driver.getDriver().switchTo().alert().accept();
    }

    @Then("Ilk sayfaya geri doner")
    public void ilk_sayfaya_geri_doner() {
       ReusableMethods.switchToWindow("WebDriverUniversity.com");
    }
    @Then("Ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {
       String actualTitle=Driver.getDriver().getTitle();
       String expectedTitle="WebDriverUniversity.com";

       Assert.assertEquals(expectedTitle,actualTitle);
    }


}
