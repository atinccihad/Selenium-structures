package tests.i20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_positiveTest {

    @Test
    public void pozitifTest() {
        //https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HMCPage hmcPage = new HMCPage();
        /*Page class'ındaki locate'lerimize ulaşabilmek için
        Page classımızdan bir obje oluşturarak, oluşturmuş olduğumuz obje ile
        page classımızdaki locate'lerimize ulaşabiliriz
         */
        // hmcPage.logInButton.click();

        ReusableMethods.jsExecutorClick(hmcPage.logInButton);
        // test data username: manager ,
        // test data password : Manager1!
        hmcPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCUsername"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("HMCPassword"))
                .sendKeys(Keys.ENTER).perform();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.logInOlmusKullaniciIsmi.isDisplayed());
        // Driver.closeDriver();
        Driver.closeDriver();
    }
}
