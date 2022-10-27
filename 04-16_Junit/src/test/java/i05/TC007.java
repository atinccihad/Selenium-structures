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

import java.time.Duration;

public class TC007 {
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
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue("homePage not displayed!", homePage.isDisplayed());

        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]")).click();

        // 5. Verify user is navigated to test cases page successfully
        WebElement testCasesBaslik = driver.findElement(By.xpath("//b[text()='Test Cases']"));
        Assert.assertTrue("test cases page not successfully", testCasesBaslik.isDisplayed());
    }
}
