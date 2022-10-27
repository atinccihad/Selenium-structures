package i05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TC015 {
    WebDriver driver;

    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCase1() throws InterruptedException {
        // 3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("home page is not visible!", expectedUrl, actualUrl);

        // 4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // 5. Fill all details in Signup and create account
        // 5. Kayıt kısmındaki tüm detayları doldurun ve hesap oluşturun
        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("tester@tester.qa");
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("tester");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).submit();

        // 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        // 7. Verify ' Logged in as username' at top

        WebElement loggedInNameValue = driver.findElement(By.xpath("//b[text()='tester']"));
        String expectedUserName = "tester";
        String actualUserName = loggedInNameValue.getText();
        Assert.assertEquals("expected ve actual degerler esit degil!", expectedUserName, actualUserName);

        // 8. Add products to cart
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

        // 9. Click 'Cart' button
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        actions.sendKeys(Keys.DOWN).perform();
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[1]")).click();

        // 10. Verify that cart page is displayed
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        // 11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        // 12. Verify Address Details and Review Your Order
        WebElement page = driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        Assert.assertTrue(page.isDisplayed());

        // 13. Enter description in comment text area and click 'Place Order'
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement textArea = driver.findElement(By.xpath("//textarea[@class='form-control']"));
        textArea.sendKeys("TEST PASSED........................................");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();


        // 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("cardName" + Keys.TAB + "123456" + Keys.TAB + "571" + Keys.TAB + "03" + Keys.TAB + "1988");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        // 15. Click 'Pay and Confirm Order' button
        // 16. Verify success message 'Your order has been placed successfully!'
        WebElement congratulations = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(congratulations.isDisplayed());

        // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

        // 18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement deleteAccount = driver.findElement(By.xpath("//h1[text()='Delete Account']"));
        deleteAccount.click();

    }
}
