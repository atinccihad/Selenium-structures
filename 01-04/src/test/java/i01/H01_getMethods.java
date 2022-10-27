package i01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Yeni bir class olusturalim : H01_GetMethods
public class H01_getMethods {
    public static void main(String[] args) {
        /*
        Yeni bir class olusturalim : H01_GetMethods
        Amazon sayfasina gidelim. https://www.amazon.com/
        Sayfa basligini(title) yazdirin
        Sayfa basliginin “Amazon” icerdigini test edin
        Sayfa adresini(url) yazdirin
        Sayfa url’inin “amazon” icerdigini test edin.
        Sayfa handle degerini yazdirin
        Sayfa HTML kodlarinda “Getaway” kelimesi gectigini test edin
        Sayfayi kapatin.
         */
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        // Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();

        if (actualTitle.contains("Amazon")) {
            System.out.println("title testi PASS");
        } else {
            System.out.println("title testi FAILED");
        }
        // Sayfa adresini(url) yazdirin
        String url = driver.getCurrentUrl();
        System.out.println("Url: " + url);
        // Sayfa url’inin “amazon” icerdigini test edin.
        if (url.contains("amazon")) {
            System.out.println("url testi PASS");
        } else {
            System.out.println("url testi FAILED");
        }
        // Sayfa handle degerini yazdirin
        System.out.println("Sayfa handle degeri: " + driver.getWindowHandle());
        // Sayfa HTML kodlarinda “Getaway” kelimesi gectigini test edin
        String html = driver.getPageSource();
        if (html.contains("Getaway")) {
            System.out.println("HTML testi PASS");
        } else {
            System.out.println("HTML testi FAILED");
        }
        // Sayfayi kapatin.
        driver.close();
    }
}
