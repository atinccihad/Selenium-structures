package tests.day17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

// 1- C01_HotelMyCampNegativeLogin
public class C01_HotelMyCampNegativeLogin {


    @Test
    public void test01(){
        // 2- Bir test method olustur NegativeLoginTest()
        //     https://www.hotelmycamp.com/  adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        //     Login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();

        //     test data username: manager1 ,
        hotelMyCampPage.userNameBox.sendKeys("manager1");

        //     test data password: manager1!
        hotelMyCampPage.passwordBox.sendKeys("manager1!");
        hotelMyCampPage.loginButonu.click();

        //     Degerleri girildiginde sayfaya girilmedigini test et.
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
