package i01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_firstTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*
        1- amazon.com sayfasina gidiniz.
        2- Basligin "Amazon" icerdigini test ediniz.
        3- URL'nin amazon icerdigini test ediniz.
        4- Sayfayi kapatiniz.
         */
        // 1- amazon.com sayfasina gidiniz.
        driver.get("https://www.amazon.com");
        // 2- Basligin "Amazon" icerdigini test ediniz.
        if (driver.getTitle().contains("Amazon")) {
            System.out.println("title PASS");
        } else {
            System.out.println("title FAILED");
        }
        // 3- URL'nin amazon icerdigini test ediniz.
        if (driver.getCurrentUrl().contains("amazon")) {
            System.out.println("URL PASS");
        } else {
            System.out.println("URL FAILED");
        }
        // 4- Sayfayi kapatiniz.
        driver.close();

    }
}
