package i11_i09_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {
    // birbirine bagimli testler olusturun..
    // BeforeClass olusturup setUp ayarlarini yapin..
    // birbirine bagimli testler olusturarak;
    // ilk once facebook'a gidin
    // sonra facebook'a bagimli olarak google'a gidin,
    // daha sonra google'a bagimli olarak amazon'a gidin
    // driver'i kapatin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void facebookTest() {
        driver.get("https://www.facebook.com");
    }

    @Test
    public void googleTest() {
        driver.get("https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
