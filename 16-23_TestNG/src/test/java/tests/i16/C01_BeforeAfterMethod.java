package tests.i16;

import org.testng.annotations.Test;
import utilities.TestNGBeforeMethodAfterMethod;

public class C01_BeforeAfterMethod extends TestNGBeforeMethodAfterMethod {

    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test(groups = "group1")
    public void bestBuyTesti() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techProTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
