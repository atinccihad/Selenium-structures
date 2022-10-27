package tests.i19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveTest {

    @Test
    public void positiveLoginTest() {
        // https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HMCPage hmcPage = new HMCPage();
        hmcPage.logInButton.click();

        //   test data username: manager ,
        hmcPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCUsername"));

        //   test data password : Manager1!
        hmcPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCPassword"));
        hmcPage.logInButton2.click();

        //   Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.logInOlmusKullaniciIsmi.isDisplayed());

        // Driver.quitDriver();
        Driver.quitDriver();
    }

}
