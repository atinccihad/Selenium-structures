package i05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;

    // @Before her testten once calisir
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // @After her testten sonra calisir
    @After
    public void tearDown() {
        driver.close();
    }

    // @Test  @Before'dan sonra  @After'dan once calisir
    // @Test notasyonu gordugunde herseferinde once @Before notasyonu sonrasinda @After notasyonu calisir.
    @Test
    public void method1() {
        driver.get("https://amazon.com");
    }

    @Test
    public void method2() {
        driver.get("https://hepsiburada.com");
    }

    @Test
    public void method3() {
        driver.get("https://facebook.com");
    }

}
