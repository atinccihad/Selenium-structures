package tests.i23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC16_PlaceOrderLoginBeforeCheckout {
    //extends TestBaseRapor
    AutomationExercisePage automationExercisePage;


    @Test
    public void test01() throws InterruptedException {
        automationExercisePage = new AutomationExercisePage();
        //extentTest=extentReports.createTest("automationexcercise","Web automation");
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        //extentTest.info("1. Tarayıcıyı başlat\n" +
        //"2. 'http://automationexercise.com' url'sine gidin");
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));

        // 3. Verify that home page is visible successfully
        // extentTest.info("3. Verify that home page is visible successfully");
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Url eslesmiyor!");

        // 4. Click 'Signup / Login' button
        // extentTest.info("4. Click 'Signup / Login' button successfully");
        automationExercisePage.signUpLoginButton.click();

        // 5. Fill email, password and click 'Login' button
        // extentTest.info("5. Fill email, password and click 'Login' button test successfully");
        automationExercisePage.newUserSignUpNameBox.sendKeys("cihad" + Keys.ENTER);
        Thread.sleep(3000);
        automationExercisePage.newUserSignUpMailBox.sendKeys("qa@qatest.com");
        automationExercisePage.newUserSignUpButton.click();

        automationExercisePage.newUserMrRadioButton.click();
        automationExercisePage.newUserPasswordBox.sendKeys("password");
        ReusableMethods.jsExecutorScrool(automationExercisePage.newUserYear);
        automationExercisePage.newUserDay.sendKeys("12");
        automationExercisePage.newUserMonth.sendKeys("March");
        automationExercisePage.newUserYear.sendKeys("1988");
        ReusableMethods.jsExecutorScrool(automationExercisePage.newUserLastName);
        automationExercisePage.newUserFirstName.sendKeys("cihad");
        automationExercisePage.newUserLastName.sendKeys("Atınç");
        automationExercisePage.newUserCompany.sendKeys("35");


        // 6. Verify 'Logged in as username' at top
        // 7. Add products to cart
        // 8. Click 'Cart' button
        // 9. Verify that cart page is displayed
        // 10. Click Proceed To Checkout
        // 11. Verify Address Details and Review Your Order
        // 12. Enter description in comment text area and click 'Place Order'
        // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        // 14. Click 'Pay and Confirm Order' button
        // 15. Verify success message 'Your order has been placed successfully!'
        // 16. Click 'Delete Account' button
    }

}
