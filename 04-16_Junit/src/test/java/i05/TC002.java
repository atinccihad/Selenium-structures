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

import java.time.Duration;

public class TC002 {
    WebDriver driver;

    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testCase1() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement home = driver.findElement(By.xpath("//i[@class='fa fa-home']"));

        Assert.assertTrue("home sekmesi gorunmuyor!!", home.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue("Login to your account not displayed!", loginToYourAccount.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("klj@kljdaaaa.com" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("1234");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement username = driver.findElement(By.xpath("//b[text()='ppppppp']"));
        Assert.assertTrue("username notDisplayed!", username.isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        driver.findElement(By.xpath("//button[text()='Delete']")).click();

    }
}
