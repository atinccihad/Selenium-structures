package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {
    @Test(groups = {"miniRegression","smoke"})
    public void pozitifLoginTesti(){
        // 1- Bir Class olustur: C04_HotelMyCampPositiveLogin
        // 2- Bir test method olustur positiveLoginTest()
        //       https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();

        //   test data username: manager  ,
        hotelMyCampPage.userNameBox.sendKeys("manager");

        //   test data password: Manager1!
        hotelMyCampPage.passwordBox.sendKeys("Manager1!");
        hotelMyCampPage.loginButonu.click();

        // Degerleri girdiginde sayfaya basarili bir sekilde girildigini test et.


    }
}
