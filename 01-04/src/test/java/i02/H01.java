package i02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// 1.Yeni bir class olusturalim (H01)
public class H01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("verify is title");
        } else {
            System.out.println("title is not equals facebook\nactualTittle= " + driver.getTitle());
        }
        Thread.sleep(3000);

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualUrl = driver.getCurrentUrl();
        String urlIcindeKelime = "facebook";

        if (actualUrl.contains(urlIcindeKelime)) {
            System.out.println("URL " + urlIcindeKelime + " iceriyor.");
        } else {
            System.out.println("URL " + urlIcindeKelime + " icermiyor.\nactualURL: " + driver.getCurrentUrl());
        }
        Thread.sleep(3000);

        // 4. https://www.walmart.com/  sayfasina gidin.
        driver.get("https://www.walmart.com/");

        // 5.Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Walmart.com";

        if (actualTitle2.contains(expectedTitle2)) {
            System.out.println("title " + expectedTitle2 + " iceriyor.");
        } else {
            System.out.println("title " + expectedTitle2 + " icermiyor.\nactualTitle: " + actualTitle2);
        }
        Thread.sleep(3000);
        // 6.Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(3000);

        // 7.Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(3000);

        // 8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        // 9.Browser’i kapatin
        driver.close();

    }
}
