package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TrendyolStepDefinition {

    TrendyolPage trendyolPage = new TrendyolPage();
    String makasSayisiStr = "";
    Actions actions = new Actions(Driver.getDriver());
    String ilkSayfaWindowHandle = "";

    @Then("{string} aratınız")
    public void uAratiniz(String aranacakUrun) throws InterruptedException {

        trendyolPage.sanaOzelBirDeneyimIcinCalisiyoruz.click();

        aranacakUrun = "makas";
        //Driver.getDriver().switchTo().alert().accept();
        trendyolPage.searchBoxTrendyol.click();
        Thread.sleep(3000);
        trendyolPage.searchBoxTrendyol.sendKeys(aranacakUrun + Keys.ENTER);
    }

    @Then("toplam ürün sayısıni alınız")
    public void toplamÜrünSayısıniAlınız() {
        String toplamMakasUrunSayisiTrendyol = trendyolPage.toplamUrunSayisiTrendyolWE.getText();
        System.out.println("Urun arama sonucu yazisi trendyol: " + toplamMakasUrunSayisiTrendyol);

        String[] toplamMakasUrunSayisiTrendyolArr = toplamMakasUrunSayisiTrendyol.split(" ");
        makasSayisiStr = toplamMakasUrunSayisiTrendyolArr[3];
        System.out.println("trendyolToplamUrunSayisiElemnti = " + makasSayisiStr);
    }


    @Then("cerezleri kabul eder")
    public void cerezleriKabulEder() {
        trendyolPage.sanaOzelBirDeneyimIcinCalisiyoruz.click();
    }

    @Then("trendyol ana sayfasindaki giris yap butonuna tiklar")
    public void trendyolAnaSayfasindakiGirisYapButonunaTiklar() {

        trendyolPage.girisYapButton.click();

    }

    @Then("eposta ve sifre boxlarini doldurur ve giris yapar")
    public void epostaVeSifreBoxlariniDoldururVeGirisYapar() {
        trendyolPage.emailBoxTrendyol.sendKeys("cihadatinctest@gmail.com");
        trendyolPage.passwordBoxTrendyol.sendKeys("test12345@GGG");
        trendyolPage.submitButtonTrendyol.click();
    }

    @And("ELEKTRONIK basligi altinda Bilgisayar & Tablet basligina tiklar")
    public void basligiAltindaBasliginaTiklar() {
        ReusableMethods.waitFor(2);
        actions.moveToElement(trendyolPage.elektronikMenuTrendyol).perform();
        trendyolPage.bilgisayartabletMenuTrendyol.click();
    }

    @And("sol taraftaki ilgili kategoriler'den  {string} secer")
    public void solTaraftakiIlgiliKategorilerDenSecer(String bilgisayar) {
        actions.click(trendyolPage.bilgisayarKategoriTrendyol).perform();
    }

    @And("sol tarafta marka kategorisi altinda {string} i secer")
    public void solTaraftaMarkaKategorisiAltindaISecer(String arg0) {
        ReusableMethods.waitFor(3);
        actions.doubleClick(trendyolPage.checkboxApple).perform();
    }

    @Then("ilk urune tiklar")
    public void ilkUruneTiklar() {
        ReusableMethods.waitFor(2);
        actions.click(trendyolPage.markaAppleIlkUrun).perform();
        ArrayList<String> pencereHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(pencereHandles.get(1));

    }

    @Then("kullanici urunu incelemek icin urun fotografi uzerine mouse'la gider")
    public void kullaniciUrunuIncelemekIcinUrunFotografiUzerineMouseLaGider() {
        actions.moveToElement(trendyolPage.zoom).perform();
        ReusableMethods.waitFor(5);
    }


    @And("urun fotografinin altindaki urunun diger forograflarini inceler")
    public void urunFotografininAltindakiUrununDigerForograflariniInceler() {
        for (WebElement each : trendyolPage.urunler) {
            each.click();
            ReusableMethods.waitFor(2);
        }
    }

    @And("urunu sepete ekler")
    public void urunuSepeteEkler() {
        actions.doubleClick(trendyolPage.sepeteEkleButton).perform();
        ReusableMethods.waitFor(3);
    }

    @And("Sepeti onaylar")
    public void sepetiOnaylar() {
       // trendyolPage.sepetim.click();
        actions.click(trendyolPage.sepetiOnaylaButton).perform();
      //  Driver.getDriver().findElement(By.xpath("//button[text()='Anladım']")).click();
        Driver.getDriver().findElement(By.xpath("(//button[@class=\"ty-primary-btn ty-btn-large\"])[1]")).click();

    }

    @And("test adresi radio butonunun secili oldugunu dogrular")
    public void testAdresiRadioButonununSeciliOldugunuDogrular() {

        Assert.assertTrue(trendyolPage.sestAdresiButton.isDisplayed());
    }

    @And("kaydet ve devam et butonuna tiklar")
    public void kaydetVeDevamEtButonunaTiklar() {
        trendyolPage.kaydetdevamEButton.click();
    }

    @And("odeme secekleri sayfasinda oldugunu dogrular")
    public void odemeSecekleriSayfasindaOldugunuDogrular() {
        Assert.assertTrue(trendyolPage.odemeSecenekleri.isDisplayed());
    }

    @And("kart bilgilerini girer")
    public void kartBilgileriniGirer() {


trendyolPage.odemeYapButton.click();

    }

    @And("Lutfen belirtilen lanlari kontrolediniz uyarisini dogrular")
    public void lutfenBelirtilenLanlariKontroledinizUyarisiniDogrular() {
    }

    @And("Siparis ozeti alaninin ekran resmini alir")
    public void siparisOzetiAlanininEkranResminiAlir() {
    }

    @And("Sayfayi kapatir")
    public void sayfayiKapatir() {
    }


}
