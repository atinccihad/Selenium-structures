package tests.i17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverFirstTest {

    @Test
    public void test01() {

        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.hepsiburada.com");
        Driver.quitDriver();

        /*
        Methotları utilities'den
        Web elementleri pages'den alıp
        Tests'te işlem yapacağız
         */
    }
}
