package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    /*
    -Amazon sayfasina gidelim
     3 farkli test methodu olusturalim
       a- Url'nin amazon icerdigini test ediniz
       b- title'in facebook icerdigini test edelim
       c- sol ust kosede amazon logosunun gorundugunu test edelim.
       d- Url'nin https://www.facebook.com oldugunu test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // a- Url'nin amazon icerdigini test ediniz
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void test02() {
        // b- title'in facebook icermedigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(2000);
        // c- sol ust kosede amazon logosunun gorundugunu test edelim.
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test04() {
        // d- Url'nin https://www.facebook.com olmadigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com";
        Assert.assertNotEquals(actualUrl, expectedUrl);
    }

}
