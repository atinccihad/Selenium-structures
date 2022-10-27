package i05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class TC016 extends TestBaseBeforeClassAfterClass {


    @Test
    public void testCase1() throws InterruptedException {
        driver.navigate().to("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("home page is not visible!", expectedUrl, actualUrl);

        // 4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // 5. Fill email, password and click 'Login' button
        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("tester@tester.qa");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("tester");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).submit();

        // 6. Verify 'Logged in as username' at top
        String username= "tester";
        WebElement usernameElementi = driver.findElement(By.xpath("//b[text()='tester']"));
        Assert.assertTrue("Girilen username ustte gorunmuyor!",usernameElementi.getText().equals(username));

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
        // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }

}
