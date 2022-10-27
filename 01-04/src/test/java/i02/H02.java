package i02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

// 1. Yeni bir class olusturun (H02)
public class H02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2.Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");

        // 3. Sayfa URL’sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL’yi yazdırın.
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains("youtube")) {
            System.out.println("actual URL youtube testi PASS=> " + actualUrl);
        } else {
            System.out.println("actual URL youtube testi FAIL,actualUrl=> " + driver.getCurrentUrl());
        }
        Thread.sleep(2000);

        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        // 5. Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);

        // 6. Sayfayi yenileyin
        driver.navigate().refresh();

        // 7. Amazon sayfasina donun
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        // 8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        // 9. Ardından sayfa başlığının “Amazon” içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Amazon")) {
            System.out.println("title Amazon testi PASS=> " + actualTitle);
        } else {
            System.out.println("title Amazon testi FAIL,actual title=> " + actualTitle);
        }
        Thread.sleep(2000);

        // 10.Sayfa URL’inin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL’yi yazdırın
        actualUrl = "https://www.amazon.com/";

        if (actualUrl.equals("https://www.amazon.com/")) {
            System.out.println("actual URL amazon testi PASS=> " + actualUrl);
        } else {
            System.out.println("actual URL amazon testi FAIL,actualURL=> " + actualUrl);
        }
        Thread.sleep(2000);

        // 11. Sayfayi kapatin
        driver.close();
    }
}
