package tests.i18;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestNGBeforeClassAfterClass;

// 1) Bir Class olustur : C03_ConfigReader
public class C03_ConfigReader {

    // 2) Bir test method olustur positiveLoginTest()
    @Test(groups = "group2")
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
