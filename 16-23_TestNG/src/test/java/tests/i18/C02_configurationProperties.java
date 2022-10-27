package tests.i18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_configurationProperties {

    @Test
    public void test01() {
        // amazon, facebook ve bestbuy sayfalarina gidiniz
        String amazonUrl = ConfigReader.getProperty("amazonUrl");
        String facebookUrl = ConfigReader.getProperty("facebookUrl");
        String bestbuyUrl = ConfigReader.getProperty("bestbuyUrl");

        Driver.getDriver().get(amazonUrl);
        Driver.getDriver().get(facebookUrl);
        Driver.getDriver().get(bestbuyUrl);

        Driver.quitDriver();
    }
}
