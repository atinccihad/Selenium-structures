package stepdefinitions;

import com.google.gson.annotations.Until;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.DemoqaPage;
import utilities.Driver;

public class DemoqaStepDefinition {
    DemoqaPage demoqaPage =new DemoqaPage();
    @When("kullanici Alerts buttonuna tiklar")
    public void kullaniciAlertsButtonunaTiklar() {
demoqaPage.alerts.click();
    }

    @And("kullanici On button click, alert will appear after bes seconds karsisindaki click me  butonuna basar")
    public void kullaniciOnButtonClickAlertWillAppearAfterBesSecondsKarsisindakiClickMeButonunaBasar() {
        demoqaPage.clickMe2.click();
    }

    @And("kullanici Allertin gorunur olmasini bekler")
    public void kullaniciAllertinGorunurOlmasiniBekler() {
        Until until;
    }

    @And("kullanici Allert uzerindeki yazinin This alert appeared after bes seconds oldugunu test eder")
    public void kullaniciAllertUzerindekiYazininThisAlertAppearedAfterBesSecondsOldugunuTestEder() {
        Driver.getDriver().switchTo().alert().getText();
    }

    @And("kullanici ok diyerek alerti kapatir")
    public void kullaniciOkDiyerekAlertiKapatir() {
    }
}
