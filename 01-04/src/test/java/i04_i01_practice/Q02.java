package i04_i01_practice;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// ...Exercise2...
public class Q02 {
    public static void main(String[] args) {
        // 1-driver olusturalim
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        // 2-java class'imiza chromedriver.exe'yi tanitalim
        WebDriver driver = new ChromeDriver();

        // 3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();

        // 4-driver'a sayfanin yuklenmesini 10.000 milisaniye(10 saniye) boyunca beklemesini soyleyelim.Eger oncesinde sayfa yuklenirse, beklemeyi biraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 5-"sahibinden.com" adresine gidelim
        driver.get("http://www.sahibinden.com");
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();

        // 6- bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        // 7-title ve url'nin "Oto"kelimesinin icerip icermedigini kontrol edelim
        String expected = "Oto";
        if (actualTitle.contains(expected) && actualUrl.contains(expected)) {
            System.out.println("Oto yazisi vardir");
        } else {
            System.out.println("Oto yazisi yoktur!");
        }

        // 8-Ardindan "https://www.gittigidiyor.com" adresine gidelim
        driver.navigate().to("https://www.gittigidiyor.com");

        // 9-Bu adresin basligini alalim ve "Sitesi" kelimesini icerip icermedigini kontrol edelim
        String gittiGidiyorActualTitle = driver.getTitle();
        String expectedGittiGidiyorTitle = "Sitesi";
        if (gittiGidiyorActualTitle.contains(expectedGittiGidiyorTitle)) {
            System.out.println("gittiGidiyorActualTitle contains expectedGittiGidiyorTitle");
        } else {
            System.out.println("gittiGidiyorActualTitle NOT contains expectedGittiGidiyorTitle!");
        }

        // 10-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        // 11-Sayfayi yenileyelim
        driver.navigate().refresh();

        // 12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();

        // 13-Son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
