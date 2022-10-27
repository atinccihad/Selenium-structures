package i04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

// 1-H01 isimli bir class olusturun
public class H01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        // Sayfayi “refresh” yapin
        driver.navigate().refresh();

        // Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Spend less";

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Spend less iceriyormu testi PASS");
        } else {
            System.out.println("Spend less iceriyormu testi FAIL");
        }

        // Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_3']")).click();

        // Birthday butonuna basin
        driver.findElement(By.xpath("(//div[@class='bxc-grid__image   bxc-grid__image--light'])[2]")).click();

        // Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

        // 9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();

        // 10-Urun ucretinin 25$ oldugunu test edin
        WebElement price = driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));

        if (price.getText().equals("25$")) {
            System.out.println("Urun ucret testi PASS");
        } else {
            System.out.println("Urun ucret testi FAIL");
        }

        // 10-Sayfayi kapatin
        driver.close();
    }
}
