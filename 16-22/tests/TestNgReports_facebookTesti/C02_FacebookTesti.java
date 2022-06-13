package tests.day22;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_FacebookTesti extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest=extentReports.createTest("facebook","fake isimle girilemedigi test edildi.");

        // 1- https://www.facebook.com/  adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        extentTest.info("facebook sayfasina gidildi.");
        FacebookPage facebookPage=new FacebookPage();
        /*facebookPage.facebookCookies.click();*/
        /*extentTest.info("cookies halledildi");*/

        // 2- POM' a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        // 3- Faker class ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();
        extentTest.info("facebook giris bilgileri faker ile dolduruldu");

        // 4- Basarili giris yapilamadigini test edin.
        Assert.assertTrue(facebookPage.girilemediYazisiElementi.isDisplayed());
        extentTest.pass("girilemedigi test edildi.");

    }

}
