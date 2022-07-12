package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DemoQaPage;
import utilities.ReusableMethods;

public class DemoQaStepDefinitions {
    DemoQaPage demoQaPage=new DemoQaPage();

    @Then("Will enable {int} seconds butonunun enable olmasini bekler")
    public void will_enable_secons_butonunun_enable_olmasini_bekler(Integer int1) {
        ReusableMethods.waitForClickablility(demoQaPage.willEnable5SecondElement,15);

    }
    @Then("Will enable {int} seconds butonunun enable oldugunu test eder")
    public void will_enable_seconds_butonunun_enable_oldugunu_test_eder(Integer int1) {
        Assert.assertTrue(demoQaPage.willEnable5SecondElement.isEnabled());

    }

}
