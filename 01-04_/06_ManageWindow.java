package day02_driverMethods.C02_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
        // 1. Yeni bir Class olusturalim.C06_ManageWindow
public class C06_ManageWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        // 2. Amazon sayfasina gidelim.https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // 3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        // 4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        // 5. Simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        // 6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("maximize durumunda position: "+driver.manage().window().getPosition());
        System.out.println("maximize durumunda size: "+driver.manage().window().getSize());
        Thread.sleep(3000);
        // 7. Sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        // 8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("fullScreen durumunda position: "+driver.manage().window().getPosition());
        System.out.println("fullScreen durumunda size: "+driver.manage().window().getSize());
        // 9. Sayfayi kapatin.
        driver.close();

    }
}
