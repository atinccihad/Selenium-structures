package tests.i17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class H02 {

    @Test
    public void wrongMailTest() {
        // http://automationpractice.com/index.php  sayfasina gidelim
        Driver.getDriver().get("http://automationpractice.com/index.php");

        // Sign in butonuna basalim
        Driver.getDriver().findElement(By.xpath("(//a[@href=\"http://automationpractice.com/index.php?controller=my-account\"])[1]")).click();

        // Email kutusuna @isareti olmayan bir mail yazip enter'a bastihimizda "Invalid mail address" uyarisi ciktigini test edelim
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("(//input[@class=\"is_required validate account_input form-control\"])[1]"));
        emailBox.sendKeys("aaaaaaasdsdsafsdfsfasfaf", Keys.ENTER);
        WebElement invalidEmailMessageWE = Driver.getDriver().findElement(By.xpath("//li[text()=\"Invalid email address.\"]"));

        SoftAssert softAssert = new SoftAssert();
        String invalidEmailMessageStr = invalidEmailMessageWE.getText();
        String expectedInvalidEmailMessageStr = "Invalid email address.";
        softAssert.assertEquals(invalidEmailMessageStr, expectedInvalidEmailMessageStr, "Invalid mail address  yazisi gorunmuyor!");
        softAssert.assertAll();

        // Driver.closeDriver();
        Driver.closeDriver();


    }
}
