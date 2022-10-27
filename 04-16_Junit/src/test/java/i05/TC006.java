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

public class TC006 {
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
    public void testCase1() {
        // 3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue("home sekmesi gorunmuyor!!", home.isDisplayed());
        // 4. Click on 'Contact Us' button
        WebElement contactUs = driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactUs.click();

        // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue("'GET IN TOUCH' is not visible", getInTouch.isDisplayed());

        // 6. Enter name, email, subject and message
        WebElement nameBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        WebElement emailBox = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        WebElement subjectBox = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        WebElement yourMessageBox = driver.findElement(By.xpath("//textarea[@placeholder='Your Message Here']"));
        nameBox.sendKeys("name");
        emailBox.sendKeys("name@name");
        subjectBox.sendKeys("blabla");
        yourMessageBox.sendKeys("blablabla");

        // 7. Upload file
        //driver.findElement(By.xpath("//input[@type='file']")).click();

        // 8. Click 'Submit' button
        Actions actions = new Actions(driver);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        actions.scrollToElement(submitButton).perform();
        submitButton.submit();

        // 9. Click OK button
        driver.switchTo().alert().accept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue("success is not displayed!", success.isDisplayed());

        // 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue("actualUrl expectedUrl esit degil", actualUrl.equals(expectedUrl));
    }
}
