package i09_i04_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05 {
    static WebDriver driver;

    // ...Exercise5...
    // @BeforeClass'in icine driver'i kuralim
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // maximize edip tum web elementler yuklenene kadar 10sn bekletelim
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Google'a gidelim ve sayfa basliginin "Google" icerdigini dogrulayalim
    @Before
    public void testtenOnce() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void title() {
        String googleTitle = driver.getTitle();
        boolean googleIceriyorMu = googleTitle.contains("Google");
        Assert.assertTrue("Google title testi FAIL", googleIceriyorMu);
    }

    // Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
    @Test
    public void url() {
        driver.get("https://www.amazon.com/");
        String amazonUrl = driver.getCurrentUrl();
        boolean amazonUrlIceriyorMu = amazonUrl.contains("www.amazon.com");
        Assert.assertTrue("Amazon URL testi FAIL", amazonUrlIceriyorMu);
    }

    // @AfterClass to driver'i kapatalim
    @AfterClass
    public static void after() {
        driver.close();
    }
}
