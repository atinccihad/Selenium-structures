package i01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class H04_manageWindowSet {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        // Sayfanın konumunu ve boyutlarını yazdırın
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        // Sayfanın konumunu ve boyutunu istediginiz sekilde ayarlayın
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(300, 500));

        // Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int xKoordinatı = driver.manage().window().getPosition().getX();
        int yKoordinatı = driver.manage().window().getPosition().getY();
        int genislik = driver.manage().window().getSize().getWidth();
        int yukseklik = driver.manage().window().getSize().getHeight();

        if (xKoordinatı == 0 && yKoordinatı == 0 && genislik == 300 && yukseklik == 500) {
            System.out.println("Olceklendirme testi PASS");
        } else {
            System.out.println("Olceklendirme testi FAILED");
        }
        // Sayfayi kapatin
        driver.close();
    }
}
