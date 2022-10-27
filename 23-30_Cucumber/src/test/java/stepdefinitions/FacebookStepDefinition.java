package stepdefinitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.Driver;

public class FacebookStepDefinition {
    @When("URL'nin {string} icerdigini test eder")
    public void urlNinIcerdiginiTestEder(String kelime) {

        String url = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(url.contains(kelime));
    }
}
