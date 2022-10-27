package tests.i18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClassFacebookTest {

    @Test(groups = "group1")
    public void test01() {
        // https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        Faker faker = new Faker();
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.emailOrNumberBox.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordBox.sendKeys(faker.internet().password());

        // Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        facebookPage.loginButton.click();

        // Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());
    }
}
