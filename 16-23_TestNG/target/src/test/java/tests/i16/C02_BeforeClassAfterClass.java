package tests.i16;

import org.testng.annotations.Test;
import utilities.TestNGBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestNGBeforeClassAfterClass {

    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void bestBuyTesti() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techProTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
