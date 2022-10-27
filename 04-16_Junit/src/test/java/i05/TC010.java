package i05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TC010 {
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
        // 4. Scroll down to footer
        // 4. Altbilgiye ilerleyin
        WebElement subscription = driver.findElement(By.xpath("(//div[@class='row'])[4]"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(subscription).perform();

        // 5. Verify text 'SUBSCRIPTION'
        String actualText = subscription.getText();
        String expectedText = "SUBSCRIPTION";
        Assert.assertNotEquals("actualText, expectedText'e esit degil!", expectedText, actualText);

        // 6. Enter email address in input and click arrow button
        // 6. Girişte e-posta adresini girin ve ok düğmesine tıklayın
        WebElement mailBoxSubmit = driver.findElement(By.xpath("//*[@class='fa fa-arrow-circle-o-right']"));
        WebElement mailBox = driver.findElement(By.xpath("//input[@type='email']"));
        mailBox.sendKeys("aasd@aaaff" + Keys.ENTER);
        mailBoxSubmit.submit();
        Thread.sleep(3000);

        // 7. Verify success message 'You have been successfully subscribed!' is visible
        // 7. Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür
        WebElement message = driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));
        Assert.assertTrue(message.isEnabled());

        Thread.sleep(3000);


    }
}
