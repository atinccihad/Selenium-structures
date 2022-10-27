package i02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
  // Yeni bir Class olusturalim.C06_ManageWindow
public class C01_manageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("window position: " + driver.manage().window().getPosition());
        System.out.println("window olculeri: " + driver.manage().window().getSize());
        // Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        // simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        // Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("maximize window position: " + driver.manage().window().getPosition());
        System.out.println("maximize window olculeri: " + driver.manage().window().getSize());
        // Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        // Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("fullscreen window position: " + driver.manage().window().getPosition());
        System.out.println("fullscreen window olculeri: " + driver.manage().window().getSize());
        Thread.sleep(3000);
        // Sayfayi kapatin
        driver.close();

    }
}
