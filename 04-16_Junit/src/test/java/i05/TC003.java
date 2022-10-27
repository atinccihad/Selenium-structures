package i05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC003 {
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
        WebElement homeKey = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        if (homeKey.isDisplayed()) {
            System.out.println("Ana sayfa testi PASSED");
        } else {
            System.out.println("Ana sayfa testi FAILED");
        }
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (loginToYourAccount.isDisplayed()) {
            System.out.println("loginToYourAccount is visible");
        } else {
            System.out.println("loginToYourAccount is not visible");
        }
        // 6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("dddd@ddd.com" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("1234");

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement error = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        if (error.isDisplayed()) {
            System.out.println("'Your email or password is incorrect!' is visible");
        } else {
            System.out.println("'Your email or password is incorrect!' is not visible");
        }
    }

}
