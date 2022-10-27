package i05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Junit {

    // JUnit birim testidir
    // notasyonla maine gerek kalmiyor
    // testler bagimsiz calisabiliyor
    // Before notasyonu her test notasyonundan once calisir
    // After notasyonu her test notasyonundan sonra calisir

    @Test
    public void method1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    // @Ignore notasyonu test notasyonundan sonra yazilir, calismasini istemedigimiz @Test notasyonunun hemen altina  @Ignore notasyonu eklenir
    @Test
    @Ignore("method2 is ignored")
    public void method2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
    }

    @Test
    public void method3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com");
    }

}
