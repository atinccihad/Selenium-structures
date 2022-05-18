package day02_driverMethods.C02_driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageWindowSet {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // 2. Amazon sayfasina gidelim.https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // 3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        // 4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(10,10));
        driver.manage().window().setSize(new Dimension(300,500));
        // 5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        int xKoordinat=driver.manage().window().getPosition().getX();
        int yKoordinat=driver.manage().window().getPosition().getY();
        int genislik=driver.manage().window().getSize().getWidth();
        int yukseklik=driver.manage().window().getSize().getHeight();

        Thread.sleep(3000);
        if (xKoordinat==10 && yKoordinat==10 && genislik==300 && yukseklik==500){
            System.out.println("Olceklendirme testi PASS");
        }else {
            System.out.println("Olceklendirme testi FAİL");
        }
        // 6. Sayfayi kapatin
        driver.close();
    }
}
