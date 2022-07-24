package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_PropertiesIlkClass {

    @Test
    public void positiveLoginTesti(){
        // Hotelmycamp sitesine positive login testini POM' a tam uygun olarak yapiniz.

        //     https://www.hotelmycamp.com/  adresine git
        //Driver.getDriver().get("buraya yapistirmak icin, properties dosyasina git HMCUrl'e karsilik gelen degeri getir..");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        //     Login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();

        //     test data username: manager1 ,
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));

        //     test data password: manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.bekle(3);
        hotelMyCampPage.loginButonu.click();

        //     Degerleri girildiginde sayfaya girilmedigini test et.
        Assert.assertTrue(hotelMyCampPage.basariliGirisYazisiElementi.isDisplayed());

        Driver.closeDriver();
    }

}
