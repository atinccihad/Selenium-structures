package tests.smokeTest;

import io.netty.handler.codec.DecoderResult;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

// 1- NegativeLoginTest
public class NegativeLoginTest {
    //     3farkli test methodunda 3 seneryoyu test et
    //          - yanliSifre
    //          - yanlisKullanici
    //          - yanlisSifreKullanici
    //    test data yanli username: manager1 , yanlis password : manager1
    // 2- https://www.hotelmycamp.com adresine git
    // 3- Login butonuna bas
    // 4- Verilen seneryolar ile giris yapilamadigini test et.

    HotelMyCampPage hotelMyCampPage;

    @Test
    public void yanlisSifreTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisSifreUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }

}
