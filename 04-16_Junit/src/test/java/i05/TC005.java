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

public class TC005 {
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
        //driver.close();
    }

    @Test
    public void testCase1() {
        // 3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue("home sekmesi gorunmuyor!!", home.isDisplayed());

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue("newUserSignUp is not displayed!", newUserSignUp.isDisplayed());

        // 6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("aaasss");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("aaasss@ccc");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@data-qa='signup-button'])")).click();

    }
}
