package tests.i19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeTest {

    @Test
    public void negativeLoginTest1() {
        // yanlis username dogru password ile sisteme giris yapilamamali!
        // https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HMCPage hmcPage = new HMCPage();
        hmcPage.logInButton.click();

        //   test data username: manager ,
        hmcPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));

        //   test data password : Manager1!
        hmcPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCPassword"));
        hmcPage.logInButton2.click();

        //   Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapilamadiYaziElementi.isDisplayed(), "Login datalarini yanlis oldugu halde giris yapildi!");

        // Driver.quitDriver();
        Driver.quitDriver();
    }

    @Test
    public void negativeLoginTest2() {
        // dogru username yanlis password ile sisteme giris yapilamamali!
        // https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HMCPage hmcPage = new HMCPage();
        hmcPage.logInButton.click();

        //   test data username: manager ,
        hmcPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCUsername"));

        //   test data password : Manager1!
        hmcPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hmcPage.logInButton2.click();

        //   Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapilamadiYaziElementi.isDisplayed(), "Login datalarini yanlis oldugu halde giris yapildi!");

        // Driver.quitDriver();
        Driver.quitDriver();
    }

    @Test
    public void negativeLoginTest3() {
        // yanlis username yanlis password ile sisteme giris yapilamamali!
        // https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HMCPage hmcPage = new HMCPage();
        hmcPage.logInButton.click();

        //   test data username: manager ,
        hmcPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));

        //   test data password : Manager1!
        hmcPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hmcPage.logInButton2.click();

        //   Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapilamadiYaziElementi.isDisplayed(), "Login datalarini yanlis oldugu halde giris yapildi!");

        // Driver.quitDriver();
        Driver.quitDriver();
    }

}
