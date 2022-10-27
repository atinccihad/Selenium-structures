package i09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Yeni bir class olusturun: C03_windowHandle
public class C03_windowHandle {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //9- Sayfaları Kapatalım
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindowHandle = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue("actualTitle expectedTitle'i icermiyor!", actualTitle.contains(expectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "TECHPROEDUCATION";
        Assert.assertFalse("actualTitle2, expectedTitle2'yi icermiyor!", actualTitle2.contains(expectedTitle2));

        //Yeni bir windowolusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue("Sayfa title Walmart icermiyor!", driver.getTitle().contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindowHandle);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }


}
