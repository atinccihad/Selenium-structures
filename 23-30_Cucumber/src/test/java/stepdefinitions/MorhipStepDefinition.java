package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WindowType;
import pages.MorhipoPage;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MorhipStepDefinition {
    MorhipoPage morhipoPage = new MorhipoPage();
    String morhipoUrunSayisiStr;
    TrendyolStepDefinition trendyolStepDefinition;
    int urunSayisiMorhipo;
    int urunSayisiTrerndyol;


    @Then("yeni sekmede {string} ya gidiniz")
    public void uAratiniz(String morhipoUrl) throws InterruptedException {
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("morhipoUrl"));
    }


    @Then("makas aratınız")
    public void makasAratınız() {
        morhipoPage.morhipoSearchBox.sendKeys("makas");
        morhipoPage.araButton.click();
    }


    @And("toplam ürün sayısını alınız")
    public void toplamÜrünSayısınıAlınız() {
        morhipoUrunSayisiStr = morhipoPage.morhipoToplamUrunSayisiElemnti.getText();
        System.out.println("morhipoUrunSayisiStr = " + morhipoUrunSayisiStr);
    }

    @Then("iki sitedeki toplam makas sayısını karşılastırınız")
    public void iki_sitedeki_toplam_makas_sayısını_karşılastırınız() {
        String[] arr = morhipoUrunSayisiStr.split(" ");
        urunSayisiMorhipo = Integer.parseInt(arr[0]);
        System.out.println("urunSayisiMorhipo = " + urunSayisiMorhipo);
        System.out.println("urunSayisiTrerndyol a cevirmeden once = " + trendyolStepDefinition.makasSayisiStr);
        urunSayisiTrerndyol = Integer.parseInt(trendyolStepDefinition.makasSayisiStr);
        System.out.println("urunSayisiTrerndyol = " + urunSayisiTrerndyol);
    }

    @Then("Önce ürün sayısı fazla olan siteyi kapatınız")
    public void önce_ürün_sayısı_fazla_olan_siteyi_kapatınız() {




    }

    @When("Sonra diğer sayfayıda kapatınız")
    public void sonra_diğer_sayfayıda_kapatınız() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}



