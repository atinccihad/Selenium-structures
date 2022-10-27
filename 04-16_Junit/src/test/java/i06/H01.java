package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// Bir Class olusturalim H01
public class H01 {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        // Sign in butonuna basalim
        driver.findElement(By.xpath("//div[@class='header_user_info']")).click();

        // Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("mehmet.gmail" + Keys.ENTER);
        WebElement alert = driver.findElement(By.xpath("//div[@id='create_account_error']"));
        Thread.sleep(3000);
        Assert.assertFalse(alert.isDisplayed());
    }
}
