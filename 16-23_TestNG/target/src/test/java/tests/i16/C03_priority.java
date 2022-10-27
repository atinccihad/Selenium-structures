package tests.i16;

import org.testng.annotations.Test;
import utilities.TestNGBeforeMethodAfterMethod;

public class C03_priority extends TestNGBeforeMethodAfterMethod {

    /*
    Testlerimizi calistirirken belirledigimiz siraya gore calissin istersek priority notasyonunu kullaniriz
    priority kullanilmazsa default olarak 0 degerini alir.
     */

    @Test(priority = -1)
    public void youtubeTesti() {
        driver.get("https://www.youtube.com");
    }

    @Test(priority = -5,groups = "group1")
    public void bestBuyTesti() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = 1)
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test // priority olmadigi icin default int degeri kabul eder => 0
    public void hepsiburadaTesti() {
        driver.get("https://www.hepsiburada.com");
    }
}
