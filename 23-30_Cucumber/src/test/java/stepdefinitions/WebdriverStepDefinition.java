package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.WebdriverPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WebdriverStepDefinition {
    WebdriverPage web = new WebdriverPage();
    Actions actions = new Actions(Driver.getDriver());

    ArrayList<String> windows;
    String ilkWindow;
    @Given("kullanici {string} anasayfasinda")
    public void kullaniciAnasayfasinda(String url) {
         Driver.getDriver().get(url);
    }

    @Then("kullanici Login Portala kadar asagi iner")
    public void kullaniciLoginPortalaKadarAsagiIner() {
        ilkWindow = Driver.getDriver().getCurrentUrl();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @And("kullanici Login Portala tiklar")
    public void kullaniciLoginPortalaTiklar() {
        web.loginportal.click();
    }

    @And("kullanici diger windowa gecer")
    public void kullaniciDigerWindowaGecer() {
        windows = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windows.get(1));
    }

    @And("kullanici {string} kutusuna bilgileri girer")
    public void kullaniciKutusunaBilgileriGirer(String userName) {
        web.usernameBox.sendKeys(userName);
    }

    @And("kullanici {string} bolumune bilgileri girer")
    public void kullaniciBolumuneBilgileriGirer(String pass) {
        actions.sendKeys(Keys.TAB).sendKeys(pass).perform();
    }

    @And("kullanici login butonuna basar")
    public void kullaniciLoginButonunaBasar() {
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    @And("kullanici Popup'ta cikan yazinin validation failed oldugunu test eder")
    public void kullaniciPopupTaCikanYazininValidationFailedOldugunuTestEder() {
        String actualPopupText = Driver.getDriver().switchTo().alert().getText();
        String expectedPopupText = "validation failed";
        Assert.assertEquals(expectedPopupText, actualPopupText);
    }

    @And("kullanici Ok diyerek Popup'i kapatir")
    public void kullaniciOkDiyerekPopupIKapatir() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @And("kullanici ilk sayfaya geri doner")
    public void kullaniciIlkSayfayaGeriDoner() {
        Driver.getDriver().switchTo().window(windows.get(0));
    }

    @And("kullanici ilk sayfaya donuldugunu test eder")
    public void kullaniciIlkSayfayaDonuldugunuTestEder() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ilkWindow);


    }


}
