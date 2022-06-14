// 1- com.techproed altinda bir package olustur: smoketest
package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

// 2- Bir Class olustur: PositiveTest
public class PosistiveLoginTest {
    // 3- Bir test methodu olustur: positiveLoginTest()
    @Test
    public void positiveLoginTest(){
        //      https://www.hotelmycamp.com
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        //      login linkine bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        //   test data username: manager  ,
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        //   test data password: Manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.loginButonu.click();
        //   degerleri girildiginde sayfaya basarili bir sekilde girilebildigini test et.
        Assert.assertTrue(hotelMyCampPage.basariliGirisYazisiElementi.isDisplayed());

        Driver.closeDriver();
    }
}
