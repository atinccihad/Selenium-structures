package i01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// Yeni bir Class olusturalim.H02
public class H02_getMethods {
    public static void main(String[] args) throws InterruptedException {
        /*
        Yeni bir Class olusturalim.H02
        Youtube ana sayfasina gidelim   https://www.youtube.com/
        Amazon soyfasina gidelim   https://www.amazon.com/
        Tekrar YouTube’sayfasina donelim
        Yeniden Amazon sayfasina gidelim
        Sayfayi Refresh(yenile) yapalim
        Sayfayi kapatalim
        Tum sayfalari kapatalim
         */
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // Youtube ana sayfasina gidelim   https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        Thread.sleep(1500);
        // Amazon soyfasina gidelim   https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(1500);
        // Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        Thread.sleep(1500);
        // Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(1500);
        // Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(1500);
        // Sayfayi kapatalim
        driver.close();
        // Tum sayfalari kapatalim
        driver.quit();

    }
}
