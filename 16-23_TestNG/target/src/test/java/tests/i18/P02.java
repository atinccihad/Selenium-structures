package tests.i18;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SaucedemoPage;
import utilities.Driver;

public class P02 {

    @Test
    public void test01() {
        SaucedemoPage saucedemoPage=new SaucedemoPage();
        //     * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");
        //     * Enter the username  as standard_user
        saucedemoPage.usernameBox.sendKeys("standard_user");
        //     * Enter the password as   secret_sauce
        saucedemoPage.passwordBox.sendKeys("secret_sauce");
        //     * Click on login button
        saucedemoPage.loginButton.click();
        //     * Choose price low to high
        Select select=new Select(saucedemoPage.dropdownElementi);
        select.selectByVisibleText(saucedemoPage.dropdownPriceLowToHigh.getText());
        //       and verify that PRICE (LOW TO HIGH) is visible
        Assert.assertTrue(saucedemoPage.dropdownPriceLowToHigh.isDisplayed(),"PRICE (LOW TO HIGH) is not visible!");

    }
}
