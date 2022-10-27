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
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TC011 {
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

        // 4. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        // 5. Scroll down to footer
        // 5. Altbilgiye ilerleyin
        driver.findElement(By.xpath("//u[text()='here']")).click();
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(subscription).perform();

        // 6. Verify text 'SUBSCRIPTION'
        String actualText = subscription.getText();
        String expectedText = "SUBSCRIPTION";
        Assert.assertTrue("textler esit degil!", actualText.equals(expectedText));

        // 7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("aaa@bbb.ccc");
        driver.findElement(By.xpath("(//button[@id='subscribe'])[1]")).click();

        // 8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement text = driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));
        String actualText2 = text.getText();
        String expectedText2 = "You have been successfully subscribed!";
        Assert.assertTrue("finished text test FAIL!", actualText2.equals(expectedText2));
    }

}
